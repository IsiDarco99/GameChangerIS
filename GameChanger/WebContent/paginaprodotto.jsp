<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="IT">
<head>
<meta charset="ISO-8859-1">
<title>GameChanger</title>
<%@ include file="includes/head.jsp" %>
<link rel="stylesheet" href="css/paginaprodotto.css" type="text/css">
</head>
<body>
<%@ include file="includes/topbar.jsp" %>
<%@ include file="includes/navbar.jsp" %>
 <div class="nome-prodotto">
        <h1>
        <span> One Piece Pirate Warriors 4
        </span>
        </h1>
        <p>
        by
        <strong>Bandai Namco Corporation</strong>
            <span>PS4</span>
         </p>
        </div>

<div class="container">

<div class="row">
<div class="col-6 box">
<div class="arrow_prev"><img src="imgs/generale/arrow.png" alt="Freccia giù" height="25"></div>
<div class="arrow_next"><img src="imgs/generale/arrow.png" alt="Freccia giù" height="25"></div>
<div class="carosello">
<img src="imgs/paginaprodotto/Onepiece.jpg"
						alt="Brawhalla">
						
<img src="imgs/homepage/secondo-carosello/computer.jpg"
						alt="Computer">
</div>

</div>

<div class="col-1"></div>
<div class="col-5">
<div class="informazioni">
<div class="prezzo">
<p> Prezzo </p>
</div>
<div class="numero">
<p> 20.99$ </p>
</div>

<div class="descrizione">
<p>
<label class="dettagli"> Dettagli 

spedizione </label>
<span> 
<em> Spedizione gratuita </em>
</span>
</p>
<p>
<label> Genere</label>
<span>Action</span>
</p>
<p>
<label> Rilascio</label>
<span> 27/03/2020</span>
</p>
<p>
<label> PEGI</label>
<span> 12+</span>
</p>
<button class="carrello">
    <span> Aggiungi al carrello</span>
</button>
</div>
</div>

</div>


</div>
<div class="descrizione-prodotto">
<h2 class= "scritta-principale">
<a> Descrizione </a>
</h2>
<div class="descrizione-2">
<div class="testo">
<p>I pirati sono tornati e portano con sé una storia più esplosiva, più ambienti di gioco, e attacchi ancora più pazzeschi in ONE PIECE: PIRATE WARRIOS 4. Segui Rufy e i pirati di Cappello di paglia sin dall'inizio, nel loro viaggio attraverso una moltitudine di isole per trovare il famoso tesoro: lo One Piece. Gioca su alcune delle isole e degli ambienti più straordinari della storia di ONE PIECE e sfida nemici memorabili.
Scegli tra alcuni dei tuoi personaggi preferiti e affronta un gran numero di nemici ripercorrendo i momenti iconici dell'anime di One Piece. Sviluppato dai maestri del genere d'azione musou, KOEI TECMO GAMES, ONE PIECE Pirate Warriors 4 unisce l'emozione di spazzare via orde di nemici con le divertenti ed energetiche personalità della serie One Piece. Salpa per una nuova avventura piratesca 
</p>


</div>



</div>


</div>
<div class="scritta-prodotti">
<h3> Prodotti Consigliati</h3> 
</div>
<div class="container-consigliati">
		<div class="arrow_prev2">
			<img src="imgs/generale/arrow.png" alt="Freccia giù" height="25">
		</div>
		<div class="arrow_next2">
			<img src="imgs/generale/arrow.png" alt="Freccia giù" height="25">
		</div>
		<div class="row nuove-uscite">
		
			<div class="col-md-12">
				<div class="content2">
					<a href="#"><img
						src="imgs/homepage/secondo-carosello/brawhalla.jpg"
						alt="Brawhalla"></a>
				</div>
			</div>
			<div class="col-md-12">
				<div class="content2">
					<img src="imgs/homepage/secondo-carosello/computer.jpg"
						alt="Computer">
				</div>
			</div>
			<div class="col-md-12">
				<div class="content2">
					<img src="imgs/homepage/secondo-carosello/gowr.jpeg"
						alt="God Of War: Ragnarok">
				</div>
			</div>
			<div class="col-md-12">
				<div class="content2">
					<img src="imgs/homepage/secondo-carosello/nuka-cola.jpg"
						alt="Nuka Cola">
				</div>
			</div>
			<div class="col-md-12">
				<div class="content2">
					<img src="imgs/homepage/secondo-carosello/ps5.jpg" alt="PS5">
				</div>
			</div>
			<div class="col-md-12">
				<div class="content2">
					<img src="imgs/homepage/secondo-carosello/rocket-league.jpg"
						alt="Rocket League">
				</div>
			</div>

		</div>

		
	</div>













</div>
<%@ include file="includes/footer.jsp" %>
<script type="text/javascript">
		$(document).ready(function() {
			$('.carosello').slick({
				  dots: true,
				  infinite: true,
				  speed: 500,
				  fade: true,
				  cssEase: 'linear',
				  prevArrow: '.arrow_prev',
				  nextArrow: '.arrow_next'
				});
		});
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.nuove-uscite').slick({
				dots : true,
				infinite : true,
				slidesToShow : 5,
				slidesToScroll : 1,
				autoplay : true,
				autoplaySpeed : 2000,
				prevArrow : '.arrow_prev2',
				nextArrow : '.arrow_next2'
			});
		});
	</script>
</body>
</html>
