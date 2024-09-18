<%-- 
    Document   : ajouterSport
    Created on : 11 sept. 2024, 10:27:51
    Author     : SIO2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sio.paris2024.model.Sport"%>
<%@page import="sio.paris2024.form.FormSport"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PARIS 2024</title>
        <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
        
        <title>Paris 2024</title>

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
				<a  href ='../ServletSport/listerSport' class="navbar-brand" href=".">Système de gestion des athlètes</a>
			</div>
		</div>
	</nav>
         <div class="container special">
		<div class="table-responsive">
                <%
                    ArrayList<Sport> lesSports = (ArrayList)request.getAttribute("pLesSports");
                %>
                <table class="table table-striped table-sm">  
        <h1>NOUVEAU SPORT</h1>
        
            <%
                FormSport form = (FormSport)request.getAttribute("form");
            %>
        
        <form class="form-inline" action="ajouter" method="POST">
                <label for="nom">NOM : </label>
                <input id="nom" type="text" name="nom"  size="30" maxlength="30" style="margin-left:10px;">         
                </br>      
                </br>
            <input type="submit" name="valider" id="valider" value="Valider"/>
            </form>
        
        
    </body>
</html>
