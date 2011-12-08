/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.entity.*;
import ch.heigvd.nobitsgram.manager.*;
import ch.heigvd.nobitsgram.model.UserBean;
import ch.heigvd.nobitsgram.util.*;
import java.io.*;
import java.util.*;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * File: RegistrationServlet.java
 *
 * @author: Eyram DOVI
 *
 * Description: This class is used to controlled a client registration.
 *
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/RegistrationServlet"})

public class RegistrationServlet extends HttpServlet {
    @EJB
    private UsersManager usersManager;
    @EJB
    private TopicsManager topicsManager;

    String firstname;
    String lastname;
    String country;
    String email;
    String username;
    String password;
    String passwordConfirm;
    List<String> listTopicName = new ArrayList<String>();
    String rawTopic;
    String street;
    String streetNumber;
    String city;
    String zip;
    String access_token;
    String username_instagram;
    Long id_instagram;
    Long id;
    String error;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            getServletContext().getRequestDispatcher("/view/registration.jsp").forward(request, response);

        }
        finally {
            out.close();
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        // We get the code of the client
        String code = request.getQueryString();

        // We extract the code of the expression
        code = code.substring(code.indexOf("=")+1);

        // This instance will permit us to communicate with instagram
        InterrogatorInstagram intInstag = new InterrogatorInstagram();

        // We  set the code of the client, which will permit us to get his
        // acces token
        intInstag.setCode(code);

        // We set the callback of application, which permit to instagram to do
        // redirection to our application
        intInstag.setCallbackUrl(request.getRequestURL().toString());

        // We get information about the client.
        String informations = intInstag.getClientInformations();

        MyParser pars = new MyParser();

        // We extract access token, username and id to record them in the databases
        access_token = pars.getValue(informations,"access_token");
        username_instagram = pars.getValue(informations, "username");
        id_instagram =Long.parseLong(pars.getValue(informations, "id"));
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        firstname = request.getParameter("firstname");
        lastname = request.getParameter("lastname");
        country = request.getParameter("country");
        email = request.getParameter("email");
        username = request.getParameter("username");
        password = request.getParameter("password");
        passwordConfirm = request.getParameter("passwordConfirm");
        rawTopic = request.getParameter("rawTopic");
        street = request.getParameter("street");
        streetNumber = request.getParameter("streetNumber");
        city = request.getParameter("city");
        zip = request.getParameter("zip");

        UserBean userBean = new UserBean(firstname,lastname,username,country,password,
                           passwordConfirm,email,streetNumber, street,city,zip);


        // If all informations about a user are valid and the username don't
        // exist yet, then the user can be record in Nobitsgram database
        if(userBean.isValid() && !usersManager.isAllReadyRecord(username)){

            User newUser = new User();
            newUser.setFirstname(firstname);
            newUser.setLastname(lastname);
            newUser.setCountry(country);
            newUser.setEmail(email);
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setId_Instagram(id_instagram);
            newUser.setUsername_instagram(username_instagram);
            newUser.setAcces_token(access_token);

            if(userBean.isValidAddress()){
                String address = streetNumber+"+"+street+"+"+city+"+"+zip;

                String tmp = new ResearchGeocode(address).getLatLng();
                // If the address is not defined, then we return to the registration
                // page with error message that invite the user to check his address
                if(tmp == null){
                    error = "Invalid address, please enter a valide one, or "
                            + "leave its fields blank";
                    // We redirect the user to register form with the according
                    // error.
                    redirectToRegisterForm(error, request, response);

                }

                String s = new MyParser().getLatLong(tmp);

                int i = s.indexOf("#");
                String lat = s.substring(0, i);
                String lng = s.substring(i+1);

                newUser.setLatitude(Double.parseDouble(lat));
                newUser.setLongitude(Double.parseDouble(lng));
            }

            // We create an user with the value which the client has enter
            usersManager.create(newUser);


            // We fill the list of topic with topicName which was separate with ","
            setListTopic(rawTopic);

            listTopicName = filterListTopic(listTopicName);

            int size = listTopicName.size();
            Topic topic;
            String topicName;

            // We try to record all topic the user have enter in the field.
            // For each topicName we try to get a topic which have the same name
            // with which we get in parameter. If the topic get was null, then
            // it haven't any topic with the same name in database, else it
            // have one and we add new user to it.
            // If the size = 0, any instruction in the loop (for) will not execute
            for(int i = 0; i <size; i++){
                topicName = listTopicName.get(i);
                try{
                    topic = topicsManager.getTopic(topicName);
                }
                catch(Exception ex){
                    topic = null;
                }

                // It haven't any topic with the same name in database, then we
                // can create a new with topicName.
                if(topic == null){
                    topic = new Topic(topicName);
                    topicsManager.create(topic);
                }
                usersManager.addTopicToUser(newUser,topic);
            }

            ServletContext sc = getServletContext();

            request.setAttribute("username",username);
            sc.getRequestDispatcher("/view/pageClient.jsp").forward(request, response);
        }

        else if(usersManager.isAllReadyRecord(username)){
            // Redirect the username to a page which it's message is
            // YOU HAVE ALREADY AN ACOUNT. YOU CAN'T REGISTER AGAIN
        }

        // Else, the client is rediret to an error page
        else{
            error = userBean.getError();
            redirectToRegisterForm(error, request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    /*
     * This method is used to do a redirection to register form with the
     * according error
     */
    private void redirectToRegisterForm(String error,HttpServletRequest request,
                                       HttpServletResponse response){
        try{
        request.setAttribute("error",error);
            getServletContext().getRequestDispatcher("/view/errorRegistration."
                                           + "jsp").forward(request, response);
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }

    public void setListTopic(String rawTopicName){
        StringTokenizer st = new StringTokenizer(rawTopicName,",");
        String s;


        while(st.hasMoreTokens()){
            // All the topic the user give, will convert to upper case. This,
            // will permit further to remove all double topic.
            s = st.nextToken().trim().toUpperCase();
            // If s is empty, we don't add it to listTopicName
            if(!s.equals("")){
                listTopicName.add(s);
            }
        }
    }


    /*
     * This method is used to remove all double element in a list of string
     */
    public List<String> filterListTopic(List<String> myList){
        List<String> tmp = myList;
        int size = tmp.size();
        int i = 0;
        int j;
        while(i<size){
            j = tmp.lastIndexOf(tmp.get(i));

            if(i != j){
                tmp.remove(j);
                size = tmp.size();
            }
            else{
                i +=1;
            }
        }
        return tmp;
    }


}

