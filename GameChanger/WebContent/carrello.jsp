<%@page import="cn.gamechanger.connection.DbCon"%>
<%@page import="cn.gamechanger.model.dao.*"%>
<%@page import="cn.gamechanger.model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
HttpSession httpSession = request.getSession();
String username = (String) httpSession.getAttribute("userSession");
System.out.println(username);
CarrelloDao cd = new CarrelloDao(DbCon.getConnection());
List<Carrello> prodotti = cd.getCarrelloByUsername(username);
float prezzoTot;
prezzoTot = 0;
%>
<!DOCTYPE html>
<html>
<head>
<title>GameChanger</title>
<%@ include file="includes/head.jsp"%>
<link rel="stylesheet" href="css/carrello.css" type="text/css">
<script src="js/carrello.js">
	
</script>
</head>
<body>
	<%@ include file="includes/topbar.jsp"%>

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
				<img src="imgs/carrello/carrellovuoto1.png" alt="Carrello vuoto">

			</div>
			<div class="scritta-carrello">
				<h1>
					<span> Il tuo carrello è vuoto<br>Da un'occhiata ai
						nostri prodotti
					</span>
				</h1>
			</div>
			</div>
			</div>
			<%
			} else {
			for (Carrello p : prodotti) {
				prezzoTot += p.getPrezzo();
			%>



			<!-- INIZIO PRODOTTO -->

			<div class="container-prodotto">
				<div class="immagine">
					<a href="paginaprodotto.jsp?codice=<%=p.getIdProdotto()%>"> <img
						class="prod-img" src="imgs/prodotti/<%=p.getNomeProdotto()%> 1.jpg"
						alt="<%=p.getNomeProdotto()%>">
					</a>
				</div>
				<div class="nome-prodotto">
					<h1>
						<span> <%=p.getNomeProdotto()%> </span>
					</h1>
					<div class="quantity">
						<strong>Quantità: </strong><span> <%=p.getQuantitàProdotto()%> </span>
					</div>
				</div>

				<div class="prezzo">
					<p>
						<strong>Prezzo</strong><br><%= p.getPrezzo() %> &#x20AC
					</p>
				</div>
			</div>
			<%
	}
	}
	%>
			<!-- FINE PRODOTTO -->

			<!-- TOTALE -->
			<div class="container-totale">
				<div class="prezzo">
					<p>
						<strong>Totale</strong><br><%= prezzoTot%> &#x20AC
					</p>
				</div>
			</div>
		</div>
	</div>

	
	<%@ include file="includes/footer.jsp"%>
</body>
</html>