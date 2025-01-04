<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="cn.gamechanger.bean.*"%>
<%@ page import="cn.gamechanger.servlet.MostraProdSingoloServlet" %>
<%Prodotto p = (Prodotto) request.getAttribute("prodotto");%>

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

	// Aggiungi un listener per l'evento "input" all'input della quantitï¿½
	var quantityInput = document.getElementById("quantity");
	quantityInput.addEventListener("input", validateInput);

</script>
</head>
<body>
	<%@ include file="includes/topbar.jsp"%>
	<%@ include file="includes/navbar.jsp"%>
	

	<div class="nome-prodotto">
		<h1>
			<span> <%=p.getNome()%>
			</span>
		</h1>
		<p>
			by <strong><%=p.getMarca()%></strong>
			<span></span>
		</p>
	</div>

	<div class="container">

		<div class="row">
			<div class="col-6 box">
				<div class="arrow_prev">
					<img src="imgs/generale/arrow.png" alt="Freccia giï¿½" height="25">
				</div>
				<div class="arrow_next">
					<img src="imgs/generale/arrow.png" alt="Freccia giï¿½" height="25">
				</div>
				<div class="carosello">
					<img src="imgs/prodotti/<%=p.getNome()%> 1.jpg" alt="<%=p.getNome()%>"> <img
						src="imgs/prodotti/<%=p.getNome()%> 2.jpg" alt="<%=p.getNome()%>"> <img
						src="imgs/prodotti/<%=p.getNome()%> 3.jpg" alt="<%=p.getNome()%>">
				</div>

			</div>

			<div class="col-1"></div>
			<div class="col-5">
				<div class="informazioni">
					<p>
						<label> Rilascio</label> <span> <%=p.getDataUscita()%></span>
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
								<%=p.getPrezzo()%>
								&#x20AC
							</p>
						</div>
						<form action="aggiungi-prodotto" method="post">
							<div class="bottoni">
								<input type="hidden" name="codice" value="<%=p.getCodice()%>">
								<button class="carrello">
									<span>Aggiungi al <br> carrello
									</span>
								</button>
								<div class="quantity">
									<button type="button" onclick="decreaseQuantity()">-</button>
									<input type="text" oninput="validateInput(event)" pattern="[1-9][0-9]{0,3}" maxlength="2" name="quantity" id="quantity" min="1" max="99" value="0">
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
						<p><%=p.getDescrizione()%></p>
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
					<a href="${pageContext.request.contextPath}/mostra-prodotto?codice=7"><img
						src="imgs\homepage\secondo-carosello\9320plusoled.jpg"
						alt="PC"></a>
				</div>
			</div>
			<div class="col-md-12">
				<div class="content2">
					<a href="${pageContext.request.contextPath}/mostra-prodotto?codice=18">
					<img src="imgs\homepage\secondo-carosello\switch.jpg"
						alt="Switch">
					</a>
				</div>
			</div>
			<div class="col-md-12">
				<div class="content2">
					<a href="${pageContext.request.contextPath}/mostra-prodotto?codice=2">
					<img src="imgs/homepage/secondo-carosello/gowr.jpeg"
						alt="God Of War: Ragnarok">
					</a>
				</div>
			</div>
			<div class="col-md-12">
				<div class="content2">
					<a href="${pageContext.request.contextPath}/mostra-prodotto?codice=15">
					<img src="imgs\homepage\secondo-carosello\streamD.jpg"
						alt="Stream">
					</a>
				</div>
			</div>
			<div class="col-md-12">
				<div class="content2">
					<a href="${pageContext.request.contextPath}/mostra-prodotto?codice=19">
					<img src="imgs\homepage\secondo-carosello\wp3025447-ps4-hd-wallpapers.jpg" alt="PS4">
					</a>
				</div>
				
			</div>
			<div class="col-md-12">
				<div class="content2">
					<a href="${pageContext.request.contextPath}/mostra-prodotto?codice=10">
					<img src="imgs\homepage\secondo-carosello\asuRogG14.jpg"
						alt="Rocket League">
					</a>
				</div>
			</div>

		</div>
		
				
			</div>
	</div>
</div>

	<%@ include file="includes/footer.jsp"%>
	<script src="js/paginaprodotto.js" type="text/javascript"></script>
	<script src="js/carrello.js" type="text/javascript"></script>
</body>
</html>
