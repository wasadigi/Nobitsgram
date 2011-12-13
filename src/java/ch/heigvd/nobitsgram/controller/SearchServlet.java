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


       if(urlList!=null && urlList.isEmpty() && topic.trim()!=""){
            urlList = null;
            message = "Nothing find!";
       }

        else if(topic.trim()!= ""){
            tagInfo = getInfoTopic(topic,access_token);
            urlList = getListsUrl(topic,access_token);
            message = "Result for \""+topic +"\" : "+tagInfo;
       }

       System.out.println("URLLIST Null =====> "+urlList==null);
       System.out.println("URLLIST =====> "+urlList.isEmpty());

       System.out.println("MESSAGE =====> "+message);
       System.out.println("URLlist.size ==> "+urlList.size());

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
       interrogator.setSearchInfoUrl(topicName);
       String url = interrogator.getUrl();

       String resultResearch = interrogator.getSearcResult(url);
       return MyParser.getValue(resultResearch,"media_count",":,").replace(":","");
    }

    public List<String> getListsUrl(String topicName,String access_token){
            List<String> listUrl = null;

            InterrogatorInstagram interrogator = new InterrogatorInstagram();
            interrogator.setAccesToken(access_token);
            interrogator.setSearchUrl(topicName);

            String url = interrogator.getUrl();

            String resultResearch = interrogator.getSearcResult(url);

            listUrl = MyParser.getListUrls(resultResearch);

            return listUrl;
     }

}
