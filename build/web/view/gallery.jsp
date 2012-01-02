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
<table cellspacing="10"  style="margin-left:20%;">
     <% List<String> topicUrlList = (List<String>)session.getAttribute("topicUrlList");
        Random random1 = new Random(); int i = -1; int size1 = topicUrlList.size();
       
       
     %>
     <tr><td> <img src="<% out.print(root+ "/images/topic.jpg"); %>" 
                   style="background: #FFA07A;width: 30px;height:30px;" /> </td>
        </tr>
     <tr>
        <% if(size1 > 0){ 
                i= random1.nextInt(size1); 
            }%>
        <td>
            
       
            <img src="<% if(i > -1){
                            out.print(topicUrlList.get(i));
                         }
                         else{
                            out.print("");}%>" style="background: #FF8C00;width: 200px;height:150px;" />
        </td>
        <td>
            
            <img src="<% if(i > -1){
                            i= random1.nextInt(size1); 
                            out.print(topicUrlList.get(i));
                         }
                         else{
                            out.print("");}%>" style="background: #FFA07A;width: 200px;height:150px;" />
        </td>
        <td>
            
            <img src="<% if(i > -1){
                            i= random1.nextInt(size1); 
                            out.print(topicUrlList.get(i));
                         }
                         else{
                            out.print("");}%>" style="background: #FF2400;width: 200px;height:150px;" />
        </td>
        
    </tr>
</table>
<br/>
<table cellspacing="10"  style="margin-left:20%;">
    <% List<String> followUrlList = (List<String>)session.getAttribute("followUrlList");
        Random random2 = new Random(); int j = -1; int size2 = followUrlList.size();
     %>
     <tr>
         <td> <img src="<% out.print(root+ "/images/follower.jpg"); %>" 
                  style="background: #FFA07A;width: 35px;height:35px;" /> </td>
        
     </tr>
    <tr>
        <% if(size2 > 0){
            j = random2.nextInt(size2); }%>
        <td>
            <img src="<% if(j > -1){
            out.print(followUrlList.get(j));
            }
            else{
            out.print("");}%>"  style="background: #D3D3D3;width: 200px;height:150px;" />
        </td>
        <td>
            
            <img src="<% if(j > -1){
                j= random2.nextInt(size2);
                out.print(followUrlList.get(j));
            }
            else{
            out.print("");}%>" style="background: #B9D3EE;width: 200px;height:150px;" />
        </td>
        <td>
            
            <img src="<% if(j > -1){
                j= random2.nextInt(size2);
                out.print(followUrlList.get(j));
            }
            else{
            out.print("");}%>"  style="background: #6C7B8B;width: 200px;height:150px;" />
        </td>
        
    </tr>
</table>
<br/>
<table cellspacing="10"  style="margin-left:20%;">
    <% List<String> likeUrlList = (List<String>)session.getAttribute("likeUrlList");
        Random random3 = new Random(); int k = -1; int size3 = likeUrlList.size();
     %>
     <tr>
         
         <td> <img src="<% out.print(root+ "/images/like.jpg"); %>" 
                  style="background: #FFA07A;width: 30px;height:30px;" /> </td>
        
     </tr>
    <tr>
        <td><% if(size3 > 0){
                k= random3.nextInt(size3);
              }%>
            
            <img src="<% if(k > -1){                               
                out.print(likeUrlList.get(k));
            }
            else{
            out.print("");}%>" style="background: #7D26CD;width: 200px;height:150px;" />
        </td>
        <td>
            <img src="<% if(k > -1){
                k= random3.nextInt(size3);
                out.print(likeUrlList.get(k));
            }
            else{
            out.print("");}%>" style="background: #007FFF;width: 200px;height:150px;" />
        </td>
        <td>
            <img src="<% if(k > -1){
                k= random3.nextInt(size3);
                out.print(likeUrlList.get(k));
            }
            else{
            out.print("");}%>" style="background: #00FFFF;width: 200px;height:150px;" />
        </td>
    </tr>
</table>
<%@include file="tools/footPage.jspf" %>

