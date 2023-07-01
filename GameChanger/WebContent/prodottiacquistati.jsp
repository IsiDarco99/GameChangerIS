
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
    
<!DOCTYPE html>
<html>
<head>
<title>GameChanger</title>
<%@ include file="includes/head.jsp"%>
<link rel="stylesheet" href="css/prodottiacquistati.css" type="text/css">
</head>
<body>
<%@ include file="includes/topbar.jsp"%>
<%@ include file="includes/navbar.jsp"%>

<div class="scritta-principale">
		<h1>
			<span> Prodotti Acquistati </span>
		</h1>
	</div>
	
	<div class="container">
		<div class="prodotti">
		
	 <% 
			/* if (prodotti.isEmpty()) {
			*/%> 
		<!--  	<div class="immagine-prodotto">
				<img src="imgs/prodottiacquistati/prodottovuoto.png" alt="Nessun prodotto">

			</div>
			<div class="scritta-prodotto">
				<h1>
					<span> Non hai acquistato nessun prodotto<br>Da un'occhiata ai
						nostri <a href="sfogliaProdotti.jsp?categoria=allProdotti">prodotti</a>
					</span>
				</h1>
			</div> -->
	
	<% /*
	} else {
	for (Carrello p : prodotti) {
		prezzoTot += (p.getPrezzo() * p.getQuantitàProdotto());
	*/%>



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
				<span> <%=p.getNomeProdotto()%>
				</span>
			</h1>
			<div class="quantity">
				<strong>Quantità: </strong> <span> 
				 <%=p.getQuantitàProdotto()%>
				
				</span>
			</div>
		</div>

		<div class="prezzo">
			<p>
				<strong>Prezzo</strong><br><%=String.format("%.2f", p.getPrezzo() * p.getQuantitàProdotto())%>
				&#x20AC
			</p>
		</div>
		</div>
		
	
	<% /*
	}
	} */
	%>
	
	
	
	
	
	
	
	
	
	
	
	
	
	</div>
	</div>
	
	<%@ include file="includes/footer.jsp"%>
</body>
</html>