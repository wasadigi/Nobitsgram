package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ch.heigvd.nobitsgram.controller.RegistrationServlet;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Application Registration</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div style=\"width: 430px; margin: 0 auto; background-color:#DCDCDC;\">\n");
      out.write("            <form action=\"/nobitsgram/RegistrationServlet\" method=\"POST\" accept-charset=\"utf-8\">\n");
      out.write("\n");
      out.write("     </br></br> <h1 style=\"margin-left: 2.5em;\">REGISTRATION</h1></br>\n");
      out.write("\n");
      out.write("    <br><label for=\"user_firstname\" name=\"firstname\">First name:</label>\n");
      out.write("    <input id=\"user_login\" name=\"firstname\" size=\"30\" type=\"text\" /></br>\n");
      out.write("\n");
      out.write("    <br><label>Last name:</label>\n");
      out.write("    <input name=\"lastname\" size=\"30\" type=\"text\" /></br>\n");
      out.write("\n");
      out.write("     <br><label>Street number:</label>\n");
      out.write("    <input name=\"streetNumber\" size=\"8\" type=\"text\" /></br>\n");
      out.write("\n");
      out.write("    <br><label>Street address:</label>\n");
      out.write("    <input name=\"street\" size=\"30\" type=\"text\" /></br>\n");
      out.write("\n");
      out.write("    <br><label>city:</label>\n");
      out.write("    <input name=\"city\" size=\"30\" type=\"text\" /></br>\n");
      out.write("\n");
      out.write("    <br><label>ZIP/Postal Code:</label>\n");
      out.write("    <input name=\"zip\" size=\"8\" type=\"text\" /></br>\n");
      out.write("\n");
      out.write("<br><label class=\"label\" for=\"country\">Country:&nbsp;&nbsp;&nbsp;</label>\n");
      out.write("\n");
      out.write("               <select class=\"\" id=\"country\" name=\"country\">\n");
      out.write("                    <option value=\"af\"   >Afghanistan</option>\n");
      out.write("                    <option value=\"ax\"   >Aland Islands</option>\n");
      out.write("                    <option value=\"al\"   >Albania</option>\n");
      out.write("\n");
      out.write("                    <option value=\"dz\"   >Algeria</option>\n");
      out.write("                    <option value=\"as\"   >American Samoa</option>\n");
      out.write("                    <option value=\"ad\"   >Andorra</option>\n");
      out.write("                    <option value=\"ao\"   >Angola</option>\n");
      out.write("                    <option value=\"ai\"   >Anguilla</option>\n");
      out.write("                    <option value=\"aq\"   >Antarctica</option>\n");
      out.write("\n");
      out.write("                    <option value=\"ag\"   >Antigua and Barbuda</option>\n");
      out.write("                    <option value=\"ar\"   >Argentina</option>\n");
      out.write("                    <option value=\"am\"   >Armenia</option>\n");
      out.write("                    <option value=\"aw\"   >Aruba</option>\n");
      out.write("                    <option value=\"au\"   >Australia</option>\n");
      out.write("                    <option value=\"at\"   >Austria</option>\n");
      out.write("\n");
      out.write("                    <option value=\"az\"   >Azerbaijan</option>\n");
      out.write("                    <option value=\"bs\"   >Bahamas</option>\n");
      out.write("                    <option value=\"bh\"   >Bahrain</option>\n");
      out.write("                    <option value=\"bd\"   >Bangladesh</option>\n");
      out.write("                    <option value=\"bb\"   >Barbados</option>\n");
      out.write("                    <option value=\"by\"   >Belarus</option>\n");
      out.write("\n");
      out.write("                    <option value=\"be\"   >Belgium</option>\n");
      out.write("                    <option value=\"bz\"   >Belize</option>\n");
      out.write("                    <option value=\"bj\"   >Benin</option>\n");
      out.write("                    <option value=\"bm\"   >Bermuda</option>\n");
      out.write("                    <option value=\"bt\"   >Bhutan</option>\n");
      out.write("                    <option value=\"bo\"   >Bolivia</option>\n");
      out.write("\n");
      out.write("                    <option value=\"ba\"   >Bosnia and Herzegovina</option>\n");
      out.write("                    <option value=\"bw\"   >Botswana</option>\n");
      out.write("                    <option value=\"bv\"   >Bouvet Island</option>\n");
      out.write("                    <option value=\"br\"   >Brazil</option>\n");
      out.write("                    <option value=\"io\"   >British Indian Ocean Territory</option>\n");
      out.write("                    <option value=\"vg\"   >British Virgin Islands</option>\n");
      out.write("\n");
      out.write("                    <option value=\"bn\"   >Brunei</option>\n");
      out.write("                    <option value=\"bg\"   >Bulgaria</option>\n");
      out.write("                    <option value=\"bf\"   >Burkina Faso</option>\n");
      out.write("                    <option value=\"bi\"   >Burundi</option>\n");
      out.write("                    <option value=\"kh\"   >Cambodia</option>\n");
      out.write("                    <option value=\"cm\"   >Cameroon</option>\n");
      out.write("\n");
      out.write("                    <option value=\"ca\"   >Canada</option>\n");
      out.write("                    <option value=\"cv\"   >Cape Verde</option>\n");
      out.write("                    <option value=\"ky\"   >Cayman Islands</option>\n");
      out.write("                    <option value=\"cf\"   >Central African Republic</option>\n");
      out.write("                    <option value=\"td\"   >Chad</option>\n");
      out.write("                    <option value=\"cl\"   >Chile</option>\n");
      out.write("\n");
      out.write("                    <option value=\"cn\"   >China</option>\n");
      out.write("                    <option value=\"cx\"   >Christmas Island</option>\n");
      out.write("                    <option value=\"cc\"   >Cocos (Keeling) Islands</option>\n");
      out.write("                    <option value=\"co\"   >Colombia</option>\n");
      out.write("                    <option value=\"km\"   >Comoros</option>\n");
      out.write("                    <option value=\"cg\"   >Congo</option>\n");
      out.write("\n");
      out.write("                    <option value=\"ck\"   >Cook Islands</option>\n");
      out.write("                    <option value=\"cr\"   >Costa Rica</option>\n");
      out.write("                    <option value=\"hr\"   >Croatia</option>\n");
      out.write("                    <option value=\"cu\"   >Cuba</option>\n");
      out.write("                    <option value=\"cy\"   >Cyprus</option>\n");
      out.write("                    <option value=\"cz\"   >Czech Republic</option>\n");
      out.write("\n");
      out.write("                    <option value=\"cd\"   >Democratic Republic of Congo</option>\n");
      out.write("                    <option value=\"dk\"   >Denmark</option>\n");
      out.write("                    <option value=\"xx\"   >Disputed Territory</option>\n");
      out.write("                    <option value=\"dj\"   >Djibouti</option>\n");
      out.write("                    <option value=\"dm\"   >Dominica</option>\n");
      out.write("                    <option value=\"do\"   >Dominican Republic</option>\n");
      out.write("\n");
      out.write("                    <option value=\"tl\"   >East Timor</option>\n");
      out.write("                    <option value=\"ec\"   >Ecuador</option>\n");
      out.write("                    <option value=\"eg\"   >Egypt</option>\n");
      out.write("                    <option value=\"sv\"   >El Salvador</option>\n");
      out.write("                    <option value=\"gq\"   >Equatorial Guinea</option>\n");
      out.write("                    <option value=\"er\"   >Eritrea</option>\n");
      out.write("\n");
      out.write("                    <option value=\"ee\"   >Estonia</option>\n");
      out.write("                    <option value=\"et\"   >Ethiopia</option>\n");
      out.write("                    <option value=\"fk\"   >Falkland Islands</option>\n");
      out.write("                    <option value=\"fo\"   >Faroe Islands</option>\n");
      out.write("                    <option value=\"fm\"   >Federated States of Micronesia</option>\n");
      out.write("                    <option value=\"fj\"   >Fiji</option>\n");
      out.write("\n");
      out.write("                    <option value=\"fi\"   >Finland</option>\n");
      out.write("                    <option value=\"fr\"   >France</option>\n");
      out.write("                    <option value=\"gf\"   >French Guyana</option>\n");
      out.write("                    <option value=\"pf\"   >French Polynesia</option>\n");
      out.write("                    <option value=\"tf\"   >French Southern Territories</option>\n");
      out.write("                    <option value=\"ga\"   >Gabon</option>\n");
      out.write("\n");
      out.write("                    <option value=\"gm\"   >Gambia</option>\n");
      out.write("                    <option value=\"ge\"   >Georgia</option>\n");
      out.write("                    <option value=\"de\"   >Germany</option>\n");
      out.write("                    <option value=\"gh\"   >Ghana</option>\n");
      out.write("                    <option value=\"gi\"   >Gibraltar</option>\n");
      out.write("                    <option value=\"gr\"   >Greece</option>\n");
      out.write("\n");
      out.write("                    <option value=\"gl\"   >Greenland</option>\n");
      out.write("                    <option value=\"gd\"   >Grenada</option>\n");
      out.write("                    <option value=\"gp\"   >Guadeloupe</option>\n");
      out.write("                    <option value=\"gu\"   >Guam</option>\n");
      out.write("                    <option value=\"gt\"   >Guatemala</option>\n");
      out.write("                    <option value=\"gn\"   >Guinea</option>\n");
      out.write("\n");
      out.write("                    <option value=\"gw\"   >Guinea-Bissau</option>\n");
      out.write("                    <option value=\"gy\"   >Guyana</option>\n");
      out.write("                    <option value=\"ht\"   >Haiti</option>\n");
      out.write("                    <option value=\"hm\"   >Heard Island and Mcdonald Islands</option>\n");
      out.write("                    <option value=\"hn\"   >Honduras</option>\n");
      out.write("                    <option value=\"hk\"   >Hong Kong</option>\n");
      out.write("\n");
      out.write("                    <option value=\"hu\"   >Hungary</option>\n");
      out.write("                    <option value=\"is\"   >Iceland</option>\n");
      out.write("                    <option value=\"in\"   >India</option>\n");
      out.write("                    <option value=\"id\"   >Indonesia</option>\n");
      out.write("                    <option value=\"ir\"   >Iran</option>\n");
      out.write("                    <option value=\"iq\"   >Iraq</option>\n");
      out.write("\n");
      out.write("                    <option value=\"xe\"   >Iraq-Saudi Arabia Neutral Zone</option>\n");
      out.write("                    <option value=\"ie\"   >Ireland</option>\n");
      out.write("                    <option value=\"il\"   >Israel</option>\n");
      out.write("                    <option value=\"it\"   >Italy</option>\n");
      out.write("                    <option value=\"ci\"   >Ivory Coast</option>\n");
      out.write("                    <option value=\"jm\"   >Jamaica</option>\n");
      out.write("\n");
      out.write("                    <option value=\"jp\"   >Japan</option>\n");
      out.write("                    <option value=\"jo\"   >Jordan</option>\n");
      out.write("                    <option value=\"kz\"   >Kazakhstan</option>\n");
      out.write("                    <option value=\"ke\"   >Kenya</option>\n");
      out.write("                    <option value=\"ki\"   >Kiribati</option>\n");
      out.write("                    <option value=\"kw\"   >Kuwait</option>\n");
      out.write("\n");
      out.write("                    <option value=\"kg\"   >Kyrgyzstan</option>\n");
      out.write("                    <option value=\"la\"   >Laos</option>\n");
      out.write("                    <option value=\"lv\"   >Latvia</option>\n");
      out.write("                    <option value=\"lb\"   >Lebanon</option>\n");
      out.write("                    <option value=\"ls\"   >Lesotho</option>\n");
      out.write("                    <option value=\"lr\"   >Liberia</option>\n");
      out.write("\n");
      out.write("                    <option value=\"ly\"   >Libya</option>\n");
      out.write("                    <option value=\"li\"   >Liechtenstein</option>\n");
      out.write("                    <option value=\"lt\"   >Lithuania</option>\n");
      out.write("                    <option value=\"lu\"   >Luxembourg</option>\n");
      out.write("                    <option value=\"mo\"   >Macau</option>\n");
      out.write("                    <option value=\"mk\"   >Macedonia</option>\n");
      out.write("\n");
      out.write("                    <option value=\"mg\"   >Madagascar</option>\n");
      out.write("                    <option value=\"mw\"   >Malawi</option>\n");
      out.write("                    <option value=\"my\"   >Malaysia</option>\n");
      out.write("                    <option value=\"mv\"   >Maldives</option>\n");
      out.write("                    <option value=\"ml\"   >Mali</option>\n");
      out.write("                    <option value=\"mt\"   >Malta</option>\n");
      out.write("\n");
      out.write("                    <option value=\"mh\"   >Marshall Islands</option>\n");
      out.write("                    <option value=\"mq\"   >Martinique</option>\n");
      out.write("                    <option value=\"mr\"   >Mauritania</option>\n");
      out.write("                    <option value=\"mu\"   >Mauritius</option>\n");
      out.write("                    <option value=\"yt\"   >Mayotte</option>\n");
      out.write("                    <option value=\"mx\"   >Mexico</option>\n");
      out.write("\n");
      out.write("                    <option value=\"md\"   >Moldova</option>\n");
      out.write("                    <option value=\"mc\"   >Monaco</option>\n");
      out.write("                    <option value=\"mn\"   >Mongolia</option>\n");
      out.write("                    <option value=\"ms\"   >Montserrat</option>\n");
      out.write("                    <option value=\"ma\"   >Morocco</option>\n");
      out.write("                    <option value=\"mz\"   >Mozambique</option>\n");
      out.write("\n");
      out.write("                    <option value=\"mm\"   >Myanmar</option>\n");
      out.write("                    <option value=\"na\"   >Namibia</option>\n");
      out.write("                    <option value=\"nr\"   >Nauru</option>\n");
      out.write("                    <option value=\"np\"   >Nepal</option>\n");
      out.write("                    <option value=\"nl\"   >Netherlands</option>\n");
      out.write("                    <option value=\"an\"   >Netherlands Antilles</option>\n");
      out.write("\n");
      out.write("                    <option value=\"nc\"   >New Caledonia</option>\n");
      out.write("                    <option value=\"nz\"   >New Zealand</option>\n");
      out.write("                    <option value=\"ni\"   >Nicaragua</option>\n");
      out.write("                    <option value=\"ne\"   >Niger</option>\n");
      out.write("                    <option value=\"ng\"   >Nigeria</option>\n");
      out.write("                    <option value=\"nu\"   >Niue</option>\n");
      out.write("\n");
      out.write("                    <option value=\"nf\"   >Norfolk Island</option>\n");
      out.write("                    <option value=\"kp\"   >North Korea</option>\n");
      out.write("                    <option value=\"mp\"   >Northern Mariana Islands</option>\n");
      out.write("                    <option value=\"no\"   >Norway</option>\n");
      out.write("                    <option value=\"om\"   >Oman</option>\n");
      out.write("                    <option value=\"pk\"   >Pakistan</option>\n");
      out.write("\n");
      out.write("                    <option value=\"pw\"   >Palau</option>\n");
      out.write("                    <option value=\"ps\"   >Palestinian Territories</option>\n");
      out.write("                    <option value=\"pa\"   >Panama</option>\n");
      out.write("                    <option value=\"pg\"   >Papua New Guinea</option>\n");
      out.write("                    <option value=\"py\"   >Paraguay</option>\n");
      out.write("                    <option value=\"pe\"   >Peru</option>\n");
      out.write("\n");
      out.write("                    <option value=\"ph\"   >Philippines</option>\n");
      out.write("                    <option value=\"pn\"   >Pitcairn Islands</option>\n");
      out.write("                    <option value=\"pl\"   >Poland</option>\n");
      out.write("                    <option value=\"pt\"   >Portugal</option>\n");
      out.write("                    <option value=\"pr\"   >Puerto Rico</option>\n");
      out.write("                    <option value=\"qa\"   >Qatar</option>\n");
      out.write("\n");
      out.write("                    <option value=\"re\"   >Reunion</option>\n");
      out.write("                    <option value=\"ro\"   >Romania</option>\n");
      out.write("                    <option value=\"ru\"   >Russia</option>\n");
      out.write("                    <option value=\"rw\"   >Rwanda</option>\n");
      out.write("                    <option value=\"sh\"   >Saint Helena and Dependencies</option>\n");
      out.write("                    <option value=\"kn\"   >Saint Kitts and Nevis</option>\n");
      out.write("\n");
      out.write("                    <option value=\"lc\"   >Saint Lucia</option>\n");
      out.write("                    <option value=\"pm\"   >Saint Pierre and Miquelon</option>\n");
      out.write("                    <option value=\"vc\"   >Saint Vincent and the Grenadines</option>\n");
      out.write("                    <option value=\"ws\"   >Samoa</option>\n");
      out.write("                    <option value=\"sm\"   >San Marino</option>\n");
      out.write("                    <option value=\"st\"   >Sao Tome and Principe</option>\n");
      out.write("\n");
      out.write("                    <option value=\"sa\"   >Saudi Arabia</option>\n");
      out.write("                    <option value=\"sn\"   >Senegal</option>\n");
      out.write("                    <option value=\"sc\"   >Seychelles</option>\n");
      out.write("                    <option value=\"sl\"   >Sierra Leone</option>\n");
      out.write("                    <option value=\"sg\"   >Singapore</option>\n");
      out.write("                    <option value=\"sk\"   >Slovakia</option>\n");
      out.write("\n");
      out.write("                    <option value=\"si\"   >Slovenia</option>\n");
      out.write("                    <option value=\"sb\"   >Solomon Islands</option>\n");
      out.write("                    <option value=\"so\"   >Somalia</option>\n");
      out.write("                    <option value=\"za\"   >South Africa</option>\n");
      out.write("                    <option value=\"gs\"   >South Georgia and South Sandwich Islands</option>\n");
      out.write("                    <option value=\"kr\"   >South Korea</option>\n");
      out.write("\n");
      out.write("                    <option value=\"es\"   >Spain</option>\n");
      out.write("                    <option value=\"pi\"   >Spratly Islands</option>\n");
      out.write("                    <option value=\"lk\"   >Sri Lanka</option>\n");
      out.write("                    <option value=\"sd\"   >Sudan</option>\n");
      out.write("                    <option value=\"sr\"   >Suriname</option>\n");
      out.write("                    <option value=\"sj\"   >Svalbard and Jan Mayen</option>\n");
      out.write("\n");
      out.write("                    <option value=\"sz\"   >Swaziland</option>\n");
      out.write("                    <option value=\"se\"   >Sweden</option>\n");
      out.write("                    <option value=\"ch\"   SELECTED >Switzerland</option>\n");
      out.write("                    <option value=\"sy\"   >Syria</option>\n");
      out.write("                    <option value=\"tw\"   >Taiwan</option>\n");
      out.write("                    <option value=\"tj\"   >Tajikistan</option>\n");
      out.write("\n");
      out.write("                    <option value=\"tz\"   >Tanzania</option>\n");
      out.write("                    <option value=\"th\"   >Thailand</option>\n");
      out.write("                    <option value=\"tg\"   >Togo</option>\n");
      out.write("                    <option value=\"tk\"   >Tokelau</option>\n");
      out.write("                    <option value=\"to\"   >Tonga</option>\n");
      out.write("                    <option value=\"tt\"   >Trinidad and Tobago</option>\n");
      out.write("\n");
      out.write("                    <option value=\"tn\"   >Tunisia</option>\n");
      out.write("                    <option value=\"tr\"   >Turkey</option>\n");
      out.write("                    <option value=\"tm\"   >Turkmenistan</option>\n");
      out.write("                    <option value=\"tc\"   >Turks And Caicos Islands</option>\n");
      out.write("                    <option value=\"tv\"   >Tuvalu</option>\n");
      out.write("                    <option value=\"ug\"   >Uganda</option>\n");
      out.write("\n");
      out.write("                    <option value=\"ua\"   >Ukraine</option>\n");
      out.write("                    <option value=\"ae\"   >United Arab Emirates</option>\n");
      out.write("                    <option value=\"uk\"   >United Kingdom</option>\n");
      out.write("                    <option value=\"us\"   >United States</option>\n");
      out.write("                    <option value=\"um\"   >United States Minor Outlying Islands</option>\n");
      out.write("                    <option value=\"uy\"   >Uruguay</option>\n");
      out.write("\n");
      out.write("                    <option value=\"vi\"   >US Virgin Islands</option>\n");
      out.write("                    <option value=\"uz\"   >Uzbekistan</option>\n");
      out.write("                    <option value=\"vu\"   >Vanuatu</option>\n");
      out.write("                    <option value=\"va\"   >Vatican City</option>\n");
      out.write("                    <option value=\"ve\"   >Venezuela</option>\n");
      out.write("                    <option value=\"vn\"   >Vietnam</option>\n");
      out.write("\n");
      out.write("                    <option value=\"wf\"   >Wallis and Futuna</option>\n");
      out.write("                    <option value=\"eh\"   >Western Sahara</option>\n");
      out.write("                    <option value=\"ye\"   >Yemen</option>\n");
      out.write("                    <option value=\"zm\"   >Zambia</option>\n");
      out.write("                    <option value=\"zw\"   >Zimbabwe</option>\n");
      out.write("                    <option value=\"rs\"   >Serbia</option>\n");
      out.write("\n");
      out.write("                    <option value=\"me\"   >Montenegro</option>\n");
      out.write("               </select>\n");
      out.write("         </br>\n");
      out.write("    <br><label  name=\"email\">Email Address:</label>\n");
      out.write("    <input id=\"user_email\" name=\"email\" size=\"30\" type=\"text\" /></br>\n");
      out.write("\n");
      out.write("    <br><label for=\"username\" name=\"username\">Username:</label>\n");
      out.write("    <input id=\"username\" name=\"username\" size=\"30\" type=\"text\" /> </br>\n");
      out.write("\n");
      out.write("    <br><label for=\"password\" name=\"password\">Password:</label>\n");
      out.write("    <input id=\"password\" name=\"password\" size=\"30\" type=\"password\"/></br>\n");
      out.write("\n");
      out.write("    <br><label name=\"Topic\">Topic:</label>\n");
      out.write("    <input name=\"Topic\" size=\"30\" type=\"text\"/></br>\n");
      out.write("\n");
      out.write("    <br><span style=\"margin-left:100px;\">\n");
      out.write("        <button type=\"submit\" style=\"border:1px solid #f6b22b;\n");
      out.write("                background:#fbe26eE;width:200px;\n");
      out.write("                background-color:#F7D92E;\n");
      out.write("                height: 35px;font-size:18px \"\n");
      out.write("            id=\"signup_button\">Create an account</button></span></br></br>\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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