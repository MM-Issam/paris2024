<%-- 
    Document   : consulterSport
    Created on : 11 sept. 2024, 09:01:35
    Author     : SIO2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sio.paris2024.model.Sport"%>
<%@page import="sio.paris2024.model.Epreuve"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PARIS 2024</title>
         <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
    </head>
    <body>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PARIS 2024</title>
        <style>
            body {
		padding-top: 50px;
            }
                .special {
		padding-top:50px;
	}
        </style>
    </head>
    <body>
      
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a  href ='../ServletSport/lister' class="navbar-brand" href=".">Listes des sports</a>
			</div>
		</div>
	</nav>
        <%
            Sport s = (Sport) request.getAttribute("pSport");
        %>
        <div class="container special">
            <h2 class="h2">Liste des participants en <% out.println(s.getNom()); %></h2>
	<div class="table-responsive">
            <table class="table table-striped table-sm">  
                <thead>
                    <tr>             
                        <th>id</th>
                        <th>nom</th>              
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <%
                        if (s != null && s.getLesEpreuves() != null) {
                            for (Epreuve a : s.getLesEpreuves()) {
                                out.println("<tr><td>");
                                out.println(a.getId());
                                out.println("</td>");

                                out.println("<td>");
                                out.println(a.getNom());
                                out.println("</a></td>");;      
                           
                        }} else {
                            out.println("Aucun athlète trouvé");
                        }
                    %>
                    </tr>
                </tbody>
            </table>
        </body>
         </div>
       </div>
  
</html>
