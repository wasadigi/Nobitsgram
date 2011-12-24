/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.entity.User;
import ch.heigvd.nobitsgram.manager.TopicsManager;
import ch.heigvd.nobitsgram.manager.UsersManager;
import ch.heigvd.nobitsgram.util.InterrogatorInstagram;
import ch.heigvd.nobitsgram.util.MyParser;
import ch.heigvd.nobitsgram.util.UserInstagram;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "FriendServlet", urlPatterns = {"/FriendServlet"})
public class FriendServlet extends HttpServlet {
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
            User user = (User)session.getAttribute("user");
            ServletContext sc = request.getServletContext();
            
            List<UserInstagram> myContacts = getInstaContact(user);
            myContacts = filterToNobitsgram(myContacts);
            
            session.setAttribute("myContacts", myContacts);
            
             sc.getRequestDispatcher("/view/friendsPage.jsp").
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

    
    private List<UserInstagram> getInstaContact(User user){
        String access_token = user.getAcces_token();
        String idInsta = user.getId_Instagram();
        InterrogatorInstagram inter = new InterrogatorInstagram();
        List<UserInstagram> myList = new ArrayList<UserInstagram>();
        String url1 = "https://api.instagram.com/v1/users/"+idInsta
                +"/follows?access_token="+access_token;
        
        String resp1 = inter.getSearcResult(url1);        
        
        myList = MyParser.getUsersFromJson(resp1,"data","username",
                                         "profile_picture","id");
        
        String url2 = "https://api.instagram.com/v1/users/"+
                     idInsta+"/follows?access_token="+access_token;
        
        resp1 = inter.getSearcResult(url2);
        
        myList.addAll(MyParser.getUsersFromJson(resp1,"data","username",
                                         "profile_picture","id"));
        return myList;
    }
    
    
    private List<UserInstagram> filterToNobitsgram(List<UserInstagram> users){
        List<UserInstagram> tmp = new ArrayList<UserInstagram>();                
        int size = users.size();        
        UserInstagram user;
        String id;
     
        for(int i = 0; i < size; i++){
            user = users.get(i);
            id = user.getId();
            // We search in the database if the id matching with an Id_instagram
            // If no, we remove the current user in the tmp list
            if(usersManager.getUser("id_Instagram",id) != null &&
               !usersManager.getUser("id_Instagram",id).isEmpty()){                
                tmp.add(user);                
            }
            
        }
        
        return tmp;
    }
    
}
