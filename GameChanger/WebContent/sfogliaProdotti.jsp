<%@page import="com.google.protobuf.TextFormatParseInfoTree"%>
<%@page import="cn.gamechanger.connection.DbCon"%>
<%@page import="cn.gamechanger.model.dao.*"%>
<%@page import="cn.gamechanger.model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String categoria = request.getParameter("categoria");
	if (categoria == null) {
		categoria = "allProdotti";
  }
	String prezzoMinParam = request.getParameter("min");
	String prezzoMaxParam = request.getParameter("max");
	
	int prezzoMinimo = 0;
	int prezzoMassimo = 9999;

	if (prezzoMinParam != null && !prezzoMinParam.isEmpty()) {
	  prezzoMinimo = Integer.parseInt(prezzoMinParam);
	}

	if (prezzoMaxParam != null && !prezzoMaxParam.isEmpty()) {
	  prezzoMassimo = Integer.parseInt(prezzoMaxParam);
	}
	
	System.out.println(prezzoMinimo + " " + prezzoMassimo);
	//RICERCA PRODOTTI PER CATEGORIA
	VideogameDao vd = new VideogameDao(DbCon.getConnection());
	List<Videogame> videogame = vd.getAllVideogame();
	
	ComputerDao cpd = new ComputerDao(DbCon.getConnection());
	List<Computer> computer = cpd.getAllComputer();
	
	ConsoleDao csd = new ConsoleDao(DbCon.getConnection());
	List<Console> console = csd.getAllConsole();
	
	AccessorioDao ad = new AccessorioDao(DbCon.getConnection());
	List<Accessorio> accessori = ad.getAllAccessori();
	
	ProdottoDao pd = new ProdottoDao(DbCon.getConnection());
	List<Prodotto> prodotti = pd.getAllProdotto();
	
	//RICERCA PRODOTTI PER PREZZO
	ProdottoDao pdp = new ProdottoDao(DbCon.getConnection());
	List<Prodotto> prodottiPrez = pd.getProdottiByPrezzo(prezzoMinimo, prezzoMassimo);
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
							<form action="sfogliaProdotti.jsp?categoria=<%= categoria %>" method="get">
							<input type="hidden" name="categoria" value="<%= categoria %>">
								<p>Da </p>
								<input type="text" oninput="validateInput(event)" pattern="[1-9][0-9]{0,3}" maxlength="4" name="min" id="prezzoMin" placeholder="0">
								<p> a </p>
								<input type="text" oninput="validateInput(event)" pattern="[1-9][0-9]{0,3}" maxlength="4" name="max" id="prezzoMax" placeholder="0">
								<input type="submit" value="Invia" />
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
						<% if (categoria.equals("videogiochi")){
							if(!videogame.isEmpty()){
								for(Videogame v:videogame){%>
									<div class="prodotto">
									<a href="paginaprodotto.jsp?codice=<%= v.getCodice() %>">
									<img class="prod-img" src="imgs/prodotti/<%= v.getNome() %> 1.jpg" alt="<%= v.getNome() %>">
									</a>
									<div class="informazioni-prodotto">
										<p>
											<strong><%= v.getNome() %></strong>
										<p><%= v.getPrezzo() %> &#x20AC</p>
									</div>
								</div>
								<%}
							}
						} else if (categoria.equals("computer")){
							if(!computer.isEmpty()){
								for(Computer c:computer){%>
									<div class="prodotto">
									<a href="paginaprodotto.jsp?codice=<%= c.getCodice() %>">
									<img class="prod-img" src="imgs/prodotti/<%= c.getNome() %> 1.jpg" alt="<%= c.getNome() %>">
									</a>
									<div class="informazioni-prodotto">
										<p>
											<strong><%= c.getNome() %></strong>
										<p><%= c.getPrezzo() %> &#x20AC</p>
									</div>
								</div>
								<%}
							}
						} else if (categoria.equals("console")){
							if(!console.isEmpty()){
								for(Console c:console){%>
									<div class="prodotto">
									<a href="paginaprodotto.jsp?codice=<%= c.getCodice() %>">
									<img class="prod-img" src="imgs/prodotti/<%= c.getNome() %> 1.jpg" alt="<%= c.getNome() %>">
									</a>
									<div class="informazioni-prodotto">
										<p>
											<strong><%= c.getNome() %></strong>
										<p><%= c.getPrezzo() %> &#x20AC</p>
									</div>
								</div>
								<%}
							}
						} else if (categoria.equals("accessori")){
							if(!accessori.isEmpty()){
								for(Accessorio a:accessori){%>
									<div class="prodotto">
									<a href="paginaprodotto.jsp?codice=<%= a.getCodice() %>">
									<img class="prod-img" src="imgs/prodotti/<%= a.getNome() %> 1.jpg" alt="<%= a.getNome() %>">
									</a>
									<div class="informazioni-prodotto">
										<p>
											<strong><%= a.getNome() %></strong>
										<p><%= a.getPrezzo() %> &#x20AC</p>
									</div>
								</div>
								<%}
							}
						} else if (categoria.equals("allProdotti")){
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