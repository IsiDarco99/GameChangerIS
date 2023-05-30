<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>GameChanger</title>
<link rel="stylesheet" href="css/Login.css">
<%@include file="includes/head.jsp"%>
</head>
<body>
<div class="logo">
<img src="imgs/logo.png" alt="Logo" height="90">
</div>

<div class="center"> 
		<h1>Login</h1>
		<form method="post"> 
		<div class="txt_field">
		<input type="text" required>
		<span></span>
		 <label>Username</label>
	</div> 
	<div class="txt_field">
	<input type="password" required>
	<span></span>
	<label>Password</label>
	</div>
	<div class="pass">Password Dimenticata? </div>
	<input type="submit" value="Login">
	<div class="signup_link">
		Non iscritto? <a href="#">Iscriviti</a>
	</div>
	</form>

</body>
</html>