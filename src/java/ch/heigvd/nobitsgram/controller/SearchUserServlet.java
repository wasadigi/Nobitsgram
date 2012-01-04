/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.manager.TopicsManager;
import ch.heigvd.nobitsgram.entity.Topic;
import java.util.*;
import java.io.IOException;
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
@WebServlet(name = "SearchUserServlet", urlPatterns = {"/SearchUserServlet"})
public class SearchUserServlet extends HttpServlet {
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
        try{
            String topicSearch = request.getParameter("topicSearchUser");
            List<Topic> topicsLike = topicsManager.getTopicLike(topicSearch);

            session.setAttribute("topicsLike", topicsLike);
            sc.getRequestDispatcher("/nobitsgramAdmin/administrator/searchUserTopicPage.jsp").forward(request, response);
        }
        catch(Exception exc){
            sc.getRequestDispatcher("/nobitsgramAdmin/administrator/home.jsp").forward(request, response);
        }
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
        
    }

  
}
