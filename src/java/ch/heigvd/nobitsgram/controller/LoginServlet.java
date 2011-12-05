/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.entity.User;
import ch.heigvd.nobitsgram.manager.UsersManager;
import java.io.IOException;
import java.io.PrintWriter;
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
 *
 *
 * 
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
@EJB
private UsersManager usersManager;

    /**
     *
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            response.sendRedirect("/nobitsgram/view/login.jsp");
        }
        finally {
            out.close();
        }
    }



    /**
     *
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user;
        try{
            user = usersManager.getUser(username);
        }
        catch(Exception exc){
           user = null;
        }


           System.out.println("\t####### USER11 ===> "+user);

        if((!username.trim().equals("") && !password.trim().equals(""))&&
             user != null){


           System.out.println("\t####### USER ===> "+user);

            // If password don't match with the username we redirect the
            // user to login error page
            if(!usersManager.isPasswordOK(user,password)){
                response.sendRedirect("/nobitsgram/view/errorLogin.jsp");
            }
            else{
                ServletContext sc = getServletContext();
                request.setAttribute("username", username);
                sc.getRequestDispatcher("/view/pageClient.jsp").forward(request, response);
            }
        }
        else{
           response.sendRedirect("/nobitsgram/view/errorLogin.jsp");
        }


        // Return a jsp page error where the username don't exist in the
        // database or the password don't match with the username

            // We redirect to the session.jsp which represent login error page

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
