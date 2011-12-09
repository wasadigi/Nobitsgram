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
    String username ;//user.getUsername();
    String action = "";
    // For default, topic is snow. If nothing is writte in the field "search
    // Topic" , the topic which will be research is "snow"
    String topic; // = "snow";
    List<List<String>>listTopicUrl = getList();
    List<String> listTopic = getListTopic();
    int curIndex = 0;
    List<String> urlList;




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

            getServletContext().getRequestDispatcher("/view/pageClient.jsp").forward(request, response);

        }
        finally {
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

       ServletContext sc = getServletContext();

       topic = request.getParameter("searchTopic");
       urlList = getListsUrl(topic);
       request.setAttribute("urlList", urlList);
       sc.getRequestDispatcher("/view/searchPage.jsp").forward(request, response);




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
     public List<String> getListsUrl(String topicName){
            List<String> listUrl = null;
            MyParser parser = new MyParser();
            InterrogatorInstagram interrogator = new InterrogatorInstagram();
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
             tmp.add(getListsUrl(s));
         }

         return tmp;
     }

     public void sendUrl(HttpServletRequest request, HttpServletResponse response,
                         ServletContext sc)throws IOException, ServletException{



            sc.getRequestDispatcher("/view/pageClient.jsp").forward(request, response);

     }
}
