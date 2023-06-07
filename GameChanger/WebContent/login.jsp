<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="IT">
<head>
<title>GameChanger</title>
<%@include file="includes/head.jsp"%>
<link rel="stylesheet" href="css/login.css" type="text/css">
<link rel="stylesheet" href="css/topbar.css">
</head>
<body>
<!-- commento -->
	<%@include file="includes/topbar.jsp"%>
	<div class="container">
	<div class="center">
		<h1>Login</h1>
		<form action="user-login" method="post">
			<div class="txt_field">
				<input type="text" name="login-username" required> <span></span>
				<label>Username</label>
			</div>
			<div class="txt_field">
				<input type="password" name="login-password" required> <span></span>
				<label>Password</label>
			</div>
			<div class="pass">Password Dimenticata?</div>
			<input type="submit" value="Login">
			<div class="signup_link">
				Non iscritto? <a href="#">Iscriviti</a>
			</div>
		</form>
	</div>
	</div>
	
	<%@include file="includes/footer.jsp"%>
</body>
</html>