<%-- 
    Document   : userInformations
    Created on : 1 janv. 2012, 14:34:20
    Author     : Eyram
--%>

<%@include file="../../view/tools/headPage.jspf" %>
<link rel="stylesheet" type="text/css" href="<% out.print(root+ "/css/adminHome_style.css"); %>" />
<% User user = (User)session.getAttribute("user"); %>
    <div class="bar" id="positionbar">
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
                    
    <div class="menubarre1" >                    
        <a href="<% out.print(root+ "/UserInfoServlet?username="+user.getUsername()); %>" class="is_selected" >User view</a>
        <a href="<% out.print(root+ "/UserHistoryServlet"); %>"  >User History</a>                   
    </div>
    
        
        
        <div>
            <h2>Informations about <% out.print(user.getUsername()); %> </h2>
            <table cellspacing="10" cellpadding="15">                               
               
                <tr>
                    <td rowspan="10">
                        <div>
                        <img src="<% out.print(user.getProfile_picture()); %>"/><br/>
                        <center>
                        <% out.print(user.getUsername()); %>
                        </center>
                        </div>
                    </td>
                   <td>
                        firstname
                    </td>
                     <td>
                        lastname
                    </td>
                    <td>
                        Street number
                    </td>
                    <td>
                        Street
                    </td>
                    <td>
                        city
                    </td>
                    <td>
                        Zip code
                    </td>
                    <td>
                        country
                    </td>
                    <td>
                        Date of count create
                    </td>
                    
                    
                    </tr>
                     <tr>
                                    
                    <td>
                        <% out.print(user.getFirstname()); %>
                    </td>
                    <td>
                        <% out.print(user.getLastname()); %>
                    </td>
                    
                     <td>
                        <% out.print(user.getStreetNumber()); %>
                    </td>
                        
                     <td>
                        <% out.print(user.getStreet()); %>
                    </td>
                    <td>
                        <% out.print(user.getCity()); %>
                    </td>
                    <td>
                        <% out.print(user.getZipCode()); %>
                    </td>
                    <td>
                        <% out.print(user.getCountry()); %>
                    </td>
                    <td>
                        <% out.print(user.getCreateDate().getTime()); %>                        
                    </td>
                    
                </tr>
                    
            </table>            
        </div>
        <div id="tab2-position">
            <center>
            <table >
                <tr>
                    <td>
                        count of connection in the month
                    </td>
                    <td>
                        count all connection
                    </td>
                    <td>
                        count of search in the month
                    </td>
                    <td>
                        count all search
                    </td>
                </tr>
                <tr>
                    <td>
                        <% out.print(user.getCountMonthConnection()); %>
                    </td>
                    <td>
                        <% out.print(user.getCountConnection()); %>
                    </td>
                    <td>
                        <% out.print(user.getCountMonthSearch()); %>
                    </td>
                    <td>
                        <% out.print(user.getCountSearch()); %>
                    </td>
                </tr>
            </table>
            </center>
        </div>
<%@include file="../../view/tools/footPage.jspf" %> 