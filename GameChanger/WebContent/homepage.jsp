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
			<img src="imgs/logo.png" alt="Logo" height="60">
		</div>
		<div class="account-settings">
			<img src="imgs/account.png" alt="Account" height="40"> <img
				src="imgs/settings.png" alt="Impostazioni" height="40">
		</div>
	</div>
		<div class="background-div">
			<div class="navbar">
				<ul>
					<li><a href="#"><img src="imgs/search.png" alt="search"
							height="40"></a></li>
					<li><a href="#"><img src="imgs/computer.png"
							alt="computer" height="40"></a></li>
					<li><a href="#"><img src="imgs/console.png" alt="console"
							height="40"></a></li>
					<li><a href="#"><img src="imgs/videogame.png"
							alt="videogame" height="40"></a></li>
					<li style="margin: 0px 10px 0px;"><a href="#"><img
							src="imgs/gadget.png" alt="gadget" height="40"></a></li>
				</ul>
			</div>
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






	<%@include file="includes/footer.jsp"%>
</body>
</html>