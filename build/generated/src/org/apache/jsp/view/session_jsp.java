package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class session_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>session nobitsgr.am</title>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color:#DAEADB;\">\n");
      out.write("\n");
      out.write("        <div id=\"wrap\" class=\"grid-all group\" >\n");
      out.write("\n");
      out.write("<div style=\"width: 350px; margin: 0 auto;\">\n");
      out.write("\n");
      out.write("    <form action=\"/nobitsgr.am/config/checkLogin.jsp\" method=\"POST\" accept-charset=\"utf-8\" class=\"table-style\">\n");
      out.write("        </br></br></br><h1 style=\"width:350px; margin:0em auto;background-color:#022F47;color:#F9FBFF\"><span style=\"margin-left:130px;\">Log in</span></h1>\n");
      out.write("        <table style=\"width:350px;padding:2em;background-color:#0AA9FF\">\n");
      out.write("            <td colspan=\"2\"><h4 style=\"color:#BF0B0B\">Incorrect Login and/or Password</h4></td>\n");
      out.write("            <tr><th><label for=\"id_username\">Username:</label></th><td><input autocapitalize=\"off\" autocorrect=\"off\" type=\"text\" name=\"username\" id=\"id_username\" /></td></tr>\n");
      out.write("<tr><th> <br/><label for=\"id_password\">Password:</label></th><td><br/><input autocapitalize=\"off\" autocorrect=\"off\" type=\"password\" name=\"password\" id=\"id_password\" /></td></tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        <p><span style=\"margin-left:140px;\"><input type=\"submit\" value=\"Log in\" class=\"button\" style=\"border:1px solid #f6b22b;background:#fbe26eE;width:100px;background-color:#F7D92E;height: 35px;font-size:18px \">\n");
      out.write("            </span></p>\n");
      out.write("        <p><h4>Do you have already an acount? <a href=\"/nobitsgr.am/config/registration.jsp\" style=\"margin-left:150px;\">Create on here!</h4> </a>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    </body>\n");
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
