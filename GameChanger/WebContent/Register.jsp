<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>Pagina Registrazione</title>
<link rel="stylesheet" href="Register.css">
</head>
<body>
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
		</form>
</body>
</html>