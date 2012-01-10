<%--
    Document   : map
    Created on : 11 déc. 2011, 16:53:49
    Author     : Eyram
--%>


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
                           style="width: 32px; height: 30px;" name="Submit" value="find">
                        </td>
                </tr>
                </table>
            </div>
 </form>


        </div>
<div class="menubarre" id="position-menu-barre">
    
        <a href="<% out.print(root+ "/MapServlet"); %>" 
           class="is_selected" style="margin-top: 10px;">
                            Photo Map
        </a>
           
        <a href="<% out.print(root+ "/NobitsgramMapServlet"); %>"
           >
                            Nobitsgram Map
        </a>        
    </div>

<% 
   
   
   User user = (User)session.getAttribute("user");
   
   
   double lat = user.getLatitude();
   double lng = user.getLongitude();
   boolean zoomOut = user.isZoomOut();
   String position = user.getCountry();
   String username = user.getUsername();
   String image = user.getProfile_picture();
   String clickLat;
   String clickLng;
   
      clickLat = request.getParameter("latitude");
      clickLng = request.getParameter("longitude");
      
  
   if(user.getStreet() != null && user.getStreet()!="" ){
       position = user.getStreet();
   }
   else if(user.getCity() != null && user.getCity() !="" ){
         position = user.getCity();
   }
  
%>


<!-- This code come from http://code.google.com/intl/fr/apis/maps/documentation/javascript/tutorial.html#Loading_the_Maps_API -->
<!-- and http://code.google.com/intl/fr/apis/maps/documentation/javascript/overlays.html#AddingOverlays -->
<script type="text/javascript">
       
   var userPosition = new google.maps.LatLng(<%out.print(lat);%>,<%out.print(lng);%>);
   var myZoom;
   var marker;
   var markersArray = [];
   var servletName ="MapServlet";
   var latitude;
   var longitude;
   var pos;
   var iconUser = new google.maps.MarkerImage("images/marker.png",         
          new google.maps.Size(40,64),         
          new google.maps.Point(0,0)                
  );
    
    
    var iconPhoto = new google.maps.MarkerImage("images/photography.png",                   
        new google.maps.Size(40,64),         
        new google.maps.Point(0,0)         
  );
    
   var tmp = <% out.print(clickLat ); %>
   if(<%out.print(zoomOut);%>){
       myZoom = 6;
   }
   else{
       myZoom = 10;
   }
 
  function initialize() {    
      
      <% if(clickLat != null){ %>
        pos = new google.maps.LatLng(<%out.print(clickLat);%>,<%out.print(clickLng);%>);
        center = pos;
      <% } else{ %>
        center = userPosition;
      <% } %>
          
     var myOptions = {      
      zoom: myZoom ,
      center : center,
      mapTypeId: google.maps.MapTypeId.ROADMAP
     
    };
    var map = new google.maps.Map(document.getElementById("myMap"),
        myOptions);
    
       
       
    marker = new google.maps.Marker({
    map:map,
    draggable:true,
    animation: google.maps.Animation.DROP,
    position: userPosition,
    icon : iconUser
  });
  google.maps.event.addListener(marker, 'click', toggleBounce);
  var areaOption = {
      strokeColor: "#0000CD",
      strokeOpacity: 0.8,
      strokeWeight: 1,
      fillColor: "#00FF7F",
      fillOpacity: 0.25,
      map: map,
      center: userPosition,
      radius: 621.3711922
    };
        <% if(clickLat != null){ %>                   
            placeMarker(pos, map)                   
        <% } %>
   
        //cityCircle = new google.maps.Circle(areaOption);    		
        var infowindow = new google.maps.InfoWindow({
            content: '<div> <img src="<% out.print(image); %>" style="background: #FFA07A;width: 50px;height:50px;" />'+
                       '<div style="margin-left:10px;"><% out.print(username);%></div>'+
                      '<p> <% out.print("Position:  " +position ); %> </div> </p>'+
                       '<p> <% out.print("Latitude:  " +lat); %> </div> </p>'+
                       '<p> <% out.print("Longitude:  " +lng ); %> </div> </p>'
        });

        google.maps.event.addListener(marker, 'click', function() {
        infowindow.open(map, marker);
    });

 google.maps.event.addListener(map, 'click', function(event) {
          
          placeMarker(event.latLng, map);
        
        latitude = event.latLng.lat();
        longitude = event.latLng.lng();        
        document.location.href = "/nobitsgram/MapServlet?latitude="+latitude+"&longitude="+longitude;        
        
    }); 
} 
 


 function toggleBounce() {

 if (marker.getAnimation() != null) {
     marker.setAnimation(null);
  } else {
    marker.setAnimation(google.maps.Animation.BOUNCE);
  }                    
  
  }

//place marker were user click
  function placeMarker(position, map) {
        var marker = new google.maps.Marker({
          position: position,
          map: map, 
          icon: iconPhoto
        });
        markersArray.push(marker);
        //clear the last marker on the map
        clearOverlays();
        
        
       
        
  }
  
  // Removes the last overlays from the map, 
 function clearOverlays() {
    if (markersArray) {
      for(var i=0; i<markersArray.length-1; i++){
        markersArray[i].setMap(null);
    }
  } 
}



</script>
<center>
    <table>
        <tr>
         
            <td>
            
            <div id="myMap" >
            </div>                
       </td>
       <td>
           <div id="myPictuPosition">
         
               
               
                   <% List<String> positionUrl = (List<String>)session.getAttribute("positionUrl");
                      String errorMap = (String)session.getAttribute("errorMap");                      
                      int size1 =  positionUrl.size();
                   if(size1 != 0){
                       Random random = new Random();
                       int index;
                       List<String> tmpList = positionUrl;
                       int b = Math.min(size1, 9);
                       
                       %>
                  <table style="margin-top:-5px; margin-left:-5px;">
                     <%  for(int i = 0; i < b; i++ ) {
                           index = random.nextInt(tmpList.size());                      
                      if(i%3 == 0){    %>                   
                      <tr>
                       <% } %>
                           <td> 
                               
                               <img   src="<% out.print(tmpList.get(index));%>"  style="width: 190px;height: 148px;"/>
                               
                           </td>
                        <% if((i+1)%3 == 0){ %>
                       </tr>
                       <% }
                          tmpList.remove(index);
                      } %>
                    </table>
                     <% } %>
               
               <% if (errorMap != null) { %>
               <center>
                   <h3 style="color:red"> <% out.print(errorMap); %> <h3/>
               </center>
              <% 
                 session.removeAttribute("errorMap");
              } %>
           </div>
           
       </td>
      
    </tr>
    <tr>
      
    </tr>
  </table>  
              
</center>
<%@include file="tools/footPage.jspf" %>

