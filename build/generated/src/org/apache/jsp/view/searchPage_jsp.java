package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Random;
import java.util.List;

public final class searchPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/view/tools/headPage.jspf");
    _jspx_dependants.add("/view/tools/footPage.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        ");
 String root = request.getContextPath(); 
      out.write("\n");
      out.write("    <title>Nobitsgram</title>\n");
      out.write("        <!-- client page css -->\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
 out.print(root+ "/css/style_client_page.css"); 
      out.write("\" />\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-15\" />\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body id=\"body_bg\" style=\"background-color:#DAEADB;\" >\n");
      out.write("\n");
      out.write("        <!--Positionnement du header et du formulaire de login-->\n");
      out.write("        <div id =\"header\" style=\"\">\n");
      out.write("            <br/>\n");
      out.write("            <img src =\"");
 out.print(root+"/images/nobitsgramLogo3.jpg");
      out.write("\" style=\"margin-left:35%; \"/>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <br/>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- client page css -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"bar\" id=\"positionbar\">\n");
      out.write("\n");
      out.write("     <a href=\"");
 out.print(root+ "/view/client.jsp"); 
      out.write("\" id=\"Home\">\n");
      out.write("            <img class=\"\" src=\"");
 out.print(root+"/images/home1.jpg");
      out.write("\" style=\"top:10px;margin-left: -5px;position: relative\"/>Home</a>\n");
      out.write("     <a href=\"");
 out.print(root+ "/view/settingAccount.jsp"); 
      out.write("\" id=\"\">\n");
      out.write("            <img class=\"\" src=\"");
 out.print(root+"/images/account1.jpg");
      out.write("\" style=\"top:10px;margin-left: -5px;position: relative\" />My account</a>\n");
      out.write("     <a href=\"");
 out.print(root+ "/view/gallery.jsp"); 
      out.write("\" id=\"Gallery\"  >\n");
      out.write("            <img class=\"\" src=\"");
 out.print(root+"/images/gallery.jpg");
      out.write("\" style=\"top:10px;margin-left: -5px;position: relative\"/>Gallery</a>\n");
      out.write("     <a href=\"");
 out.print(root+ "/view/friendsPage.jsp"); 
      out.write("\" id=\"\">\n");
      out.write("            <img class=\"\" src=\"");
 out.print(root+"/images/friends3.jpg");
      out.write("\" style=\"top:10px;margin-left: -5px;position: relative\" />Friends</a>\n");
      out.write("     <a href=\"");
 out.print(root+ "/view/map.jsp"); 
      out.write("\" id=\"\">\n");
      out.write("             <img class=\"\" src=\"");
 out.print(root+"/images/map.jpg");
      out.write("\" style=\"top:10px;margin-left: -5px;position: relative\"  />Map</a>\n");
      out.write("     <a href=\"");
 out.print(root+ "/view/searchPage.jsp"); 
      out.write("\" class=\"selected\">\n");
      out.write("             <img class=\"\" src=\"");
 out.print(root+"/images/search1.jpg");
      out.write("\" style=\"top:10px;margin-left: -5px;position: relative\"/>Search</a>\n");
      out.write("\n");
      out.write("<!-- <form action=\"");
// out.print(root+ "/LogoutServlet"); 
      out.write("\" method=\"GET\"> -->\n");
      out.write("            <!-- <input type=\"submit\" name=\"disconnect\" value=\"Logout\"> -->\n");
      out.write("             <a href=\"");
out.print(root+ "/LogoutServlet"); 
      out.write("\" id=\"\">\n");
      out.write("             <img class=\"\" src=\"");
 out.print(root+"/images/logout1.jpg");
      out.write("\" style=\"top:10px;margin-left: -5px;position: relative\" />Logout</a>\n");
      out.write("<!-- </form> -->\n");
      out.write("\n");
      out.write("<form action=\"");
 out.print(root+ "/SearchServlet"); 
      out.write("\" method=\"GET\">\n");
      out.write("            <!-- Bare menu -->\n");
      out.write("            <div id=\"posearch\">\n");
      out.write("                <input type=\"text\" name=\"searchTopic\" value=\"\" size=\"25\">\n");
      out.write("                <input type=\"submit\" name=\"Submit\" value=\"find\">\n");
      out.write("            </div>\n");
      out.write(" </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("     <br/>\n");
      out.write("\n");
      out.write("<br/>\n");
      out.write("     <br/>\n");
      out.write("     ");

        String message = (String)request.getAttribute("message");

        if(request.getAttribute("urlList")!=null){
            List<String> urlList =(List<String>)request.getAttribute("urlList");
           int size = urlList.size(); Random random = new Random(); int j;
          String username =(String)request.getSession().getAttribute("username");
      out.write("\n");
      out.write("\n");
      out.write("          <div style=\"margin-left: 40%\">\n");
      out.write("\n");
      out.write("                   <h2>Result for ");
 out.print(message); 
      out.write("</h2>\n");
      out.write("\n");
      out.write("\n");
      out.write("          </div>\n");
      out.write("<div>\n");
      out.write("    <br/>\n");
      out.write("    <br/>\n");
      out.write("     <br/>\n");
      out.write("\n");
      out.write("    <table style=\"margin-left: 18%\">\n");
      out.write("\n");
      out.write("        <tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");

                for(int i = 0; i < 3; i++) {
                    j = random.nextInt(size);
              
      out.write("\n");
      out.write("            <td>\n");
      out.write("                <span style=\"margin-right: 80px;\"><img src=\"");
 out.print(urlList.get(j));
      out.write("\" style=\"width: 220px;height:170px;\" /></span>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </td>\n");
      out.write("\n");
      out.write("\n");
      out.write("           ");
 }
      out.write("\n");
      out.write("\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
      out.write("</div>\n");
      out.write("            ");

           }
      out.write("\n");
      out.write("\n");
      out.write("<br/>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\n");
      out.write("\t</div>\n");
      out.write("\t</body>\n");
      out.write("</html>");
      out.write('\n');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
