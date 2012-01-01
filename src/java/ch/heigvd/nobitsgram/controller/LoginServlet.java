/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.entity.User;
import ch.heigvd.nobitsgram.manager.UsersManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
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
            response.sendRedirect(request.getContextPath()+"/view/login.jsp");
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
        User user = null;
        try{
            List<User> myList = usersManager.getUser("username",username);
            
            if(myList != null && !myList.isEmpty()){
                user = myList.get(0);           
            }
        }
        catch(Exception exc){
           
        }

        if((!username.trim().equals("") && !password.trim().equals(""))&&
             user != null){

            // If password don't match with the username we redirect the
            // user to login error page
            if(!usersManager.isPasswordOK(user,password)){
                response.sendRedirect(request.getContextPath()+"/view/errorLogin.jsp");
            }
            else{
                // If user was blocked, we redirect him to a page which him
                // that he has been blocked
                if(user.isIsBlocked()){
                    response.sendRedirect(request.getContextPath()+"/view/forbidenPage.jsp");
                }
                else{
                    HttpSession session = request.getSession();
                    // We set the value which indicate how many time user
                    // has been connected to his account
                    user.setCountConnection(user.getCountConnection()+1);
                    
                    Calendar currentDate = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
                    Calendar date = user.getLastDateConnection();
                    
                    // We check if the month change. If it change, we set the 
                    // countMonthConnection to one, because it is the first connection
                    // in that month
                    if(currentDate.get(currentDate.MONTH) != date.get(date.MONTH)){
                        user.setCountMonthConnection(1);
                        // We change the lastDateConnection
                        user.setLastDateConnection(currentDate);
                    }
                    // We increment the countMonthConnection
                    else{
                        user.setCountMonthConnection(user.getCountMonthConnection()+1);
                    }
                    
                    
                    session.setAttribute("username", username);
                    user.setIsConnect(true);
                    user = usersManager.edit(user);
                    session.setAttribute("user", user);        
                    response.sendRedirect(request.getContextPath()+"/GalleryServlet");
                }
            }
        }
        // Return a jsp page error where the username don't exist in the
        // database or the password don't match with the username
        else{
           response.sendRedirect("/nobitsgram/view/errorLogin.jsp");
        }




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
