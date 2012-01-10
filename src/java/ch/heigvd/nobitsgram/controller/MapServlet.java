/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.entity.User;
import ch.heigvd.nobitsgram.manager.UsersManager;
import ch.heigvd.nobitsgram.model.Position;
import ch.heigvd.nobitsgram.model.UserHistory;
import ch.heigvd.nobitsgram.util.InterrogatorInstagram;
import ch.heigvd.nobitsgram.util.MyParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eyram
 */
@WebServlet(name = "MapServlet", urlPatterns = {"/MapServlet"})
public class MapServlet extends HttpServlet {
    @EJB
    UsersManager usersManager;
   
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
            String lat = request.getParameter("latitude");
            String lng = request.getParameter("longitude");
            String urlMediaPosition = "";            
            UserHistory history;
            String errorMap;
            
            List<String> positionUrl = new ArrayList<String>();            
            InterrogatorInstagram inter = new InterrogatorInstagram();
                        
            User user = (User)session.getAttribute("user");            
            if(lat != null){
                
                history = user.getHistory();
                Position position = new Position(lat,lng);
                history.addPosition(position);
                user.setHistory(history);
                user = usersManager.edit(user);
                urlMediaPosition ="https://api.instagram.com/v1/media/search?"
                       + "lat="+lat+"&lng="+lng+"&access_token="+user.getAcces_token();                
                positionUrl = getListUrl(urlMediaPosition, inter);
                
                if(positionUrl.isEmpty()){
                    errorMap = "It haven't any picture in that area!";
                    session.setAttribute("errorMap", errorMap);
                }
                
            }                                   
            
                                    
            session.setAttribute("positionUrl", positionUrl);                              
            sc.getRequestDispatcher("/view/map.jsp").
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

    
    
    
    public List<String> getListUrl(String url,InterrogatorInstagram inter){
        List<String> myList = new ArrayList<String>();
        
        if(url != ""){
            String resp = inter.getSearcResult(url);            
            myList = MyParser.parseResponse(resp,"data","url",true);
        }
                
        return myList;
    }
    
}
