<%-- 
    Document   : myMedia
    Created on : 10 janv. 2012, 17:57:33
    Author     : Eyram
--%>

<%@include file="tools/headPage.jspf" %>
<div class="bar" id="positionbar">

    <a href="<% out.print(root+ "/GalleryServlet"); %>" >
         <img class="" src="<% out.print(root+"/images/gallery.jpg");%>" class ="posipicto" /><span id="myText">Gallery </span></a>
     <a href="<% out.print(root+ "/view/settingAccount.jsp"); %>" class="selected">
            <img class="" src="<% out.print(root+"/images/account1.jpg");%>" class ="posipicto" /><span id="myText">My account</span></a>
     <a href="<% out.print(root+ "/FriendServlet"); %>">
            <img class="" src="<% out.print(root+"/images/friends3.jpg");%>" class ="posipicto"/><span id="myText">Friends</span></a>
     <a href="<% out.print(root+ "/MapServlet"); %>" >
             <img class="" src="<% out.print(root+"/images/map.jpg");%>" class ="posipicto"  /><span id="myText">Map</span></a>
     <a href="<%out.print(root+ "/LogoutServlet"); %>" id="">
             <img class="" src="<% out.print(root+"/images/logout1.jpg");%>" class ="posipicto" /><span id="myText">Logout</span></a>

 <div class="menubarre3" id="position-menu-barre">    
        <a href="<% out.print(root+ "/view/settingAccount.jsp"); %>" 
           style="margin-top: 10px;">Setting Account</a>
        <a href="<% out.print(root+ "/UserMediaServlet"); %>" class="is_selected">My Medias</a>        
    </div>

        <form action="<% out.print(root+ "/SearchServlet"); %>" method="GET">
            <!-- Bare menu -->
            <div id="posearch">
                <table>
                    <tr>
                        <td>
                    <input type="text" name="searchTopic" value="" size="25">
                        </td>
                        <td>
                        <input type="image" src="<% out.print(root+"/images/search.jpg");%>"
                           style="width: 32px; height: 32px;" name="Submit" value="find">
                        </td>
                </tr>
                </table>
            </div>
        </form>

  </div>
                           <center>                           
<div style="margin-top: 100px;">
     <table style="margin-left: 20px;" cellspacing="10">
      <% 
          List<String> listUrl = (List<String>)session.getAttribute("listMediaUrl");
          int size = listUrl.size();
          for(int i = 0; i < size; i++) { 
             if(i%4 == 0){             
    %>
            <tr>
                
        <% } %>  
        <td>
            <img src="<% out.print(listUrl.get(i));%>" style="width: 200px;height:150px;" />
        </td>
     <% if((i+1)%4 == 0 ){  %>
    </tr>
    <% } %>
    <% } %>

    </table>
</div>
                           </center>
<%@include file="tools/footPage.jspf" %>