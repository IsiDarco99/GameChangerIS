<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="cn.gamechanger.model.*"%>
<%@page import="cn.gamechanger.servlet.InserisciCategoria" %>
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
   String categoria = request.getParameter("categoria");

   if (categoria != null) {
      switch (categoria) {
         case "videogame":
%>

<div class="container">
               <div class="blocco">
               
                  
                  
                  <h2><strong>Videogioco</strong></h2>
                  <form action="Inserisci-Categoria" method="post" onsubmit="return validateFormVideogame()">
                  	 <input type="hidden" name="categoria" value="videogame">
                    <p>Pegi:<br> <select name="pegi" >
                    <option value="3">3</option>
                    <option value="7">7</option>
                    <option value="12">12</option>
                    <option value="16">16</option>
                    <option value="18">18</option>
                </select></p> 
                    <p>Sviluppatore:<br> <input type="text" name="sviluppatore" required onblur="validateSvilupp()"></p>
                    <p id="errorSvilupp" style="color: red;"></p>
                    <p>Genere:<br> <input type="text" name="genere" required onblur="validateGenere()"></p>                
                  	<p id="errorGenere" style="color: red;"></p>
                  <button type="submit">Avanti</button>
                  </form>
               </div>
            </div>
<%
            break;
     
         case "accessori":
        	 %>
<div class="container">
               <div class="blocco">
               
                   
                  <h2><strong>Accessori</strong></h2>
                  <form action="Inserisci-Categoria" method="post" onsubmit="return validateFormAccessori()">
                  <input type="hidden" name="categoria" value="accessori">
                    <p>Tipologia:<br> <input type="text" name="tipo" required onblur="validateTipo()"></p>
                    <p id="errorTipo" style="color: red;"></p>
                  <button type="submit">Avanti</button>
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
                  <form action="Inserisci-Categoria" method="post" onsubmit="return validateFormGen()">
                  <input type="hidden" name="categoria" value="console">
                    <p>Generazione:<br> <input type="text" name="generazione" required onblur="validateGen()"></p>                                   
                  	<p id="errorGen" style="color: red;"></p>
                  <button type="submit">Avanti</button>
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
                  <form action="Inserisci-Categoria" method="post" onsubmit="return validateFormComputer()">
                  <input type="hidden" name="categoria" value="computer">
                    <p>Categoria:<br> 
                    <input type="checkbox" name="casa" value="casa">Casa
                    <input type="checkbox" name="ufficio" value="ufficio">Ufficio
                    <input type="checkbox" name="gaming" value="gaming">Gaming</p>                
                  <button type="submit">Avanti</button>
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
</html>