<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="cn.gamechanger.model.User" %>
<%@ page import="cn.gamechanger.servlet.profiloservlet" %>

<% User user = (User) request.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<title>GameChanger</title>
<%@include file="includes/head.jsp"%>
<link rel="stylesheet" href="css/modifica.css" type="text/css">
</head>
<body>
<%@include file="includes/topbar.jsp"%>

<%
   String modifica = (String) request.getAttribute("modifica");
   if (modifica != null) {
      switch (modifica) {
         case "username":
%>
            <div class="container">
               <div class="blocco">
               <form action="modifica-dati" method="post">
                  <h2><strong>Modifica Username</strong></h2>
                  <p>Vecchio Username: ${user.username}</p>
                  <p>Nuovo Username: <input type="text" name="nuovousername"></p>
                  <button type="submit">Salva modifiche</button>
                  </form>
               </div>
            </div>
<%
            break;

         case "password":
%>
            <div class="container">
  <div class="blocco">
    <form action="modifica-dati" method="post" onsubmit="return validatePassword()">
      <h2><strong>Modifica Password</strong></h2>
      <p>Vecchia Password: <input type="password" name="vecchiapassword"></p>
      <p>Nuova Password: <input type="password" name="nuovapassword"></p>
      <p>Ripeti Nuova Password: <input type="password" name="ripetipassword"></p>
      <p id="error" style="color: red;"></p>
      <button type="submit">Salva modifiche</button>
    </form>
  </div>
</div>
<%
            break;
     
         case "immagine":
%>
            <div class="container">
               <div class="blocco">
               <form action="modifica-dati" method="post">
                  <h2><strong>Modifica Icona profilo</strong></h2>
                  <p>Scegli l'icona che preferisci!</p>
                  <div class="container-img">
                  <div class="container-img2">
                  <a href="#" onclick="submitFormMario('${pageContext.request.contextPath}/modifica-dati')">
                  	<img src="imgs/profilo/mario.png" alt="Super Mario">
                  </a>
                  <a href="#" onclick="submitFormPeach('${pageContext.request.contextPath}/modifica-dati')">
                  	<img src="imgs/profilo/peach.jpg" alt="Principessa Peach">
                  </a>
                  <a href="#" onclick="submitFormHunter('${pageContext.request.contextPath}/modifica-dati')">
                  	<img src="imgs/profilo/hunter.png" alt="Monster Hunter">
                  </a>
                  <a href="#" onclick="submitFormKratos('${pageContext.request.contextPath}/modifica-dati')">
                  	<img src="imgs/profilo/godOfWar.jpg" alt="Kratos">
                  </a>
                  </div>
                  <div class="container-img2">
                  <a href="#" onclick="submitFormCody('${pageContext.request.contextPath}/modifica-dati')">
                  	<img src="imgs/profilo/cody.jpg" alt="Cody">
                  </a>
                  <a href="#" onclick="submitFormMay('${pageContext.request.contextPath}/modifica-dati')">
                  	<img src="imgs/profilo/may.jpg" alt="May">
                  </a>
                  <a href="#" onclick="submitFormLink('${pageContext.request.contextPath}/modifica-dati')">
                  	<img src="imgs/profilo/link.jpg" alt="Link">
                  </a>
                  <a href="#" onclick="submitFormZoro('${pageContext.request.contextPath}/modifica-dati')">
                  	<img src="imgs/profilo/zoro.jpg" alt="Zoro">
                  </a>
                  </div>
                  </div>
               </form>
               </div>
            </div>
 <% 
        break;
 
         case "mail":
        	 %>
        	             <div class="container">
        	                <div class="blocco">
        	                <form action="modifica-dati" method="post">
        	                   <h2><strong>Modifica E-mail</strong></h2>
        	                   <p>Vecchia E-mail: </p>
        	                   <p>Nuova E-mail: <input type="text" name="nuovamail"></p>
        	                    <button type="submit">Salva modifiche</button>
        	                </form>
        	                </div>
        	             </div>
<% 
        	  break;
         case "paypal":
        	 %>
        	             <div class="container">
        	                <div class="blocco">
        	                <form action="modifica-dati" method="post">
        	                   <h2><strong>Modifica E-mail Paypal</strong></h2>
        	                   <p>Vecchia E-mail Paypal: </p>
        	                   <p>Nuova E-mail Paypal: <input type="text" name="nuovamailpaypal"></p>
        	                   <button type="submit">Salva modifiche</button>
        	                </form>
        	                </div>
        	             </div>
<% 
     break;
         case "numero":
        	 %>
        	             <div class="container">
        	                <div class="blocco">
        	                <form action="modifica-dati" method="post">
        	                   <h2><strong>Modifica Numero di telefono</strong></h2>
        	                   <p>Vecchio Numero di telefono: </p>
        	                   <p>Nuovo Numero di telefono: <input type="text" name="nuovonum"></p>
        	                    <button type="submit">Salva modifiche</button>
        	                </form>
        	                </div>
        	             </div>
<% 
      break;
         case "indirizzo":
        	 %>
        	             <div class="container">
        	                <div class="blocco">
        	                <form action="modifica-dati" method="post">
        	                   <h2><strong>Modifica Indirizzo</strong></h2>
        	                   <p>Vecchio Indirizzo: </p>
        	                   <p>Nuovo Stato: <input type="text" name="nuovoStato"></p>
        	                   <p>Nuova città: <input type="text" name="nuovaCitta"></p>
        	                   <p>Nuova via: <input type="text" name="nuovaVia"></p>
        	                   <p>Nuovo CAP: <input type="text" name="nuovoCAP"></p>
        	                  <button type="submit">Salva modifiche</button>
        	               </form>
        	                </div>
        	             </div>
<% 
     break;
         default:
            break;
      }
   }
%>

<%@include file="includes/footer.jsp"%>
<script src="js/modificaImmagine.js" type="text/javascript"></script>
</body>
</html>
