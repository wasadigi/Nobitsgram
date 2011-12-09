<%--
    Document   : formAction
    Created on : 21 nov. 2011, 08:33:56
    Author     : Eyram
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Nobitsgram</title>

    </head>
    <body>

        <form action="/nobitsgram/sessionServlet" method="GET" accept-charset="utf-8">

            <jsp:useBean id="url" class ="java.lang.String"  scope="session" />
            <jsp:useBean id="username" class ="java.lang.String"  scope="session" />
            <% url =(String)request.getAttribute("url");%>
            <% username =(String)request.getSession().getAttribute("username");%>


        <h2 style="margin-left: 500px;"> Wellcome <% out.println(username); %> </h2>
       <div style="width: 400px;height:300px; margin: 0 auto;background:#0AA9FF">

           <img src= "<%out.print(url);%>" name ="image"
             style="width: 400px; height: 300px" >
       </div>
         <p>  <span style="margin-left:620px;">
                 <input type="submit" name ="action" value="Refresh" class="button"
                         style="border:1px solid #00CC00;
                         width:100px;
                         background-color:#00CC00;
                         height: 35px;font-size:18px;">
               </span>


          </p>
           <table style=" margin: 0 auto;width:900px;height: 60px;background: #DCDCDC">
               <td> <label name="Topic">Topic:</label>
              <input name="Topic" size="30" type="text"/>
              <input type="submit" name ="action" value="Add Topic" class="button"
                         style="border:1px solid #f6b22b;
                         background:#fbe26eE;width:100px;
                         background-color:#F7D92E;
                         height: 35px;font-size:18px;">
              </td>
              <td><label name="search" style="margin-left: 70px" >Search Topic:</label>
            <input name="searchTopic" size="30" type="text"/>
            <input type="submit" name ="action" value="Search" class="button"
                         style="border:1px solid #f6b22b;
                         background:#fbe26eE;width:100px;
                         background-color:#F7D92E;
                        height: 35px;font-size:18px;">
            </td>

          </table>

       </form>

    </body>
</html>
