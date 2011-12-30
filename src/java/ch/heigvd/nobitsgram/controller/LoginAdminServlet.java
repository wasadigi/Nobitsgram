/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "LoginAdminServlet", urlPatterns = {"/LoginAdminServlet"})
public class LoginAdminServlet extends HttpServlet {


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
        String adminUsername = "admin";
        String error = null;
        ServletContext sc = request.getServletContext();
        HttpSession session = request.getSession();
        
        // We will choose for next time a strong password
        String adminPassword = "123";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // If the username and password are correct, we redirect the user to
        // the nobitsgram administrator home page
        if(username.equals(adminUsername) && password.equals(adminPassword)){
            response.sendRedirect(request.getContextPath()+"/HomeServlet");
        }
        else{
            error = "Your username or your password is not correct ";
            session.setAttribute("error",error);
           sc.getRequestDispatcher("/nobitsgram/administrator/administrator.jsp").
                     forward(request, response);
        }
      
    }

    
}
