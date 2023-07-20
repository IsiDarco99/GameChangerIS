<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="cn.gamechanger.model.*"%>
<%@page import="cn.gamechanger.servlet.getAdminServlet" %>
<% Amministratore admin = (Amministratore) request.getAttribute("admin"); %>
<!DOCTYPE html>
<html>
<head>
<title>GameChanger</title>
<%@include file="includes/head.jsp"%>
<link rel="stylesheet" href="css/profilo.css" type="text/css">
</head>
<body>
<%@include file="includes/topbar.jsp"%>
<div class="scritta-principale">
<h1> <strong>Pagina Amministratore</strong></h1>
</div>

<div class="container">
<div class="row"> 
<div class="col-3">

<p class="username"> <strong></strong></p>
<div class="container-2">
<h5><strong>Modifica</strong></h5>

<a href="#" onclick="submitFormnomeAmm('${pageContext.request.contextPath}/Modifica-Admin')">Nome e Cognome<br></a>
<a href="#"> E-mail<br></a>
<a href="#"> Password<br></a>
</div>
</div>

<div class="col-9">
<div class="container-1">
<div class="scritta">
<h5><strong>Informazioni amministratore</strong></h5>
</div>
<p>Nome: ${admin.nome}</p>
<p>Cognome: ${admin.cognome}</p>
<p>E-mail: ${admin.email}</p>





</div>
<div class="container-1">
<div class="scritta">
<h5><strong>Operazioni amministratore</strong></h5>
<a href="operazioniamministratore.jsp?modifica=inserisci">  Aggiungi nuovo prodotto<br></a>
<a href="operazioniamministratore.jsp?modifica=modifica">  Modifica prodotto<br></a>
<p>Elimina prodotto</p>
<p>Visualizza prodotti</p>
<p>Visualizza ordini</p>
</div>


</div>



</div>
</div>




</div>

<%@include file="includes/footer.jsp"%>
<script src="js/user.js" type="text/javascript"></script>
</body>
</html>