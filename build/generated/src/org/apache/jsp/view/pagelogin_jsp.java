package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pagelogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html>\n");
      out.write("    ");
 String root = request.getContextPath(); 
      out.write("\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <title>Welcome to Nobitsgram</title>\n");
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"/nobitsgram/css/style.css\" />\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-15\" />\n");
      out.write("        <title>Nobitsgram</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <body id=\"body_bg\" style=\"background-color:#DAEADB;\">\n");
      out.write("        <!--Positionnement du header et du formulaire de login-->\n");
      out.write("        <div id =\"header\">\n");
      out.write("            <div style=\"width: 300px;\">\n");
      out.write("\n");
      out.write("                <form id = \"formlogin\" action=\"");
 out.print(root+ "/LoginServlet"); 
      out.write("\" method=\"POST\" accept-charset=\"utf-8\" name =\"Login\" class=\"table-style\" align=\"right\">\n");
      out.write("\n");
      out.write("                    <h1 style=\"width:250px; margin:0em auto;color:#F9FBFF\">\n");
      out.write("                        <span style=\"margin-left:130px;\">Log in</span>\n");
      out.write("                    </h1>\n");
      out.write("\n");
      out.write("                    <table style=\"width:350px;\" >\n");
      out.write("                            <tr>\n");
      out.write("                                <th><label style=\"color:#FFFFFF\">Username:</label></th>\n");
      out.write("                                <td><input type=\"text\" name=\"username\"/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>\n");
      out.write("                                    <br/><label style=\"color:#FFFFFF\">Password:</label>\n");
      out.write("                                </th>\n");
      out.write("                                <td>\n");
      out.write("                                    <br/><input type=\"password\" name=\"password\"/>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                    </table>\n");
      out.write("\n");
      out.write("                    <span style=\"margin-left:160px;\">\n");
      out.write("                        <input style=\"border:0;width:70px; height:25px\" src=\"");
 out.print(root+ "/images/login1.jpg"); 
      out.write("\"  type=\"image\" value=\"submit\" align=\"middle\" />\n");
      out.write("\n");
      out.write("                    </span>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div style=\"width: 250px;\">\n");
      out.write("\n");
      out.write("                <form id = \"formregister\" action=\"");
 out.print(root+"/RegisterServlet"); 
      out.write("\"\n");
      out.write("                                method=\"POST\" accept-charset=\"utf-8\"\n");
      out.write("                                name =\"Login\" class=\"table-style\" align=\"right\">\n");
      out.write("\n");
      out.write("                    <h4 style=\"width:360px; margin-bottom: 7px;color:#FFF68F\">\n");
      out.write("                        <span style=\"margin-left:140px;\">Have you already an account?</span>\n");
      out.write("                    </h4>\n");
      out.write("                    <br/>\n");
      out.write("\n");
      out.write("                    <div id=\"cadreregister\">\n");
      out.write("                        <span style=\"margin-left:80px;\">\n");
      out.write("                                 ");


                String client_id = "5e2a174a39804619840925781251b646";
                String redirect_uri = request.getRequestURL().toString()+"RegistrationServlet";

                String response_type = "code";
                String oauth_url = "https://api.instagram.com/oauth/authorize/";

                String url =oauth_url+"?client_id="+client_id+
                "&redirect_uri="+redirect_uri+
                "&response_type="+response_type;
                    
      out.write("\n");
      out.write("                <a href=\"");
out.print(url);
      out.write("\" ><img src=\"");
 out.print(root+ "/images/register_1.jpg"); 
      out.write("\"  style=\"border:0; height:30px; width:150px\"  target=\"cadre1\"/></a>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </span>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"cadreInstagram\">\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("<form action=\"");
 out.print(root+ "/WelcomeServlet"); 
      out.write("\" method=\"POST\" id=\"RefreshUrl\" accept-charset=\"utf-8\">\n");
      out.write("        <!--Texte instagram-->\n");
      out.write("        <div id=\"cadretexteInstagram\">\n");
      out.write("                <font style =\"font-size: 75px; color: #330099; margin-left: 100px;\"> Nobitsgram</font>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--Mise en place du cadre pour l'image-->\n");
      out.write("\n");
      out.write("\n");
      out.write("            <script language=\"JavaScript\">\n");
      out.write("                setInterval( \"RefreshImage();\", 5000 );\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                $(function () {\n");
      out.write("                RefreshImage = function(){\n");
      out.write("\n");
      out.write("                $('#RefreshUrl').fadeOut(\"slow\").load('/nobitsgram/WelcomeServlet').fadeIn(\"slow\");\n");
      out.write("\n");
      out.write("                }\n");
      out.write("                 });\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("                    ");
 url =(String)request.getAttribute("url");
                        if(url == null){
                            url = "http://distilleryimage2.instagram.com/fabbedf01cd411e180c9123138016265_7.jpg";
                        }
                    
      out.write("\n");
      out.write("\n");
      out.write("            <table id= \"global\" bgcolor=\"#000000\">\n");
      out.write("            <tr>\n");
      out.write("              <th> <img src=\"");
out.print(url);
      out.write("\" name=\"image\" style=\"width:300px; height:240px;\"/></th>\n");
      out.write("             </tr>\n");
      out.write("            </table>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
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
