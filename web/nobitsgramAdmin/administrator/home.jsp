<%-- 
    Document   : home
    Created on : 29 déc. 2011, 20:26:56
    Author     : Eyram
--%>


<%@include file="../../view/tools/headPage.jspf" %>
<link rel="stylesheet" type="text/css" href="<% out.print(root+ "/css/adminHome_style.css"); %>" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
<div class="bar" id="positionbar">
    <%  int nberRow; 
        String tmp;        
        String errorBlock = (String)session.getAttribute("errorBlock");
        
        try{   
            tmp = request.getParameter("numberOfRow");           
            if(tmp == null || tmp ==""){
                tmp = "10";
            }                    
            nberRow = Integer.parseInt(tmp);


        }
        catch(NumberFormatException nfe){

            nberRow = 10;
        }      
     %>     
     <a href="<% out.print(root+ "/HomeServlet"); %>" class="selected">
         <img class="" src="<% out.print(root+"/images/usersSetting.jpg");%>" class ="posipicto" /><span id="myText">Users setting</span></a>
     
     
     <a href="<%out.print(root+ "/LogoutAdmin"); %>" id="">
                <img class="" src="<% out.print(root+"/images/adminLogout.jpg");%>" class ="posipicto" /><span id="myText">Logout</span></a>
   
    
   <div>         
        <form action="<% out.print(root+ "/nobitsgramAdmin/administrator/home.jsp"); %>">
             
        <table  id="contenerSelectUser" >          
         <tr> 
             <td>
                 <label>Number of users</label>
             </td>
            <td><select name="numberOfRow">

                            <hr/><option value="<% out.print(nberRow); %>"><% out.print(nberRow); %></option>
                           <% if(nberRow != 10) { %> 
                                <option value="10">10</option>
                           <% } %>
                                <option value="20">20</option>

                            <option value="30">30</option>

                            <option value="40">40</option>

                </select>
            </td>         
            <td> <input type="submit" style="border:1px solid #f6b22b;
                                        background:#fbe26eE;width:35px;
                                        background-color:#F7D92E;
                                        height: 20px;font-size:16px;" name="action" value="ok" />
            </td>
         </tr>
        </table>
         </form>
       </div>
    <form action="<% out.print(root+ "/SearchUserServlet"); %>" method="GET">
            <!-- Bare menu -->
            <div id="posearch">
                <table>
                    <tr>
                        <td>
                    <input type="text" name="topicSearchUser" value="" size="25">
                        </td>
                        <td>
                        <input type="image" src="<% out.print(root+"/images/searchUser.jpg");%>"
                           style="width: 40px; height: 40px;" name="Submit" value="find">
                        </td>
                </tr>
                </table>
            </div>
 </form>
