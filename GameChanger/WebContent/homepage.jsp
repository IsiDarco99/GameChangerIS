<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>GameChanger</title>
<%@include file="includes/head.jsp"%>
</head>
<body>
	<div class="top-bar">
		<div class="logo">
			<!-- Inserisci qui il tuo logo -->
			<img src="imgs/logo.png" alt="Logo" height="60">
		</div>
		<div class="account-settings">
			<!-- Inserisci qui le icone per l'account e le impostazioni -->
			<img src="imgs/account.png" alt="Account" height="40"> <img
				src="imgs/settings.png" alt="Impostazioni" height="40">
		</div>
	</div>
	<div class="navbar">
		<ul>
			<li><a href="#">Home</a></li>
			<li><a href="#">Catalogo</a></li>
			<li><a href="#">Promozioni</a></li>
			<li><a href="#">Carrello</a></li>
			<li><a href="#">Contatti</a></li>
		</ul>
	</div>

	<div class="image-slider">
		<div class="slider-controls">
			<img src="imgs/arrow-up.png" alt="Freccia sinistra" height="25">
			<img src="imgs/arrow-down.png" alt="Freccia destra" height="25">
		</div>
		<div class="slider-dots">
			<div class="slider-dot"></div>
			<div class="slider-dot"></div>
			<div class="slider-dot"></div>
		</div>
	</div> 








	<%@include file="includes/footer.jsp"%>
</body>
</html>