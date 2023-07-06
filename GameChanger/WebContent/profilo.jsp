<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.google.protobuf.TextFormatParseInfoTree"%>
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
<%switch(user.getImmagine()){
case 1:%>
<img src="imgs/profilo/mario.png" alt="Immagine Profilo">
<%break;
case 2:%>
<img src="imgs/profilo/peach.jpg" alt="Immagine Profilo">
<%break;
case 3:%>
<img src="imgs/profilo/hunter.png" alt="Immagine Profilo">
<%break;
case 4:%>
<img src="imgs/profilo/godOfWar.jpg" alt="Immagine Profilo">
<%break;
case 5:%>
<img src="imgs/profilo/cody.jpg" alt="Immagine Profilo">
<%break;
case 6:%>
<img src="imgs/profilo/may.jpg" alt="Immagine Profilo">
<%break;
case 7:%>
<img src="imgs/profilo/link.jpg" alt="Immagine Profilo">
<%break;
case 8:%>
<img src="imgs/profilo/zoro.jpg" alt="Immagine Profilo">
<%break;
}System.out.println(user.getImmagine()); %>

</div>

<p class="username"> <strong><%= user.getUsername() %></strong></p>
<div class="container-2">
<h5><strong>Modifica</strong></h5>

<a href="#" onclick="submitFormUsername('${pageContext.request.contextPath}/modifica-profilo', 'username')"> Username<br></a>
<a href="#" onclick="submitFormPassword('${pageContext.request.contextPath}/modifica-profilo')"> Password<br></a>
<a href="#" onclick="submitFormImg('${pageContext.request.contextPath}/modifica-profilo')"> Immagine Profilo<br></a>
<a href="#" onclick="submitFormEmail('${pageContext.request.contextPath}/modifica-profilo')"> E-mail<br></a>
<a href="#" onclick="submitFormEmailPaypal('${pageContext.request.contextPath}/modifica-profilo')"> E-mail PayPal<br></a>
<a href="#" onclick="submitFormNumero('${pageContext.request.contextPath}/modifica-profilo')"> Num. Cellulare<br></a>
<a href="#" onclick="submitFormIndirizzo('${pageContext.request.contextPath}/modifica-profilo')"> Indirizzo di spedizione<br></a>
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
<script src="js/user.js" type="text/javascript"></script>
</body>
</html>