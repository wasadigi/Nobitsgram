/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.entity.User;
import ch.heigvd.nobitsgram.model.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 *
 * @author Eyram
 */
@WebServlet(name = "ServletPersonnalPage", urlPatterns = {"/ServletPersonnalPage"})
public class ServletPersonnalPage extends HttpServlet {
    private String firstname;
    private String lastname;
    private String password;
    private String passwordConfirm;
    private String country;
    private String email;
    private String streetNumber;
    private String street;
    private String city;
    private String zip;
    private List<String> topics = new ArrayList<String>();


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

            firstname = request.getParameter("firstname");
            lastname = request.getParameter("lastname");
            email = request.getParameter("email");
            country = request.getParameter("country");
            city = request.getParameter("city");
            street = request.getParameter("street");
            streetNumber = request.getParameter("streetNumber");


            String error="";

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
            if(userBean.isValidPassword(password, passwordConfirm)){
                user.setPassword(password);
            }

            else{
                if(error.trim() !=""){
                    error += ", "+userBean.getError();
                }

                else{
                    error = userBean.getError();
                }
            }

            
            for(int i = 0; i < size; i++){
                topics.add(request.getParameter("topic"+i));
            }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);


    }

    protected void setUser(String firstname, String lastname, String email,
                           String country, List<String> topics){



    }
}
