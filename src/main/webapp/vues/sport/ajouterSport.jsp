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
        <title>paris 2024</title>
    </head>
    <body>
        <h1>NOUVEAU SPORT</h1>
        
            <%
                FormSport form = (FormSport)request.getAttribute("form");
            %>
        
        <form class="form-inline" action="ajouter" method="POST">
                <label for="nom">NOM : </label>
                <input id="nom" type="text" name="nom"  size="30" maxlength="30">         
                </br>              
            <input type="submit" name="valider" id="valider" value="Valider"/>
            </form>
        
        
    </body>
</html>
