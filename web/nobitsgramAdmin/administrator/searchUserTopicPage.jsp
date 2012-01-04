<%-- 
    Document   : searchUserTopicPage
    Created on : 3 janv. 2012, 01:50:40
    Author     : Eyram
--%>

<%@include file="../../view/tools/headPage.jspf" %>

<link rel="stylesheet" type="text/css" href="<% out.print(root+ "/css/adminHome_style.css"); %>" />
<% User user = (User)session.getAttribute("user"); %>
    <div class="bar" id="positionbar">
        <a href="<% out.print(root+ "/HomeServlet"); %>" >
             <img class="" src="<% out.print(root+"/images/usersSetting.jpg");%>" class ="posipicto" /><span id="myText">Users setting</span></a>
                      

            <a href="<%out.print(root+ "/SearchUserServlet"); %>" class="selected">
                 <img class="" src="<% out.print(root+"/images/searchUser1.jpg");%>" style="width: 35px;height: 35px;" class ="posipicto" /><span id="myText">User Informations</span></a>
                 
         <a href="<%out.print(root+ "/LogoutAdmin"); %>" id="">
                    <img class="" src="<% out.print(root+"/images/adminLogout.jpg");%>" class ="posipicto" /><span id="myText">Logout</span></a>
<form action="<% out.print(root+ "/SearchUserServlet"); %>" method="GET">
            <!-- Bare menu -->
            <div id="posearch">
                <table>
                    <tr>
                        <td>
                            <input type="text" name="topicSearchUser" value="" size="25"/>
                        </td>
                        <td>
                        <input type="image" src="<% out.print(root+"/images/searchUser.jpg");%>"
                           style="width: 40px; height: 40px;" name="Submit" value="find" />
                        </td>
                </tr>
                </table>
            </div>
 </form>
    
    <div>
        <% List<Topic> topics = (List<Topic>)session.getAttribute("topicsLike"); 
           int size = topics.size();
           if(size != 0){
           Topic topic;
           User user;
           int size1;
         %>
         
        <table>
            <tr>
                <td>
                    username
                </td>
                <td>
                    profile picture
                </td>
            </tr>
            <% for(int i = 0; i < size; i++) { 
                topic = topics.get(i);
                    size1 = topic.getUsers().size();
                    for(int j = 0; j < size1; j++){
                        user = topic.getUsers().get(i);
             %>
            <tr>
                <td>
                    <% out.print(user.getUsername()); %>                    
                </td>
                <td>
                    <% out.print(user.getProfile_picture()); %>
                </td>
            </tr>
            <% } }%>
        </table>
        <% }else { %>
        <center>
            <h2> Any user haven't this word in his topic </h2>
        </center>
        <% } %>
    </div>

<%@include file="../../view/tools/footPage.jspf" %> 