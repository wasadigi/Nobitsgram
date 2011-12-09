<%--
    Document   : gallery
    Created on : 9 déc. 2011, 04:47:02
    Author     : Eyram
--%>

<%@include file="tools/headPage.jspf" %>
    <div class="bar" id="positionbar">
        <a href="client.jsp" id="Home" >
                <img class="" src="../images/home1.jpg"  style="top:10px;margin-left: -5px;position: relative"/>Home</a>
                <a href="settingAccount.jsp" id="">
                    <img class="" src="../images/account1.jpg" style="top:10px;margin-left: -5px;position: relative" />My account</a>
        <a href="gallery.jsp" class="selected"  >
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
<br/>
<br/><br/>
<table style="margin-left:25%;">
    <tr>
        <td>
            <img src="" style="background: #FF8C00;width: 200px;height:150px;" />
        </td>
        <td>
            <img src="" style="background: #FFA07A;width: 200px;height:150px;" />
        </td>
        <td>
            <img src="" style="background: #FF2400;width: 200px;height:150px;" />
        </td>
    </tr>
</table>
<br/>
<table style="margin-left:25%;">
    <tr>
        <td>
            <img src="" style="background: #D3D3D3;width: 200px;height:150px;" />
        </td>
        <td>
            <img src="" style="background: #B9D3EE;width: 200px;height:150px;" />
        </td>
        <td>
            <img src="" style="background: #6C7B8B;width: 200px;height:150px;" />
        </td>
    </tr>
</table>
<br/>
<table style="margin-left:25%;">
    <tr>
        <td>
            <img src="" style="background: #7D26CD;width: 200px;height:150px;" />
        </td>
        <td>
            <img src="" style="background: #007FFF;width: 200px;height:150px;" />
        </td>
        <td>
            <img src="" style="background: #00FFFF;width: 200px;height:150px;" />
        </td>
    </tr>
</table>
<%@include file="tools/footPage.jspf" %>

