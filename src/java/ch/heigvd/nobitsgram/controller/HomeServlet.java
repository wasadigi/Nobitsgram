/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.entity.User;
import ch.heigvd.nobitsgram.manager.UsersManager;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {
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
            
            ServletContext sc = request.getServletContext();
            HttpSession session = request.getSession();
            // We get the index of the page user want to see
            String action = request.getParameter("action");
            int indexPage;
            
            // If action is null, we show the first page
            if(action == null){
                action ="1";
            }
            
            indexPage = Integer.parseInt(action)-1;
            
            // The number of elements in one page
            String nbElement = (String)session.getAttribute("nbElement");
            int nber;
            int nbPage;
            
            // if the nbElement is null, then we set default number element to 10
            if(nbElement == null){
                nbElement = "10";
            }
            
            nber = Integer.parseInt(nbElement);
            
            List<User> users = usersManager.findAllUser();
            
            nbPage = users.size()/ nber;
            
            if(users.size()%nber != 0){
                nbPage += 1;
            }
            
            //We add the list of user to the administrator session
            session.setAttribute("users", users);
            session.setAttribute("nbPage", nbPage);
            session.setAttribute("nber", nber);
            session.setAttribute("indexPage", indexPage);
            sc.getRequestDispatcher("/nobitsgram/administrator/home.jsp").forward(request, response);
        }
        catch(Exception exc){
            response.sendRedirect(request.getContextPath()+"/nobitsgram/administrator/administrator.jsp");
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
