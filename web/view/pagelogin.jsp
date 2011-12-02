<%--
    Document   : pagelogin
    Created on : 1 déc. 2011, 13:13:55
    Author     : Eyram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<meta http-equiv="refresh" content="5; URL=/nobitsgram/WelcomeServlet">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-us" lang="en-us">
<head>
<title>Test page login</title>
<link rel="stylesheet" type="text/css" href="view/css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-15" />
</head>
<body style="background-color:#DAEADB;">
<!--Positionnement du header et du formulaire de login-->
<div id ="header">
    <div style="width: 300px; margin-left: 130 auto;">
        <form class="table-style" align="right">

        <span style="margin-left:140px;">
            <%

        String client_id = "5e2a174a39804619840925781251b646";
        String redirect_uri = "/nobitsgram/sessionServlet";
        String response_type = "token";
        String oauth_url = "https://api.instagram.com/oauth/authorize/";

        String url =oauth_url+"?client_id="+client_id+
        "&redirect_uri="+redirect_uri+
        "&response_type="+response_type;
            %>
            <h3><a href="<%out.print(url);%>" style="color:#0000CC; margin-left:40px;" title="instagram login">Sign in with Instagram</a></h3>
        </span>
        </form>
    </div>
	<div style="width: 300px; margin: 0 auto;">

		<form id = "formlogin" action="/nobitsgram/LoginServlet" method="POST" accept-charset="utf-8" name ="Login" class="table-style" align="right">

			<h1 style="width:350px; margin:0em auto;background-color:#022F47;color:#F9FBFF"><span style="margin-left:130px;">Log in</span></h1>
			<table style="width:350px;padding:1em;" >
				<tr><th><label>Username:</label></th><td><input type="text" name="username"/></td></tr>
				<tr><th> <br/><label>Password:</label></th><td><br/><input type="password" name="password"/></td></tr>
			</table>

        <span style="margin-left:140px;"><input type="submit" value="Log in" class="button" style="border:1px solid #f6b22b;background:#fbe26eE;width:100px;background-color:#F7D92E;height: 35px;font-size:18px" />
         </span>

        </form>
	</div>

	<div style="width: 300px; margin: 0 auto;">

		<form id = "formregister"  class="table-style" align="right">

		<h1 style="width:350px; margin:0em auto;background-color:#022F47;color:#F9FBFF"><span style="margin-left:130px;">No Account</span></h1>
		<br/>
                <h2><span style="margin-left:150px;color:#FFFFCC"> <a href="/nobitsgram/view/registration.jsp" style="color:#00CC00"  title="Nobitsgram Registration">Register</a></span></h2>
        </span>
        </form>
	</div>


</div>
<form action="/nobitsgram/WelcomeServlet" method="POST" accept-charset="utf-8">

            <% url =(String)request.getAttribute("url");
                if(url == null){
                    url = "http://distilleryimage2.instagram.com/fabbedf01cd411e180c9123138016265_7.jpg";
                }
            %>

    <table id= "global" bgcolor="#000000">
    <tr>
      <th> <img src="<%out.print(url);%>" name="image" style="width:400px; height:300px border=0"/></th>
     </tr>
    </table>
</form>

</body>
</html>
