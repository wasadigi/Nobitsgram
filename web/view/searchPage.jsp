<%--
    Document   : searchPage
    Created on : 9 déc. 2011, 05:19:53
    Author     : Eyram
--%>

<%@page import="java.util.List"%>
<%@include file="tools/headPage.jspf" %>

<br/>
<% root =request.getContextPath();%>
<form action="<% out.print(root+ "/sessionServlet"); %>" method="GET" accept-charset="utf-8">

    <jsp:useBean id="url" class ="java.lang.String"  scope="session" />
    <jsp:useBean id="username" class ="java.lang.String"  scope="session" />
    <% List<String> urlList =(List<String>)request.getAttribute("urlList");
       int size = urlList.size();%>
    <% username =(String)request.getSession().getAttribute("username");%>

    <table style="margin-left:25%;top:25%" >
        <tr>
            <% for(int i = 0; i < 3; i++) {%>
            <td>
                <img src="<%out.print(urlList.get(i));%>" style="width: 200px;height:150px;" />

            </td>
            <% }%>
        </tr>
    </table>
</form>
<br/>

<%@include file="tools/footPage.jspf" %>

