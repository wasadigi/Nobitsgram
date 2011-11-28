package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pageClient_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <title>Nobitsgram</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <form action=\"/nobitsgram/sessionServlet\" method=\"POST\" accept-charset=\"utf-8\">\n");
      out.write("\n");
      out.write("            ");
      java.lang.String url = null;
      synchronized (session) {
        url = (java.lang.String) _jspx_page_context.getAttribute("url", PageContext.SESSION_SCOPE);
        if (url == null){
          url = new java.lang.String();
          _jspx_page_context.setAttribute("url", url, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("            ");
      java.lang.String username = null;
      synchronized (session) {
        username = (java.lang.String) _jspx_page_context.getAttribute("username", PageContext.SESSION_SCOPE);
        if (username == null){
          username = new java.lang.String();
          _jspx_page_context.setAttribute("username", username, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("            ");
 url =(String)request.getAttribute("url");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <h2 style=\"margin-left: 500px;\"> Wellcome ");
 out.println(username); 
      out.write(" </h2>\n");
      out.write("       <div style=\"width: 400px;height:300px; margin: 0 auto;background:#0AA9FF\">\n");
      out.write("\n");
      out.write("           <img src= \"");
out.print(url);
      out.write("\" name =\"image\"\n");
      out.write("             style=\"width: 400px; height: 300px\" >\n");
      out.write("       </div>\n");
      out.write("         <p>  <span style=\"margin-left:620px;\">\n");
      out.write("                 <input type=\"submit\" name =\"action\" value=\"Refresh\" class=\"button\"\n");
      out.write("                         style=\"border:1px solid #00CC00;\n");
      out.write("                         width:100px;\n");
      out.write("                         background-color:#00CC00;\n");
      out.write("                         height: 35px;font-size:18px;\">\n");
      out.write("               </span>\n");
      out.write("\n");
      out.write("\n");
      out.write("          </p>\n");
      out.write("           <table style=\" margin: 0 auto;width:900px;height: 60px;background: #DCDCDC\">\n");
      out.write("               <td> <label name=\"Topic\">Topic:</label>\n");
      out.write("              <input name=\"Topic\" size=\"30\" type=\"text\"/>\n");
      out.write("              <input type=\"submit\" name =\"action\" value=\"Add Topic\" class=\"button\"\n");
      out.write("                         style=\"border:1px solid #f6b22b;\n");
      out.write("                         background:#fbe26eE;width:100px;\n");
      out.write("                         background-color:#F7D92E;\n");
      out.write("                         height: 35px;font-size:18px;\">\n");
      out.write("              </td>\n");
      out.write("              <td><label name=\"search\" style=\"margin-left: 70px\" >Search Topic:</label>\n");
      out.write("            <input name=\"searchTopic\" size=\"30\" type=\"text\"/>\n");
      out.write("            <input type=\"submit\" name =\"action\" value=\"Search\" class=\"button\"\n");
      out.write("                         style=\"border:1px solid #f6b22b;\n");
      out.write("                         background:#fbe26eE;width:100px;\n");
      out.write("                         background-color:#F7D92E;\n");
      out.write("                        height: 35px;font-size:18px;\">\n");
      out.write("            </td>\n");
      out.write("\n");
      out.write("          </table>\n");
      out.write("          \n");
      out.write("       </form>\n");
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
