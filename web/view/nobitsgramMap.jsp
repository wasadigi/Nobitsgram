<%-- 
    Document   : nobitsgramMap
    Created on : 26 déc. 2011, 05:48:38
    Author     : Eyram
--%>
<%@page import="ch.heigvd.nobitsgram.model.MapUser"%>
<%@include file="tools/mapHead.jspf" %>

<div class="bar" id="positionbar">
         <a href="<% out.print(root+ "/GalleryServlet"); %>" >
         <img class="" src="<% out.print(root+"/images/gallery.jpg");%>" class ="posipicto" /><span id="myText">Gallery </span></a>
     <a href="<% out.print(root+ "/view/settingAccount.jsp"); %>" id="">
            <img class="" src="<% out.print(root+"/images/account1.jpg");%>" class ="posipicto" /><span id="myText">My account</span></a>
     <a href="<% out.print(root+ "/FriendServlet"); %>" id="">
            <img class="" src="<% out.print(root+"/images/friends3.jpg");%>" class ="posipicto"/><span id="myText">Friends</span></a>
            <a href="<% out.print(root+ "/MapServlet"); %>" class="selected" >
             <img class="" src="<% out.print(root+"/images/map.jpg");%>" class ="posipicto"  /><span id="myText">Map</span></a>
     <a href="<%out.print(root+ "/LogoutServlet"); %>" id="">
             <img class="" src="<% out.print(root+"/images/logout1.jpg");%>" class ="posipicto" /><span id="myText">Logout</span></a>

        <!--Bare menu-->
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
    
        <a href="<% out.print(root+ "/MapServlet"); %>" 
            style="margin-top: 10px;">
                            Photo Map
        </a>
           
        <a href="<% out.print(root+ "/NobitsgramMapServlet"); %>"
           class="is_selected" >
                            Nobitsgram Map
        </a>        
    </div>

<% 
   
   List<User> users = (List<User>)session.getAttribute("users");
   String position;
   String image;
   String username;
   double lat;
   double lng;
   int size = users.size();
   User user = (User)session.getAttribute("user");   
   double lat1 = user.getLatitude();
   double lng1 = user.getLongitude();
   boolean isConnected;
   
   
%>


<!-- This code come from http://code.google.com/intl/fr/apis/maps/documentation/javascript/tutorial.html#Loading_the_Maps_API -->
<!-- and http://code.google.com/intl/fr/apis/maps/documentation/javascript/overlays.html#AddingOverlays -->
<script type="text/javascript">
       
   var userPosition= new google.maps.LatLng(<%out.print(lat1);%>,<%out.print(lng1);%>);
   var myZoom = 2;
   var marker;
   var infowindow = new google.maps.InfoWindow();
  
 
  function initialize() {    
    var myOptions = {
      center: userPosition,
      zoom: myZoom ,
      mapTypeId: google.maps.MapTypeId.ROADMAP
     
    };
    var map = new google.maps.Map(document.getElementById("map_canvas"),
        myOptions);
    var j;
    
    currentMarker = new google.maps.Marker();
    currentMarker.setPosition();
    
    <% for(int i = 0; i < size; i++) {

            lat = users.get(i).getLatitude();
            lng = users.get(i).getLongitude();            
            position =users.get(i).getCountry();
            image = users.get(i).getProfile_picture();
            username = users.get(i).getUsername(); 
            isConnected = users.get(i).isConnect();
            
            if(users.get(i).getStreet() != null && users.get(i).getStreet() != ""){  
              position = users.get(i).getStreet();
            } 
            
            else if(users.get(i).getCity() != null && users.get(i).getCity() != ""){
               position = users.get(i).getCity();
            }

       %>
                          
              marker = new google.maps.Marker({
                        position: new google.maps.LatLng(<%out.print(lat);%>,<%out.print(lng);%>),
                            map: map
                    });
       
                  
    google.maps.event.addListener(marker, 'click', (function(marker,j){
        return function() {
          infowindow.setContent('<div> <img src="<% out.print(image); %>" style="width: 50px;height:50px;" />'+
                    '<% if (isConnected){ %>' +
                   '<img src="<% out.print(root+ "/images/connected3.jpg"); %>"style="width: 20px;height:20px;" />'+
                    '<% } %>'+
                   '<div style="margin-left:10px;"><% out.print(username);%></div>'+
                  '<p> <% out.print("Position:  " +position ); %> </div> </p>'+
                   '<p> <% out.print("Latitude:  " +lat); %> </div> </p>'+
                   '<p> <% out.print("Longitude:  " +lng ); %> </div> </p>' );
          
          infowindow.open(map, marker);
        }
      })(marker, <%out.print(i);%>));
      
      
      
   
       <% } %>
   
    
  

    
    
    
    

}



</script>

    <br/><br/>
    <div >
     <div id="map_canvas" style="width:95%; height:95%;
    border: 2px solid #000; margin-top: 30px;"> 
     </div>
    <div 
     <div>
        <table>
            <tr>
                
            </tr>
        </table>
    
    </div>
    </div>
        
<%@include file="tools/footPage.jspf" %>

