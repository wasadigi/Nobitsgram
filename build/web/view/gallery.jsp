<%--
    Document   : gallery
    Created on : 9 d�c. 2011, 04:47:02
    Author     : Eyram
--%>

<%@page import="java.util.Random"%>
<%@page import="java.util.*"%>
<%@include file="tools/headPage.jspf" %>
    <div class="bar" id="positionbar">
       <a href="<% out.print(root+ "/view/client.jsp"); %>" id="Home">
            <img class="" src="<% out.print(root+"/images/home1.jpg");%>" style="top:10px;margin-left: -5px;position: relative"/>Home</a>
     <a href="<% out.print(root+ "/view/settingAccount.jsp"); %>" id="">
            <img class="" src="<% out.print(root+"/images/account1.jpg");%>" style="top:10px;margin-left: -5px;position: relative" />My account</a>
     <a href="<% out.print(root+ "/GalleryServlet"); %>" id="Gallery" class="selected" >
            <img class="" src="<% out.print(root+"/images/gallery.jpg");%>" style="top:10px;margin-left: -5px;position: relative"/>Gallery</a>
     <a href="<% out.print(root+ "/view/friendsPage.jsp"); %>" id="">
            <img class="" src="<% out.print(root+"/images/friends3.jpg");%>" style="top:10px;margin-left: -5px;position: relative" />Friends</a>
     <a href="<% out.print(root+ "/view/map.jsp"); %>" id="">
             <img class="" src="<% out.print(root+"/images/map.jpg");%>" style="top:10px;margin-left: -5px;position: relative"  />Map</a>
     <a href="<%out.print(root+ "/LogoutServlet"); %>" id="">
             <img class="" src="<% out.print(root+"/images/logout1.jpg");%>" style="top:10px;margin-left: -5px;position: relative" />Logout</a>

    <!--Bare menu-->

        <form action="<% out.print(root+ "/SearchServlet"); %>" method="get" id="posearch">
            <input type="text" name="searchTopic" value="" size="25">
             <input type="submit" name="Submit" value="find">

        </form>


    </div>
<br/>
<br/><br/>
<table style="margin-left:25%;">
     <% List<String> topicUrlList = (List<String>)session.getAttribute("topicUrlList");
        Random random1 = new Random(); int j = 0; int size1 = topicUrlList.size();
       
       
     %>
    <tr> <% if(size1 > 0){ j= random1.nextInt(size1); %>
        <td>
            
       
            <img src="<% out.print(topicUrlList.get(j)); %>" style="background: #FF8C00;width: 200px;height:150px;" />            
        </td>
        <td>
            <% j= random1.nextInt(size1); %>
            <img src="<% out.print(topicUrlList.get(j)); %>" style="background: #FFA07A;width: 200px;height:150px;" />
        </td>
        <td>
            <% j= random1.nextInt(size1); %>
            <img src="<% out.print(topicUrlList.get(j)); %>" style="background: #FF2400;width: 200px;height:150px;" />
        </td>
        <% } %>
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
    <% List<String> likeUrlList = (List<String>)session.getAttribute("likeUrlList");
        Random random3 = new Random(); int i = 0; int size3 = likeUrlList.size();
     %>
    <tr>
        <td>
            <% i= random3.nextInt(size3); %>
            <img src="<% out.print(likeUrlList.get(i)); %>" style="background: #7D26CD;width: 200px;height:150px;" />
        </td>
        <td><% i= random3.nextInt(size3); %>
            <img src="<% out.print(likeUrlList.get(i)); %>" style="background: #007FFF;width: 200px;height:150px;" />
        </td>
        <td><% i= random3.nextInt(size3); %>
            <img src="<% out.print(likeUrlList.get(i)); %>" style="background: #00FFFF;width: 200px;height:150px;" />
        </td>
    </tr>
</table>
<%@include file="tools/footPage.jspf" %>

