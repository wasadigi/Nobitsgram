<%-- 
    Document   : usersConnectedPage
    Created on : 24 déc. 2011, 23:38:08
    Author     : Eyram
--%>


<%@page import="ch.heigvd.nobitsgram.util.UserInstagram"%>
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
           style="margin-top: 10px;">
                            My contacts
        </a>
           
        <a href="<% out.print(root+ "/ListTopicUserServlet"); %>">
                            My topics users
        </a>
        <a href="<% out.print(root+ "/UsersActualyConnectServlet"); %>" 
           class="is_selected" >Nobitsgram users</a>
        <a href="<% out.print(root+ "/MyFollowerServlet"); %>">My followers</a>                      
    </div>
    
    
<table cellspacing="20"> 
    
    <% 
        List<User> usersConnected = (List<User>)session.getAttribute("usersConnected");

        int compt=1;
        String image;
        String name;
        for(User user: usersConnected){
            image = user.getProfile_picture();
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
                    <p style="margin-top: -10px;">
                          <img src="<%out.print(root+ "/images/connected3.jpg");%>" 
                   style="background: #FFA07A;width: 20px;height:20px;" /> 
                          <span style=" position:absolute ;color: green; margin-left: 10px; 
                               margin-top: -1px; font-weight: bold;"> <% out.print(name); %> </span>
                     </p>
  
    <% if(compt%6 == 0){ %>
    </tr>   
   <% }%>
    
 <% } %>
    
</table>    
                
<%@include file="tools/footPage.jspf" %>


