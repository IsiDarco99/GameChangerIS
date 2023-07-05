<%@page import="cn.gamechanger.connection.DbCon"%>
<%@page import="cn.gamechanger.model.dao.*"%>
<%@page import="cn.gamechanger.model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cn.gamechanger.servlet.MostraCarrelloServlet" %>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<title>parte 3 </title>
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
          <li class="step-wizard-item  ">
            <span class="progress-count">1</span>
            <span class="progress-label">Billing Info</span>
          </li>
          <li class="step-wizard-item ">
            <span class="progress-count">2</span>
            <span class="progress-label">Pay</span>
          </li>
        
          <li class="step-wizard-item current-item">
            <span class="progress-count">3</span>
            <span class="progress-label">Checkout</span>
          </li>
    
          <li class="step-wizard-item">
            <span class="progress-count">4</span>
            <span class="progress-label">Finish</span>
          </li>
        </ul>
        </section>
      
    </div> 
  </div>
  
  <!-- Inizio codice carrello -->
  
  <div class="container">
  <div class="row">
  <div class="col-9">
		<div class="carrello">
		
  <div id="prodotto" class="container-prodotto">
  
				<div class="immagine">
				
					<img class="prod-img"
						src="imgs/prodotti/God of War 1.jpg"
						alt="prodotto">
				</div>
				<div class="nome-prodotto">
					<h1>
						<span> 
						amo fare la cacca
						</span>
					</h1>
					<div class="quantity">
						<strong>Quantità: </strong><span> 

						</span>
					</div>
				</div>

				<div class="prezzo">
					<p>
						<strong>Prezzo</strong><br>
						123 &#x20AC
					</p>
				</div>
				<form action="/GameChanger/rimuovi-prodotto" method="post" id="rimuoviProdottoForm-">
				<input type="hidden" name="codice" value="">
				
				</form>
			</div>

			
			

<div class="container-totale">
				<div class="totale">
					<p>
						<strong>Totale: </strong><br>
						150 &#x20AC
					</p>
				</div>
				<form action="/GameChanger/checkout-1" method="post">
				
				</form>
			</div>
			
			
		</div>
		</div>
		<div class="col-3">
		<div class="informazioni">
		<h2> Il mio indirizzo</h2>
		<p> Nome </p>
		<p> Indirizzo </p>
		<p> Numero di telefono: </p>
		
		<h2 class="pagamento">Pagamento</h2>
		<p> Email Paypal: </p>
		<p> Totale Ordine: </p>
		<button class="acquista">
		<span>Acquista</span>
		</button>
		</div>
		</div>
		</div>
		
	</div>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 <%@ include file="includes/footer.jsp"%>
</body>
</html>
