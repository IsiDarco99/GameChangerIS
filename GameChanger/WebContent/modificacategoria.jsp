<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="cn.gamechanger.model.*"%>
<%@page import="cn.gamechanger.servlet.InserisciCategoria" %>
<!DOCTYPE html>
<html>

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
                  <form action="Inserisci-Categoria" method="post">
                    <p>Pegi:</p>
                    <div class="radio">
					  <label><input type="radio" name="pegi" value="3"> 3</label><br>
					  <label><input type="radio" name="pegi" value="7"> 7</label><br>
					  <label><input type="radio" name="pegi" value="12"> 12</label><br>
					  <label><input type="radio" name="pegi" value="16"> 16</label><br>
					  <label><input type="radio" name="pegi" value="18"> 18</label><br>
					</div>
                    <p>Sviluppatore:<br> <input type="text" name="sviluppatore"></p>
                    <p>Genere:<br> <input type="text" name="genere"></p>                
                  <button type="submit">Inserisci prodotto</button>
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
                    <p>Tipologia:<br> <input type="text" name="tipo"></p>                                   
                  <button type="submit">Inserisci prodotto</button>
                  
               </div>
            </div>

<%
            break;
     
         case "console":
        	 %>
<div class="container">
               <div class="blocco">
               
                   
                  <h2><strong>Console</strong></h2>
                    <p>Generazione:<br> <input type="text" name="generazione"></p>                                   
                  <button type="submit">Inserisci prodotto</button>
                  
               </div>
            </div>

<%
            break;
     
         case "computer":
        	 %>
<div class="container">
               <div class="blocco">
               
                   
                  <h2><strong>Computer</strong></h2>
                    <p>Casa:<br> <input type="text" name="casa"></p>
                    <p>Ufficio:<br> <input type="text" name="ufficio"></p>
                    <p>Gaming:<br> <input type="text" name="gaming"></p>                
                  <button type="submit">Inserisci prodotto</button>
                  
               </div>
            </div>
<% 
break;
      }
   }
%>










<%@include file="includes/footer.jsp"%>
</body>
</html>