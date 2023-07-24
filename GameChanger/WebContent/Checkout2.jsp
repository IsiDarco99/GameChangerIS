<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cn.gamechanger.model.User" %>
<%@ page import="cn.gamechanger.servlet.profiloservlet" %>

<% User user = (User) request.getAttribute("user"); %>
<!DOCTYPE html>
<html lang="IT">
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
	<%@include file="includes/topbar.jsp"%>
	<div class="container-total">
    <div class="container-fluid">
      <!--barra di esperienza-->
      <section class="step-wizard">
        <ul class="step-wizard-list">
          <li class="step-wizard-item  ">
            <span class="progress-count">1</span>
            <span class="progress-label">Informazioni di spedizione</span>
          </li>
          <li class="step-wizard-item current-item">
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

	<!--payment-->
	<fieldset>
		<legend>Pagamento</legend>
		<div class="col-75">
			<div class="container">
			<form id="myForm" action="Checkout4-Servlet" method="post">
  <div class="col-50">
    <h3><b>Pagamento</b></h3>
    <label for="fname">Pagamenti accettati</label>
    <div class="icon-container">
      <i class='fa fa-paypal'></i>
    </div>
    <label for="cname">E-mail PayPal</label>
    <input type="text" id="cname" name="emailPayPal" value="${user.emailPaypal}" onblur="validateEmailPayPal()">
    <span id="errorEmailPayPal" style="color: red;" class="error"></span>
  </div>

  <label>
    <input type="checkbox" checked="checked" name="salva-dati"> Salva e-mail PayPal per i prossimi acquisti
  </label>
  <input type="submit" id="submitBtn" value="Continua" class="btn">
</form>

			</div>
		</div>
	</fieldset>


	<%@include file="includes/footer.jsp"%>
	<script src="js/checkout2.js" type="text/javascript"></script>
</body>
</html>
