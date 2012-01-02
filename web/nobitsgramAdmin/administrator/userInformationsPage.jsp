<%-- 
    Document   : userInformations
    Created on : 1 janv. 2012, 14:34:20
    Author     : Eyram
--%>

<%@include file="../../view/tools/headPage.jspf" %>
    <div class="bar" id="positionbar">
        <a href="<% out.print(root+ "/HomeServlet"); %>" >
             <img class="" src="<% out.print(root+"/images/usersSetting.jpg");%>" class ="posipicto" /><span id="myText">Users setting</span></a>

             <a href="<%out.print(root+ "/UserInfoServlet"); %>" class="selected">
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
                    
    <div class="menubarre1" >                    
        <a href="<% out.print(root+ "/UsersInfoServlet"); %>" class="is_selected" >User view</a>
        <a href="<% out.print(root+ "/UserHistoryServlet"); %>"  >User History</a>                   
    </div>
    
        <% User user = (User)session.getAttribute("user"); %>
        
        <div>
            
            <table>
                <caption><h2>Informations about <% out.print(user.getUsername()); %> </h2></caption>
                <colgroup>
                    <col class="usernCol"/>
                    <col class="firstnCol"/>
                    <col class="lastnCol"/>
                    <col class="countryCol"/>
                    <col class="pictureCol"/>
                    <col class="blockCol"/>
                    <col class="activeCol"/>
                </colgroup>
            </table>
            
        </div>
<%@include file="../../view/tools/footPage.jspf" %> 