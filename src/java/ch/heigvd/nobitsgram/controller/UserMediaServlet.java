/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.entity.User;
import ch.heigvd.nobitsgram.util.InterrogatorInstagram;
import ch.heigvd.nobitsgram.util.MyParser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 *
 * @author Eyram
 */
@WebServlet(name = "UserMediaServlet", urlPatterns = {"/UserMediaServlet"})
public class UserMediaServlet extends HttpServlet {

 
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
            ServletContext sc = request.getServletContext();
            List<String> listMediaUrl = new ArrayList<String>();
            
            try{
                HttpSession session = request.getSession();
                User user = (User)session.getAttribute("user");
                String url = "https://api.instagram.com/v1/users/"+user.getId_Instagram()+
                             "/media/recent/?access_token="+user.getAcces_token();
                InterrogatorInstagram inter = new InterrogatorInstagram();
                listMediaUrl = getListURL(url, inter);
                session.setAttribute("listMediaUrl",listMediaUrl);
                sc.getRequestDispatcher("/view/myMedia.jsp").
                   forward(request, response);   
            }
            catch(Exception exc){
                response.sendRedirect(request.getContextPath()+"/view/pagelogin.jsp");
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
        doGet(request, response);
    }
    
     /*
     * This method get the list 
     */
    private List<String> getListURL(String url,InterrogatorInstagram inter){
        String response = inter.getSearcResult(url);
        
        // We indicate to parser to remove all carater "" at the begin
        // and the end of all result it will put in the list
        return MyParser.parseResponse(response,"data","url",true);
    }

    
}
