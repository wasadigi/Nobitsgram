<%--
    Document   : clientPage
    Created on : 5 déc. 2011, 08:49:52
    Author     : Eyram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<title>Nobitsgram</title>
<!--css page client-->
<link rel="stylesheet" type="text/css" href="../css/style_client_page.css" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-15" />

</head>
<body id="body_bg" style="background-color:#DAEADB;" >
<!--Positionnement du header et du formulaire de login-->
<div id ="header" style=" top: 0px; margin-top: 0px">
    <h1 style="margin-top: -5px; margin-left: 40%;"> Nobitsgram </h1>
</div>

<!--Bare menu-->
<div class="menu">
  |<a href="">My Account</a>|
  <a href="">Friends</a> |
   <a href="">Gallery</a> |
    <a href="">Map</a> |
  <a href="">Logout</a> |

</div>

<!--Form search-->
<div id="posearch">
<form action="recherche.html" method="get">
<input type="text" name="searchKeywords" value="search" size="25" onfocus="javascript:if(this.value == 'search') this.value='';" onblur="javascript:if(this.value == '') this.value='search';">
<input type="submit" name="Submit" value="OK">
<!--<button class="btn-search" value="Search" type="submit"></button> -->
</form>
</div>





</div>

</body>
</html>
