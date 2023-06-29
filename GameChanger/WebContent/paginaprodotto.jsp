<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="cn.gamechanger.connection.DbCon"%>
<%@page import="cn.gamechanger.model.dao.*"%>
<%@page import="cn.gamechanger.model.*"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="cn.gamechanger.servlet.MostraProdottoSingoloServlet" %>
<%@page import="java.util.List"%>
<%
String categoria = (String) request.getAttribute("categoria");
Videogame v = null;
Computer cm = null;
Accessorio a = null;
Console cs = null;

if (categoria.equals("videogame")){
	v = (Videogame) request.getAttribute("prodotto");
} else if (categoria.equals("computer")){
	cm = (Computer) request.getAttribute("prodotto");
} else if (categoria.equals("accessorio")){
	a = (Accessorio) request.getAttribute("prodotto");
} else if (categoria.equals("console")){
	cs = (Console) request.getAttribute("prodotto");
} 
%>

<!DOCTYPE html>
<html lang="IT">
<head>
<title>GameChanger</title>
<%@ include file="includes/head.jsp"%>
<link rel="stylesheet" href="css/paginaprodotto.css" type="text/css">


<script>

	function validateInput(event) {
	  var input = event.target;
	  var value = input.value;

	  // Rimuovi i caratteri non numerici
	  var filteredValue = value.replace(/[^0-9]/g, '');

	  // Limita il valore massimo a 99
	  if (filteredValue > 99) {
	    filteredValue = 99;
	  }

	  // Imposta il valore filtrato nell'input
	  input.value = filteredValue;
	}

	// Aggiungi un listener per l'evento "input" all'input della quantità
	var quantityInput = document.getElementById("quantity");
	quantityInput.addEventListener("input", validateInput);

