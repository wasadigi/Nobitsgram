<%-- 
    Document   : userHistoryPage
    Created on : 8 janv. 2012, 14:04:36
    Author     : Eyram
--%>

<%@page import="ch.heigvd.nobitsgram.model.UserHistory"%>
<%@include file="../../view/tools/headPage.jspf" %>
<link rel="stylesheet" type="text/css" href="<% out.print(root+ "/css/adminHome_style.css"); %>" />
<% User user = (User)session.getAttribute("user"); %>
    <div class="bar3" id="positionbar">
        <a href="<% out.print(root+ "/HomeServlet"); %>" >
             <img class="" src="<% out.print(root+"/images/usersSetting.jpg");%>" class ="posipicto" /><span id="myText">Users setting</span></a>

             <a href="<%out.print(root+ "/UserInfoServlet?username="+user.getUsername()); %>" class="selected">
                 <img class="" src="<% out.print(root+"/images/userInfo1.jpg");%>" style="width: 35px;height: 35px;" class ="posipicto" /><span id="myText">User Informations</span></a>

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
    </div>
                    
    <div class="menubarre2" >                    
        <a href="<% out.print(root+ "/UserInfoServlet?username="+user.getUsername()); %>"  >User view</a>
        <a href="<% out.print(root+ "/UserHistoryServlet?username="+user.getUsername()); %>"  class="is_selected">User History</a>                   
    </div>
<%     
    UserHistory history = user.getHistory();
    List<Calendar> connexionsList = history.getDatesConnexion();
    List<Calendar> deconnexionList = history.getDatesDeconnexion();
    List<String> searchList = history.getSearchList();
%>
<div id="contener1">
    <h3> Date of account creation : <% out.print(history.getCreateDate().getTime()); %></h3>  
    
</div>
<div id="contener2">
    <table>    
        <tr>
            <td>
                Connexion date
            </td>        
        </tr>
        <% for(Calendar calendar: connexionsList){ %>
        <tr>
            <th>
                <% out.print(calendar.getTime()); %>
            </th>
        </tr>
        <% } %>
    </table>
</div>
<div id="contener3">
    <table>    
        <tr>
            <td>
                Deconnexion date
            </td>        
        </tr>
        <% for(Calendar calendar: deconnexionList){ %>
        <tr>
            <th>
                <% out.print(calendar.getTime()); %>
            </th>
        </tr>
        <% } %>
    </table>
</div>
    
<div id="contener4">
    <% 
        int size = searchList.size();
        for(int i = 0; i < size; i++){
            
            if(i%15 == 0){
    %>
    <br/>
    <% } out.print(searchList.get(i)+"     "); %>
    
    <% } %>
</div>
<%@include file="../../view/tools/footPage.jspf" %> 