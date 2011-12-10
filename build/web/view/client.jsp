<%--
    Document   : client
    Created on : 8 déc. 2011, 22:39:46
    Author     : Eyram
--%>

<%@include file="tools/headPage.jspf" %>

<div class="bar" id="positionbar">
            <a href="client.jsp" id="Home" class="selected">
                <img class="" src="../images/home1.jpg"  style="top:10px;margin-left: -5px;position: relative"/>Home</a>
                <a href="settingAccount.jsp" id="">
                    <img class="" src="../images/account1.jpg" style="top:10px;margin-left: -5px;position: relative" />My account</a>
            <a href="gallery.jsp" id="Gallery"  >
                <img class="" src="../images/gallery.jpg" style="top:10px;margin-left: -5px;position: relative"/>Gallery</a>
            <a href="friendsPage.jsp" id="">
                <img class="" src="../images/friends3.jpg" style="top:10px;margin-left: -5px;position: relative" />Friends</a>
            <a href="map.jsp" id=""><img class="" src="../images/map.jpg" style="top:10px;margin-left: -5px;position: relative"  />Map</a>
            <a href="logout.jsp" id=""><img class="" src="../images/logout1.jpg" style="top:10px;margin-left: -5px;position: relative" />Logout</a>


        <!--Bare menu-->

            <form action="<% out.print(root+ "/sessionServlet"); %>" method="get" id="posearch">
                <input type="text" name="searchTopic" value="search" size="25">
                 <input type="submit" name="Submit" value="find">

            </form>


        </div>

<%@include file="tools/footPage.jspf" %>
