<%--
    Document   : displayUserData
    Created on : 12 déc. 2011, 01:58:21
    Author     : Eyram
--%>

<%@page import="ch.heigvd.nobitsgram.entity.User"%>
<%@page import="ch.heigvd.nobitsgram.entity.Topic"%>
<%@page import="java.util.*"%>

<%@include file="tools/headPage.jspf" %>

<div class="bar" id="positionbar">
           <a href="<% out.print(root+ "/view/client.jsp"); %>" id="Home" class="">
            <img class="" src="<% out.print(root+"/images/home1.jpg");%>" style="top:10px;margin-left: -5px;position: relative"/>Home</a>
     <a href="<% out.print(root+ "/view/settingAccount.jsp"); %>" id="" class ="selected">
            <img class="" src="<% out.print(root+"/images/account1.jpg");%>" style="top:10px;margin-left: -5px;position: relative" />My account</a>
     <a href="<% out.print(root+ "/view/gallery.jsp"); %>" id="Gallery"  >
            <img src="<% out.print(root+"/images/gallery.jpg");%>" style="top:10px;margin-left: -5px;position: relative"/>Gallery</a>
     <a href="<% out.print(root+ "/view/friendsPage.jsp"); %>" id="">
            <img class="" src="<% out.print(root+"/images/friends3.jpg");%>" style="top:10px;margin-left: -5px;position: relative" />Friends</a>
     <a href="<% out.print(root+ "/view/map.jsp"); %>" id="">
             <img class="" src="<% out.print(root+"/images/map.jpg");%>" style="top:10px;margin-left: -5px;position: relative"  />Map</a>
     <a href="<%out.print(root+ "/LogoutServlet"); %>" id="">
             <img class="" src="<% out.print(root+"/images/logout1.jpg");%>" style="top:10px;margin-left: -5px;position: relative" />Logout</a>

        <!--Bare menu-->

            <form action="<% out.print(root+ "/SearchServlet"); %>" method="get" id="posearch">
                <input type="text" name="searchTopic" value="" size="25">
                 <input type="submit" name="Submit" value="find">

            </form>


        </div>

        <%
            User user = (User)request.getSession().getAttribute("user");
            String firstname = user.getFirstname();
            String lastname = user.getLastname();
            String country = user.getCountry();
            String email = user.getEmail();
            List <Topic> topics = user.getTopicList();
            String username = user.getUsername();

        %>
        <div>
		<form  method="post"  action="<% out.print(root+ "/ServletPersonnalPage"); %>">
                    <h2 style="margin-left: 20%; margin-top: 100px;"><% out.print(username); %>, your data! </h2>
        <table cellspacing="50"  bgcolor='#38B0DE' style="margin-left: 5%; margin-top: 20px;margin-bottom: 5%">

            <tr>
				<td><label for="lastname" >Last name</label></td>

                                <td><label><% out.print(lastname); %></label></td>
			</tr>
			<tr>
				<td><label for="firstname" >First name</label></td>

                                <td><label><% out.print(firstname); %></label></td>
			</tr>


            <tr>
                <td><label class="label" for="country">Country</label></td>
                <td><label><% out.print(country); %></label></td>
            </tr>

            <tr>
				<td><label for="email" id="email">Email </label></td>
                                <td><label><% out.print(email); %></label></td>
			</tr>
			<tr>



                         <%
                            int size = topics.size();
                            for(int i = 0; i < size; i++){

                            %>
                            <tr>
                            <td><label name="Topic">Topic <% out.print(" "+(i+1)); %></label></td>
                            <td><input name="topic<%out.print(i);%>" size="30" type="text"/></td>
                            <td><label name="Topic"><% out.print(topics.get(i).getName()); %></label></td>

                        </tr>
                        <% } %>


		</table>

		</form>

	</div>


<%@include file="tools/footPage.jspf" %>

