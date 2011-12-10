/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.entity.Topic;
import ch.heigvd.nobitsgram.entity.User;
import ch.heigvd.nobitsgram.manager.UsersManager;
import ch.heigvd.nobitsgram.util.MyParser;
import ch.heigvd.nobitsgram.util.InterrogatorInstagram;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Eyram
 */
@WebServlet(name = "sessionServlet", urlPatterns = {"/sessionServlet"})
public class SessionServlet extends HttpServlet {

    static int i = 0;
    static int j = 0;
    //UsersManager usersManager = new UsersManager();
    //User user = usersManager.findUser(12);
    private String username ;//user.getUsername();
    private String action = "";
    // For default, topic is snow. If nothing is writte in the field "search
    // Topic" , the topic which will be research is "snow"
    private String topic; // = "snow";
    private List<List<String>>listTopicUrl = getList();
    private List<String> listTopic = null;
    private int curIndex = 0;
    private List<String> urlList;
    private String error;

    private HttpSession session;
    private String access_token = null;
    private User user=null;

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

            getServletContext().getRequestDispatcher("/view/client.jsp").forward(request, response);
            //response.sendRedirect(request.getContextPath()+"/view/client.jsp");


        }
        finally {
            out.close();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       ServletContext sc = getServletContext();
       session = request.getSession();
       user = (User)session.getAttribute("user");
       String submit = request.getParameter("Submit");


       if(submit.equals("find")){
           if(user != null && urlList == null){
               access_token = user.getAcces_token();

           }

           topic = request.getParameter("searchTopic");

           if(urlList == null && topic.trim().equals("")){
                error = "You must enter a value to search";


           }
           else{
                if(urlList!=null && urlList.isEmpty()){
                    urlList.clear();
                }
                if(topic.trim()!= ""){
                    urlList = getListsUrl(topic,access_token);
                }

            }

           if(urlList.isEmpty() && topic.trim()!=""){
               urlList = null;
               error = "Nothing find!";
           }

           request.setAttribute("urlList", urlList);
           sc.getRequestDispatcher("/view/searchPage.jsp").forward(request, response);
           //response.sendRedirect(request.getContextPath()+"/view/searchPage.jsp");

       }
       else{
           //sc.getRequestDispatcher("/view/client.jsp").forward(request, response);
           response.sendRedirect(request.getContextPath()+"/view/client.jsp");
       }




        //getServletContext().getRequestDispatcher("/view/pageClient.jsp").forward(request, response);

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




    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /*
     * This method return a list of url.
     */
     public List<String> getListsUrl(String topicName,String access_token){
            List<String> listUrl = null;
            MyParser parser = new MyParser();
            InterrogatorInstagram interrogator = new InterrogatorInstagram();
            interrogator.setAccesToken(access_token);
            interrogator.setSearchUrl(topicName);

            String resultResearch = interrogator.getSearcResult();

            listUrl = parser.getListUrls(resultResearch);

            return listUrl;
     }

     public List<String> getListTopic(){
         List<String> tmp = new ArrayList<String>();
         tmp.add("cat");
         tmp.add("Tokyo");
         tmp.add("sea");
         tmp.add("snow");
         tmp.add("Ferrari");
         return tmp;
     }
     public List<List<String>> getList(){
         int size = getListTopic().size();
         String s;
         List <List<String>> tmp = new ArrayList<List<String>>();
         for(int i = 0; i < size; i++ ){
             s = getListTopic().get(i);

         }

         return tmp;
     }

     public void sendUrl(HttpServletRequest request, HttpServletResponse response,
                         ServletContext sc)throws IOException, ServletException{



            sc.getRequestDispatcher("/view/pageClient.jsp").forward(request, response);

     }
}
