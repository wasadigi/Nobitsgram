<%--
    Document   : gallery
    Created on : 9 déc. 2011, 04:47:02
    Author     : Eyram
--%>

<%@page import="java.util.Random"%>
<%@include file="tools/headPage.jspf" %>
    <div class="bar" id="positionbar">
         <a href="<% out.print(root+ "/GalleryServlet"); %>" class="selected" >
         <img class="" src="<% out.print(root+"/images/gallery.jpg");%>" class ="posipicto" /><span id="myText">Gallery </span></a>
     <a href="<% out.print(root+ "/view/settingAccount.jsp"); %>" id="">
            <img class="" src="<% out.print(root+"/images/account1.jpg");%>" class ="posipicto" /><span id="myText">My account</span></a>
     <a href="<% out.print(root+ "/FriendServlet"); %>" id="">
            <img class="" src="<% out.print(root+"/images/friends3.jpg");%>" class ="posipicto"/><span id="myText">Friends</span></a>
     <a href="<% out.print(root+ "/MapServlet"); %>">
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
<br/>
<br/><br/>
<center>
<table cellspacing="10" >
     <% List<String> topicUrlList = (List<String>)session.getAttribute("topicUrlList");        
         int size1 = topicUrlList.size();         
        if(size1 > 0 ){
            List<String> tmpList = topicUrlList;        
            Random random = new Random(); 
            int a;
            int b = Math.min(size1, 3);
            
     %>
     <tr><td> <img src="<% out.print(root+ "/images/topic.jpg"); %>" title="TOPIC"
                   style="background: #FFA07A;width: 30px;height:30px;" /> </td>
         <td><h3>Topic Pictures</h3></td>
        </tr>
     <tr>
        <% for (int i = 0; i < b; i++){
                a = random.nextInt(tmpList.size());
         %>
        <td>
            
       
            <img src="<%out.print(tmpList.get(a));%>" style="background: #FF8C00;width: 200px;height:150px;" />
        </td>
        <%  
            tmpList.remove(a);
        } %> 
    </tr>
    <% } %>
</table>
<br/>
<table cellspacing="10">
    <% List<String> followUrlList = (List<String>)session.getAttribute("followUrlList");
        int size2 = followUrlList.size();         
        if(size2 > 0 ){
            List<String> tmpList2 = followUrlList;        
            Random random = new Random(); 
            int a;            
            int b = Math.min(size2, 3);
     %>
     <tr>
         <td> <img src="<% out.print(root+ "/images/follower.jpg"); %>" title="FOLLOWER"
                  style="background: #FFA07A;width: 35px;height:35px;" /> </td>
         <td><h3>Follower Pictures</h3>
        
     </tr>
    <tr>
        <% for(int i = 0; i < b; i++){
            a = random.nextInt(tmpList2.size()); %>
        <td>
            <img src="<%out.print(tmpList2.get(a)); %>" style="width: 200px;height:150px;"/>
        </td>
        <% 
         tmpList2.remove(a);
         } 
        %>
    </tr>
    <% } %>
</table>
        
<br/>
<table cellspacing="10" >
    <% List<String> likeUrlList = (List<String>)session.getAttribute("likeUrlList");
        
        int size3 = likeUrlList.size();                 
        if(size3 > 0 ){
            List<String> tmpList3 = likeUrlList;        
            Random random = new Random(); 
            int a;
            int b = Math.min(size3, 3);
                
     %>
     <tr>
         
         <td> <img src="<% out.print(root+ "/images/like.jpg"); %>" title="LIKE"
                  style="width: 30px;height:30px;" /> </td>
         <td><h3>Like Pictures</h3></td>
        
     </tr>
    <tr>
        <% for(int i = 0; i < b; i++){
                a = random.nextInt(tmpList3.size()); %>
        <td>
            
            <img src="<% out.print(tmpList3.get(a));%>" style="width: 200px;height:150px;" />
        </td>
        <% 
        tmpList3.remove(a);
        } %>
    </tr>
    <% } %>
</table>
</center>
<%@include file="tools/footPage.jspf" %>

