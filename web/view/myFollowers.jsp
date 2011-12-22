<%-- 
    Document   : myFollowers
    Created on : 21 déc. 2011, 14:48:23
    Author     : Eyram
--%>
<%@page import="ch.heigvd.nobitsgram.util.UserInstagram"%>
<%@include file="tools/headPage.jspf" %>

<div class="bar" id="positionbar">
           <a href="<% out.print(root+ "/view/client.jsp"); %>" id="Home" class="">
            <img class="" src="<% out.print(root+"/images/home1.jpg");%>" style="top:10px;margin-left: -5px;position: relative"/>Home</a>
     <a href="<% out.print(root+ "/view/settingAccount.jsp"); %>" id="" >
            <img class="" src="<% out.print(root+"/images/account1.jpg");%>" style="top:10px;margin-left: -5px;position: relative" />My account</a>
     <a href="<% out.print(root+ "/GalleryServlet"); %>" id="Gallery"  >
            <img src="<% out.print(root+"/images/gallery.jpg");%>" style="top:10px;margin-left: -5px;position: relative"/>Gallery</a>
     <a href="<% out.print(root+ "/view/friendsPage.jsp"); %>" id="" class ="selected" >
            <img class="" src="<% out.print(root+"/images/friends3.jpg");%>" style="top:10px;margin-left: -5px;position: relative" />Friends</a>
     <a href="<% out.print(root+ "/view/map.jsp"); %>" id="">
             <img class="" src="<% out.print(root+"/images/map.jpg");%>" style="top:10px;margin-left: -5px;position: relative"  />Map</a>
     <a href="<%out.print(root+ "/LogoutServlet"); %>" id="">
             <img class="" src="<% out.print(root+"/images/logout1.jpg");%>" style="top:10px;margin-left: -5px;position: relative" />Logout</a>

        <!--Bare menu-->

            <form action="<% out.print(root+ "/SearchServlet"); %>" method="get" id="posearch1">
                <input type="text" name="searchTopic" value="" size="25">
                 <input type="submit" name="Submit" value="find">

            </form>

    </div>

    <div class="menubarre" id="position-menu-barre">
    
        <a href="<% out.print(root+ "/view/friendsPage.jsp"); %>" style="margin-top: 10px;">My contacts</a>
        <a href="<% out.print(root+ "/ListTopicUserServlet"); %>"  >My topics users</a>
        <a href="">Nobitsgram users</a>
        <a href="<% out.print(root+ "/MyFollowerServlet"); %>"
           class="is_selected">My followers</a>                  
    </div>
        <% 
           List<UserInstagram> myFollowers = (List<UserInstagram>)session.
                                                getAttribute("myFollowers");           
           int size = 0;
           
           if(myFollowers != null && !myFollowers.isEmpty()){
               size = myFollowers.size();
           }
           for(int i = 0; i < size; i++){
               
           }
        %>
        
<%@include file="tools/footPage.jspf" %>