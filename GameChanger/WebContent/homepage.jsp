<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>GameChanger</title>
<%@include file="includes/head.jsp"%>
<link rel="stylesheet" href="css/styles.css" type="text/css">
</head>
<body>
	<%@include file="includes/topbar.jsp"%>
	<%@include file="includes/navbar.jsp"%>

	<div class="background-div">

		<div class="image-slider">
			<div class="slider-controls">
				<img src="imgs/arrow.png" alt="Freccia su" height="15"
					style="transform: rotate(180deg)">
			</div>
			<div class="slider-dots">
				<div class="slider-dot"></div>
				<div class="slider-dot"></div>
				<div class="slider-dot"></div>
			</div>
			<div class="slider-controls">
				<img src="imgs/arrow.png" alt="Freccia giù" height="15">
			</div>
		</div>
	</div>
	<div class="d-flex justify-content-center neon">
		<p>da un'occhiata ai nostri</p>
	</div>
	<div class="d-flex justify-content-center neon" style="padding: 0 0 50px 0;">
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

	<p style="padding: 400px">Padding</p>
	<img src="imgs/homepage/carousel/sekiro.jpg" class="img-fluid">
	<p style="padding: 400px">Padding</p>
	<p style="padding: 400px">Padding</p>




	<%@include file="includes/footer.jsp"%>
</body>
</html>