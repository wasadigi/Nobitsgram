<%-- 
    Document   : newjsp
    Created on : 2 janv. 2012, 09:09:50
    Author     : Eyram
--%>

<!DOCTYPE html>
<html>                                                            
 <head>
 <title>Ma première page HTML - jQuery</title>
 
 <link rel="prev" href="/fr/javascript/jquery-guide-demarrage/comment-installer-jquery" />

<link rel="up" href="/fr/javascript/jquery-guide-demarrage/jquery-guide-demarrage" />

<link rel="next" href="/fr/javascript/jquery-guide-demarrage/jquery-core-coeur-jquery" />
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>                                            
 </head>                                                           
 <body>
	 <script type="text/javascript">                               
$(document).ready(function(){
   $("#demo1 a").click(function(){
        alert("Vous venez de cliquer sur "+ $(this).html());
        return false;
    });
 });                              
 </script>    
	<div id="demo1">                                                                 
		<div id="div1">
		<h1>Ma page HTML pour tester jQuery</h1>
		<p>Entete de ma page avec un <a href="#">lien 1</a></p>

		</div>
		<div id="div2">
		 <p>Contenu de ma page avec un <a href="#">lien 2</a></p>
		</div>
		<div id="div3">
		 <p>Pied de page avec un <a href="#">lien 3</a></p>
		</div>

	</div>               
 </body>                                                                 
 </html>