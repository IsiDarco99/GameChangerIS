<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="IT">
<head>

	<!-- aggiungo codice javascript per controllare funzionamento navbar!-->
	<script type="text/javascript" src="
	http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script type="text/jsx" src="js/navbar.js"></script>

<!--                          -------								 -->
	<title>GameChanger</title>
	<%@include file="includes/head.jsp"%>
	<link rel="stylesheet" href="css/styles.css" type="text/css">

</head>
<body>
	<%@include file="includes/topbar.jsp"%>
	<%@include file="includes/navbar.jsp"%>


	<div class="container-home">
		<div class="arrow_prev1">
			<img src="imgs/generale/arrow.png" alt="Freccia gi�" height="25">
		</div>
		<div class="arrow_next1">
			<img src="imgs/generale/arrow.png" alt="Freccia gi�" height="25">
		</div>
		
		<div class="row carosello-home">
			<div class="gradient">
			<div class="col-md-12">
				<img src="imgs/homepage/primo-carosello/sekiro.jpg" alt="Brawhalla">
			</div>
			</div>
			<div class="gradient">
			<div class="col-md-12">
				<img src="imgs/homepage/primo-carosello/fallout.jpg" alt="Computer">
			</div>
			</div>

			
		</div>
	</div>


	<div class="d-flex justify-content-center neon">
		<p>da un'occhiata ai nostri</p>
	</div>
	<div class="d-flex justify-content-center neon"
		style="padding: 0 0 50px 0;">
		<h1 style="padding: 0;">
			<span class="B">B</span>est<span class="S">s</span>e<span class="L">l</span>le<span
				class="R">r</span>
		</h1>
	</div>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-3">
				<div class="border-img">
					<img class="card-img" src="imgs/homepage/prima_vetrina/fallout.jpg"
						alt="prima_offerta">
					<div class="overlay">
						<div class="content">
							<h1>Scoprilo subito</h1>
						</div>
					</div>
				</div>
			</div>
			<div class="col-1"></div>
			<div class="col-3">
				<div class="border-img">
					<img class="card-img" src="imgs/homepage/prima_vetrina/rdr2.jpg"
						alt="prima_offerta">
					<div class="overlay">
						<div class="content">
							<h1>Scoprilo subito</h1>
						</div>
					</div>
				</div>
			</div>
			<div class="col-1"></div>
			<div class="col-3">
				<div class="border-img">
					<img class="card-img"
						src="imgs/homepage/prima_vetrina/outer_worlds.jpg"
						alt="prima_offerta">
					<div class="overlay">
						<div class="content">
							<h1>Scoprilo subito</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="nuove-usc-testo">
		<div class="title-wrapper">
			<h1 class="sweet-title">
				<span data-text="Nuove">Nuove</span> <span data-text="Uscite">Uscite</span>
			</h1>
			<span class="top-title">Scopri le nostre</span>
		</div>
	</div>
	<div class="container">
		<div class="arrow_prev2">
			<img src="imgs/generale/arrow.png" alt="Freccia gi�" height="25">
		</div>
		<div class="arrow_next2">
			<img src="imgs/generale/arrow.png" alt="Freccia gi�" height="25">
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
	<div class="container box" style="margin-top: 100px;">
		<div class="row">
			<div class="col-5 video-info">
				<span class="head">IN ARRIVO</span>
				<p>Neva segue la storia di Alba, una giovane donna legata a un
					curioso cucciolo di lupo, a seguito di un incontro traumatico con
					le forze oscure. Insieme intraprendono un pericoloso viaggio
					attraverso un mondo un tempo meraviglioso, ma che ora cade
					lentamente a pezzi. Nel tempo, il loro rapporto si evolve man mano
					che imparano a collaborare, aiutandosi l'un l'altra per superare
					coraggiosamente situazioni sempre pi� pericolose. Il lupo passer�
					dall'essere un cucciolo ribelle a un adulto imponente in cerca
					della sua identit�, mettendo alla prova l'affetto di Alba e il loro
					impegno reciproco.</p>
			</div>
			<div class="col-7 video-container">
				<iframe width="560" height="315"
					src="https://www.youtube.com/embed/q7qpQuCNgQo"
					title="YouTube video player"></iframe>
			</div>

		</div>
	</div>

	<%@include file="includes/footer.jsp"%>

	<script type="text/javascript">
		$(document).ready(function() {
			$('.nuove-uscite').slick({
				dots : true,
				infinite : true,
				slidesToShow : 3,
				slidesToScroll : 1,
				autoplay : true,
				autoplaySpeed : 2000,
				prevArrow : '.arrow_prev2',
				nextArrow : '.arrow_next2'
			});
		});
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.carosello-home').slick({
				dots : true,
				infinite : true,
				slidesToShow : 1,
				slidesToScroll : 1,
				autoplay : true,
				autoplaySpeed : 5000,
				prevArrow : '.arrow_prev1',
				nextArrow : '.arrow_next1'
			});
		});
	</script>


</body>
</html>