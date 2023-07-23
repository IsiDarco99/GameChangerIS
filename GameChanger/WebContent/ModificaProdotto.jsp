<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="cn.gamechanger.model.*"%>
<%@page import="cn.gamechanger.servlet.ModificaProdottoServlet" %>
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
String categoria = (String) request.getAttribute("categoria");
int codice = (int) request.getAttribute("codice");
   
Videogame v = null;
Computer cm = null;
Accessorio a = null;
Console cs = null;

if (categoria.equals("videogame")){
	v = (Videogame) request.getAttribute("prodotto");
} else if (categoria.equals("computer")){
	cm = (Computer) request.getAttribute("prodotto");
} else if (categoria.equals("accessorio")){
	a = (Accessorio) request.getAttribute("prodotto");
} else if (categoria.equals("console")){
	cs = (Console) request.getAttribute("prodotto");
} 

   if (categoria != null) {
      switch (categoria) {
         case "videogame":
%>

<div class="container">
               <div class="blocco">
               
                  
                  
                  <h2><strong>Videogioco</strong></h2>
					<form action="modifica-prodotto2" method="post">
					    <input type="hidden" name="categoria" value="videogame">
					    <input type="hidden" name="codice" value="<%= codice %>">
					    <p>Nome:<br> <input type="text" name="nomeprodotto" value="<%= v.getNome() %>" required onblur="validateNome()"></p>
					    <p id="errorNome" style="color: red;"></p>
					    <p>Marca:<br> <input type="text" name="marca" value="<%= v.getMarca() %>" required onblur="validateMarca()"></p>
					    <p id="errorMarca" style="color: red;"></p>
					    <p>Prezzo:<br> <input type="text" name="prezzo" value="<%= v.getPrezzo() %>" required onblur="validatePrezzo()"></p>
					    <p id="errorPrezzo" style="color: red;"></p>
					    <p>Data:<br> <input type="text" name="data" value="<%= v.getDataUscita() %>" required onblur="validateData()"></p>
					    <p id="errorData" style="color: red;"></p>
					    <textarea name="descrizioneprodotto" rows="10" cols="50" required onblur="validateDescr()"><%= v.getDescrizione() %></textarea>
					    <p id="errorDescrizione" style="color: red;"></p>
					    <p>PEGI:<br> <input type="text" name="pegi" value="<%= v.getPegi() %>" required onblur="validatePEGI()"></p>
					    <p id="errorPEGI" style="color: red;"></p>
					    <p>Sviluppatore:<br> <input type="text" name="sviluppatore" value="<%= v.getSviluppatore() %>" required onblur="validateSvilup()"></p>
					    <p id="errorSvilupp" style="color: red;"></p>
					    <p>Genere:<br> <input type="text" name="genere" value="<%= v.getGenere() %>" required onblur="validateGenere()"></p>
					    <p id="errorGenere" style="color: red;"></p>
					    <button type="submit">Conferma modifiche</button>
					</form>
               </div>
            </div>
<%
            break;
     
         case "accessorio":
        	 %>
<div class="container">
               <div class="blocco">
               
                   
                  <h2><strong>Accessori</strong></h2>
					<form action="modifica-prodotto2" method="post">
					    <input type="hidden" name="categoria" value="accessorio">
					    <input type="hidden" name="codice" value="<%= codice %>">
					    <p>Nome:<br> <input type="text" name="nome" value="<%= a.getNome() %>" required onblur="validateNome()"></p>
					    <p id="errorNome" style="color: red;"></p>
					    <p>Marca:<br> <input type="text" name="marca" value="<%= a.getMarca() %>" required onblur="validateMarca()"></p>
					    <p id="errorMarca" style="color: red;"></p>
					    <p>Prezzo:<br> <input type="text" name="prezzo" value="<%= a.getPrezzo() %>" required onblur="validatePrezzo()"></p>
					    <p id="errorPrezzo" style="color: red;"></p>
					    <p>Data:<br> <input type="text" name="data" value="<%= a.getDataUscita() %>" required onblur="validateData()"></p>
					    <p id="errorData" style="color: red;"></p>
					    <textarea name="descrizioneprodotto" rows="10" cols="50" required onblur="validateDescr()"><%= a.getDescrizione() %></textarea>
					    <p id="errorDescrizione" style="color: red;"></p>
					    <p>Tipologia:<br> <input type="text" name="tipo" value="<%= a.getTipo() %>" required onblur="validateTipo()"></p>
					    <p id="errorTipo" style="color: red;"></p>
					    <button type="submit">Conferma modifiche</button>
					</form> 
                  
               </div>
            </div>

<%
            break;
     
         case "console":
        	 %>
<div class="container">
               <div class="blocco">
               
                   
                  <h2><strong>Console</strong></h2>
					<form action="modifica-prodotto2" method="post">
					    <input type="hidden" name="categoria" value="console">
					    <input type="hidden" name="codice" value="<%= codice %>">
					    <p>Nome:<br> <input type="text" name="nome" value="<%= cs.getNome() %>" required onblur="validateNome()"></p>
					    <p id="errorNome" style="color: red;"></p>
					    <p>Marca:<br> <input type="text" name="marca" value="<%= cs.getMarca() %>" required onblur="validateMarca()"></p>
					    <p id="errorMarca" style="color: red;"></p>
					    <p>Prezzo:<br> <input type="text" name="prezzo" value="<%= cs.getPrezzo() %>" required onblur="validatePrezzo()"></p>
					    <p id="errorPrezzo" style="color: red;"></p>
					    <p>Data:<br> <input type="text" name="data" value="<%= cs.getDataUscita() %>" required onblur="validateData()"></p>
					    <p id="errorData" style="color: red;"></p>
					    <textarea name="descrizioneprodotto" rows="10" cols="50" required onblur="validateDescr()"><%= cs.getDescrizione() %></textarea>
					    <p id="errorDescrizione" style="color: red;"></p>
					    <p>Generazione:<br> <input type="text" name="gen" value="<%= cs.getGenerazione() %>" required onblur="validateGen()"></p>
					    <p id="errorGen" style="color: red;"></p>
					    <button type="submit">Conferma modifiche</button>
					</form> 
               </div>
            </div>

<%
            break;
     
         case "computer":
        	 %>
<div class="container">
               <div class="blocco">
               
                   
                  <h2><strong>Computer</strong></h2>
					<form action="modifica-prodotto2" method="post">
					    <input type="hidden" name="categoria" value="computer">
					    <input type="hidden" name="codice" value="<%= codice %>">
					    <p>Nome:<br> <input type="text" name="nome" value="<%= cm.getNome() %>" required onblur="validateNome()"></p>
					    <p id="errorNome" style="color: red;"></p>
					    <p>Marca:<br> <input type="text" name="marca" value="<%= cm.getMarca() %>" required onblur="validateMarca()"></p>
					    <p id="errorMarca" style="color: red;"></p>
					    <p>Prezzo:<br> <input type="text" name="prezzo" value="<%= cm.getPrezzo() %>" required onblur="validatePrezzo()"></p>
					    <p id="errorPrezzo" style="color: red;"></p>
					    <p>Data:<br> <input type="text" name="data" value="<%= cm.getDataUscita() %>" required onblur="validateData()"></p>
					    <p id="errorData" style="color: red;"></p>
					    <textarea name="descrizioneprodotto" rows="10" cols="50" required onblur="validateDescr()"><%= cm.getDescrizione() %></textarea>
					    <p id="errorDescrizione" style="color: red;"></p>
					    <p>Categoria:<br> 
					        <input type="checkbox" name="casa" value="casa" <%= cm.getCasa().equals("y") ? "checked" : "" %>>Casa
					        <input type="checkbox" name="ufficio" value="ufficio" <%= cm.getUfficio().equals("y") ? "checked" : "" %>>Ufficio
					        <input type="checkbox" name="gaming" value="gaming" <%= cm.getGaming().equals("y") ? "checked" : "" %>>Gaming
  						 </p> 
					    <button type="submit">Conferma modifiche</button>
					</form> 
               </div>
            </div>
<% 
break;
      }
   }
%>










<%@include file="includes/footer.jsp"%>
<script src="js/controlliCateg.js" type="text/javascript"></script>
</body>
