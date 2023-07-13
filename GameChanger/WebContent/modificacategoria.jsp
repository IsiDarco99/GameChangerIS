<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="cn.gamechanger.model.*"%>
<%@page import="cn.gamechanger.servlet.getAdminServlet" %>
<% Amministratore admin = (Amministratore) request.getAttribute("admin"); %>
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
                    <p>Pegi:<br> <input type="text" name="pegi"></p>
                    <p>Sviluppatore:<br> <input type="text" name="sviluppatore"></p>
                    <p>Genere:<br> <input type="text" name="genere"></p>                
                  <button type="submit">Inserisci prodotto</button>
                  
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