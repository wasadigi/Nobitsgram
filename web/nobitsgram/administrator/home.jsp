<%-- 
    Document   : home
    Created on : 29 déc. 2011, 20:26:56
    Author     : Eyram
--%>

<%@include file="../../view/tools/headPage.jspf" %>
<link rel="stylesheet" type="text/css" href="<% out.print(root+ "/css/adminHome_style.css"); %>" />
<div class="bar" id="positionbar">
         <a href="<% out.print(root+ "/HomeServlet"); %>" class="selected" >
         <img class="" src="<% out.print(root+"/images/usersSetting.jpg");%>" class ="posipicto" /><span id="myText">Users setting</span></a>
     
     
     <a href="<%out.print(root+ "/LogoutAdmin"); %>" id="">
             <img class="" src="<% out.print(root+"/images/adminLogout.jpg");%>" class ="posipicto" /><span id="myText">Logout</span></a>
</div>    
             <% 
                List<User> users = (List<User>)session.getAttribute("users");
                int nbUser = users.size();
                int nbPage = (Integer)session.getAttribute("nbPage");
                int indexPage = (Integer)session.getAttribute("indexPage");
                int nber = (Integer)session.getAttribute("nber");
                int begin = indexPage*nber;
                int tmp;
                if(begin+nber > nbUser){
                    tmp = nbUser;
                }
                else{
                    tmp = begin+nber;
                }
             %>
            
           <center>
            <div >
           
            <table border="2" id ="tableContener">
                <caption><h2>It were <% out.print(nbUser); %> users in nobitsgram</h2></caption>
                <tr>
                    <td>
                        <h3>  username </h3>
                    </td>
                    <td>
                        <h3> block user </h3>
                    </td>
                    <td>
                        <h3> firstname </h3>
                    </td>
                    <td>
                        <h3> lastname </h3>
                    </td>
                    <td>
                        <h3> country </h3>
                    </td>
                </tr>
            <%  for(int i = begin; i < tmp; i++){
              %>
              <tr>
                  <td>
                      <a href="<% out.print(root+ "/UserViewServlet"); %>" >
                          <% out.print(users.get(i).getUsername()); %>
                      </a>
                  </td>
                  <td>
                      <% out.print(users.get(i).getFirstname()); %>
                  </td>
                  <td>
                      <% out.print(users.get(i).getLastname()); %>
                  </td>
                  <td>
                      <% out.print(users.get(i).getCountry()); %>
                  </td>
                  <td>
                    <a href="<% out.print(root+ "/BlockUserServlet"); %>" >
                        <img src="<% out.print(root+"/images/blockUser1.jpg");%>"
                             style="width: 35px; height: 35px;" />
                    </a>
                  </td>
              </tr>
            <% } %>
            </table>
            </div>
           </center>
            <center>
            <form  method="GET"  action="<% out.print(root+ "/HomeServlet"); %>">
            <table cellspacing="20">
                <tr>
                    <% for(int i = 0; i < nbPage; i++) { %>
                    <td style="text-align: center ">
                         <input type="submit" name="action" value="<% out.print(i+1); %>" />
                        
                       
                    </td>
                    <% } %>
                </tr>
            </table>
            </form>
            </center>
<%@include file="../../view/tools/footPage.jspf" %> 