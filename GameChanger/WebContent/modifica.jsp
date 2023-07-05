<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
   String modifica = request.getParameter("modifica");

   if (modifica != null) {
      switch (modifica) {
         case "username":
%>
            <div class="container">
               <div class="blocco">
                  <h2><strong>Modifica Username</strong></h2>
                  <p>Vecchio Username: </p>
                  <p>Nuovo Username: <input type="text" name="nuovousername"></p>
                  <button type="submit">Salva modifiche</button>
               </div>
            </div>
<%
            break;

         case "password":
%>
            <div class="container">
               <div class="blocco">
                  <h2><strong>Modifica Password</strong></h2>
                  <p>Vecchia Password: <input type="password" name="vecchiapassword"></p>
                  <p>Nuova Password: <input type="password" name="nuovapassword"></p>
                  <p>Ripeti Nuova Password: <input type="password" name="ripetipassword"></p>
                   <button type="submit">Salva modifiche</button>
               </div>
            </div>
<%
            break;
     
         case "immagine":
%>
            <div class="container">
               <div class="blocco">
                  <h2><strong>Modifica Icona profilo</strong></h2>
                  <p>Scegli l'icona che preferisci!</p>
                   <button type="submit">Salva modifiche</button>
               </div>
            </div>
 <% 
        break;
 
         case "mail":
        	 %>
        	             <div class="container">
        	                <div class="blocco">
        	                   <h2><strong>Modifica E-mail</strong></h2>
        	                   <p>Vecchia E-mail: </p>
        	                   <p>Nuova E-mail: <input type="text" name="nuovamail"></p>
        	                    <button type="submit">Salva modifiche</button>
        	                </div>
        	             </div>
<% 
        	  break;
         case "paypal":
        	 %>
        	             <div class="container">
        	                <div class="blocco">
        	                   <h2><strong>Modifica E-mail Paypal</strong></h2>
        	                   <p>Vecchia E-mail Paypal: </p>
        	                   <p>Nuova E-mail Paypal: <input type="text" name="nuovamailpaypal"></p>
        	                   <button type="submit">Salva modifiche</button>
        	                </div>
        	             </div>
<% 
     break;
         case "numero":
        	 %>
        	             <div class="container">
        	                <div class="blocco">
        	                   <h2><strong>Modifica Numero di telefono</strong></h2>
        	                   <p>Vecchio Numero di telefono: </p>
        	                   <p>Nuovo Numero di telefono: <input type="text" name="nuovonum"></p>
        	                    <button type="submit">Salva modifiche</button>
        	                </div>
        	             </div>
<% 
      break;
         case "indirizzo":
        	 %>
        	             <div class="container">
        	                <div class="blocco">
        	                   <h2><strong>Modifica Indirizzo di spedizione</strong></h2>
        	                   <p>Vecchio Indirizzo di spedizione: </p>
        	                   <p>Nuovo Indirizzo di spezidione: <input type="text" name="nuovoindirizzo"></p>
        	                  <button type="submit">Salva modifiche</button>
        	                </div>
        	             </div>
<% 
     break;
         default:
            // Nessuna opzione valida, mostra un messaggio di errore o gestisci in altro modo
            break;
      }
   }
%>

<%@include file="includes/footer.jsp"%>
</body>
</html>
