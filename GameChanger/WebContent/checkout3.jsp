<%@page import="cn.gamechanger.connection.DbCon"%>
<%@page import="cn.gamechanger.dao.*"%>
<%@page import="cn.gamechanger.bean.*"%>
<%@page import="java.util.List"%>
<%@page import="com.google.protobuf.TextFormatParseInfoTree"%>
<% User user = (User) request.getAttribute("user"); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
List<Carrello> prodotti = (List<Carrello>) request.getAttribute("prodotti");
float prezzoTot;
prezzoTot = 0;%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>GameChanger</title>
<%@ include file="includes/head.jsp"%>
<script src="check.js"></script>

<link rel="stylesheet" href="css/checkout3.css">
<link rel="stylesheet" href="css/topbar.css">
</head>

<body>
	<%@include file="includes/topbar.jsp"%>
	<div class="container-total">
		<div class="container-fluid">
			<!--barra di esperienza-->
			<section class="step-wizard">
				<ul class="step-wizard-list">
					<li class="step-wizard-item  "><span class="progress-count">1</span>
						<span class="progress-label">informazioni di spedizione</span></li>
					<li class="step-wizard-item "><span class="progress-count">2</span>
						<span class="progress-label">Pagamento</span></li>

					<li class="step-wizard-item current-item"><span
						class="progress-count">3</span> <span class="progress-label">Checkout</span>
					</li>

					<li class="step-wizard-item"><span class="progress-count">4</span>
						<span class="progress-label">Ordine confermato</span></li>
				</ul>
			</section>

		</div>
	</div>

	<!-- Inizio codice carrello -->

	<form action="Checkout4-Servlet" method="post">
<input type="hidden" name="step" value="1">
	</form>
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="carrello">

					<% 	for (Carrello p : prodotti) {
				prezzoTot += (p.getPrezzo() * p.getQuantit�Prodotto());
			%>

					<div id="prodotto-<%=p.getIdProdotto()%>"
						class="container-prodotto">

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
								<strong>Quantit�:<%=p.getQuantit�Prodotto()%>
								</strong><span> </span>
							</div>
						</div>

						<div class="prezzo">
							<p>
								<strong>Prezzo</strong><br><%=String.format("%.2f", p.getPrezzo() * p.getQuantit�Prodotto())%>
								&#x20AC
							</p>
						</div>
					</div>

					<%
			}
			 %>
					<div class="container-totale">
						<div class="totale">
							<p>
								<strong>Totale: <%=String.format("%.2f", prezzoTot)%>
									&#x20AC
								</strong>

							</p>
						</div>
						<form action="checkout-1" method="post"></form>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="informazioni">
					<h2>Il mio indirizzo</h2>
					<p>${user.nome}${user.cognome}</p>
					<p>${user.stato},${user.citta}, ${user.indirizzo},
						${user.cod_postale}</p>
					<p>Numero di telefono: ${user.numTel}</p>

					<h2 class="pagamento">Pagamento</h2>
					<p>Email Paypal:${user.emailPaypal}</p>
					<p>
						Totale Ordine:<%=String.format("%.2f", prezzoTot)%>
						&#x20AC
					</p>
					<form action="checkout-1" method="post">
					<input type="hidden" name="step" value="4">
						<button class="acquista">Acquista</button>
					</form>
				</div>
			</div>
		</div>

	</div>
	<%@ include file="includes/footer.jsp"%>
	<script type="text/javascript" src="js/carrello.js"></script>
</body>
</html>
