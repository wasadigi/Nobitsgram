/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.util.MyParser;
import ch.heigvd.nobitsgram.util.InterrogatorInstagram;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "WelcomeServlet", urlPatterns = {"/WelcomeServlet"})
public class WelcomeServlet extends HttpServlet {

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

            getServletContext().getRequestDispatcher("/view/pagelogin.jsp").forward(request, response);
        }
        finally {
            out.close();
        }
    }


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
        String myAccess_token = "10840565.f59def8.778aab0dc2d64a8ca9c27694ed9444bc";
        String topicName = "nobits";
        String urlTopic = "https://api.instagram.com/v1/tags/"+topicName+"/media/recent?access_token="+myAccess_token;
        
        // We create a list of url with the name nobits
        List<String> listTopicRefresh = getListsUrl(urlTopic);        
        session.setAttribute("listTopicRefresh", listTopicRefresh);        
        sc.getRequestDispatcher("/view/pagelogin.jsp").forward(request, response);
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

    
    /*
     * This method create a list of url according to the topic name we get in
     * parameter
     */
    public List<String> getListsUrl(String url){
            List<String> listUrl = new ArrayList<String>();
            InterrogatorInstagram interrogator = new InterrogatorInstagram();            

            // Get the result when an instance of InterrogatorInstagram do a request
            // to the instagram site.
            String resultResearch = interrogator.getSearcResult(url);             
            listUrl = MyParser.parseResponse(resultResearch,"data","url",true);            
            return listUrl;
     }

}
