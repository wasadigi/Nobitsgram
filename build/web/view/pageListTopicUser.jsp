<%-- 
    Document   : pageListTopicUser
    Created on : 20 déc. 2011, 16:41:35
    Author     : Eyram
--%>

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
        <a href="<% out.print(root+ "/ListTopicUserServlet"); %>" class="is_selected" >My topics users</a>
        <a href="">Nobitsgram users</a>
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
                            <p id="picturposition">
                                <img src="<% out.print(user.getProfile_picture()); %>" 
                                         style="width: 80px;height:80px;" />
                            </p>
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

