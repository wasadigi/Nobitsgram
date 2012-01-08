/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.entity.*;
import ch.heigvd.nobitsgram.manager.*;
import ch.heigvd.nobitsgram.model.UserBean;
import ch.heigvd.nobitsgram.model.UserHistory;
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
    




    /**
     *
     * This method redirect the user to formular page and set the parameter code
     * to the code its receive from instagram
     *
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {               
        
        // We get the code of the client
        String codeInstagram = request.getQueryString();


        // We extract the code of the expression
        codeInstagram = codeInstagram.substring(codeInstagram.indexOf("=")+1);

        HttpSession session = request.getSession();

        // We create a hash table according to the code we get from instagram
        Hashtable<String,String> tableInfoInstagram = getInstagramInfo(codeInstagram, request);                        

        // We get the value of access_token in the hash table
        String access_token = tableInfoInstagram.get("access_token");

        // We get the value of username of instagram in the hash table
        String usernameInstagram = tableInfoInstagram.get("username_instagram");

        // We get the value of instagram id in the hash table
        //Long id_instagram = Long.parseLong(tableInfoInstagram.get("id_instagram"));
        String idInstagram = tableInfoInstagram.get("id_instagram");
        
        String profile_picture = tableInfoInstagram.get("profile_picture");
        
        setInfoInstagramToSession(access_token, usernameInstagram, idInstagram, 
                                  profile_picture,session);

        session.setAttribute("codeInstagram", codeInstagram);

        getServletContext().getRequestDispatcher("/view/registration.jsp").
                                                    forward(request, response);


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

        HttpSession session = request.getSession();
        
        String access_token = (String)session.getAttribute("access_token");
        String usernameInstagram = (String)session.getAttribute("usernameInstagram");
        String idInstagram = (String)session.getAttribute("idInstagram");
        String profile_picture = (String)session.getAttribute("profile_picture");

        String error=null;
        InterrogatorInstagram interrogator = new InterrogatorInstagram();
        ServletContext sc = getServletContext();;
       

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String country = request.getParameter("country");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");
        String rawTopic = request.getParameter("rawTopic");
        String street = request.getParameter("street");
        String streetNumber = request.getParameter("streetNumber");
        String city = request.getParameter("city");
        String zip = request.getParameter("zip");
        String address;
        
        List<String> listTopicName;

        UserBean userBean = new UserBean(firstname,lastname,username,country,password,
                           passwordConfirm,email,streetNumber, street,city,zip);



        // If all informations about a user are valid and the username don't
        // exist yet, then the user can be record in Nobitsgram database
        if(userBean.isValid() && userBean.isValidPassword(password, passwordConfirm)
                && !usersManager.isAllReadyRecord(username)){

            User user = new User();
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setCountry(country);
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(password);

            user.setId_Instagram(idInstagram);
            user.setUsername_instagram(usernameInstagram);
            user.setAcces_token(access_token);
            user.setProfile_picture(profile_picture);

            // We check if one of the address field was fill or not
            if(userBean.isAddress(city, street, streetNumber, zip)){                
                // We check if the field of street number or zip code was filled
                // and it value is a number
                if((streetNumber!="" && !userBean.isNumber(streetNumber)) ||
                   (zip!="" && !userBean.isNumber(zip))){
                    streetNumber ="";
                    zip ="";
                    error = "Error! your street number and/or zip code\n must be a number";
                    setUserInput(firstname, lastname, username, email, street,
                                 streetNumber, zip, city, rawTopic, session);
                    redirectToRegisterForm(error, request, response);
                }
                                
                user.setCity(city);
                user.setStreet(street);
                user.setStreetNumber(streetNumber);
                user.setZipCode(zip);
                user.setZoomOut(false);
          
                // If all is ok, we create an address and we search its geocode
                                 
                address = streetNumber+"+"+street+"+"+city+"+"+zip;                
            }
            
            // If the user don't enter an address, we get his geocoding according
            // to his country
            else{                                     
                user.setZoomOut(true);
                address = country;                
            }
           // We build the url of request to googleapis
            String url = "http://maps.googleapis.com/maps/api/geocode/json?address="
                         + address + "&sensor=true";

            // we get the response of request
            String result = interrogator.getSearcResult(url);


            // We get the status of request. It can be take only two values
            // If the request succeed, it value is "OK",
            // if not it take the value "ZERO_RESULT"
            String status = MyParser.parseResponse(result, "status",true);


            // If the address is not defined, then we return to the registration
            // page with error message that invite the user to check his address
            if(status==null || !status.equalsIgnoreCase("ok")){
                error = "Invalid address, please enter a valide one, or "
                        + "leave its fields blank";
                // We redirect the user to register form with the according
                // error.
                street="";
                streetNumber="";
                zip="";
                city ="";
                setUserInput(firstname, lastname, username, email, street,
                             streetNumber, zip, city, rawTopic, session);

            }
            // If the status of the response is ok, we extract latitude and
            // longitude of the client address
            else{

                // parseResponse return a list of String. In this case, only
                // one element will be on the list if the status of request
                // is ok; else it will be nothing.
                // We don't wont to remove all caracter "", because, we'll parse the result again
                String location = MyParser.parseResponse(result,"location",false);


                String lat = MyParser.parseResponse(location, "lat",true);
                String lng = MyParser.parseResponse(location, "lng",true);

                // We set lat and lng to the user
                user.setLatitude(Double.parseDouble(lat));
                user.setLongitude(Double.parseDouble(lng));
            }

            if(error == null){
                // We indicate that the user is connect
                user.setIsConnect(true);
                
                // We create an user with the value which the client has enter
                usersManager.create(user);


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



                 user.setIsConnect(true);
                 
                 // We create a date with the current timezone et local of user
                 Calendar date = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
                 
                 // We set all the date 
                 user.setCreateDate(date);
                 user.setLastDateConnection(date);
                 user.setLastDateSearch(date);
                 user.setCountConnection(1);
                 user.setCountMonthConnection(1);
                 UserHistory history = new UserHistory();
                 history.setCreateDate(date);
                 user = usersManager.edit(user);
                 
                // We send the client to the redirect page
                session.setAttribute("user",user);


                // The register is ok, we redirect the client to his client page
                response.sendRedirect(request.getContextPath()+"/GalleryServlet");
            }
            else{
                redirectToRegisterForm(error, request, response);
            }
        }

        else if(usersManager.isAllReadyRecord(username)){
            error = "The username \""+username+"\" is not available, "
                    + "choose another one!";
            username = "";
            setUserInput(firstname, lastname, username, email, street,
                         streetNumber, zip, city,rawTopic, session);
            redirectToRegisterForm(error, request, response);
        }

        // Else, the client is rediret to an error page
        else{
            error = userBean.getError();
            setUserInput(firstname, lastname, username, email, street,
                          streetNumber, zip, city, rawTopic, session);
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
            HttpSession session = request.getSession();

        request.setAttribute("error",error);
            getServletContext().getRequestDispatcher("/view/errorRegistration."
                                           + "jsp").forward(request, response);
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }


   

    private Hashtable<String,String> getInstagramInfo(String code,HttpServletRequest request){
        List<String> infoList = new ArrayList<String>();
        Hashtable<String,String> table = new Hashtable<String, String>();
        String delimiter ="\"";
        

        // This instance will permit us to communicate with instagram
        InterrogatorInstagram intInstag = new InterrogatorInstagram();

      
       
       // We create a list of the parameters of the request OAuth's Post request
        List<String> parameters = new ArrayList<String>();
        parameters.add("client_id");
        parameters.add("client_secret");
        parameters.add("grant_type");
        parameters.add("redirect_uri");
        parameters.add("code");

        // We create a list of parameters values of the OAuth's Post request,
        // and we insert the value according to parameter we insert before.
        List<String> value = new ArrayList<String>();
        value.add("5e2a174a39804619840925781251b646");
        value.add("26a951460081472fab2c0bb2f505a397");
        value.add("authorization_code");
        value.add(request.getRequestURL().toString());
        value.add(code);
        String oauthUrl = "https://api.instagram.com/oauth/access_token";
        // We get information about the client.
        String informations = intInstag.getClientInformations(oauthUrl,parameters,value);
                

        // We extract access token, username and id to record them in the databases
        String access_token = MyParser.parseResponse(informations,"access_token",true);       
        // We insert the key access_token and its value to the hashtable
        table.put("access_token", access_token);

        
        String profile_picture = MyParser.parseResponse(informations, "profile_picture",true);
        table.put("profile_picture",profile_picture);

        // We insert the key username of instagram and its value to the hashtable
        String username_instagram = MyParser.parseResponse(informations, "username",true);
        table.put("username_instagram", username_instagram);

        // We insert id of instagram and its value to the hash table
        String id_instagram = MyParser.parseResponse(informations, "id",true);
        table.put("id_instagram",id_instagram);

        return table;

    }


    public void setInfoInstagramToSession(String access_token,
                  String usernameInstagram, String idInstagram, 
                  String profile_picture, HttpSession session){

        session.setAttribute("access_token", access_token);
        session.setAttribute("usernameInstagram", usernameInstagram);
        session.setAttribute("idInstagram", idInstagram);
        session.setAttribute("profile_picture", profile_picture);

    }

    public void setUserInput(String firstname, String lastname, String username,String email,
                     String street, String streetNumber, String zip, String city,
                     String topicRaw,HttpSession session){

        session.setAttribute("firstname", firstname);
        session.setAttribute("lastname", lastname);
        session.setAttribute("username", username);
        session.setAttribute("email", email);
        session.setAttribute("street", street);
        session.setAttribute("streetNumber", streetNumber);
        session.setAttribute("zip", zip);
        session.setAttribute("city", city);
        session.setAttribute("topicRaw", topicRaw);

    }



}

