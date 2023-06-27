<style>
.top-bar {
	position: relative;
	z-index: 9999;
	color: #fff;
	height: 70px;
	display: flex;
	align-items: center;
	justify-content: space-between;
	padding: 0 20px;
	justify-content: space-between;
}

.icons img {
	padding-right: 30px;
}
</style>

<div class="top-bar">
	<div class="logo">
		<a href="homepage.jsp"><img src="imgs/generale/logo.png" alt="Home" height="90"></a>
	</div>
	<div class="icons">
		<% if (session.getAttribute("userSession") == null) { %>
			<a href="login.jsp"><img src="imgs/generale/account.png" alt="Account" height="40"></a>
		<% } else { %>
			<a href="profilo.jsp"><img src="imgs/generale/account.png" alt="Account" height="40"></a>
			<a href="carrello.jsp"><img src="imgs/generale/carrello.jpg" alt="Carrello" height="40"></a>
			<a href="#" onclick="logout()"><img src="imgs/generale/logout.png" alt="Logout" height="40"></a>
		<% } %>
	</div>
</div>



<script>
  function logout() {
    var form = document.createElement('form');
    form.method = 'POST';
    form.action = 'user-logout';

    document.body.appendChild(form);
    form.submit();
  }
</script>