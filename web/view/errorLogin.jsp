<%--
    Document   : session
    Created on : 17 nov. 2011, 13:11:15
    Author     : Eyram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>session nobitsgr.am</title>
    </head>
    <body style="background-color:#DAEADB;">

        <div id="wrap" class="grid-all group" >

<div style="width: 350px; margin: 0 auto;">

    <form action="/nobitsgram/LoginServlet" method="POST" accept-charset="utf-8"
          name ="Login" class="table-style">
        </br></br></br><h1 style="width:350px; margin:0em auto;background-color:#022F47;color:#F9FBFF"><span style="margin-left:130px;">Log in</span></h1>
        <table style="width:350px;padding:2em;background-color:#0AA9FF">
            <td colspan="2"><h4 style="color:#BF0B0B">Incorrect Login and/or Password</h4></td>
            <tr><th><label for="id_username">Username:</label></th><td><input  type="text" name="username" id="id_username" /></td></tr>
<tr><th> <br/><label for="id_password">Password:</label></th><td><br/><input   type="password" name="password" id="id_password" /></td></tr>
        </table>

        <p><span style="margin-left:140px;"><input type="submit" value="Log in" class="button" style="border:1px solid #f6b22b;background:#fbe26eE;width:100px;background-color:#F7D92E;height: 35px;font-size:18px ">
            </span></p>

                <%
                String client_id = "5e2a174a39804619840925781251b646";
                String redirect_uri = request.getRequestURL().toString();
                String removePath = request.getServletPath();
                redirect_uri = redirect_uri.replaceAll(removePath,"/") + "RegistrationServlet";

                String response_type = "code";
                String oauth_url = "https://api.instagram.com/oauth/authorize/";

                String url =oauth_url+"?client_id="+client_id+
                "&redirect_uri="+redirect_uri+
                "&response_type="+response_type;
                 %>
                <p><h4>Do you have already an acount?<a href="<%out.print(url);%>" >Create on here!</h4> </a>
        </form>

</div>

    </div>

    </body>
</html>
