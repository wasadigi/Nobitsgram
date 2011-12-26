<%--
    Document   : searchPage
    Created on : 9 déc. 2011, 05:19:53
    Author     : Eyram
--%>

<%@page import="java.util.Random"%>
<%@include file="tools/headPage.jspf" %>



        <!-- client page css -->



<div class="bar1" id="positionbar">

     <a href="<% out.print(root+ "/GalleryServlet"); %>" >
         <img class="" src="<% out.print(root+"/images/gallery.jpg");%>" class ="posipicto" /><span id="myText">Gallery </span></a>
     <a href="<% out.print(root+ "/view/settingAccount.jsp"); %>" id="">
            <img class="" src="<% out.print(root+"/images/account1.jpg");%>" class ="posipicto" /><span id="myText">My account</span></a>
     <a href="<% out.print(root+ "/FriendServlet"); %>" id="">
            <img class="" src="<% out.print(root+"/images/friends3.jpg");%>" class ="posipicto"/><span id="myText">Friends</span></a>
     <a href="<% out.print(root+ "/MapServlet"); %>" >
             <img class="" src="<% out.print(root+"/images/map.jpg");%>" class ="posipicto"  /><span id="myText">Map</span></a>
             <a href="<% out.print(root+ "/view/searchPage.jsp"); %>" class="selected">
             <img class="" src="<% out.print(root+"/images/search3.jpg");%>"  class ="posipicto"/><span id="myText">Search</span></a>

             <a href="<%out.print(root+ "/LogoutServlet"); %>" id="">
             <img class="" src="<% out.print(root+"/images/logout1.jpg");%>" class ="posipicto" /><span id="myText">Logout</span></a>


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

        String message = (String)session.getAttribute("message");
        List<String> urlList =(List<String>)request.getSession().getAttribute("urlList");
        %>

        <div style="text-align: center;">

            <h2><% out.print(message); %></h2>

        </div>

        <% if( urlList !=null && !urlList.isEmpty()){
           int size = urlList.size(); Random random = new Random(); int j;
           String username =(String)request.getSession().getAttribute("username");%>


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

