<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.google.protobuf.TextFormatParseInfoTree"%>
    <%@page import="cn.gamechanger.connection.DbCon"%>
    <%@page import="cn.gamechanger.model.dao.*"%>
    <%@page import="cn.gamechanger.model.*"%>
    <%@page import="java.util.List"%>
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
<h1> <strong>Profilo</strong></h1>
</div>

<div class="container">
<div class="row"> 
<div class="col-3">
<div class="immagine-profilo"> 
<img src="imgs/generale/account.png"
						alt="Brawhalla">

</div>
<p class="username"> <strong><%= user.getNome() %></strong></p>
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
<h5><strong>Informazioni di base</strong></h5>
</div>
<p>Nome:${user.nome} </p>
<p>Cognome:${user.cognome}</p>
<p>Data di nascita:${user.dataNascita}</p>
<p>Codice fiscale:${user.codFiscale}</p>
<p>Indirizzo di spedizione:${user.indirizzo}</p>
<a href="#">Prodotti acquistati</a>





</div>
<div class="container-1">
<div class="scritta">
<h5><strong>Informazioni di contatto</strong></h5>
</div>
<p>Cellulare:${user.numTel}</p>
<p>E-mail:${user.emailPers}</p>
<p>E-mail Paypal:${user.emailPaypal}</p>


</div>



</div>
</div>


















</div>










<%@include file="includes/footer.jsp"%>
</body>
</html>