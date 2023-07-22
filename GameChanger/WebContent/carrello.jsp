<%@page import="cn.gamechanger.connection.DbCon"%>
<%@page import="cn.gamechanger.model.dao.*"%>
<%@page import="cn.gamechanger.model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cn.gamechanger.servlet.MostraCarrelloServlet" %>
<%
List<Carrello> prodotti = (List<Carrello>) request.getAttribute("prodotti");
float prezzoTot;
prezzoTot = 0;
%>
<!DOCTYPE html>
<html lang="it">
<head>
<title>GameChanger</title>
<%@ include file="includes/head.jsp"%>
<link rel="stylesheet" href="css/carrello.css" type="text/css">

</head>
<body>
	<%@ include file="includes/topbar.jsp"%>
	<%@include file="includes/navbar.jsp"%>

	<div class="scritta-principale">
		<h1>
			<span> Carrello </span>
		</h1>
	</div>

	<div class="container">
		<div class="carrello">


			<%
			if (prodotti.isEmpty()) {
			%>
			<div class="immagine-carrello">
				<img src="imgs\carrello\cartcompra.svg" alt="Carrello vuoto">

			</div>
			<div class="scritta-carrello">
				<h1>
					<span> Il tuo carrello &eacute; vuoto<br>Da un'occhiata ai
						nostri <a href="${pageContext.request.contextPath}/mostra-tutti-prodotti?categoria=allProdotti">prodotti</a>
					</span>
				</h1>
			</div>
			<%
			} else {
			for (Carrello p : prodotti) {
				prezzoTot += (p.getPrezzo() * p.getQuantitàProdotto());
			%>



			<!-- INIZIO PRODOTTO -->

			<div id="prodotto-<%=p.getIdProdotto()%>" class="container-prodotto">
				<div class="immagine">
					<img class="prod-img"
						src="imgs/prodotti/<%=p.getNomeProdotto()%> 1.jpg"
						alt="<%=p.getNomeProdotto()%>">
				</div>
				<div class="nome-prodotto">
					<h1>
						<span> <%=p.getNomeProdotto()%>
						</span>
					</h1>
					<div class="quantity">
						<strong>Quantit&aacute : </strong><span> <input
							class="quantity-input" type="text" oninput="validateInput(event)"
							data-previous-value="<%=p.getQuantitàProdotto()%>"
							pattern="[1-9][0-9]{0,3}" maxlength="2" name="quantity"
							id="quantity-<%=p.getIdProdotto()%>"
							onblur="handleBlur(<%=p.getIdProdotto()%>)"
							value="<%=p.getQuantitàProdotto()%>">

						</span>
					</div>
				</div>

				<div class="prezzo">
					<p>
						<strong>Prezzo</strong><br><%=String.format("%.2f", p.getPrezzo() * p.getQuantitàProdotto())%>
						&#x20AC
					</p>
				</div>
				<form action="/GameChanger/rimuovi-prodotto" method="post" id="rimuoviProdottoForm-<%=p.getIdProdotto()%>">
				<input type="hidden" name="codice" value="<%= p.getIdProdotto()%>">
				<button class="carrello" onclick="submitFormCart(event, <%= p.getIdProdotto()%>)">
					<span>X </span>
				</button>
				</form>
			</div>

			<%
			}
			}
			%>
			<%
			if (!prodotti.isEmpty()) {
			%>
			<div class="container-totale">
				<div class="prezzo">
					<p>
						<strong>Totale</strong><br><%=String.format("%.2f", prezzoTot)%>
						&#x20AC
					</p>
				</div>
				<form action="/GameChanger/checkout-1" method="post">
				<button class="acquista">
					<span>Acquista </span>
				</button>
				</form>
			</div>
			<%
			}
			%>
			<!-- FINE PRODOTTO -->


		</div>
	</div>



	<%@ include file="includes/footer.jsp"%>
	<script type="text/javascript" src="js/carrello.js"></script>
</body>
</html>