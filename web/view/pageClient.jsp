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

        <form action="/nobitsgram/sessionServlet" method="POST" accept-charset="utf-8">

            <jsp:useBean id="url" class ="java.lang.String"  scope="session" />
            <jsp:useBean id="username" class ="java.lang.String"  scope="session" />
            <% url =(String)request.getAttribute("url");%>
            <% username =(String)request.getAttribute("username");%>


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
             <script>
                 $(function() {
if (location.hash) {
    var access_token = location.hash.split('=')[1];
    $.ajax({
        dataType: "jsonp",
        url: "https://api.instagram.com/v1/users/self/feed",
        data: {
            access_token: access_token
        },
        success: function(json) {
//          console.log(json);
            var htmls = [];
            for (var i = 0; i < json.data.length; i++) {
                htmls[htmls.length] = (function(data){
                var html = '\
                        <li class="item">\
                            <div class="userprofile">\
                                <img width="20" src="'+data.user.profile_picture+'"><span>'+data.user.username+'</span>\
                            </div>\
                            <div class="userimage">\
                                <a href="'+data.images.standard_resolution.url+'" target="_blank"><img src="'+data.images.thumbnail.url+'"></a>\
                                <div class="overimage">\
                                    ';
                                    if(data.caption != null){
                                        html += '<p>'+data.caption.text+'</p>';
                                    }
                                    html += '\
                                    <p>filter : '+data.filter+'</p>\
                                </div>\
                            </div>\
                        </li>\
                    ';
                    return html;
                })(json.data[i]);
            }
            $("#main ul").html(htmls.join(''));
        }
    });
} else {
    //http://instagram.com/developer/manage/
    var CLIENT_ID = '5e2a174a39804619840925781251b646'; //change here
    var CALLBACK_URL = 'http://localhost:8080/nobitsgram/sessionServlet'; // change here
    location.href="https://instagram.com/oauth/authorize/?display=touch&client_id="+CLIENT_ID+"&redirect_uri="+CALLBACK_URL+"&response_type=token";
}
});
             </script>
    </body>
</html>
