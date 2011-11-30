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
import javax.ejb.EJB;
import javax.servlet.ServletContext;
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


        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String country = request.getParameter("country");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String topicName = request.getParameter("Topic");
        String street = request.getParameter("street");
        String streetNumber = request.getParameter("streetNumber");
        String city = request.getParameter("city");
        String zip = request.getParameter("zip");

        UserBean userBean = new UserBean(firstname,lastname,country,username,
                     password,email,streetNumber, street,city,zip);

        // If all informations about a user are valid and the username don't
        // exist yet, then the user can be record in Nobitsgram database
        if(userBean.isValid() && !usersManager.isAllreadyRecord(username)){

            User newUser = new User();
            newUser.setFirstname(firstname);
            newUser.setLastname(lastname);
            newUser.setCountry(country);
            newUser.setEmail(email);
            newUser.setUsername(username);
            newUser.setPassword(password);

            if(userBean.isValidAddress()){
                String address = streetNumber+"+"+street+"+"+city+"+"+zip;

                String tmp = new ResearchGeocode(address).getLatLng();
                String s = new MyParser().getLatLong(tmp);
                int i = s.indexOf("#");
                String lat = s.substring(0, i);
                String lng = s.substring(i+1);

                newUser.setLatitude(Double.parseDouble(lat));
                newUser.setLongitude(Double.parseDouble(lng));
            }


            Topic topic = new Topic(topicName);

            usersManager.create(newUser);
            // We get the id of topic in database. If the this topic don't
            // exist yet in database, it return -1, else it return the id of
            // the topic which have the same name with this topic
            int topicId = topicsManager.getId(topic);


            if( topicId != -1){
                topic = topicsManager.findTopic(topicId);

            }

            else{
                topicsManager.create(topic);

            }
            usersManager.addTopicToUser(newUser,topic);


            ServletContext sc = getServletContext();

            request.setAttribute("username",username);
            sc.getRequestDispatcher("/view/pageClient.jsp").forward(request, response);
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

