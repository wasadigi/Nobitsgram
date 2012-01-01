<%-- 
    Document   : administrator
    Created on : 29 déc. 2011, 15:12:04
    Author     : Eyram
--%>

<%@include file="../../view/tools/headPage.jspf" %>
<link rel="stylesheet" type="text/css" href="<% out.print(root+ "/css/administrator_style.css"); %>" />


<center>
    
    <form action="/nobitsgram/LoginAdminServlet" method="POST" accept-charset="utf-8">
<fieldset id="fieldContener">
   

    <Legend id="legendContener">Adminitrator login</Legend>  
     <% String error = (String)session.getAttribute("error"); 
        if(error != null){
    %>

    
    <font style="color: red; background-color: #C1CDC1;"> <b> <% out.print(error); %></b> </font>

    
    <% } %>
    <div class="login-form">        
        <p id="position-login-form">
            <p><label>Administrator</label><br/>
                    <input type="text" name="username"/>
            </p>
            
       
        
        
            <p><label>Password</label><br/>
                <input type="password" name="password"/>
            </p>
        </p>
    </div>
    <div>
        <table>
            <tr>
                <td>
                    <img src="<%out.print(root+"/images/padlock6.jpg");%>" id="positionPicture"/>
                <td>
                <td style="margin-top: 50px;">
                    <br/>
                    <input type="submit" value="Log in" class="button" 
                     style="border:1px solid #f6b22b;backgrond:#fbe26eE;
                     width:100px;background-color:#F7D92E;
                     height: 35px;font-size:18px;  margin-left: 100px;"> </input>
                </td>
        </tr>
        
        </table>
        
    </div>
     

</fieldset>
</center>

<%@include file="../../view/tools/footPage.jspf" %> 
