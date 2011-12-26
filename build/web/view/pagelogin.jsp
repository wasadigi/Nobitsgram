<%--
    Document   : pagelogin
    Created on : 1 déc. 2011, 13:13:55
    Author     : Eyram
--%>

<%@page import="ch.heigvd.nobitsgram.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <% String root = request.getContextPath(); %>

    <head>

        <title>Welcome to Nobitsgram</title>
         <link rel="stylesheet" type="text/css" href="/nobitsgram/css/style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-15" />
        <title>Nobitsgram</title>
    </head>


    <body id="body_bg" style="background-color:#DAEADB;">
        <!--Positionnement du header et du formulaire de login-->
        <div id ="header">

            <!-- We try to redirect the user to the client page when the session is still open -->
            <% if(request.getSession().getAttribute("user") != null){
                User user = (User)session.getAttribute("user");
                user.setIsConnect(true); %>
            <jsp:forward page="/GalleryServlet">
                <jsp:param name="transfert" value="ok" />
            </jsp:forward>
            <%}%>

            <!-- Else we show the welcome page -->
            <div style="width: 300px;">

                <form id = "formlogin" action="<% out.print(root+ "/LoginServlet"); %>" method="POST" accept-charset="utf-8" name ="Login" class="table-style" align="right">

                    <h1 style="width:250px; margin:0em auto;color:#F9FBFF">
                        <span style="margin-left:130px;">Log in</span>
                    </h1>

                    <table style="width:350px;" >
                            <tr>
                                <th><label style="color:#FFFFFF">Username:</label></th>
                                <td><input type="text" name="username"/></td>
                            </tr>
                            <tr>
                                <th>
                                    <br/><label style="color:#FFFFFF">Password:</label>
                                </th>
                                <td>
                                    <br/><input type="password" name="password"/>
                                </td>
                            </tr>
                    </table>

                    <span style="margin-left:160px;">
                        <input style="border:0;width:70px; height:25px" src="<% out.print(root+ "/images/login1.jpg"); %>"  type="image" value="submit" align="middle" />

                    </span>

                </form>
            </div>

            <div style="width: 250px;">

                <form id = "formregister" action="<% out.print(root+"/RegisterServlet"); %>"
                                method="POST" accept-charset="utf-8"
                                name ="Login" class="table-style" align="right">

                    <h4 style="width:360px; margin-bottom: 7px;color:#FFF68F">
                        <span style="margin-left:140px;">Have you already an account?</span>
                    </h4>
                    <br/>

                    <div id="cadreregister">
                        <span style="margin-left:80px;">
                                 <%

                String client_id = "5e2a174a39804619840925781251b646";
                String redirect_uri = request.getRequestURL().toString()+"RegistrationServlet";
                String removePath = request.getServletPath();
                redirect_uri = redirect_uri.replaceAll(removePath,"/");

                String response_type = "code";
                String oauth_url = "https://api.instagram.com/oauth/authorize/";

                String url =oauth_url+"?client_id="+client_id+
                "&redirect_uri="+redirect_uri+
                "&response_type="+response_type;
                    %>
                <a href="<%out.print(url);%>" ><img src="<% out.print(root+ "/images/register_1.jpg"); %>"  style="border:0; height:30px; width:150px"  target="cadre1"/></a>


                        </span>
                    </div>
                </form>
            </div>

            <div id="cadreInstagram">

            </div>

        </div>
<form action="<% out.print(root+ "/WelcomeServlet"); %>" method="POST" id="RefreshUrl" accept-charset="utf-8">
        <!--Texte instagram-->
        <div id="cadretexteInstagram">
                <font style ="font-size: 75px; color: #330099; margin-left: 100px;"> Nobitsgram</font>
        </div>

        <!--Mise en place du cadre pour l'image-->


            <script language="JavaScript">
                setInterval( "RefreshImage();", 5000 );



                $(function () {
                RefreshImage = function(){

                $('#RefreshUrl').fadeOut("slow").load('/nobitsgram/WelcomeServlet').fadeIn("slow");

                }
                 });
            </script>

                    <% url =(String)request.getAttribute("url");
                        if(url == null){
                            url = "http://distillery.s3.amazonaws.com/media/2011/10/04/51279e6fb3484ae78dec5b9ef51081ff_6.jpg";
                        }
                    %>

            <table>
            <tr>
              <th> <img src="<%out.print(url);%>" name="image" id ="global"/></th>
             </tr>
            </table>
</form>

    </body>

</html>

