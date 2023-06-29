<%@page import="com.google.protobuf.TextFormatParseInfoTree"%>
<%@page import="cn.gamechanger.connection.DbCon"%>
<%@page import="cn.gamechanger.model.dao.*"%>
<%@page import="cn.gamechanger.model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cn.gamechanger.servlet.MostraTuttiProdottiServlet" %>
<%
	String categoria = request.getParameter("categoria");
	if (categoria == null) {
		categoria = "allProdotti";
  }
	List<Prodotto> prodotti = (List<Prodotto>) request.getAttribute("prodotti");
	
%>
<!DOCTYPE html>
<html lang="IT">
<head>
<title>GameChanger</title>
<script>
    function validateInput(event) {
      const input = event.target;
      const value = input.value;

      // Rimuovi i caratteri non numerici
      const filteredValue = value.replace(/[^0-9]/g, '');

      // Imposta il valore filtrato nell'input
      input.value = filteredValue;
    }
  </script>
<%@include file="includes/head.jsp"%>
<link rel="stylesheet" href="css/sfogliaProdotti.css" type="text/css">
</head>
<body>
	<%@ include file="includes/topbar.jsp"%>
	<div class="container">
		<div class="titolo">
			<h1>Scopri i nostri prodotti!</h1>
		</div>
	</div>

	<div>
		<div></div>
	</div>
	<div class="container">
		<div class="container-generale">
			<div class="row">
				<div class="col-2">

					<div class="categoria">
						<p>
							<strong> Categoria</strong>
						</p>

						<div class="filtri">
							<p><a href="sfogliaProdotti.jsp?categoria=allProdotti">Tutti i prodotti</a></p>
							<p><a href="sfogliaProdotti.jsp?categoria=videogiochi">Videogiochi</a></p>
							<p><a href="sfogliaProdotti.jsp?categoria=accessori">Accessori</a></p>
							<p><a href="sfogliaProdotti.jsp?categoria=computer">Computer</a></p>
							<p><a href="sfogliaProdotti.jsp?categoria=console">Console</a></p>
						</div>

						<div class="prezzo">
							<p>
								<strong> Prezzo</strong>
							</p>
							<div class="filtri-2">
							<form action="${pageContext.request.contextPath}/filtra-prezzo" method="get">
							<input type="hidden" name="categoria" value="<%= categoria %>">
								<div class="filtri-2">
								<p>Da </p>
								<input type="text" oninput="validateInput(event)" pattern="[1-9][0-9]{0,3}" maxlength="4" name="min" id="prezzoMin" placeholder="0">
								</div>
								<div class="filtri-2">
								<p> a </p>
								<input type="text" oninput="validateInput(event)" pattern="[1-9][0-9]{0,3}" maxlength="4" name="max" id="prezzoMax" placeholder="0">
								</div>
								<input type="submit" value="Invia" >
							</form>
							</div>
							
						</div>
					</div>

				</div>
				<div class="col-10">
					<div class="prodotti">
						<div class="scritta">
							<p>
								<strong> Risultati</strong>
							</p>
						</div>

						<div class="container-prodotti">
						<%	if(!prodotti.isEmpty()){
								for(Prodotto p:prodotti){%>
									<div class="prodotto">
									<a href="${pageContext.request.contextPath}/mostra-prodotto?codice=<%= p.getCodice() %>">
									
									<img class="prod-img" src="imgs/prodotti/<%= p.getNome() %> 1.jpg" alt="<%= p.getNome() %>">
									</a>
									<div class="informazioni-prodotto">
										<p>
											<strong><%= p.getNome() %></strong>
										<p><%= p.getPrezzo() %> &#x20AC</p>
									</div>
								</div>
								<%}
							}
						%>
							
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="includes/footer.jsp"%>
</body>