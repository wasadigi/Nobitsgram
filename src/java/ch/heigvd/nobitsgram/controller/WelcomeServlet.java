/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.controller;

import ch.heigvd.nobitsgram.util.MyParser;
import ch.heigvd.nobitsgram.util.InterrogatorInstagram;
import java.io.IOException;
import java.io.PrintWriter;
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

    /*
     * This method send the url to the jsp page which call this servlet
     */
    public void sendUrlToJSP(HttpServletRequest request, HttpServletResponse response,
                         ServletContext sc)throws IOException, ServletException{
        
        // We create a list of url with the name nobits
        List<String> listTopic = getListsUrl("nobits");
        int i = 0;

        // This variable will be increment to scan the list
        HttpSession session;
        int size = listTopic.size();
        String url = listTopic.get((i++)%size);
        request.setAttribute("url", url);
        sc.getRequestDispatcher("/view/pagelogin.jsp").forward(request, response);

     }

    /*
     * This method create a list of url according to the topic name we get in
     * parameter
     */
    public List<String> getListsUrl(String topicName){
            List<String> listUrl = null;
            InterrogatorInstagram interrogator = new InterrogatorInstagram();
            interrogator.setSearchUrl(topicName);
            String url = interrogator.getUrl();


            // Get the result when an instance of InterrogatorInstagram do a request
            // to the instagram site.
            String resultResearch = interrogator.getSearcResult(url);

            listUrl = MyParser.getListUrls(resultResearch);

            return listUrl;
     }

}
