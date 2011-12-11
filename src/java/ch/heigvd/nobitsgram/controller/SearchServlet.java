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
    private List<String> urlList;
    private String message="";
    private String topic;
    private HttpSession session;
    private String access_token = null;
    private User user=null;
    private String tagInfo;




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

       ServletContext sc = getServletContext();
       session = request.getSession();
       user = (User)session.getAttribute("user");

       if(user != null && urlList == null){
            access_token = user.getAcces_token();
       }

       topic = request.getParameter("searchTopic");

       if(urlList == null && topic.trim().equals("")){
            message = "Please type some words in the search box!";

       }


       if(urlList!=null && urlList.isEmpty() && topic.trim()!=""){
            urlList = null;
            message = "Nothing find!";
       }

        else if(topic.trim()!= ""){
            tagInfo = getInfoTopic(topic);
            urlList = getListsUrl(topic,access_token);
            message = topic +" : "+tagInfo;
       }

       System.out.println("MESSAGE =====> "+message);

       request.setAttribute("urlList", urlList);
       request.setAttribute("message",message);
       sc.getRequestDispatcher("/view/searchPage.jsp").forward(request, response);



    }


    /*
     * This method return the informations about a topic which is in parameter
     */
    public String getInfoTopic(String topicName){
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
