<%--
    Document   : session
    Created on : 17 nov. 2011, 13:11:15
    Author     : Eyram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>session nobitsgr.am</title>
    </head>
    <body style="background-color:#DAEADB;">

        <div id="wrap" class="grid-all group" >

<div style="width: 350px; margin: 0 auto;">

    <form action="/nobitsgr.am/config/checkLogin.jsp" method="POST" accept-charset="utf-8" class="table-style">
        </br></br></br><h1 style="width:350px; margin:0em auto;background-color:#022F47;color:#F9FBFF"><span style="margin-left:130px;">Log in</span></h1>
        <table style="width:350px;padding:2em;background-color:#0AA9FF">
            <td colspan="2"><h4 style="color:#BF0B0B">Incorrect Login and/or Password</h4></td>
            <tr><th><label for="id_username">Username:</label></th><td><input autocapitalize="off" autocorrect="off" type="text" name="username" id="id_username" /></td></tr>
<tr><th> <br/><label for="id_password">Password:</label></th><td><br/><input autocapitalize="off" autocorrect="off" type="password" name="password" id="id_password" /></td></tr>
        </table>

        <p><span style="margin-left:140px;"><input type="submit" value="Log in" class="button" style="border:1px solid #f6b22b;background:#fbe26eE;width:100px;background-color:#F7D92E;height: 35px;font-size:18px ">
            </span></p>
        <p><h4>Do you have already an acount? <a href="/nobitsgram/view/registration.jsp" style="margin-left:150px;">Create on here!</h4> </a>
        </form>

</div>

    </div>

    </body>
</html>
