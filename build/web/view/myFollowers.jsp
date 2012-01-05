<%-- 
    Document   : myFollowers
    Created on : 21 déc. 2011, 14:48:23
    Author     : Eyram
--%>
<%@page import="ch.heigvd.nobitsgram.model.UserInstagram"%>
<%@include file="tools/headPage.jspf" %>
<script type="text/javascript" src="jquery-1.2.3.min.js"></script>
<script type="text/javascript" src="Default.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
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

    <div class="menubarre" id="position-menu-barre">
    
        <a href="<% out.print(root+ "/view/friendsPage.jsp"); %>" style="margin-top: 10px;">My contacts</a>
        <a href="<% out.print(root+ "/ListTopicUserServlet"); %>"  >My topics users</a>
        <a href="<% out.print(root+ "/UsersActualyConnectServlet"); %>">Nobitsgram users</a>
        <a href="<% out.print(root+ "/MyFollowerServlet"); %>"
           class="is_selected">My followers</a>                  
    </div>
        <% 
           List<UserInstagram> myFollowers = (List<UserInstagram>)session.
                                                getAttribute("myFollowers");
           User user = (User)session.getAttribute("user");
           int size = 0;
           String image;
           String name;
           String userId;
           UserInstagram userInsta;
           if(myFollowers != null && !myFollowers.isEmpty()){
               size = myFollowers.size();
           }
           for(int i = 0; i < size; i++){
               userInsta = myFollowers.get(i);
               image = userInsta.getProfilePicture();
               name = userInsta.getUsername();
               userId = userInsta.getId();
        %>
        <table cellspacing="18"  style="margin-left:2%;">
           
             <tr>
                 
                 <td>
                     <form name ="ajax" method="Post">
                     <table cellspacing="0" >
                         <tr>
                         <td  class="pictureContener">
                    <center>
                     <p id="picturposition">
                         <img src="<% out.print(image); %>" 
                   style="background: #FFA07A;width: 60px;height:60px;" /> 
                     </p>
                    </center>
                     <p id="nameposition">
                            <% out.print(name); %> 
                     </p>
                 
                    </td>
                  </tr>
                  <tr>
                      <td>
                  <center id="buttonContainer">
                      <input title="FOLLOW" type ="button" value="follow" name="<% out.print(userId); %>"  
                         style="border:1px solid #1C86EE;
                         background:#1C86EE;width:60px;
                         background-color:#1C86EE;
                         height: 20px;font-size:14px" onclick="submitFollow(userId = <% out.print(userId); %>,'idButton')" 
                         id="idButton" /> 
                  </center>
                      </td>
                  </tr>
                </table>
                      </form>
                     </td>
            

                 <% 
                    List<String> urlList = userInsta.getListPicture(); 
                    for(String s: urlList){
                 %>
                 <td class="pictureContener">
                     <p>
                 <center>
                     
                     <img src="<% out.print(s); %>" 
                   style="background: #FFA07A;width: 185px;height:170px;" /> 
                     
                 </center>
                  </p>
                  <form method="POST" name ="ajax">
                  <p id="nameposition">
                      <input src="<%out.print(root+ "/images/like1.jpg");%>" 
                   style="margin-left: 2px;width: 30px;height:30px;" title="LIKE" 
                   title="FOLLOW" type ="image" value="submit" onclick="submitLike()" />
                     </p>
                  </form>
                 </td>
                 <%}%>
                </tr>                                  
           
             </tr>
        </table>
               
       <% }%>
        

       
<script type="text/javascript">
    
    var xmlObject;
    var userId;     
    var urlFollow;
    
   
    function submitFollow(userId,idButton){               
        
        urlFollow = "https://api.instagram.com/v1/users/"+userId+"/relationship?access_token=<% out.print(user.getAcces_token()); %>";
                
        $.ajax({
        type: "POST",         
        dataType: "jsonp",        
        url: urlFollow,
        success: function() {
            alert("Follow is OK!!");
            document.getElementById(idButton).disabled = 'disable';
        }
    });

   }   
        
        
   

</script>  

<%@include file="tools/footPage.jspf" %>