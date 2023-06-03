<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GameChanger</title>
<%@ include file="includes/head.jsp" %>
<link rel="stylesheet" href="css/paginaprodotto.css" type="text/css">
</head>
<body>
<%@ include file="includes/topbar.jsp" %>
<%@ include file="includes/navbar.jsp" %>
<div class="container">
    <div class="nome-prodotto">
        <h1>
        <span> Nome Gioco Casuale
        </span>
        </h1>
        <p>
        by
        <strong>Bandai Isidoro Corporation</strong>
            <span>PS4</span>
         </p>
        </div>
    
    <div class="carosello">
     <div class="container-carosello">
    <div class="immagine-carosello">
      <img src="imgs//paginaprodotto/Onepiece.jpg" alt="immagine1">
   <div class="carousel-prev">&#8249;</div>
  <div class="carousel-next">&#8250;</div>
    </div>
    <div class="immagine-carosello">
      <img src="imgs/gadget.png" alt="immagine2">
   <div class="carousel-prev">&#8249;</div>
  <div class="carousel-next">&#8250;</div>
    </div>
    <div class="immagine-carosello">
      <img src="imgs/computer.png" alt="immagine3">
  <div class="carousel-prev">&#8249;</div>
  <div class="carousel-next">&#8250;</div>
    </div>
  </div>
    <div class="compra-prodotto">
         <div class="nome-prezzo">
         <p> Prezzo </p>
         <div class="blocco-prezzo">
         <span> 20,98$</span></div>
         </div>
        <button class="bottone-compra">
  <span></span>
  <span></span>
  <span></span>
  <span></span> Compra!
</button>
<span></span>
<button class="bottone-carrello">
  <span></span>
  <span></span>
  <span></span>
  <span></span> Aggiungi al carrello!
</button>
    </div>
 
  
</div>
    
    <div class="descrizione-prodotto">
    
    </div>

</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {
    var containerCarosello = $('.container-carosello');
    var immagineCarosello = $('.immagine-carosello');
    var grandezzaCarosello = immagineCarosello.length;
    var larghezzaElemento = immagineCarosello.outerWidth(true);
    var margineSinistro = parseInt(immagineCarosello.css('margin-left'));
    var margineDestro = parseInt(immagineCarosello.css('margin-right'));
    var spazioTotale = (larghezzaElemento + margineSinistro + margineDestro) * grandezzaCarosello;

    containerCarosello.width(spazioTotale);

    function slideLeft() {
        containerCarosello.animate({ 'left': -(larghezzaElemento + margineSinistro + margineDestro) }, 500, function() {
            containerCarosello.css('left', 0);
            containerCarosello.append(containerCarosello.children().first());
        });
    }

    function slideRight() {
        containerCarosello.prepend(containerCarosello.children().last());
        containerCarosello.css('left', -(larghezzaElemento + margineSinistro + margineDestro));
        containerCarosello.animate({ 'left': 0 }, 500, function() {
            containerCarosello.css('left', '');
        });
    }

    $('.carousel-prev').click(function() {
        slideLeft();
    });

    $('.carousel-next').click(function() {
        slideRight();
    });
});
</script>

<%@ include file="includes/footer.jsp" %>
</body>
</html>
