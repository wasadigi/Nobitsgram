<%--
    Document   : formAction
    Created on : 21 nov. 2011, 08:33:56
    Author     : Eyram
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <% String username = request.getParameter("username"); %>
        <title><% out.println(username+" - "); %>Nobitsgram</title>
    </head>
    <body>
        <form action="/nobitsgram/SessionServlet" method="POST" accept-charset="utf-8">
        <% String url = "http://images.instagram.com/profiles/profile_13263821_75sq_1321367990.jpg"; %>
        <h2 style="margin-left: 500px;"> Bonjour <% out.println(username); %> </h2>
       <div style="width: 400px;height:300px; margin: 0 auto;background:#0AA9FF">

        <img src="http://images.instagram.com/profiles/profile_13263821_75sq_1321367990.jpg"
             style="width: 400px; height: 300px" >

       </div>
         <p>  <span style="margin-left:467px;">
                 <input type="submit" value="Refresh" class="button"
                        style="border:1px solid #f6b22b;
                        background:#fbe26eE;width:100px;
                        background-color:#F7D92E;
                        height: 35px;font-size:18px;">
              </span>


         </p>
          <table style=" margin: 0 auto;width:400px;height: 60px;background: #DCDCDC">
              <td> <label name="Topic">Topic:</label>
             <input name="Topic" size="30" type="text"/>
             <input type="submit" value="Add Topic" class="button"
                        style="border:1px solid #f6b22b;
                        background:#fbe26eE;width:100px;
                        background-color:#F7D92E;
                        height: 35px;font-size:18px;">
              </td>
         </table>
        </form>
    </body>
</html>
