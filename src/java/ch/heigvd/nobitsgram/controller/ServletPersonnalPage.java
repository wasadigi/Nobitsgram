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
import ch.heigvd.nobitsgram.util.MyParser;
import ch.heigvd.nobitsgram.util.ResearchGeocode;
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


    private String firstname="";
    private String lastname="";
    private String password="";
    private String passwordConfirm="";
    private String country="";
    private String email="";
    private String streetNumber="";
    private String street="";
    private String city="";
    private String zip="";




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

            String action = request.getParameter("action");


            if(action != null && action.equals("Submit")){
                setUser(request,response);

            }

            // When action is not null, then it seem that the client want to
            // remove a topic in his topic list
            else if(action != null){

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
            HttpServletResponse response)throws IOException, ServletException{

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


            String error="";
            String message ="";

            User user = (User)request.getSession().getAttribute("user");
            UserBean userBean = new UserBean();

            int size = user.getTopicList().size();
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
                    error = userBean.getError();
                }
            }

            // We check the validity of the password
            if(password != "" || passwordConfirm != ""){
                if(userBean.isValidPassword(password, passwordConfirm)){
                    user.setPassword(password);
                }

                else{
                    if(error.trim() !=""){
                        error += ", ";
                    }

                    error += userBean.getError()+" =====>"+password+"******";
                }
            }
             // We check if one of the address field was fill or not
            if(userBean.isAddress(city, street, streetNumber, zip)){
                // We check if the field of street number or zip code was filled
                // and it value is a number
                if((streetNumber!="" && !userBean.isNumber(streetNumber)) ||
                   (zip!="" && !userBean.isNumber(zip))){
                    if(error.trim() !=""){
                        error += ", ";
                    }
                    error += "Error! your street number and/or zip code\n must be a number";

                }
                // If all is ok, we create an address and we search its geocode
                String address = streetNumber+"+"+street+"+"+city+"+"+zip;
                ResearchGeocode researcheGeocode = new ResearchGeocode(address);
                String tmp = researcheGeocode.getLatLng();

                String status = null;
                /*
                 * It possible that googleapis don't response. In that case, tmp
                 * will be null. If not, we can extract the status of the response
                 * of googleapis.
                 */
                if(tmp != null){
                    status = researcheGeocode.getStatusOfReasearch(tmp);
                }

                // If the address is not defined, then we return to the registration
                // page with error message that invite the user to check his address
                if(status==null || !status.equalsIgnoreCase("ok")){
                    if(error.trim() !=""){
                        error += ", ";
                    }
                    error += "Invalid address, please enter a valide one, or "
                            + "leave its fields blank";

                }
                // If the status of the response is ok, we extract latitude and
                // longitude of the client address
                else{

                    String s = new MyParser().getLatLong(tmp);
                    // We separate lat and lng with the caracter "#"
                    int i = s.indexOf("#");
                    String lat = s.substring(0, i);
                    String lng = s.substring(i+1);

                    // We set lat and lng to the user
                    user.setLatitude(Double.parseDouble(lat));
                    user.setLongitude(Double.parseDouble(lng));
                }
            }

            String topicName;
            Topic topic = null;
            for(int i = 0; i < size; i++){
                topicName = request.getParameter("topic"+i).trim();

                // If the topicName is not empty, then we try to check
                // if the topicName is already the attribute of one topic
                if(topicName != null && topicName != "" ){
                    try{
                        topic = topicsManager.getTopic(topicName);
                    }
                    catch(Exception ex){
                        topic = null;
                    }

                }

                // If it haven't any topic with the same name in database, then we
                // can create a new with topicName.
                if(topic == null){
                    topic = new Topic(topicName);
                    topicsManager.create(topic);
                }
                usersManager.addTopicToUser(user,topic);
            }

            // If error is not empty, then some error was found, and we redirect
            // the client to setting account page with the according error
            if(error != ""){
                message = "error found";


            }

            // If every thing is ok, then we redirect the client to setting account
            // page with the message that setting is ok
            else{
                message ="setting ok";
            }
            request.setAttribute("message", message);
            if(error != ""){
                redirectToSettingAccount(error, request, response);
            }
            else{

               getServletContext().getRequestDispatcher("/view/displayUserData."
                                           + "jsp").forward(request, response);
            }
    }

}
