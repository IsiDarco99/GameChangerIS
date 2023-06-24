<%@page import="cn.gamechanger.connection.DbCon"%>
<%@page import="cn.gamechanger.model.dao.ProdottoDao"%>
<%@page import="cn.gamechanger.model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	ProdottoDao pd = new ProdottoDao(DbCon.getConnection());
	List<Prodotto> prodotti = pd.getAllProdotto();
%>
<!DOCTYPE html>
<html lang="IT">
<head>
<title>GameChanger</title>
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
<<<<<<< HEAD
	<div class ="container-generale">
	<div class="row">
	<div class="col-2">
	
	<div class="categoria">
	<p> <strong> Categoria</strong></p>
	
	<div class="filtri">
	<p> Videogiochi</p>
	<p>Accessori</p>
	<p>Computer</p>
	<p>Console</p>
	
	</div>
	
	<div class="prezzo">
	<p> <strong> Prezzo</strong></p>
	<div class="filtri-2">
	<p> Fino a 20 EUR</p>
	<p>Da 20 a 50 EUR</p>
	<p>Da 50 a 100 EUR</p>
	</div>
	
	</div>
	</div>
	
	
	
	</div>
	<div class="col-10">
	<div class="prodotti">
	<div class="scritta">
	<p> <strong> Risultati</strong></p>
	</div>
	
	<div class="container-prodotti">
	<div class="prodotto">
	<img src="imgs/paginaprodotto/Onepiece.png"
						alt="Brawhalla">
	<div class="informazioni-prodotto">
	<p> <strong>Nome Prodotto</strong>
	<p> 20.99$ </p>
	</div>
	</div>
	<div class="prodotto">
	<img src="imgs/paginaprodotto/Onepiece.png"
						alt="Brawhalla">
						<div class="informazioni-prodotto">
						<p> <strong>Nome Prodotto</strong>
	<p> 20.99$ </p>
	</div>
	</div>
	<div class="prodotto">
	<img src="imgs/paginaprodotto/Onepiece.png"
						alt="Brawhalla">
						<div class="informazioni-prodotto">
						<p> <strong>Nome Prodotto</strong>
	<p> 20.99$ </p>
	</div>
	</div>
	
	<div class="prodotto">
	<img src="imgs/paginaprodotto/Onepiece.png"
						alt="Brawhalla">
						<div class="informazioni-prodotto">
						<p> <strong>Nome Prodotto</strong>
	<p> 20.99$ </p>
	
	</div>
	</div>
	
	
	
	
	<div class="prodotto">
	<img src="imgs/paginaprodotto/Onepiece.png"
						alt="Brawhalla">
						<div class="informazioni-prodotto">
						<p> <strong>Nome Prodotto</strong>
	<p> 20.99$ </p>
	</div>
	</div>
	
	<div class="prodotto">
	<img src="imgs/paginaprodotto/Onepiece.png"
						alt="Brawhalla">
						<div class="informazioni-prodotto">
						<p> <strong>Nome Prodotto</strong>
	<p> 20.99$ </p>
	
	</div>
	</div>
	
	
	<div class="prodotto">
	<img src="imgs/paginaprodotto/Onepiece.png"
						alt="Brawhalla">
						<div class="informazioni-prodotto">
						<p> <strong>Nome Prodotto</strong>
	<p> 20.99$ </p>
	</div>
	</div>
	
	<div class="prodotto">
	<img src="imgs/paginaprodotto/Onepiece.png"
						alt="Brawhalla">
						<div class="informazioni-prodotto">
						<p> <strong>Nome Prodotto</strong>
	<p> 20.99$ </p>
	
	</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	</div>
	
	
	
	</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	</div>
	</div>
=======
		<div class="container-generale">
			<div class="row">
				<div class="col-2">

					<div class="categoria">
						<p>
							<strong> Categoria</strong>
						</p>

						<div class="filtri">
							<p>Tutti i prodotti</p>
							<p>Videogiochi</p>
							<p>Accessori</p>
							<p>Computer</p>
							<p>Console</p>

						</div>

						<div class="prezzo">
							<p>
								<strong> Prezzo</strong>
							</p>
							<div class="filtri-2">
								<p>Fino a 20 EUR</p>
								<p>Da 20 a 50 EUR</p>
								<p>Da 50 a 100 EUR</p>
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
						<% 
							if(!prodotti.isEmpty()){
								for(Prodotto p:prodotti){%>
									<div class="prodotto">
									<a href="paginaprodotto.jsp?codice=<%= p.getCodice() %>">
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
>>>>>>> branch 'master' of https://github.com/IsiDarco99/GameChangerRep.git
	</div>
	<%@include file="includes/footer.jsp"%>
</body>