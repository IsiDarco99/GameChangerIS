<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="cn.gamechanger.bean.*"%>
<%@page import="cn.gamechanger.servlet.GetAdminServlet"%>
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
			<form action="Inserisci-Prodotto" method="post" enctype="multipart/form-data"
				onsubmit="return validateUploadImmagini()">
				<p>
					Categoria:<br> <select name="categoria">
						<option value="videogame">Videogame</option>
						<option value="accessorio">Accessori</option>
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
					<textarea name="descrizioneprodotto" rows="10" cols="27" required
						onblur="validateDescr()"></textarea>
				</p>
				<p id="errorDescrizione" style="color: red;"></p>
				<p>Immagine 1:<br>
                <input type="file" name="immagine1">
        		</p>
            	<p>Immagine 2:<br>
                <input type="file" name="immagine2">
            	</p>
            	<p>Immagine 3:<br>
                <input type="file" name="immagine3">
            	</p>
            	<p id="errorMessaggio" style="color: red;"></p>
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
			<form action="modifica-prodotto" method="post" onsubmit="return validateFormModifica()">
			<p>Codice del prodotto:</p>
			<input type="text" name="codice" required
					oninput="validateCodice(this)"> <br>
			<p id="errorCodice" style="color: red;"></p>
			<button type="submit">Avanti</button>
			</form>
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
			<form id="deleteProductForm" action="elimina-prodotto" method="post" onsubmit="return validateFormElimina()">
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

	case "ordiniData":
	%>
	<div class="container">
		<div class="blocco">
			<h2>
				<strong>Visualizza ordini per data</strong>
			</h2>
			<form action="visualizza-ordini-data" method="post" onsubmit="return validateFormOrdiniData()">
				<p>Data iniziale:</p>
				<input type="text" name="dataIniz" required onblur="validateDataIniz()"> <br>
				<p id="errorDataIniz" style="color: red;"></p>
				<p>Data finale:</p>
				<input type="text" name="dataFin" required onblur="validateDataFin()"> <br>
				<p id="errorDataFin" style="color: red;"></p>
				<button type="submit">Avanti</button>
			</form>
		</div>
	</div>


	<%
	break;

	case "ordiniUser":
	%>
	<div class="container">
		<div class="blocco">
			<h2>
				<strong>Visualizza ordini per User</strong>
			</h2>
			<form action="visualizza-ordini-user" method="post" onsubmit="return validateFormOrdiniUser()">
				<p>Username:</p>
				<input type="text" name="username" required onblur="validateUsername()"> <br>
				<p id="errorUsername" style="color: red;"></p>
				<button type="submit">Avanti</button>
			</form>
		</div>
	</div>


	<%
	}
	}
	%>




	<%@include file="includes/footer.jsp"%>
	<script src="js/controlliNuovoProdotto.js" type="text/javascript"></script>
	<script src="js/controlliUpload.js" type="text/javascript"></script>
</body>
</html>