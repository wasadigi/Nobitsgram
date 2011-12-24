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
            <a href="<% out.print(root+ "/view/map.jsp"); %>" class="selected" >
             <img class="" src="<% out.print(root+"/images/map.jpg");%>" class ="posipicto"  /><span id="myText">Map</span></a>
     <a href="<%out.print(root+ "/LogoutServlet"); %>" id="">
             <img class="" src="<% out.print(root+"/images/logout1.jpg");%>" class ="posipicto" /><span id="myText">Logout</span></a>

        <!--Bare menu-->

            <form action="<% out.print(root+ "/SearchServlet"); %>" method="get" id="posearch">
                <input type="text" name="searchTopic" value="" size="25">
                 <input type="submit" name="Submit" value="find">

            </form>


        </div>
<!-- Google Custom Search Element -->

<% 
   User user = (User)session.getAttribute("user");   
   double lat = user.getLatitude();
   double lng = user.getLongitude();
   boolean zoomOut = user.isZoomOut();
%>


<!-- This code come from http://code.google.com/intl/fr/apis/maps/documentation/javascript/tutorial.html#Loading_the_Maps_API -->
<!-- and http://code.google.com/intl/fr/apis/maps/documentation/javascript/overlays.html#AddingOverlays -->
<script type="text/javascript">
       
   var userPosition = new google.maps.LatLng(<%out.print(lat);%>,<%out.print(lng);%>);
   var myZoom;
   if(<%out.print(zoomOut);%>){
       myZoom = 6;
   }
   else{
       myZoom = 15;
   }
 
  function initialize() {    
    var myOptions = {
      
      zoom: myZoom ,
      center : userPosition,
      mapTypeId: google.maps.MapTypeId.ROADMAP
     
    };
    var map = new google.maps.Map(document.getElementById("map_canvas"),
        myOptions);
    
    
       
          var marker = new google.maps.Marker({
    map:map,
    draggable:true,
    animation: google.maps.Animation.DROP,
    position: userPosition
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
    cityCircle = new google.maps.Circle(areaOption);

}

function toggleBounce() {

  if (marker.getAnimation() != null) {
    marker.setAnimation(null);
  } else {
    marker.setAnimation(google.maps.Animation.BOUNCE);
  }
       
    
    
     
  
  }

</script>

    <br/><br/>
     <div id="map_canvas" style="width:100%; height:100%; margin: 0; padding: 0;margin-top: -25px;"></div>

<%@include file="tools/footPage.jspf" %>

