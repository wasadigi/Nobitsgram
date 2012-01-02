<%-- 
    Document   : pageListTopicUser
    Created on : 20 déc. 2011, 16:41:35
    Author     : Eyram
--%>

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

            <form action="<% out.print(root+ "/SearchServlet"); %>" method="GET">
            
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

    <div class="menubarre" id="position-menu-barre">
    
        <a href="<% out.print(root+ "/view/friendsPage.jsp"); %>" style="margin-top: 10px;">My contacts</a>
        <a href="<% out.print(root+ "/ListTopicUserServlet"); %>" class="is_selected" >My topics users</a>
        <a href="<% out.print(root+ "/UsersActualyConnectServlet"); %>">Nobitsgram users</a>
        <a href="<% out.print(root+ "/MyFollowerServlet"); %>">My followers</a>                  
    </div>
        <% List<Topic> topics = (List<Topic>)session.getAttribute("topics");
           int size = 0;
           if(topics != null){
               size = topics.size();
           }
        %>
        <div>
            <% for(int i = 0; i < size; i++){ %>
            <div class="imageContener">
                                    
              <h2 style="margin-bottom:-3px;">  <% out.print(topics.get(i).getName()); %>   </h2>
                                        
                
              <table>  
                    <tr>
                        <% List<User> users = topics.get(i).getUsers();
                   users.remove((User)session.getAttribute("user"));
                   int size1 = users.size(); User user;
                   for(int j = 0; j < size1; j++){
                       user = users.get(j);
                %>
                        <td class="pictureContener">
                    <center>
                            <p id="picturposition">
                                <img src="<% out.print(user.getProfile_picture()); %>" 
                                         style="width: 80px;height:80px;" />
                            </p>
                    </center>
                            <p id="nameposition">
                                        <% out.print(user.getUsername()); %> 
                            </p>
                        </td>
                        <td>
                    
                        </td>
                          <% } %>
                    </tr>

                    </table>
                  
                                    


            <% } %>
            
        </div>
                
<%@include file="tools/footPage.jspf" %>

