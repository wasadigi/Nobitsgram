/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.entity.User;
import ch.heigvd.nobitsgram.util.InterrogatorInstagram;
import ch.heigvd.nobitsgram.util.MyParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
            String urlIdMedia = "";
            String urlSearchId = "";
            
            
            List<String> positionUrl = new ArrayList<String>();
            List<String> listId = new ArrayList<String>();
            InterrogatorInstagram inter = new InterrogatorInstagram();
                        
            User user = (User)session.getAttribute("user");            
            if(lat != null){
                                
                urlSearchId = "https://api.instagram.com/v1/locations/search?lat="
                    + lat+"&lng="+lng+"&access_token="+user.getAcces_token();
                listId = getListId(urlSearchId,inter);
                if(listId.isEmpty()){
                    String errorMap = "Any picture in this area";
                    session.setAttribute("errorMap", errorMap);
                }
            }                       
            
            if(!listId.isEmpty()){
                Random random = new Random();
                String id =""+listId.get(random.nextInt(listId.size()));                
                urlIdMedia = "https://api.instagram.com/v1/locations/"
                    +id+"/media/recent/?access_token="+user.getAcces_token();
                positionUrl = getListUrl(urlIdMedia, inter);
                
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

    
    public List<String> getListId(String url,InterrogatorInstagram inter){
       List<String> myList = new ArrayList<String>();
       String resp = inter.getSearcResult(url);       
       myList = MyParser.parseResponse(resp,"data","id",true);      
       return myList;
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
