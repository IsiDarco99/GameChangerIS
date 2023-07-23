<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
<title>GameChanger</title>
<%@include file="includes/head.jsp"%>
<link rel="stylesheet" href="css/modifica.css" type="text/css">
</head>
<body>
<%@include file="includes/topbar.jsp"%>
</head>
<body>
 <div class="container">
               <div class="blocco">
                  <h2><strong>Prodotto aggiunto al database</strong></h2>
                  <img class="pagamento" src="imgs\icone\successo.png" alt="pagamento">
                  <p>Torna alla <a href="#" onclick="submitForm('${pageContext.request.contextPath}/get-admin')">pagina amministratore</a></p>
                  
               </div>
            </div>
<%@ include file="includes/footer.jsp"%>
</body>
</html>