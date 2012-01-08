/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.entity.User;
import ch.heigvd.nobitsgram.manager.UsersManager;
import ch.heigvd.nobitsgram.model.UserHistory;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.ejb.EJB;
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
@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {
@EJB
private UsersManager usersManager;
  
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
        try{                        
            HttpSession session = request.getSession();           
            
            // We disconnect the user
            toDisconnect(session);            
        }
        catch(Exception excp){
            
        }
        response.sendRedirect(request.getContextPath()+"/view/pagelogin.jsp");
    }



    /*
     * This method deconnect the user to nobitsgram
     *
     */
    public void toDisconnect(HttpSession session)
         throws IOException, ServletException{

       User user = (User)session.getAttribute("user");
       UserHistory history = user.getHistory();
       Calendar dateDeconnexion = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault()); 
       history.addDateDeconnexion(dateDeconnexion);
       user.setHistory(history);
       user.setIsConnect(false);               
       user = usersManager.edit(user);
       session.invalidate();
       
    }

}