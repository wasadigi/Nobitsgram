package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class clientPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("<title>Nobitsgram</title>\n");
      out.write("<!--css page client-->\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/style_client_page.css\" />\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-15\" />\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body id=\"body_bg\" style=\"background-color:#DAEADB;\" >\n");
      out.write("<!--Positionnement du header et du formulaire de login-->\n");
      out.write("<div id =\"header\" style=\" top: 0px; margin-top: 0px\">\n");
      out.write("    <h1 style=\"margin-top: -5px; margin-left: 40%;\"> Nobitsgram </h1>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!--Bare menu-->\n");
      out.write("<div class=\"menu\">\n");
      out.write("  |<a href=\"\">My Account</a>|\n");
      out.write("  <a href=\"\">Friends</a> |\n");
      out.write("   <a href=\"\">Gallery</a> |\n");
      out.write("    <a href=\"\">Map</a> |\n");
      out.write("  <a href=\"\">Logout</a> |\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!--Form search-->\n");
      out.write("<div id=\"posearch\">\n");
      out.write("<form action=\"recherche.html\" method=\"get\">\n");
      out.write("<input type=\"text\" name=\"searchKeywords\" value=\"search\" size=\"25\" onfocus=\"javascript:if(this.value == 'search') this.value='';\" onblur=\"javascript:if(this.value == '') this.value='search';\">\n");
      out.write("<input type=\"submit\" name=\"Submit\" value=\"OK\">\n");
      out.write("<!--<button class=\"btn-search\" value=\"Search\" type=\"submit\"></button> -->\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
