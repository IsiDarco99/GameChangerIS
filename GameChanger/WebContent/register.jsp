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
		<form action="user-register" method="post">
			<div class="txt_field">
				<input type="text" name="username" required> <span></span> <label>Username</label>

			</div>
			<div class="txt_field">
				<input type="password" name="password" required> <span></span> <label>Password</label>
			</div>
			<div class="txt_field">
				<input type="password" required> <span></span> <label>Ripeti
					Password</label>
			</div>
			<div class="nome">
				<div class="txt_field">
					<input type="text" name="nome" required> <span></span> <label>Nome</label>
				</div>
				<div class="nome">
					<div class="txt_field">
						<input type="text" name="cognome" required> <span></span> <label>Cognome</label>
					</div>
					<div class="data">
						<div class="txt_field">
							<input type="text" name="dataNascita" required> <span></span> <label>Data
								di nascita</label>
						</div>
						<div class="email">
							<div class="txt_field">
								<input type="text" name="emailPers" required> <span></span> <label>E-mail</label>
							</div>
							<label class="checkbox"> <input type="checkbox">
								<span class="checkmark"></span> <span class="text">Privacy</span>
							</label> <input type="submit" value="Registrati">
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
</body>
</html>