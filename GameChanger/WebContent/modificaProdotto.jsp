<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="cn.gamechanger.bean.*"%>
<%@page import="cn.gamechanger.servlet.IdentificaProdottoServlet" %>
<!DOCTYPE html>
<html lang="IT">

<head>
<title>GameChanger</title>
<%@include file="includes/head.jsp"%>
<link rel="stylesheet" href="css/operazioniamministratore.css" type="text/css">
</head>


<body>
<%@include file="includes/topbar.jsp"%>

<%
Prodotto p = (Prodotto) request.getAttribute("prodotto");
%>

<div class="container">
               <div class="blocco">
					<form action="modifica-prodotto2" method="post">
					    <input type="hidden" name="codice" value="<%= p.getCodice() %>">
					    <p>Nome:<br> <input type="text" name="nomeprodotto" value="<%= p.getNome() %>" required onblur="validateNome()"></p>
					    <p id="errorNome" style="color: red;"></p>
					    <p>Marca:<br> <input type="text" name="marca" value="<%= p.getMarca() %>" required onblur="validateMarca()"></p>
					    <p id="errorMarca" style="color: red;"></p>
					    <p>Prezzo:<br> <input type="text" name="prezzo" value="<%= p.getPrezzo() %>" required onblur="validatePrezzo()"></p>
					    <p id="errorPrezzo" style="color: red;"></p>
					    <p>Data:<br> <input type="text" name="data" value="<%= p.getDataUscita() %>" required onblur="validateData()"></p>
					    <p id="errorData" style="color: red;"></p>
					    <textarea name="descrizioneprodotto" rows="10" cols="27" required onblur="validateDescr()"><%= p.getDescrizione() %></textarea>
					    <p id="errorDescrizione" style="color: red;"></p>
					    <p>Categoria:<br> <select name="categoria">
						<option value="videogame">Videogame</option>
						<option value="accessorio">Accessori</option>
						<option value="console">Console</option>
						<option value="computer">Computer</option>
					</select>
				</p>
					    <button type="submit">Conferma modifiche</button>
					</form>
               </div>
            </div>
<%@include file="includes/footer.jsp"%>
<script src="js/controlliCateg.js" type="text/javascript"></script>
</body>
