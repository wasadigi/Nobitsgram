/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.entity.*;
import ch.heigvd.nobitsgram.util.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Eyram
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {




    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            getServletContext().getRequestDispatcher("/view/searchPage.jsp").forward(request, response);

        }
        finally {
            out.close();
        }
    }


    /**
     *
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        // We get the urlList from the session
        List<String> urlList =(List<String>)session.getAttribute("urlList");
        // We set the message to empty always the jsp page call this servlet
        String message="";
        String topic;
        String access_token = null;
        User user=(User)session.getAttribute("user");
        String tagInfo;

       ServletContext sc = getServletContext();


       // We get the acces token unless if the urlList was not yet set
       if(user != null && urlList == null){
            access_token = user.getAcces_token();
       }

       topic = request.getParameter("searchTopic");

       if(topic.trim().equals("") && urlList == null){
            message = "Please type some words in the search box!";

       }



      if(topic.trim()!= ""){

            urlList = getListsUrl(topic,access_token);
            if(urlList.isEmpty()){
                message = "No matching topic for \""+topic+"\"";
            }
            else{
                tagInfo = getInfoTopic(topic,access_token);
                if(tagInfo != "")
                    message = "Result for \""+topic +"\" : "+tagInfo;
                else{
                    message = "An error occured when we try to get the number of topic";
                }
            }
       }
      
       session.setAttribute("urlList", urlList);
       session.setAttribute("message",message);       
       sc.getRequestDispatcher("/view/searchPage.jsp").forward(request, response);



    }


    /*
     * This method return the informations about a topic which is in parameter
     */
    public String getInfoTopic(String topicName,String access_token){
       InterrogatorInstagram interrogator = new InterrogatorInstagram();
       interrogator.setAccesToken(access_token);
       
       String url = "https://api.instagram.com/v1/"+"tags/"+topicName+"?access_token="+access_token;
       
     

       String resultResearch = interrogator.getSearcResult(url);
       String s = "";
       if(resultResearch != null){
            s = MyParser.getValue(resultResearch,"media_count",":,").replace(":","");
                  
       }
        
       return s;
    }

    public List<String> getListsUrl(String topicName,String access_token){
            List<String> listUrl = new ArrayList<String>();

            InterrogatorInstagram interrogator = new InterrogatorInstagram();
            interrogator.setAccesToken(access_token);
            
            String url = "https://api.instagram.com/v1/tags/"+topicName+"/media/recent?access_token="+access_token;

            String resultResearch = interrogator.getSearcResult(url);

            //We check if the result is not null before we affect it to listUrl
            if(resultResearch != null){
                listUrl = MyParser.getListUrls(resultResearch);
            }
            return listUrl;
     }

}
