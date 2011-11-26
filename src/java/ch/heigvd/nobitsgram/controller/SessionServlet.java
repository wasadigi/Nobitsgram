/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.util.URLParser;
import ch.heigvd.nobitsgram.util.ResearchTag;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "sessionServlet", urlPatterns = {"/sessionServlet"})
public class SessionServlet extends HttpServlet {

    static int i = 0;
    // For default, topic is snow. If nothing is writte in the field "search
    // Topic" , the topic which will be research is "snow"
    String topic = "snow";
    List<String> listTopic = null;


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
            response.sendRedirect("/nobitsgram/view/pageClient.jsp");
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
        processRequest(request, response);
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

        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        ServletContext sc = getServletContext();


        String url;
       // HttpSession session = request.getSession(true);
        if(action.equals("Refresh")){

            listTopic = getListsUrl(topic);
             i = (i+3) % (listTopic.size()-1);
            try{
                url = listTopic.get(i);
            }
            catch(IndexOutOfBoundsException exc){
                url = "";
            }
            request.setAttribute("url", url);

            sc.getRequestDispatcher("/view/pageClient.jsp").forward(request, response);


        }

        else if(action.equals("Add Topic")){


        }

        else{
            topic = request.getParameter("searchTopic");
            listTopic = getListsUrl(topic);
            i = (i+3) % (listTopic.size()-1);
            try{
                url = listTopic.get(i);
            }
            catch(IndexOutOfBoundsException exc){
                url = "";
            }
            request.setAttribute("url", url);

            sc.getRequestDispatcher("/view/pageClient.jsp").forward(request, response);

        }



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
            List<String> listUrl;
            URLParser parser = new URLParser();
            ResearchTag research = new ResearchTag();
            research.setUrl(topicName);

            String resultResearch = research.getSearcResult();

            listUrl = parser.getListUrls(resultResearch);

            return listUrl;
     }

}
