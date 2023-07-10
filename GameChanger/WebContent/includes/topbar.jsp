<link rel="stylesheet" type="text/css" href="css\topbar.css"/>
<div class="top-bar">
	<div class="logo">
		<a href="homepage.jsp"><img src="imgs/generale/logo.png" alt="Home" height="60"></a>
	</div>
	<div class="icons">
		<% if (session.getAttribute("userSession") == null) {
				if (session.getAttribute("adminSession") == null) { %>
					<a href="login.jsp"><img src="imgs/generale/account.png" alt="Account" height="40"></a>
				<%} else if (session.getAttribute("adminSession") != null) {%>
					<a href="#" onclick="submitForm('${pageContext.request.contextPath}/get-admin')"><img src="imgs/generale/account.png" alt="Account" height="40"></a>
					<a href="#" onclick="logout()"><img src="imgs/generale/logout.png" alt="Logout" height="40"></a>
				<%}
		  } else if (session.getAttribute("userSession") != null) {%>
			<a href="#" onclick="submitForm('${pageContext.request.contextPath}/dati-profilo')"><img src="imgs/generale/account.png" alt="Account" height="40"></a>
			<a href="#" onclick="submitForm('${pageContext.request.contextPath}/mostra-carrello')"><img src="imgs/generale/carrello.jpg" alt="Carrello" height="40"></a>
			<a href="#" onclick="logout()"><img src="imgs/generale/logout.png" alt="Logout" height="40"></a>
		<%} %>
	</div>
</div>