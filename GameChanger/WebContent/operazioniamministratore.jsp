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
   String modifica = (String) request.getParameter("modifica");
   if (modifica != null) {
      switch (modifica) {
         case "inserisci":
%>


<div class="container">
               <div class="blocco">
               
                  
                  <h2><strong>Inserisci nuovo prodotto</strong></h2>
                  <form action="Inserisci-Prodotto" method="post">
                  <p>Categoria:<br> <select name="categoria" >
                    <option value="videogame">Videogame</option>
                    <option value="accessori">Accessori</option>
                    <option value="console">Console</option>
                    <option value="computer">Computer</option>
                </select></p>                                     
                       <p>Nome:<br> <input type="text" name="nomeprodotto"></p>
                        <p>Prezzo:<br> <input type="text" name="prezzoprodotto"></p>                       
                         <p>Marca:<br> <input type="text" name="marcaprodotto"></p>
                          <p>Data di uscita:<br> <input type="text" name="data_usc"></p>
                           <p>Descrizione:<br> <textarea name="descrizioneprodotto" rows="10" cols="50"></textarea></p>                                        
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
               
                  
                  <h2><strong>Modifica prodotto</strong></h2>
                  
                        <p>Nome attuale:</p>             
                       <p>Nome:<br> <input type="text" name="nomeprodotto"></p>
                       <p>Prezzo attuale:</p>
                        <p>Prezzo:<br> <input type="text" name="prezzoprodotto"></p> 
                        <p>Marca attuale:</p>                      
                         <p>Marca:<br> <input type="text" name="marcaprodotto"></p>
                         <p>Data di uscita attuale:</p>
                          <p>Data di uscita:<br> <input type="text" name="data_usc"></p>
                          <p>Descrizione attuale:</p>
                           <p>Descrizione:<br> <input type="text" name="descrizioneprodotto"></p>                                        
                  <button type="submit">Aggiungi prodotto</button>
                  
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
</body>
</html>