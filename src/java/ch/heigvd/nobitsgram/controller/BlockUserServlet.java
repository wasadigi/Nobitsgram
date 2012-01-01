/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.entity.User;
import ch.heigvd.nobitsgram.manager.UsersManager;
import ch.heigvd.nobitsgram.util.MyParser;
import java.io.IOException;
import java.util.*;
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
@WebServlet(name = "BlockUserServlet", urlPatterns = {"/BlockUserServlet"})
public class BlockUserServlet extends HttpServlet {
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
        HttpSession session = request.getSession();
        ServletContext sc = request.getServletContext();        
        try{
            String[] tabID = request.getParameterValues("blockID");            
            blockUsers(tabID,session);            
        }
        catch(NullPointerException except){
            String errorBlock = "You don't select any user to block!";            
            session.setAttribute("errorBlock", errorBlock);
            
        }
        sc.getRequestDispatcher("/nobitsgramAdmin/administrator/home.jsp").forward(request, response);
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

    public void blockUsers(String[] tab, HttpSession session){
        List<User> users = usersManager.findAllUser();
        int i;
        User user;
        try{
            for(String s:tab){                
                i = Integer.parseInt(s);
                user = users.get(i);                
                user.setIsBlocked(!user.isIsBlocked());;                
                user = usersManager.edit(users.get(i));                
            }
        }
        catch(Exception ex){
            
        }
        
        session.removeAttribute("users");
        session.setAttribute("users", users);
    }
    
    
}
