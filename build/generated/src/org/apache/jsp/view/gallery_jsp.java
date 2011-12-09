package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class gallery_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("    <title>Nobitsgram</title>\n");
      out.write("        <!-- client page css -->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/style_client_page.css\" />\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-15\" />\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body id=\"body_bg\" style=\"background-color:#DAEADB;\" >\n");
      out.write("        ");
 String root = request.getContextPath(); 
      out.write("\n");
      out.write("        <!--Positionnement du header et du formulaire de login-->\n");
      out.write("        <div id =\"header\" style=\"\">\n");
      out.write("            <br/>\n");
      out.write("            <img src =\"../images/nobitsgramLogo3.jpg\" style=\"margin-left:35%; \"/>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"bar\" style=\"height:50px;\">\n");
      out.write("            <a href=\"\" id=\"Home\" class=\"selected\">\n");
      out.write("                <img class=\"\" src=\"../images/home1.jpg\"  style=\"top:7px;margin-right:10px;position: relative\"/>Home</a>\n");
      out.write("                <a href=\"\" id=\"\">\n");
      out.write("                    <img class=\"\" src=\"../images/account1.jpg\" style=\"top:7px;margin-right:10px;position: relative\" />My account</a>\n");
      out.write("            <a href=\"\" id=\"Gallery\" style=\"margin-top: -3px;\" >\n");
      out.write("                <img class=\"\" src=\"../images/gallery.jpg\" style=\"top:7px;margin-right:10px;position: relative\"/>Gallery</a>\n");
      out.write("            <a href=\"\" id=\"\">\n");
      out.write("                <img class=\"\" src=\"../images/friends3.jpg\" style=\"top:7px;margin-right:10px;position: relative\" />Friend</a>\n");
      out.write("            <a href=\"\" id=\"\"><img class=\"\" src=\"../images/map.jpg\" style=\"top:7px;margin-right:10px;position: relative\"  />Map</a>\n");
      out.write("            <a href=\"\" id=\"\"><img class=\"\" src=\"../images/logout1.jpg\" style=\"top:7px;margin-right:10px;position: relative\" />Logout</a>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--Bare menu-->\n");
      out.write("\n");
      out.write("            <form action=\"");
 out.print(root+ "/sessionServlet"); 
      out.write("\" method=\"get\" id=\"posearch\">\n");
      out.write("                <input type=\"text\" name=\"searchTopic\" value=\"search\" size=\"25\">\n");
      out.write("                 <input type=\"submit\" name=\"Submit\" value=\"find\">\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <br/>\n");
      out.write("\n");
      out.write("<br/>\n");
      out.write("<table style=\"margin-left:25%;\">\n");
      out.write("    <tr>\n");
      out.write("        <td>\n");
      out.write("            <img src=\"\" style=\"background: #FF8C00;width: 200px;height:150px;\" />\n");
      out.write("        </td>\n");
      out.write("        <td>\n");
      out.write("            <img src=\"\" style=\"background: #FFA07A;width: 200px;height:150px;\" />\n");
      out.write("        </td>\n");
      out.write("        <td>\n");
      out.write("            <img src=\"\" style=\"background: #FF2400;width: 200px;height:150px;\" />\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("</table>\n");
      out.write("<br/>\n");
      out.write("<table style=\"margin-left:25%;\">\n");
      out.write("    <tr>\n");
      out.write("        <td>\n");
      out.write("            <img src=\"\" style=\"background: #D3D3D3;width: 200px;height:150px;\" />\n");
      out.write("        </td>\n");
      out.write("        <td>\n");
      out.write("            <img src=\"\" style=\"background: #B9D3EE;width: 200px;height:150px;\" />\n");
      out.write("        </td>\n");
      out.write("        <td>\n");
      out.write("            <img src=\"\" style=\"background: #6C7B8B;width: 200px;height:150px;\" />\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("</table>\n");
      out.write("<br/>\n");
      out.write("<table style=\"margin-left:25%;\">\n");
      out.write("    <tr>\n");
      out.write("        <td>\n");
      out.write("            <img src=\"\" style=\"background: #7D26CD;width: 200px;height:150px;\" />\n");
      out.write("        </td>\n");
      out.write("        <td>\n");
      out.write("            <img src=\"\" style=\"background: #007FFF;width: 200px;height:150px;\" />\n");
      out.write("        </td>\n");
      out.write("        <td>\n");
      out.write("            <img src=\"\" style=\"background: #00FFFF;width: 200px;height:150px;\" />\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("</table>\n");
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
