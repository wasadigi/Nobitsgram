<%--
    Document   : searchPage
    Created on : 9 déc. 2011, 05:19:53
    Author     : Eyram
--%>

<%@page import="java.util.List"%>
<%@include file="tools/headPage.jspf" %>
<div class="bar" style="height:50px;">
       <a href="client.jsp" id="Home" >
                <img class="" src="../images/home1.jpg"  style="top:10px;margin-left: -5px;position: relative"/>Home</a>
                <a href="settingAccount.jsp" id="">
                    <img class="" src="../images/account1.jpg" style="top:10px;margin-left: -5px;position: relative" />My account</a>
        <a href="gallery.jsp" >
                <img class="" src="../images/gallery.jpg" style="top:10px;margin-left: -5px;position: relative"/>Gallery</a>
            <a href="friendsPage.jsp" id="">
                <img class="" src="../images/friends3.jpg" style="top:10px;margin-left: -5px;position: relative" />Friends</a>
            <a href="map.jsp" id=""><img class="" src="../images/map.jpg" style="top:10px;margin-left: -5px;position: relative"  />Map</a>
            <a href="searchPage.jsp" class="selected"><img class="" src="../images/search1.jpg" style="top:10px;margin-left: -5px;position: relative"  />Search</a>
            <a href="logout.jsp" id=""><img class="" src="../images/logout1.jpg" style="top:10px;margin-left: -5px;position: relative" />Logout</a>
    <!--Bare menu-->

        <form action="<% out.print(root+ "/sessionServlet"); %>" method="get" id="posearch">
            <input type="text" name="searchTopic" value="search" size="25">
             <input type="submit" name="Submit" value="find">

        </form>


    </div>
<br/>
<% root =request.getContextPath();%>
<form action="<% out.print(root+ "/sessionServlet"); %>" method="GET" accept-charset="utf-8">

    <jsp:useBean id="url" class ="java.lang.String"  scope="session" />
    <jsp:useBean id="username" class ="java.lang.String"  scope="session" />
    <% List<String> urlList =(List<String>)request.getAttribute("urlList");
       int size = urlList.size();%>
    <% username =(String)request.getSession().getAttribute("username");%>

    <table style="margin-left:25%;top:25%" >
        <tr>
            <% for(int i = 0; i < 3; i++) {%>
            <td>
                <img src="<%out.print(urlList.get(i));%>" style="width: 200px;height:150px;" />

            </td>
            <% }%>
        </tr>
    </table>
</form>
<br/>

<%@include file="tools/footPage.jspf" %>

