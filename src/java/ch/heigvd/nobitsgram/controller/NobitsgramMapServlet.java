/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.entity.User;
import ch.heigvd.nobitsgram.manager.UsersManager;
import ch.heigvd.nobitsgram.model.MapUser;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "NobitsgramMapServlet", urlPatterns = {"/NobitsgramMapServlet"})
public class NobitsgramMapServlet extends HttpServlet {
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
            User user = (User)session.getAttribute("user");
            List<User> users = usersManager.findAllUser();
                        
            session.setAttribute("users", users);            
            sc.getRequestDispatcher("/view/nobitsgramMap.jsp").
                    forward(request, response);
        }
        catch(Exception except){
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

  
    public List<MapUser> getMapUsers(List<User> users){
        
        List<MapUser> tmp = new ArrayList<MapUser>();
        
        String s;
        for(User user:users){
         MapUser mapUser = new MapUser();
         
            mapUser.setUsername(user.getUsername());
            mapUser.setLat(user.getLatitude());
            mapUser.setLng(user.getLongitude());
            mapUser.setProfilePicture(user.getProfile_picture());
            mapUser.setIsConnected(user.isConnect());
            
            if(user.isZoomOut()){
                s = user.getCountry();
            }
            
            else if(user.getCity() != null && user.getStreet() == null){
                s = user.getCity();
            }
            else{
               s = user.getStreet();
            }
            
            mapUser.setAddress(s);
            tmp.add(mapUser);
        }
        
        return tmp;
    }
    
}
