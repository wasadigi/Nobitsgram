<%-- 
    Document   : searchUserTopicPage
    Created on : 3 janv. 2012, 01:50:40
    Author     : Eyram
--%>

<%@include file="../../view/tools/headPage.jspf" %>

<link rel="stylesheet" type="text/css" href="<% out.print(root+ "/css/adminHome_style.css"); %>" />
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
    <br/><br/><br/>
    
    <div style="margin-left: 40%">
        <% List<Topic> topics = (List<Topic>)session.getAttribute("topicsLike"); 
           int size = topics.size();
           if(size != 0){
           Topic topic;
           User user;
           int size1;
         %>
         
        
            
            <% for(int i = 0; i < size; i++) { 
                topic = topics.get(i);
            size1 = topic.getUsers().size(); %>
                
                <center>
                   
                        <h2> <% if(size1 != 0) out.print(topics.get(i).getName()); %> </h2>
               <table cellspacing="30">     
                
               <% for(int j = 0; j < size1; j++){
                        user = topic.getUsers().get(j);
                        
                        if(j%7 == 0){
             %>
             <tr>
                 <% } %>
                 <td>
                    <a href="<% out.print(root+ "/UserInfoServlet?username="+user.getUsername()); %>">
                        <img class="" src="<% out.print(user.getProfile_picture()); %>" style="width: 80px; height: 80px"/>
                    </a>
                    
                    <center>
                    <br style="margin-top: -15px;"/>
                        <% out.print(user.getUsername()); %> 
                    
                    </center>
                </td>
            <% if((j+1)%7 == 0) {%>
            </tr>
            <% }} %>
            </table>
                </center>
            <%  }%>
        
        <% }else { %>
        <center>
            <h2> Any user haven't this word in his topic </h2>
        </center>
        <% } %>
    </div>
    
<%@include file="../../view/tools/footPage.jspf" %> 