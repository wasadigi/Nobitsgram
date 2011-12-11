<%--
    Document   : searchPage
    Created on : 9 déc. 2011, 05:19:53
    Author     : Eyram
--%>

<%@page import="java.util.Random"%>
<%@page import="java.util.List"%>
<%@include file="tools/headPage.jspf" %>



        <!-- client page css -->



<div class="bar" id="positionbar">

     <a href="<% out.print(root+ "/view/client.jsp"); %>" id="Home">
            <img class="" src="<% out.print(root+"/images/home1.jpg");%>" style="top:10px;margin-left: -5px;position: relative"/>Home</a>
     <a href="<% out.print(root+ "/view/settingAccount.jsp"); %>" id="">
            <img class="" src="<% out.print(root+"/images/account1.jpg");%>" style="top:10px;margin-left: -5px;position: relative" />My account</a>
     <a href="<% out.print(root+ "/view/gallery.jsp"); %>" id="Gallery"  >
            <img class="" src="<% out.print(root+"/images/gallery.jpg");%>" style="top:10px;margin-left: -5px;position: relative"/>Gallery</a>
     <a href="<% out.print(root+ "/view/friendsPage.jsp"); %>" id="">
            <img class="" src="<% out.print(root+"/images/friends3.jpg");%>" style="top:10px;margin-left: -5px;position: relative" />Friends</a>
     <a href="<% out.print(root+ "/view/map.jsp"); %>" id="">
             <img class="" src="<% out.print(root+"/images/map.jpg");%>" style="top:10px;margin-left: -5px;position: relative"  />Map</a>
     <a href="<% out.print(root+ "/view/searchPage.jsp"); %>" class="selected">
             <img class="" src="<% out.print(root+"/images/search1.jpg");%>" style="top:10px;margin-left: -5px;position: relative"/>Search</a>

<!-- <form action="<%// out.print(root+ "/LogoutServlet"); %>" method="GET"> -->
            <!-- <input type="submit" name="disconnect" value="Logout"> -->
             <a href="<%out.print(root+ "/LogoutServlet"); %>" id="">
             <img class="" src="<% out.print(root+"/images/logout1.jpg");%>" style="top:10px;margin-left: -5px;position: relative" />Logout</a>
<!-- </form> -->

<form action="<% out.print(root+ "/SearchServlet"); %>" method="GET">
            <!-- Bare menu -->
            <div id="posearch">
                <input type="text" name="searchTopic" value="" size="25">
                <input type="submit" name="Submit" value="find">
            </div>
 </form>
    </div>

     <br/>

<br/>
     <br/>
     <%
        String message = (String)request.getAttribute("message");

        if(request.getAttribute("urlList")!=null){
            List<String> urlList =(List<String>)request.getAttribute("urlList");
           int size = urlList.size(); Random random = new Random(); int j;
          String username =(String)request.getSession().getAttribute("username");%>

          <div style="margin-left: 40%">

                   <h2>Result for <% out.print(message); %></h2>


          </div>
<div>
    <br/>
    <br/>
     <br/>

    <table style="margin-left: 18%">

        <tr>


            <%
                for(int i = 0; i < 3; i++) {
                    j = random.nextInt(size);
              %>
            <td>
                <span style="margin-right: 80px;"><img src="<% out.print(urlList.get(j));%>" style="width: 220px;height:170px;" /></span>


            </td>


           <% }%>

        </tr>
    </table>
</div>
            <%
           }%>

<br/>

<%@include file="tools/footPage.jspf" %>

