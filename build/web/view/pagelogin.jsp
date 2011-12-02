<%--
    Document   : pagelogin
    Created on : 1 déc. 2011, 13:13:55
    Author     : Eyram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <form  action="/nobitsgram/instagramLogin" method="POST" accept-charset="utf-8"  class="table-style" align="right">

        <span style="margin-left:140px;">
            <%

        String client_id = "5e2a174a39804619840925781251b646";
        String redirect_uri = "http://localhost:8080/nobitsgram/sessionServlet";
        String response_type = "token";
        String oauth_url = "https://api.instagram.com/oauth/authorize/";

        String url =oauth_url+"?client_id="+client_id+
        "&redirect_uri="+redirect_uri+
        "&response_type="+response_type;
            %>
         <a href="<%out.print(url);%>" title="instagram login" class="sign-up-haut btn-sign-up-right">Sign in with Instagram</a>
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

		<form id = "formregister" action="http://localhost:8080/nobitsgram/view/registration.jsp" method="POST" accept-charset="utf-8" name ="Login" class="table-style" align="right">

		<h1 style="width:350px; margin:0em auto;background-color:#022F47;color:#F9FBFF"><span style="margin-left:130px;">No Account</span></h1>
		<br/>
		<span style="margin-left:140px;"><input type="submit" value="Register" class="button" style="border:1px solid #f6b22b;background:#fbe26eE;width:100px;background-color:#F7D92E;height: 35px;font-size:18px" />
        </span>
        </form>
	</div>


</div>
<!--Mise en place du cadre pour l'image-->
<!--Fonction de déféliment indéfini logo-->
            <script type="jtext/javascript">
var photologo = new Array("images/fleure.jpg","images/image1.jpg","images/image2.jpg","images/image3.jpg","images/image4.jpg")
var limgCt = 5;
var limgNum = 0;
<!--document.write("<p>" + " " + "</p>"+"<br>");-->
function lAvantPremiere(){
limgNum++
if(limgNum==limgCt){limgNum = 0;
}
document.logo.src = photologo[limgNum];
setTimeout("lAvantPremiere()",1500);
}
</script>
<!--End Fonction de déféliment indéfini logo-->
<table id= "global" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#B0A3C0">
  <tr>
      <th height="245" colspan="2" bgcolor="#B0A3C0" scope="row"> <img src="view/images/fleure.jpg" name="logo" style="width:300px; height:200px border=0" alt="noBits"/> &nbsp;</th>
  </tr>
</table>

</body>
</html>
