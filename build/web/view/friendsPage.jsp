<%--
    Document   : friendsPage
    Created on : 11 déc. 2011, 16:51:44
    Author     : Eyram
--%>

<%@page import="ch.heigvd.nobitsgram.model.UserInstagram"%>
<%@include file="tools/headPage.jspf" %>

<div class="bar2" id="positionbar">
     <a href="<% out.print(root+ "/GalleryServlet"); %>" >
         <img class="" src="<% out.print(root+"/images/gallery.jpg");%>" class ="posipicto" /><span id="myText">Gallery </span></a>
     <a href="<% out.print(root+ "/view/settingAccount.jsp"); %>" id="">
            <img class="" src="<% out.print(root+"/images/account1.jpg");%>" class ="posipicto" /><span id="myText">My account</span></a>
     <a href="<% out.print(root+ "/FriendServlet"); %>" class="selected">
            <img class="" src="<% out.print(root+"/images/friends3.jpg");%>" class ="posipicto"/><span id="myText">Friends</span></a>
     <a href="<% out.print(root+ "/MapServlet"); %>" >
             <img class="" src="<% out.print(root+"/images/map.jpg");%>" class ="posipicto"  /><span id="myText">Map</span></a>
     <a href="<%out.print(root+ "/LogoutServlet"); %>" id="">
             <img class="" src="<% out.print(root+"/images/logout1.jpg");%>" class ="posipicto" /><span id="myText">Logout</span></a>


        <!--Bare menu-->

            <form action="<% out.print(root+ "/SearchServlet"); %>" method="get" id="posearch1">
                <input type="text" name="searchTopic" value="" size="25">
                 <input type="submit" name="Submit" value="find">

            </form>

    </div>

    <div class="menubarre" id="position-menu-barre">
    
        <a href="<% out.print(root+ "/view/friendsPage.jsp"); %>" 
           class="is_selected" style="margin-top: 10px;">
                            My contacts
        </a>
           
        <a href="<% out.print(root+ "/ListTopicUserServlet"); %>">
                            My topics users
        </a>
        <a href="<% out.print(root+ "/UsersActualyConnectServlet"); %>">Nobitsgram users</a>
        <a href="<% out.print(root+ "/MyFollowerServlet"); %>">My followers</a>                      
    </div>
    
    
<table cellspacing="20"> 
    
    <% 
        List<UserInstagram> users = (List<UserInstagram>)session.getAttribute("myContacts");

        int compt=1;
        String image;
        String name;
        for(UserInstagram user: users){
            image = user.getProfilePicture();
            name = user.getUsername();
            if(compt%6 == 0){
    %>
    <tr>
    <% } %>
    <td  class="pictureContener">
                    <center>
                     <p id="picturposition">
                         <img src="<% out.print(image); %>" 
                   style="background: #FFA07A;width: 100px;height:100px;" /> 
                     </p>
                    </center>
                     <p id="nameposition">
                            <% out.print(name); %> 
                     </p>
  
    <% if(compt%6 == 0){ %>
    </tr>   
   <% }%>
    
 <% } %>
    
</table>    
                
<%@include file="tools/footPage.jspf" %>