</script>
</head>
<body>
	<%@ include file="includes/topbar.jsp"%>
	<%@ include file="includes/navbar.jsp"%>
	
	
	<!-- VIDEOGIOCHI -->
	
	
	<% if (v != null) { %>
	<div class="nome-prodotto">
		<h1>
			<span> <%=v.getNome()%>
			</span>
		</h1>
		<p>
			by <strong><%=v.getSviluppatore()%></strong>
			<span></span>
		</p>
	</div>

	<div class="container">

		<div class="row">
			<div class="col-6 box">
				<div class="arrow_prev">
					<img src="imgs/generale/arrow.png" alt="Freccia giù" height="25">
				</div>
				<div class="arrow_next">
					<img src="imgs/generale/arrow.png" alt="Freccia giù" height="25">
				</div>
				<div class="carosello">
					<img src="imgs/prodotti/<%=v.getNome()%> 1.jpg" alt="<%=v.getNome()%>"> <img
						src="imgs/prodotti/<%=v.getNome()%> 2.jpg" alt="<%=v.getNome()%>"> <img
						src="imgs/prodotti/<%=v.getNome()%> 3.jpg" alt="<%=v.getNome()%>">
				</div>

			</div>

			<div class="col-1"></div>
			<div class="col-5">
				<div class="informazioni">
					<p>
						<label class="dettagli"> PEGI </label> <span> <em> <%=v.getPegi()%>
						</em>
						</span>
					</p>
					<p>
						<label> Genere</label> <span><%=v.getGenere()%></span>
					</p>
					<p>
						<label> Rilascio</label> <span> <%=v.getDataUscita()%></span>
					</p>
					<div class="scritta-spedizione">
						<p>
							<label> Dettagli spedizione</label> <span> Spedizione
								gratuita</span>
						</p>
					</div>
					<div class="prezzo">
						<div class="numero">
							<p>
								<%=v.getPrezzo()%>
								&#x20AC
							</p>
						</div>
						<form action="aggiungi-prodotto" method="post">
							<div class="bottoni">
								<input type="hidden" name="codice" value="<%=v.getCodice()%>">
								<button class="carrello">
									<span>Aggiungi al <br> carrello
									</span>
								</button>
								<div class="quantity">
									<button type="button" onclick="decreaseQuantity()">-</button>
									<input type="text" oninput="validateInput(event)" pattern="[1-9][0-9]{0,3}" maxlength="2" name="quantity" id="quantity" value="1">
									<button type="button" onclick="increaseQuantity()">+</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="descrizione-prodotto">
				<h2 class="scritta-principale">
					<a> Descrizione </a>
				</h2>
				<div class="descrizione-2">
					<div class="testo">
						<p><%=v.getDescrizione()%></p>
					</div>
				</div>
			</div>
			<div class="scritta-prodotti">
				<h3>Prodotti Consigliati</h3>
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
	</div>
	
	
	<!-- COMPUTER -->
	
	
	
	<%} else if (cm != null) { %>
	<div class="nome-prodotto">
	<h1>
		<span> <%=cm.getNome()%>
		</span>
	</h1>
	<p>
		by <strong><%=cm.getMarca()%></strong>
		<span></span>
	</p>
</div>

<div class="container">

	<div class="row">
		<div class="col-6 box">
			<div class="arrow_prev">
				<img src="imgs/generale/arrow.png" alt="Freccia giù" height="25">
			</div>
			<div class="arrow_next">
				<img src="imgs/generale/arrow.png" alt="Freccia giù" height="25">
			</div>
			<div class="carosello">
				<img src="imgs/prodotti/<%=cm.getNome()%> 1.jpg" alt="<%=cm.getNome()%>"> <img
					src="imgs/prodotti/<%=cm.getNome()%> 2.jpg" alt="<%=cm.getNome()%>"> <img
					src="imgs/prodotti/<%=cm.getNome()%> 3.jpg" alt="<%=cm.getNome()%>">
			</div>

		</div>

		<div class="col-1"></div>
		<div class="col-5">
			<div class="informazioni">
				<p>
					<label class="dettagli"> Adatto a: </label> <span> <em>
							<%
							if (cm.getCasa().equals("y") && cm.getUfficio().equals("y") && cm.getGaming().equals("y")) {
							%> Casa, ufficio e gaming <%
							} else if (cm.getCasa().equals("y") && cm.getUfficio().equals("y") && cm.getGaming().equals("n")) {
							%> Casa e ufficio <%
							} else if (cm.getCasa().equals("y") && cm.getUfficio().equals("n") && cm.getGaming().equals("y")) {
							%> Casa e gaming <%
							} else if (cm.getCasa().equals("y") && cm.getUfficio().equals("n") && cm.getGaming().equals("n")) {
							%> Casa <%
							} else if (cm.getCasa().equals("n") && cm.getUfficio().equals("y") && cm.getGaming().equals("y")) {
							%> Ufficio e gaming <%
							} else if (cm.getCasa().equals("n") && cm.getUfficio().equals("y") && cm.getGaming().equals("n")) {
							%> Ufficio <%
							} else {
							%> Gaming <%
							}
							%>
					</em>
					</span>
				</p>
				<p>
					<label> Rilascio</label> <span> <%=cm.getDataUscita()%></span>
				</p>
				<div class="scritta-spedizione">
					<p>
						<label> Dettagli spedizione</label> <span> Spedizione
							gratuita</span>
					</p>
				</div>
				<div class="prezzo">
					<div class="numero">
						<p>
							<%=cm.getPrezzo()%>
							&#x20AC
						</p>
					</div>
					<form action="aggiungi-prodotto" method="post">
						<div class="bottoni">
							<input type="hidden" name="codice" value="<%=cm.getCodice()%>">
							<button class="carrello">
								<span>Aggiungi al <br> carrello
								</span>
							</button>
							<div class="quantity">
								<button type="button" onclick="decreaseQuantity()">-</button>
								<input type="text" oninput="validateInput(event)" pattern="[1-9][0-9]{0,3}" maxlength="2" name="quantity" id="quantity" value="1">
								<button type="button" onclick="increaseQuantity()">+</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="descrizione-prodotto">
			<h2 class="scritta-principale">
				<a> Descrizione </a>
			</h2>
			<div class="descrizione-2">
				<div class="testo">
					<p><%=cm.getDescrizione()%></p>
				</div>
			</div>
		</div>
		<div class="scritta-prodotti">
			<h3>Prodotti Consigliati</h3>
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
</div>


	<!-- ACCESSORI -->
	
	
	
<%} else if (a != null) { %>
<div class="nome-prodotto">
<h1>
	<span> <%=a.getNome()%>
	</span>
</h1>
<p>
	by <strong><%=a.getMarca()%></strong>
	<span></span>
</p>
</div>

<div class="container">

<div class="row">
	<div class="col-6 box">
		<div class="arrow_prev">
			<img src="imgs/generale/arrow.png" alt="Freccia giù" height="25">
		</div>
		<div class="arrow_next">
			<img src="imgs/generale/arrow.png" alt="Freccia giù" height="25">
		</div>
		<div class="carosello">
			<img src="imgs/prodotti/<%=a.getNome()%> 1.jpg" alt="<%=a.getNome()%>"> <img
				src="imgs/prodotti/<%=a.getNome()%> 2.jpg" alt="<%=a.getNome()%>"> <img
				src="imgs/prodotti/<%=a.getNome()%> 3.jpg" alt="<%=a.getNome()%>">
		</div>

	</div>

	<div class="col-1"></div>
	<div class="col-5">
		<div class="informazioni">
			<p>
				<label class="dettagli"> Tipo accessorio </label> <span> <em>
						<%=a.getTipo()%>
				</em>
				</span>
			</p>
			<p>
				<label> Rilascio</label> <span> <%=a.getDataUscita()%></span>
			</p>
			<div class="scritta-spedizione">
				<p>
					<label> Dettagli spedizione</label> <span> Spedizione
						gratuita</span>
				</p>
			</div>
			<div class="prezzo">
				<div class="numero">
					<p>
						<%=a.getPrezzo()%>
						&#x20AC
					</p>
				</div>
				<form action="aggiungi-prodotto" method="post">
					<div class="bottoni">
						<input type="hidden" name="codice" value="<%=a.getCodice()%>">
						<button class="carrello">
							<span>Aggiungi al <br> carrello
							</span>
						</button>
						<div class="quantity">
							<button type="button" onclick="decreaseQuantity()">-</button>
							<input type="text" oninput="validateInput(event)" pattern="[1-9][0-9]{0,3}" maxlength="2" name="quantity" id="quantity" value="1">
							<button type="button" onclick="increaseQuantity()">+</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="descrizione-prodotto">
		<h2 class="scritta-principale">
			<a> Descrizione </a>
		</h2>
		<div class="descrizione-2">
			<div class="testo">
				<p><%=a.getDescrizione()%></p>
			</div>
		</div>
	</div>
	<div class="scritta-prodotti">
		<h3>Prodotti Consigliati</h3>
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
</div>


<!-- CONSOLE -->



<%} else if (cs != null) { %>
<div class="nome-prodotto">
<h1>
	<span> <%=cs.getNome()%>
	</span>
</h1>
<p>
	by <strong><%=a.getMarca()%></strong>
	<span></span>
</p>
</div>

<div class="container">

<div class="row">
	<div class="col-6 box">
		<div class="arrow_prev">
			<img src="imgs/generale/arrow.png" alt="Freccia giù" height="25">
		</div>
		<div class="arrow_next">
			<img src="imgs/generale/arrow.png" alt="Freccia giù" height="25">
		</div>
		<div class="carosello">
			<img src="imgs/prodotti/<%=cs.getNome()%> 1.jpg" alt="<%=cs.getNome()%>"> <img
				src="imgs/prodotti/<%=cs.getNome()%> 2.jpg" alt="<%=cs.getNome()%>"> <img
				src="imgs/prodotti/<%=cs.getNome()%> 3.jpg" alt="<%=cs.getNome()%>">
		</div>

	</div>

	<div class="col-1"></div>
	<div class="col-5">
		<div class="informazioni">
			<p>
				<label class="dettagli"> Gen </label> <span> <em>
						<%=cs.getGenerazione()%>
				</em>
				</span>
			</p>
			<p>
				<label> Rilascio</label> <span> <%=cs.getDataUscita()%></span>
			</p>
			<div class="scritta-spedizione">
				<p>
					<label> Dettagli spedizione</label> <span> Spedizione
						gratuita</span>
				</p>
			</div>
			<div class="prezzo">
				<div class="numero">
					<p>
						<%=cs.getPrezzo()%>
						&#x20AC
					</p>
				</div>
				<form action="aggiungi-prodotto" method="post">
					<div class="bottoni">
						<input type="hidden" name="codice" value="<%=cs.getCodice()%>">
						<button class="carrello">
							<span>Aggiungi al <br> carrello
							</span>
						</button>
						<div class="quantity">
							<button type="button" onclick="decreaseQuantity()">-</button>
							<input type="text" oninput="validateInput(event)" pattern="[1-9][0-9]{0,3}" maxlength="2" name="quantity" id="quantity" value="1">
							<button type="button" onclick="increaseQuantity()">+</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="descrizione-prodotto">
		<h2 class="scritta-principale">
			<a> Descrizione </a>
		</h2>
		<div class="descrizione-2">
			<div class="testo">
				<p><%=cs.getDescrizione()%></p>
			</div>
		</div>
	</div>
	<div class="scritta-prodotti">
		<h3>Prodotti Consigliati</h3>
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
</div>
<%} %>

	<%@ include file="includes/footer.jsp"%>
	<script src="js/paginaprodotto.js" type="text/javascript"></script>
	<script src="js/carrello.js" type="text/javascript"></script>
</body>
</html>
