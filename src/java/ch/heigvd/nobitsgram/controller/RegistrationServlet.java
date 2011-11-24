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
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Eyram
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/RegistrationServlet"})


public class RegistrationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        //processRequest(request, response);
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
        //processRequest(request, response);


        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String country = request.getParameter("country");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String topicName = request.getParameter("Topic");
        UserBean userBean = new UserBean(firstname,lastname,country,username,
                                         password,email);

        // If all informations about a user are valid, then the user can be
        // record in Nobitsgram database
        if(userBean.isValid()){

        UsersManager usersManager = new UsersManager();
        User newUser = new User(firstname,lastname);
        //newUser.setFirstname(firstname);
        //newUser.setLastname(lastname);
        newUser.setCountry(country);
        newUser.setCountry(email);
        newUser.setUsername(username);
        newUser.setPassword(password);



        Topic topic = new Topic(topicName);

        //topic.setId(21L);

        //TopicFacadeREST topicFac = new TopicFacadeREST();
        TopicsManager topicsManager = new TopicsManager();
        newUser.addTopic(topic);
        topic.addUser(newUser);

        //usersManager.create(newUser);
        topicsManager.create(topic);
        //topicFac.create(topic);

        response.sendRedirect("/nobitsgram/view/pageClient.jsp");


        }

        // Else, the client is rediret to an error page
        else{
            response.sendRedirect("/nobitsgram/view/errorRegistration.jsp");
        }

    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
