
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
<title>Welcome to Nobitsgram</title>
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-15" />

<head>
<title>Nobitsgram</title>
</head>


<body id="body_bg" style="background-color:#DAEADB;">

<!--Positionnement du header et du formulaire de login-->
<div id ="header">


	<div style="width: 300px;">

		<form id = "formlogin" action="/nobitsgram/LoginServlet" method="POST" accept-charset="utf-8" name ="Login" class="table-style" align="right">

			<h1 style="width:250px; margin:0em auto;color:#F9FBFF"><span style="margin-left:130px;">Log in</span></h1>
			<table style="width:350px;" >
				<tr><th><label style="color:#FFFFFF">Username:</label></th><td><input type="text" name="username"/></td></tr>
				<tr><th> <br/><label style="color:#FFFFFF">Password:</label></th><td><br/><input type="password" name="password"/></td></tr>
			</table>

        <span style="margin-left:160px;"> <input border=0 src="images/login1.jpg" width=70 height=25 type=image Value=submit align="middle" >

         </span>

        </form>
	</div>

	<div style="width: 250px;">

		<form id = "formregister" action="/nobitsgram/RegisterServlet" method="POST" accept-charset="utf-8" name ="Login" class="table-style" align="right">

		<h4 style="width:360px; margin-bottom: 7px;color:#FFF68F"><span style="margin-left:140px;">Have you already an account?</span></h4>
		<br/>

	<div id="cadreregister">
	<span style="margin-left:80px;"><a href="/nobitsgram/view/registration.jsp" target="cadre1"><img src="images/register_1.jpg" width=125 height=25 border=0></a>
	</div>

		<input type="submit" hidden="true" value="Register" class="button" style="border:1px solid #f6b22b;background:#fbe26eE;width:100px;background-color:#F7D92E;height: 35px;font-size:18px ">
        </span>
        </form>
	</div>
	<div id="cadreInstagram">
	 <%

        String client_id = "5e2a174a39804619840925781251b646";
        String redirect_uri = "http://localhost:8080/nobitsgram/sessionServlet";
        String response_type = "token";
        String oauth_url = "https://api.instagram.com/oauth/authorize/";

        String url =oauth_url+"?client_id="+client_id+
        "&redirect_uri="+redirect_uri+
        "&response_type="+response_type;
            %>
	<a href="<%out.print(url);%>" ><img src="images/instagram_2.jpg" border=0 style="height:30px; width:150px"></a>
	</div>

</div>

<!--Texte instagram-->
<div id="cadretexteInstagram">
	<font style ="font-size: 75; color: #330099; margin-left: 100px;"> Nobitsgram</font>
</div>

<!--Mise en place du cadre pour l'image-->

<form action="/nobitsgram/WelcomeServlet" method="POST" accept-charset="utf-8">

            <% url =(String)request.getAttribute("url");
                if(url == null){
                    url = "http://distilleryimage2.instagram.com/fabbedf01cd411e180c9123138016265_7.jpg";
                }
            %>

    <table id= "global" bgcolor="#000000">
    <tr>
      <th> <img src="<%out.print(url);%>" name="image" style="width:300px; height:240px;"/></th>
     </tr>
    </table>
</form>



</body>
</html>

