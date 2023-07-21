<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="cn.gamechanger.model.*"%>
<%@page import="cn.gamechanger.servlet.getAdminServlet"%>
<%
Amministratore admin = (Amministratore) request.getAttribute("admin");
%>
<!DOCTYPE html>
<html lang="it">

<head>
<title>GameChanger</title>
<%@include file="includes/head.jsp"%>
<link rel="stylesheet" href="css/operazioniamministratore.css"
	type="text/css">
</head>

<body>
	<%@include file="includes/topbar.jsp"%>

	<%
	String modifica = (String) request.getParameter("modifica");
	if (modifica != null) {
		switch (modifica) {
		case "inserisci":
	%>


	<div class="container">
		<div class="blocco">


			<h2>
				<strong>Inserisci nuovo prodotto</strong>
			</h2>
			<form action="Inserisci-Prodotto" method="post"
				onsubmit="return validateForm()">
				<p>
					Categoria:<br> <select name="categoria">
						<option value="videogame">Videogame</option>
						<option value="accessori">Accessori</option>
						<option value="console">Console</option>
						<option value="computer">Computer</option>
					</select>
				</p>
				<p>
					Nome:<br> <input type="text" name="nomeprodotto" required
						onblur="validateNome()">
				</p>
				<p id="errorNome" style="color: red;"></p>
				<p>
					Prezzo:<br> <input type="text" name="prezzoprodotto" required
						onblur="validatePrezzo()">
				</p>
				<p id="errorPrezzo" style="color: red;"></p>
				<p>
					Marca:<br> <input type="text" name="marcaprodotto" required
						onblur="validateMarca()">
				</p>
				<p id="errorMarca" style="color: red;"></p>
				<p>
					Data di uscita:<br> <input type="text" name="data_usc"
						required onblur="validateData()">
				</p>
				<p id="errorData" style="color: red;"></p>
				<p>
					Descrizione:<br>
					<textarea name="descrizioneprodotto" rows="10" cols="50" required
						onblur="validateDescr()"></textarea>
				</p>
				<p id="errorDescrizione" style="color: red;"></p>
				<button type="submit">Avanti</button>
			</form>
		</div>
	</div>
	<%
	break;

	case "modifica":
	%>
	<div class="container">
		<div class="blocco">


			<h2>
				<strong>Modifica prodotto</strong>
			</h2>

			<p>Nome attuale:</p>
			<p>
				Nome:<br> <input type="text" name="nomeprodotto">
			</p>
			<p>Prezzo attuale:</p>
			<p>
				Prezzo:<br> <input type="text" name="prezzoprodotto">
			</p>
			<p>Marca attuale:</p>
			<p>
				Marca:<br> <input type="text" name="marcaprodotto">
			</p>
			<p>Data di uscita attuale:</p>
			<p>
				Data di uscita:<br> <input type="text" name="data_usc">
			</p>
			<p>Descrizione attuale:</p>
			<p>
				Descrizione:<br> <input type="text" name="descrizioneprodotto">
			</p>
			<button type="submit">Aggiungi prodotto</button>

		</div>
	</div>

	<%
	break;

	case "elimina":
	%>
	<div class="container">
		<div class="blocco">
			<h2>
				<strong>Elimina prodotto</strong>
			</h2>
			<form id="deleteProductForm" action="elimina-prodotto" method="post">
				<p>Codice del prodotto:</p>
				<br> <input type="text" name="codice" required
					oninput="validateCodice(this)"> <br>
				<p id="errorCodice" style="color: red;"></p>
				<button type="button" onclick="submitForm()">Elimina
					prodotto</button>
			</form>
		</div>
	</div>


	<%
	break;

	case "altro":
	%>

	<%
	}
	}
	%>




	<%@include file="includes/footer.jsp"%>
	<script src="js/controlliNuovoProdotto.js" type="text/javascript"></script>
</body>
</html>