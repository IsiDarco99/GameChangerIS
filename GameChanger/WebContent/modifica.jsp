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
                  <p>Vecchio Username</p>
                  <p>Nuovo Username</p>
                  <button>Salva modifiche</button>
               </div>
            </div>
<%
            break;

         case "password":
%>
            <div class="container">
               <div class="blocco">
                  <h2><strong>Modifica Password</strong></h2>
                  <p>Vecchia Password</p>
                  <p>Nuova Password</p>
                  <p>Ripeti Nuova Password</p>
                  <button>Salva modifiche</button>
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
                  <button>Salva modifiche</button>
               </div>
            </div>
 <% 
        break;
 
         case "mail":
        	 %>
        	             <div class="container">
        	                <div class="blocco">
        	                   <h2><strong>Modifica E-mail</strong></h2>
        	                   <p>Vecchia E-mail</p>
        	                   <p>Nuova E-mail</p>
        	                   <button>Salva modifiche</button>
        	                </div>
        	             </div>
<% 
        	  break;
         case "paypal":
        	 %>
        	             <div class="container">
        	                <div class="blocco">
        	                   <h2><strong>Modifica E-mail Paypal</strong></h2>
        	                   <p>Vecchia E-mail Paypal</p>
        	                   <p>Nuova E-mail Paypal</p>
        	                   <button>Salva modifiche</button>
        	                </div>
        	             </div>
<% 
     break;
         case "numero":
        	 %>
        	             <div class="container">
        	                <div class="blocco">
        	                   <h2><strong>Modifica Numero di telefono</strong></h2>
        	                   <p>Vecchio Numero di telefono</p>
        	                   <p>Nuovo Numero di telefono</p>
        	                   <button>Salva modifiche</button>
        	                </div>
        	             </div>
<% 
      break;
         case "indirizzo":
        	 %>
        	             <div class="container">
        	                <div class="blocco">
        	                   <h2><strong>Modifica Indirizzo di spedizione</strong></h2>
        	                   <p>Vecchio Indirizzo di spedizione</p>
        	                   <p>Nuovo Indirizzo di spezidione</p>
        	                   <button>Salva modifiche</button>
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
