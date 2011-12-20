/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.entity.Topic;
import ch.heigvd.nobitsgram.entity.User;
import ch.heigvd.nobitsgram.manager.TopicsManager;
import ch.heigvd.nobitsgram.manager.UsersManager;
import ch.heigvd.nobitsgram.model.UserBean;
import ch.heigvd.nobitsgram.util.InterrogatorInstagram;
import ch.heigvd.nobitsgram.util.MyParser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.ejb.EJB;

/**
 *
 * @author Eyram
 */
@WebServlet(name = "ServletPersonnalPage", urlPatterns = {"/ServletPersonnalPage"})
public class ServletPersonnalPage extends HttpServlet {

    @EJB
    private UsersManager usersManager;
    @EJB
    private TopicsManager topicsManager;






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

        }
        finally {
            out.close();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            User user =(User)request.getSession().getAttribute("user");
            String action = request.getParameter("action");           


            if(action != null && action.equals("Submit")){
                setUser(request,response,user);

            }

            // When action is not null, then it seem that the client want to
            // remove a topic in his topic list
            else if(action != null && !action.equals("Submit")){
                int index = Integer.parseInt(action);
                Topic topic = user.getTopicList().get(index);
                if(usersManager.removeTopicOfUser(user, topic)){
                    topicsManager.remove(topic);
                }
                getServletContext().getRequestDispatcher("/view/client.jsp").forward(request, response);
            }

          
           
           

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);


    }

    /*
     * This method is used to do a redirection to register form with the
     * according error to setting account page
     */
    private void redirectToSettingAccount(String error,HttpServletRequest request,
                                       HttpServletResponse response){
        try{
            request.setAttribute("error",error);
            getServletContext().getRequestDispatcher("/view/settingAccount."
                                           + "jsp").forward(request, response);
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }


    private void setUser(HttpServletRequest request,
            HttpServletResponse response, User user)throws IOException, ServletException{

        String firstname="";
        String lastname="";
        String password="";
        String passwordConfirm="";
        String country="";
        String email="";
        String streetNumber="";
        String street="";
        String city="";
        String zip="";
        String rawTopic =request.getParameter("rawTopic");
        List<String> listTopicName = new ArrayList<String>();
        
        if(request.getParameter("firstname") != null){
                firstname = request.getParameter("firstname");
            }
            if(request.getParameter("lastname") != null){
                lastname = request.getParameter("lastname");
            }
            if(request.getParameter("email") != null){
                email = request.getParameter("email");
            }
            if(request.getParameter("country") != null){
                country = request.getParameter("country");
            }
            if(request.getParameter("city") != null){
                city = request.getParameter("city");
            }
            if(request.getParameter("street") != null){
                street = request.getParameter("street");
            }
            if(request.getParameter("streetNumber") != null){
                streetNumber = request.getParameter("streetNumber");
            }
            if(request.getParameter("zip") != null){
                zip = request.getParameter("zip");
            }

            if(request.getParameter("password") != null){
                password = request.getParameter("password").trim();
            }
            if(request.getParameter("passwordConfirm") != null){
                passwordConfirm = request.getParameter("passwordConfirm").trim();
            }
            
            
            String error="";
            String message ="";

            UserBean userBean = new UserBean();

            
            // if the firstname field was fill, then we set the first name of user
            // by the new first name he has typed
            if(firstname.trim()!=""){                
                user.setFirstname(firstname);
            }

            // We set the lastname unless its field is not empty
            if(lastname.trim() != ""){
                user.setLastname(lastname);
            }

            // We set the email unless its fields was filled and the email is
            // valid email
            if(email.trim() != ""){
                if(userBean.isValidEmail(email)){
                    user.setEmail(email);
                }
                else{
                    error = "Invalid email! Please try again";
                    redirectToSettingAccount(error, request, response);
                }
            }

            // We check the validity of the password
            if(password != "" || passwordConfirm != ""){
                if(userBean.isValidPassword(password, passwordConfirm)){
                    
                    user.setPassword(password);
                }

                else{                                   
                    error = userBean.getError();
                    redirectToSettingAccount(error, request, response);
                }
            }
             // We check if one of the address field was fill or not
            if(userBean.isAddress(city, street, streetNumber, zip)){
                // We check if the field of street number or zip code was filled
                // and it value is a number
                if((streetNumber!="" && !userBean.isNumber(streetNumber)) ||
                   (zip!="" && !userBean.isNumber(zip))){                   
                    error += "Error! your street number and/or zip code\n must be a number";
                    redirectToSettingAccount(error, request, response);

                }
                // If all is ok, we create an address and we search its geocode
                String address = streetNumber+"+"+street+"+"+city+"+"+zip;
                
                InterrogatorInstagram interrogator = new InterrogatorInstagram();
                
                // We construct the url of request to googleapis
                String url = "http://maps.googleapis.com/maps/api/geocode/json?address="
                             + address + "&sensor=true";
                
                // we get the response of request
                String result = interrogator.getSearcResult(url);
                
                
                // We get the status of request. It can be take only two values
                // If the request succeed, it value is "OK",
                // if not it take the value "ZERO_RESULT"
                String status = MyParser.parseResponse(result, "status");
                

                // If the address is not defined, then we return to the registration
                // page with error message that invite the user to check his address
                if(status==null || !status.equalsIgnoreCase("ok")){
                    error += "Invalid address, please enter a valide one, or "
                            + "leave its fields blank";                    

                }
                // If the status of the response is ok, we extract latitude and
                // longitude of the client address
                else{

                    // parseResponse return a list of String. In this case, only
                    // one element will be on the list if the status of request
                    // is ok; else it will be nothing.
                    // We don't wont to remove all caracter "", because, we'll parse the result again
                    String location = MyParser.parseResponse(result,"results","location",false).get(0);
                    
                    
                    String lat = MyParser.parseResponse(location, "lat");
                    String lng = MyParser.parseResponse(location, "lng");

                    // We set lat and lng to the user
                    user.setLatitude(Double.parseDouble(lat));
                    user.setLongitude(Double.parseDouble(lng));
                }
            }

            // We fill the list of topic with topicName which was separate with ","
            listTopicName = MyParser.setListTopic(rawTopic,",");         

            listTopicName = MyParser.filterListTopic(listTopicName);
            
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
                usersManager.addTopicToUser(user,topic);
            }
            
            
            usersManager.edit(user);
            getServletContext().getRequestDispatcher("/view/client.jsp").forward(request, response);
            
    }

}
