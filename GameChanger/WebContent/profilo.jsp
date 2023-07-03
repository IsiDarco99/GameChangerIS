<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.google.protobuf.TextFormatParseInfoTree"%>
    <%@page import="cn.gamechanger.connection.DbCon"%>
    <%@page import="cn.gamechanger.model.dao.*"%>
    <%@page import="cn.gamechanger.model.*"%>
    <%@ page import="cn.gamechanger.servlet.profiloservlet" %>
    
    <% User user = (User) request.getAttribute("user"); %>
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
						alt="Profilo">

</div>

<p class="username"> <strong><%= user.getUsername() %></strong></p>
<div class="container-2">
<h5><strong>Modifica</strong></h5>

<a href="modifica.jsp?modifica=username"> Username<br></a>
<a href="modifica.jsp?modifica=password"> Password<br></a>
<a href="modifica.jsp?modifica=immagine"> Immagine Profilo<br></a>
<a href="modifica.jsp?modifica=mail"> E-mail<br></a>
<a href="modifica.jsp?modifica=paypal"> E-mail Paypal<br></a>
<a href="modifica.jsp?modifica=numero"> Num. Cellulare<br></a>
<a href="modifica.jsp?modifica=indirizzo"> Indirizzo di spedizione<br></a>
</div>
</div>

<div class="col-9">
<div class="container-1">
<div class="scritta">
<h5><strong>Informazioni di base</strong></h5>
</div>
<p>Nome: ${user.nome} </p>
<p>Cognome: ${user.cognome}</p>
<p>Data di nascita: ${user.dataNascita}</p>
<p>Codice fiscale: ${user.codFiscale}</p>
<p>Indirizzo di spedizione: ${user.stato}, ${user.citta}, ${user.indirizzo}, ${user.cod_postale}</p>
<a href="prodottiacquistati.jsp">Prodotti acquistati</a>





</div>
<div class="container-1">
<div class="scritta">
<h5><strong>Informazioni di contatto</strong></h5>
</div>
<p>Cellulare: ${user.numTel}</p>
<p>E-mail: ${user.emailPers}</p>
<p>E-mail Paypal: ${user.emailPaypal}</p>


</div>



</div>
</div>


















</div>










<%@include file="includes/footer.jsp"%>
</body>
</html>