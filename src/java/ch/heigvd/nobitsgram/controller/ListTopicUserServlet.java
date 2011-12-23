/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import java.io.IOException;
import java.util.*;
import ch.heigvd.nobitsgram.entity.*;
import ch.heigvd.nobitsgram.manager.*;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eyram
 */
@WebServlet(name = "ListTopicUserServlet", urlPatterns = {"/ListTopicUserServlet"})
public class ListTopicUserServlet extends HttpServlet {
    @EJB
    private UsersManager usersManager;
    @EJB
    private TopicsManager topicsManager;
   
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
        HttpSession session = request.getSession();
        ServletContext sc = request.getServletContext();
        User user = (User)session.getAttribute("user");
        user = usersManager.edit(user);
        List<Topic> topics = user.getTopicList();
        
        refreshTopics(topics);
        session.setAttribute("user", user);
        session.setAttribute("topics", topics);        
        sc.getRequestDispatcher("/view/pageListTopicUser.jsp").
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
        doGet(request, response);
    }

    public void refreshTopics(List<Topic> topics){
        
        for(Topic topic: topics){
            topic = topicsManager.edit(topic);
        }
    }
   
    
}
