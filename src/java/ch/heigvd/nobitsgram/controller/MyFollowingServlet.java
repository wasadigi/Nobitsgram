/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.model.UserInstagram;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ch.heigvd.nobitsgram.entity.*;
import ch.heigvd.nobitsgram.model.Picture;
import ch.heigvd.nobitsgram.util.*;
import java.util.*;
import javax.servlet.ServletContext;

/**
 *
 * @author Eyram
 */
@WebServlet(name = "MyFollowingServlet", urlPatterns = {"/MyFollowingServlet"})
public class MyFollowingServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            ServletContext sc = request.getServletContext();

            HttpSession session = request.getSession();

            InterrogatorInstagram inter = new InterrogatorInstagram();

            User user = (User)session.getAttribute("user");
            String access_token = user.getAcces_token();       

            String followingUrl ="https://api.instagram.com/v1/users/"+
                         user.getId_Instagram()+"/follows?access_token="+access_token;
            // We get the list of Instagram user which the user is follow by
            List<UserInstagram> followings = getListUserInstgram(followingUrl, inter);            
           
            followings = setListUrl(followings, inter, access_token);

            session.setAttribute("followings", followings);

            sc.getRequestDispatcher("/view/myFollowings.jsp").
                     forward(request, response);
        }
        catch(NullPointerException nulExc){
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

    
    
    public List<UserInstagram> getListUserInstgram(String url, InterrogatorInstagram inter){
                
        String result = inter.getSearcResult(url);        
        return MyParser.getUsersFromJson(result,"data","username",
                                         "profile_picture","id");
    }
    
    
    
    
    public List<UserInstagram> setListUrl(List<UserInstagram> myList, 
                              InterrogatorInstagram inter,String access_token){
        List<UserInstagram> tmp = myList;
        int size = tmp.size();
        String urlPart1 = "https://api.instagram.com/v1/users/";
        String urlPart2 = "/media/recent/?access_token=";
        String url;
        String response;
        List<String> pictureUrl;
        List<String> pictureIds;        
        List<Picture> pictures;
        
        // we scan the list and for each userInstagram, we get it recent picture
        // which we set to it
        for(int i = 0; i < size; i++){
            pictures = new ArrayList<Picture>();
            // For each user we build the request which get us his recent pictures
            url = urlPart1+tmp.get(i).getId()+urlPart2+access_token;
            response = inter.getSearcResult(url);
            pictureUrl = MyParser.parseResponse(response,"data","url", true);
            pictureIds = MyParser.getPictureIDs(response, "id");
            
            // For each url and id we build new picture which we add to list 
            // of picture
            for(int j = 0; j < pictureUrl.size(); j++){
                pictures.add(new Picture(pictureUrl.get(j),pictureIds.get(j)));
            }
            // We set the pictures to the current user
            tmp.get(i).setListPictures(pictures);                        
        }
        
        
        return tmp;
    }

}