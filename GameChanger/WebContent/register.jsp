<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/head.jsp"%>
<title>Pagina Registrazione</title>
<link rel="stylesheet" href="css/register.css">
<link rel="stylesheet" href="css/topbar.css">
</head>
<body>
<%@include file="includes/topbar.jsp"%>
<div class="cont">
	<div class="center">
		<h1>Registrati</h1>
		<form method="post">
			<div class="txt_field">
				<input type="text" required> <span></span> <label>Username</label>

			</div>
			<div class="txt_field">
				<input type="password" required> <span></span> <label>Password</label>
			</div>
			<div class="txt_field">
				<input type="password" required> <span></span> <label>Ripeti
					Password</label>
			</div>
			<div class="nome">
				<div class="txt_field">
					<input type="text" required> <span></span> <label>Nome</label>
				</div>
				<div class="nome">
					<div class="txt_field">
						<input type="text" required> <span></span> <label>Cognome</label>
					</div>
					<div class="data">
						<div class="txt_field">
							<input type="text" required> <span></span> <label>Data
								di nascita</label>
						</div>
						<div class="email">
							<div class="txt_field">
								<input type="text" required> <span></span> <label>E-mail</label>
							</div>
							<label class="checkbox"> <input type="checkbox">
								<span class="checkmark"></span> <span class="text">Privacy</span>
							</label> <input type="submit" value="Registrati">
							<div class="signup_link">
								Già iscritto? <a href="#">Accedi</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	</div>
	<%@include file="includes/footer.jsp"%>
</body>
</html>