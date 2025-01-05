<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="cn.gamechanger.bean.*"%>
<%@page import="cn.gamechanger.servlet.GetAdminServlet" %>
<% Amministratore admin = (Amministratore) request.getAttribute("admin"); %>
<!DOCTYPE html>
<html lang="it">
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
<div class="col-12">
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
<a href="operazioniAmministratore.jsp?modifica=inserisci">Aggiungi nuovo prodotto<br></a>
<a href="operazioniAmministratore.jsp?modifica=modifica">Modifica prodotto<br></a>
<a href="operazioniAmministratore.jsp?modifica=elimina">Elimina prodotto<br></a>
<a href="${pageContext.request.contextPath}/mostra-tutti-prodotti?categoria=allProdotti">Visualizza tutti i prodotti<br></a>
<a href="${pageContext.request.contextPath}/visualizza-all-ordini">Visualizza tutti gli ordini<br></a>
<a href="operazioniAmministratore.jsp?modifica=ordiniData">Visualizza ordini per data<br></a>
<a href="operazioniAmministratore.jsp?modifica=ordiniUser">Visualizza ordini per utente<br></a>
</div>


</div>



</div>
</div>




</div>

<%@include file="includes/footer.jsp"%>
<script src="js/user.js" type="text/javascript"></script>
</body>
</html>