</div>      
             <% 
                int leftLength;
                int rightLength;
                int step = 9;
                List<User> users = (List<User>)session.getAttribute("users");
                int nbUser = users.size();
                int indexPage = 1; 
                int limit;
                int begining;
                int nbPage;
               
                
                try{
                   tmp = request.getParameter("indexPage");                   
                    // If tmp is null, it seem that it is the first time this page
                    // is loading, then indexPage will be 1
                    if(tmp == null || tmp == ""){
                        tmp = "1";
                    }

                    // Here we asign tmp to indexPage
                    indexPage = Integer.parseInt(tmp);
                }
                catch(NumberFormatException nfe){
                    indexPage = 1;
                }

                
                nbPage = nbUser / nberRow;
                                                
                if(nbUser % nberRow != 0){
                    nbPage += 1;
                }
                
               if(request.getParameter("action") != null){
                    
                    if(request.getParameter("action").equals("first")){
                        indexPage = 1;
                    }

                    else if(request.getParameter("action").equals("previous")){
                        indexPage = indexPage - 1;
                    }
                    else if(request.getParameter("action").equals("next")){
                        indexPage += 1;
                    }
                    else if(request.getParameter("action").equals("last")){
                        indexPage = nbPage;
                    }

                }
                                                          
                
                begining = nberRow*(indexPage - 1);
                limit = indexPage*nberRow;
                if(limit > nbUser){
                    limit = nbUser;
                }
               
             %>
            
           <center>
          
            <div >
           <form action="<% out.print(root+ "/BlockUserServlet"); %>" method="GET" name="checkForm">
            <table border="2" id ="tableContener">
                <caption><h2>It were <% out.print(nbUser); %> users in nobitsgram</h2></caption>                
                <tr>
                    <td>
                        <h3>  username </h3>
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
                    <td>
                        <h3> picture </h3>
                    </td>
                    <td>
                        <h3> block user </h3>
                    </td>
                    <td>
                        <h3> Active user </h3>
                    </td>
                </tr>
            <%  for(int i = begining; i < limit; i++){
              %>
              <tr>
                  <td>
                      
                      <a href="<% out.print(root+ "/UserInfoServlet?username="+users.get(i).getUsername()); %>" >
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
                     <img src="<% out.print(users.get(i).getProfile_picture()); %>"
                           style="width: 35px; height: 35px;" />
                    
                  </td>
                  <td>
                     
                         
                      <% if(!users.get(i).isIsBlocked()){  %>
                          
                          
                          <input  type="checkbox" name="blockID"
                                value="<% out.print(i); %>" />                       
                       <% } else { %> 
                           <img  src="<% out.print(root+"/images/blockUser1.jpg");%>" 
                             style="width: 35px; height: 35px; margin-top: 5px;" />
                       <% } %>
                  </td>
                  <td>
                     
                     <%   
                      if(users.get(i).isIsBlocked()){ 
                          //url = root+"/images/activeAccount.jpg"; %>
                      
                          <input  type="checkbox" name="blockID"
                                value="<% out.print(i); %>" />                                             
                      <% } else { %>
                       <img  src="<% out.print(root+"/images/activeAccount.jpg");%>"
                              style="width: 35px; height: 35px; margin-top: 5px;" />
                       <% } %>  
                    
                  </td>
              </tr>
            <% } %>
            </table>
            <div>
                <input type="submit" style="border:1px solid #f6b22b;
                background:#fbe26eE;width:200px;
                background-color:#F7D92E;
                height: 35px;font-size:18px;" name="action" value="Submit"
                onclick="showMessage()"/>
                
            </div>                   
             </form>
            </div>
           </center>
            
            <br/>
            <br/>
            <center>
                
            <table  cellspacing="10">
                 <tr>
                     <% if(indexPage != 1) { %>
                    <td>                        
                        <a href="/nobitsgram/nobitsgramAdmin/administrator/home.jsp?action=first&indexPage=<% out.print(indexPage); %>&numberOfRow=<% out.print(nberRow); %>" style="text-decoration: none">                        
                            <img src="<% out.print(root+"/images/first_index.jpg");%>"/>
                        </a>                    
                    </td>
                    
                    <td>                        
                        <a href="/nobitsgram/nobitsgramAdmin/administrator/home.jsp?action=previous&indexPage=<% out.print(indexPage); %>&numberOfRow=<% out.print(nberRow); %>" style="text-decoration: none">                        
                            <img src="<% out.print(root+"/images/previous.jpg");%>"/>
                        </a>                    
                    </td>
                     <% } %>
                    <td>
                        <img src="<% out.print(root+"/images/logo.jpg");%>"  style="height: 40px;"/>
                    </td>
                    <% if(indexPage != nbPage && nbPage != 0) { %>
                        <td>
                            <a href="/nobitsgram/nobitsgramAdmin/administrator/home.jsp?action=next&indexPage=<% out.print(indexPage); %>&numberOfRow=<% out.print(nberRow); %>" style="text-decoration: none">
                                <img src="<% out.print(root+"/images/next.jpg");%>"/>
                            </a>
                        </td>
                        <td>
                           <a href="/nobitsgram/nobitsgramAdmin/administrator/home.jsp?action=last&indexPage=<% out.print(indexPage); %>&numberOfRow=<% out.print(nberRow); %>" style="text-decoration: none">
                                <img src="<% out.print(root+"/images/last_index.jpg");%>"/>
                            </a>
                        </td>
                    <% } %>
                </tr>    
            </table>
                
                
            <table cellspacing="10">
               
                <tr>
                    <% leftLength = indexPage - step;
                       if(leftLength < 1){
                           leftLength = 1;
                       }
                       
                       rightLength = indexPage + step;
                       
                       if(rightLength > nbPage){
                           rightLength = nbPage;
                       }
                       
                        
                    for(int i = leftLength; i <= rightLength; i++) { %>
                    <td style="text-align: center ">
                        <a href="/nobitsgram/nobitsgramAdmin/administrator/home.jsp?indexPage=<% out.print(i); %>&numberOfRow=<% out.print(nberRow); %>" 
                           style="text-decoration: none">
                        <% if(i == indexPage) { %>
                        <b style="color: black"> <% out.print(i); %></b>
                       <% } else { %>
                            <% out.print(i); %> 
                       <% } %>
                        </a>
                    </td>
                    <% } %>
                </tr>
            </table>           
</center>
<script language="javascript">
        function showMessage(){
            
          <% if(errorBlock != null){ %>              
               alert("You don't select any user to block!");
               
         <% 
              session.removeAttribute("errorBlock"); 
         } %>
            
         }
</script>


<%@include file="../../view/tools/footPage.jspf" %> 