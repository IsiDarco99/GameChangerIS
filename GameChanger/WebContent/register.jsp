<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="IT">
<head>
<title>GameChanger</title>
<%@include file="includes/head.jsp"%>
<link rel="stylesheet" href="css/register.css">
<link rel="stylesheet" href="css/topbar.css">
</head>
<body>
<%@include file="includes/topbar.jsp"%>
<div class="cont">
	<div class="center">
		<h1>Registrati</h1>
		<form id="registerForm" action="user-register" method="post" onsubmit="return validateForm()">
			<div class="txt_field">
				<input type="text" name="nuovousername" required onblur="validateUsername()"> <span></span> <label>Username</label>
			</div>
			<p id="errorUsername" style="color: red;"></p>
			<div class="txt_field">
				<input type="password" name="password" required onblur="validatePassword()"> <span></span> <label>Password</label>
			</div>
			<p id="errorPassword" style="color: red;"></p>
			<div class="txt_field">
				<input type="password" name="ripetipassword" required onblur="validatePasswordRepeat()"> <span></span> <label>Ripeti
					Password</label>
			</div>
			<p id="errorPasswordRepeat" style="color: red;"></p>
			<div class="nome">
				<div class="txt_field">
					<input type="text" name="nome" required onblur="validateNome()"> <span></span> <label>Nome</label>
				</div>
				<p id="errorNome" style="color: red;"></p>
				<div class="nome">
					<div class="txt_field">
						<input type="text" name="cognome" required onblur="validateCognome()"> <span></span> <label>Cognome</label>
					</div>
					<p id="errorCognome" style="color: red;"></p>
					<div class="data">
						<div class="txt_field-2">
							<input type="text" name="datanascita" required onblur="validateData()"> <span></span> <label>Data di nascita (YYYY-MM-DD)</label>
						</div>
						<p id="errorData" style="color: red;"></p>
						<div class="email">
							<div class="txt_field">
								<input type="text" name="emailPers" required onblur="validateMail()"> <span></span> <label>E-mail</label>
							</div>
							<p id="errorMail" style="color: red;"></p>
							<label class="checkbox"> <input type="checkbox" name="privacy">
								<span class="checkmark"></span> <a href="privacy.jsp">Privacy</a>
								
							</label>
							<label class="checkbox"> <input type="checkbox" name="terms">
								<span class="checkmark"></span> <a href="termini.jsp">Termini e condizioni</a>
								
							</label>
							<p id="errorPrivacy" style="color: red;"></p>
							<p id="errMex" style="color: red;"></p>
							 <input type="submit" value="Registrati">
							<div class="signup_link">
								Già  iscritto? <a href="login.jsp">Accedi</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</form>
	</div>
	</div>
	
	<%@include file="includes/footer.jsp"%>
	<script src="js/controlliRegistra.js" type="text/javascript"></script>
</body>
</html>