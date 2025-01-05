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
	<%@include file="includes/topbar.jsp"%>
	<div class="container">
	<div class="center">
		<h1>Login</h1>
		<form id="loginForm" action="user-login" method="post" onsubmit="return validateForm()">
			<div class="txt_field">
				<input type="text" name="login-username" required onblur="validateUsername()"> <span></span>
				<label>Username</label>
			</div>
			<p id="errorUsername" style="color: red;"></p>
			<div class="txt_field">
				<input type="password" name="login-password" required onblur="validatePassword()"> <span></span>
				<label>Password</label>
			</div>
			<p id="errorPassword" style="color: red;"></p>
			<div class="pass">Password Dimenticata?</div>
			<input type="submit" value="Login">
			<div class="signup_link">
				Non iscritto? <a href="register.jsp">Iscriviti</a>
			</div>
		</form>
	</div>
	</div>

	
	<%@include file="includes/footer.jsp"%>
	<script src="js/controlliLogin.js" type="text/javascript"></script>
	<%
    String loginError = (String) request.getAttribute("loginError");
    if (loginError != null) {
        loginError = loginError.replace("'", "\\'"); // Escaping single quotes
%>
<script>
    window.addEventListener('DOMContentLoaded', function() {
        var errorMessage = '<%= loginError %>';
        if (errorMessage !== '') {
            alert(errorMessage);
        }
    });
</script>
<%
    }
%>
</body>
</html>