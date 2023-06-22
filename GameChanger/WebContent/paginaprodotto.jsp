<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page import="cn.gamechanger.connection.DbCon"%>
<%@page import="cn.gamechanger.model.dao.*"%>
<%@page import="cn.gamechanger.model.*"%>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<%
int codice = Integer.parseInt(request.getParameter("codice"));
VideogameDao vd = new VideogameDao(DbCon.getConnection());
Videogame videogame = vd.getVideogameByCodice(codice);

ComputerDao cpd = new ComputerDao(DbCon.getConnection());
Computer computer = cpd.getComputerByCodice(codice);

ConsoleDao csd = new ConsoleDao(DbCon.getConnection());
Console console = csd.getConsoleByCodice(codice);

AccessorioDao ad = new AccessorioDao(DbCon.getConnection());
Accessorio accessorio = ad.getAccessorioByCodice(codice);

String categoria = null;

if (videogame != null) {
    categoria = "videogame";
} else if (computer != null) {
    categoria = "computer";
} else if (console != null) {
	categoria = "console";
} else if (accessorio != null){
	categoria = "accessorio";
}

String nome = "";
String marca = "";
String sviluppatore = "";
String pegi = "";
String genere = "";
float prezzo = 0;
String descrizione = "";
Date dataUscita = null;
String dataUscitaString = "";
String casa = "";
String ufficio = "";
String gaming = "";
String tipo = "";
int generazione = 0;

if (categoria != null) {
    if (categoria.equals("videogame")) {
        nome = videogame.getNome();
        marca = videogame.getMarca();
        sviluppatore = videogame.getSviluppatore();
        pegi = videogame.getPegi();
        genere = videogame.getGenere();
        dataUscita = videogame.getDataUscita();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dataUscitaString = dateFormat.format(dataUscita);
        prezzo = videogame.getPrezzo();
        descrizione = videogame.getDescrizione();
    } else if (categoria.equals("computer")) {
        nome = computer.getNome();
        marca = computer.getMarca();
        dataUscita = computer.getDataUscita();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dataUscitaString = dateFormat.format(dataUscita);
        prezzo = computer.getPrezzo();
        descrizione = computer.getDescrizione();
        casa = computer.getCasa();
        ufficio = computer.getUfficio();
        gaming = computer.getGaming();
    } else if (categoria.equals("accessorio")) {
        nome = accessorio.getNome();
        marca = accessorio.getMarca();
        dataUscita = accessorio.getDataUscita();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dataUscitaString = dateFormat.format(dataUscita);
        prezzo = accessorio.getPrezzo();
        descrizione = accessorio.getDescrizione();
        tipo = accessorio.getTipo();
    } else if (categoria.equals("console")) {
        nome = console.getNome();
        marca = console.getMarca();
        dataUscita = console.getDataUscita();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dataUscitaString = dateFormat.format(dataUscita);
        prezzo = console.getPrezzo();
        descrizione = console.getDescrizione();
        generazione = console.getGenerazione();
    }
}
%>



<!DOCTYPE html>
<html lang="IT">
<head>
<title>GameChanger</title>
<%@ include file="includes/head.jsp" %>
<link rel="stylesheet" href="css/paginaprodotto.css" type="text/css">
<script src="js/paginaprodotto.js"> </script>
<script src="js/carrello.js"></script>
</head>
<body>
<%@ include file="includes/topbar.jsp" %>
<%@ include file="includes/navbar.jsp" %>
 <div class="nome-prodotto">
        <h1>
        <span> <%= nome %>
        </span>
        </h1>
        <p>
        by
        <strong><%= marca  %></strong>
            <span><%= (categoria == "videogame") ? sviluppatore : "" %></span>
         </p>
        </div>

<div class="container">

<div class="row">
<div class="col-6 box">
<div class="arrow_prev"><img src="imgs/generale/arrow.png" alt="Freccia giù" height="25"></div>
<div class="arrow_next"><img src="imgs/generale/arrow.png" alt="Freccia giù" height="25"></div>
<div class="carosello">
<img src="imgs/prodotti/<%= nome %> 1.jpg"
						alt="<%= nome %>">
						
<img src="imgs/prodotti/<%= nome %> 2.jpg"
						alt="<%= nome %>">
						
<img src="imgs/prodotti/<%= nome %> 3.jpg"
						alt="<%= nome %>">
</div>

</div>

<div class="col-1"></div>
<div class="col-5">
<div class="informazioni">

<div class="descrizione">
<p>
<label class="dettagli"> PEGI </label>
<span> 
<em> <%= (categoria == "videogame") ? pegi : "" %> </em>
</span>
</p>
<p>
<label> Genere</label>

<span><%= (categoria == "videogame") ? genere : "" %></span>
</p>
<p>
<label> Rilascio</label>
<span> <%= dataUscitaString %></span>
</p>
<div class="scritta-spedizione">>
<p>
<label>  Dettagli spedizione</label>
<span> Spedizione gratuita</span>
</p>
</div>
<div class="prezzo">
<div class="numero">
<p> <p> <%= prezzo%> &#x20AC</p>

</div>
<form action="aggiungi-prodotto" method="post">
<div class="bottoni" >
<button class="carrello">
    <span>Aggiungi al <br> carrello</span>
</button>
<div class="quantity">
  <input type="text" name="quantity" id="quantity" value="1">
  <button onclick="decreaseQuantity()">-</button>
  <button onclick="increaseQuantity()">+</button>
</div>
</div>
</form>

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
<p><%= descrizione %></p>


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
