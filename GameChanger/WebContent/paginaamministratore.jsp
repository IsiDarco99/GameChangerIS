<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<a href="#"> Username<br></a>
<a href="#"> Password<br></a>
<a href="#"> Immagine Profilo<br></a>
<a href="#"> E-mail<br></a>
<a href="#"> E-mail Paypal<br></a>
<a href="#"> Num. Cellulare<br></a>
<a href="#"> Indirizzo di spedizione<br></a>
</div>
</div>

<div class="col-9">
<div class="container-1">
<div class="scritta">
<h5><strong>Informazioni amministratore</strong></h5>
</div>
<p>Nome: </p>
<p>Cognome: </p>
<p>Data di nascita: </p>
<p>Codice fiscale: </p>
<p>Indirizzo di spedizione: </p>
<a href="prodottiacquistati.jsp">Prodotti acquistati</a>





</div>
<div class="container-1">
<div class="scritta">
<h5><strong>Operazioni amministratore</strong></h5>
</div>
<p>Cellulare: </p>
<p>E-mail: </p>
<p>E-mail Paypal: </p>


</div>



</div>
</div>


















</div>










<%@include file="includes/footer.jsp"%>
</body>
</html>