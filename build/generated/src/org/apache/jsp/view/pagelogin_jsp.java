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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en-us\" lang=\"en-us\">\n");
      out.write("<head>\n");
      out.write("<title>Test page login</title>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-15\" />\n");
      out.write("</head>\n");
      out.write("<body style=\"background-color:#DAEADB;\">\n");
      out.write("<!--Positionnement du header et du formulaire de login-->\n");
      out.write("<div id =\"header\">\n");
      out.write("    <div style=\"width: 300px; margin-left: 130 auto;\">\n");
      out.write("        <form  action=\"/nobitsgram/instagramLogin\" method=\"POST\" accept-charset=\"utf-8\"  class=\"table-style\" align=\"right\">\n");
      out.write("\n");
      out.write("        <span style=\"margin-left:140px;\">\n");
      out.write("            ");


        String client_id = "5e2a174a39804619840925781251b646";
        String redirect_uri = "http://localhost:8080/nobitsgram/view/pageClient.jsp";
        String response_type = "token";
        String oauth_url = "https://api.instagram.com/oauth/authorize/";

        String url =oauth_url+"?client_id="+client_id+
        "&redirect_uri="+redirect_uri+
        "&response_type="+response_type;
            
      out.write("\n");
      out.write("         <a href=\"");
out.print(url);
      out.write("\" title=\"instagram login\" class=\"sign-up-haut btn-sign-up-right\">Sign in with Instagram</a>\n");
      out.write("        </span>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("\t<div style=\"width: 300px; margin: 0 auto;\">\n");
      out.write("\n");
      out.write("\t\t<form id = \"formlogin\" action=\"/nobitsgram/LoginServlet\" method=\"POST\" accept-charset=\"utf-8\" name =\"Login\" class=\"table-style\" align=\"right\">\n");
      out.write("\n");
      out.write("\t\t\t<h1 style=\"width:350px; margin:0em auto;background-color:#022F47;color:#F9FBFF\"><span style=\"margin-left:130px;\">Log in</span></h1>\n");
      out.write("\t\t\t<table style=\"width:350px;padding:1em;\" >\n");
      out.write("\t\t\t\t<tr><th><label>Username:</label></th><td><input type=\"text\" name=\"username\"/></td></tr>\n");
      out.write("\t\t\t\t<tr><th> <br/><label>Password:</label></th><td><br/><input type=\"password\" name=\"password\"/></td></tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("\n");
      out.write("        <span style=\"margin-left:140px;\"><input type=\"submit\" value=\"Log in\" class=\"button\" style=\"border:1px solid #f6b22b;background:#fbe26eE;width:100px;background-color:#F7D92E;height: 35px;font-size:18px\" />\n");
      out.write("         </span>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div style=\"width: 300px; margin: 0 auto;\">\n");
      out.write("\n");
      out.write("\t\t<form id = \"formregister\" action=\"/nobitsgram/RegisterServlet\" method=\"POST\" accept-charset=\"utf-8\" name =\"Login\" class=\"table-style\" align=\"right\">\n");
      out.write("\n");
      out.write("\t\t<h1 style=\"width:350px; margin:0em auto;background-color:#022F47;color:#F9FBFF\"><span style=\"margin-left:130px;\">No Account</span></h1>\n");
      out.write("\t\t<br/>\n");
      out.write("\t\t<span style=\"margin-left:140px;\"><input type=\"submit\" value=\"Register\" class=\"button\" style=\"border:1px solid #f6b22b;background:#fbe26eE;width:100px;background-color:#F7D92E;height: 35px;font-size:18px\" />\n");
      out.write("        </span>\n");
      out.write("        </form>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<!--Mise en place du cadre pour l'image-->\n");
      out.write("<!--Fonction de déféliment indéfini logo-->\n");
      out.write("            <script type=\"jtext/javascript\">\n");
      out.write("var photologo = new Array(\"images/fleure.jpg\",\"images/image1.jpg\",\"images/image2.jpg\",\"images/image3.jpg\",\"images/image4.jpg\")\n");
      out.write("var limgCt = 5;\n");
      out.write("var limgNum = 0;\n");
      out.write("<!--document.write(\"<p>\" + \" \" + \"</p>\"+\"<br>\");-->\n");
      out.write("function lAvantPremiere(){\n");
      out.write("limgNum++\n");
      out.write("if(limgNum==limgCt){limgNum = 0;\n");
      out.write("}\n");
      out.write("document.logo.src = photologo[limgNum];\n");
      out.write("setTimeout(\"lAvantPremiere()\",1500);\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("<!--End Fonction de déféliment indéfini logo-->\n");
      out.write("<table id= \"global\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#B0A3C0\">\n");
      out.write("  <tr>\n");
      out.write("      <th height=\"245\" colspan=\"2\" bgcolor=\"#B0A3C0\" scope=\"row\"> <img src=\"images/fleure.jpg\" name=\"logo\" style=\"width:300px; height:200px border=0\" alt=\"noBits\"/> &nbsp;</th>\n");
      out.write("  </tr>\n");
      out.write("</table>\n");
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
