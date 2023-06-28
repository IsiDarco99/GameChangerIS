<style>
.navbar {
	position: fixed !important;
	z-index: 9999;
	top: 80px;
	margin-left: 10px;
	background-color: #333;
	color: #fff;
	width: 60px; /* Imposta la larghezza desiderata */
	max-height: calc(100vh - 50px);
	/* Utilizza max-height invece di height */
	display: flex;
	align-items: center;
	justify-content: space-between;
	flex-direction: column;
	border-radius: 50px;
}

.navbar ul {
	padding: 5px 0px;
	list-style-type: none;
}

.navbar ul li {
	margin: 0px 10px 30px;
}
</style>

<div class="navbar">
	<ul>
		<li><a href="#"><img src="imgs/generale/search.png" alt="search"
				height="40"></a></li>
		<li><a href="sfogliaProdotti.jsp?categoria=allProdotti"><img src="imgs/generale/computer.png" alt="computer"
				height="40"></a></li>
		<li><a href="#"><img src="imgs/generale/console.png" alt="console"
				height="40"></a></li>
		<li><a href="#"><img src="imgs/generale/videogame.png" alt="videogame"
				height="40"></a></li>
		<li style="margin: 0px 10px 0px;"><a href="#"><img
				src="imgs/generale/gadget.png" alt="gadget" height="40"></a></li>
	</ul>
</div>