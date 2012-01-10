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
             <img class="" src="<% out.print(root+"/images/search64.jpg");%>" style="width: 34px;height: 34px;" class ="posipicto"/><span id="myText">Search</span></a>

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
           int b = Math.min(size, 3);
           List<Integer> tmpList = new ArrayList<Integer>();                      
        %>


<div>
    <br/>
    <br/>
     <br/>

    <table style="margin-left: 18%">

        <tr>


            <%
                for(int i = 0; i < b; i++) {
                    j = random.nextInt(size);                    
                    while(!tmpList.isEmpty() && tmpList.contains(j)){
                        j = random.nextInt(size);
                    }
                    System.out.println("j APRES ==> "+j);
                    tmpList.add(j);
              %>
            <td>
                <span style="margin-right: 80px;"><img src="<% out.print(urlList.get(j));%>" style="width: 220px;height:170px;" /></span>


            </td>


           <% 
            if(tmpList.size()%3 == 0 && size - tmpList.size() <= 3){
                tmpList = new ArrayList<Integer>();
            }
             }
            %>

        </tr>
    </table>
</div>
            <%
           }%>

<br/>

<%@include file="tools/footPage.jspf" %>

