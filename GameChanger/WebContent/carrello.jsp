<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>GameChanger</title>
<%@ include file="includes/head.jsp" %>
<link rel="stylesheet" href="css/carrello.css" type="text/css">
<script src="js/carrello.js"> </script>
</head>
<body>
<%@ include file="includes/topbar.jsp" %>

<div class="scritta-principale">
<h1>
        <span>  Carrello 
        </span>
        </h1>
</div>

<div class="container">
<div class="carrello">


<!--  
<div class="immagine-carrello">
<img src="imgs/carrello/carrellovuoto1.png" alt="Carrello vuoto">

</div>
<div class="scritta-carrello">
<h1>
        <span> Il tuo carrello è vuoto<br>Da un'occhiata ai nostri prodotti  
        </span>
        </h1>
</div>
 
 -->
 <div class="container-prodotto">
 
  
 <div class="immagine">
 <img src="imgs/paginaprodotto/Onepiece.png" alt="Carrello vuoto">
 </div>
 <div class="nome-prodotto">
 <h1>
        <span> One Piece Pirate Warriors 4 
        </span>
        </h1>
        <div class="quantity">
 <input type="text" name="quantity" id="quantity" value="1">
  <button onclick="decreaseQuantity()">-</button>
  <button onclick="increaseQuantity()">+</button>
 </div>
 </div>
 
 <div class="prezzo">
 
 <p> <strong>Prezzo</strong><br>20.99$ </p>
 </div>
</div>
<div class="container-totale">
 
  
 
 <div class="prezzo">
 
 <p> <strong>Totale</strong><br>20.99$ </p>
 </div>
</div>

</div>

</div>









</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>