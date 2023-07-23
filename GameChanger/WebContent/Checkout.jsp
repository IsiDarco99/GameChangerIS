<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cn.gamechanger.model.User" %>
<%@ page import="cn.gamechanger.servlet.profiloservlet" %>

<% User user = (User) request.getAttribute("user"); %>
<!DOCTYPE html>
<html lang="it">
<head> 
<meta charset="ISO-8859-1">
<title>GameChanger</title>
<script src="check.js"></script>
<head>
<title>GameChanger</title>
<%@include file="includes/head.jsp"%>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;1,200&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/checkout.css">
<link rel="stylesheet" href="css/topbar.css">
</head>

<body>

<%@include file="includes/topbar.jsp"%>
  <div class="container-total">
    <div class="container-fluid">
      <!--barra di esperienza-->
      <section class="step-wizard">
        <ul class="step-wizard-list">
          <li class="step-wizard-item current-item ">
            <span class="progress-count">1</span>
            <span class="progress-label">Informazioni di spedizione</span>
          </li>
          <li class="step-wizard-item ">
            <span class="progress-count">2</span>
            <span class="progress-label">Pagamento</span>
          </li>
        
          <li class="step-wizard-item ">
            <span class="progress-count">3</span>
            <span class="progress-label">Checkout</span>
          </li>
    
          <li class="step-wizard-item">
            <span class="progress-count">4</span>
            <span class="progress-label">Ordine confermato</span>
          </li>
        </ul>
        </section>
      
    </div> 
  </div>
  
  <fieldset>
  <legend>Informazioni di spedizione</legend>
      <div class="row">
        <div class="col-75">
          <div class="container">
            <form id="myForm" action="/GameChanger/checkout-2" method="post">
  <div class="row">
    <div class="col-50">
      <label for="fname"><i class="fa fa-user"></i> Nome Completo</label>
      <input type="text" id="fname" name="firstname" value="${user.nome} ${user.cognome}" onblur="validateNome()">
      <span id="errorNome" style="color: red;" class="error"></span>

      <label for="email"><i class="fa fa-envelope"></i> Email</label>
      <input type="text" id="email" name="email" value="${user.emailPers}" onblur="validateEmail()">
      <span id="errorEmail" style="color: red;" class="error"></span>

      <h3><b> Indirizzo</b></h3>
      <label for="adr"><i class="fa fa-address-card-o"></i> Indirizzo</label>
      <input type="text" id="adr" name="address" value="${user.indirizzo}" onblur="validateIndirizzo()">
      <span id="errorIndirizzo" style="color: red;" class="error"></span>

      <label for="city"><i class="fa fa-institution"></i> Città</label>
      <input type="text" id="city" name="city" value="${user.citta}" onblur="validateCitta()">
      <span id="errorCitta" style="color: red;" class="error"></span>

      <div class="row">
        <div class="col-50">
          <label for="state">Stato</label>
          <input type="text" id="state" name="state" value="${user.stato}" onblur="validateStato()">
          <span id="errorStato" style="color: red;" class="error"></span>
        </div>
        <div class="col-50">
          <label for="zip">Codice Postale</label>
          <input type="text" id="zip" name="zip" value="${user.cod_postale}" onblur="validateCodicePostale()">
          <span id="errorCodicePostale" style="color: red;" class="error"></span>
        </div>
      </div>
    </div>
  </div>

  <label>
    <input type="checkbox" checked="checked" name="salva-dati"> Salva informazioni di spedizione per i prossimi acquisti
  </label>
  <input type="submit" id="submitBtn" value="Continua" class="btn">
</form>

          </div>
        </div>
       </div>
  </fieldset>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<%@include file="includes/footer.jsp"%>
	<script src="js/controlliCheckout.js" type="text/javascript"></script>
</body>
</html>
