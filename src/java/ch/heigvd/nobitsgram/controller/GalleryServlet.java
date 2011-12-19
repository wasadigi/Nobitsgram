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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import javax.servlet.ServletContext;
/**
 *
 * @author Eyram
 */
@WebServlet(name = "GalleryServlet", urlPatterns = {"/GalleryServlet"})
public class GalleryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
        } finally {            
            out.close();
        }
    }

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
        HttpSession session = request.getSession();        
        User user = (User)session.getAttribute("user");        
        String access_token = user.getAcces_token();
        InterrogatorInstagram inter = new InterrogatorInstagram();
        inter.setLikeMediaUrl(access_token);
        
        // Here we get the url of the media which the user like
        String likeUrl = inter.getUrl();
        List<String> likeUrlList = getListURL(likeUrl,inter);                
        session.setAttribute("likeUrlList", likeUrlList);
        
        // Here we get the url of the media which is match of one of the 
        // topic of the user
        // We get ramdom of a topic
        int size = user.getTopicList().size();
        List<String> topicUrlList = new ArrayList<String>();
        if(size > 0){
            int i = new Random().nextInt(size);            
            String topic = user.getTopicList().get(i).getName();                   
            inter.setSearchUrl(topic);
            String topicUrl = inter.getUrl();                
            topicUrlList = getListURL(topicUrl, inter);           
        }        
        session.setAttribute("topicUrlList",topicUrlList);
        // Here we get the url of the follower
        List<String> followUrlList = new ArrayList<String>();       
        session.setAttribute("followUrlList",followUrlList);        
        
        sc.getRequestDispatcher("/view/gallery.jsp").
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
        processRequest(request, response);
    }

    /*
     * This method get the list 
     */
    private List<String> getListURL(String url,InterrogatorInstagram inter){        
        String response = inter.getSearcResult(url);
        return MyParser.getListUrls(response);         
    }
            
}
