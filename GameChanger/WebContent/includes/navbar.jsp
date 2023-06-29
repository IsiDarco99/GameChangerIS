<head>
  <script type="text/javascript" src="
	http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script type="text/javascript" src="js/navbar.js"></script>
</head>
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
	display: none; /*deve essere flex*/
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
/*   barra ricerca   */
.togglesearch{
	background: #333;
    position: absolute;
    top: 11px;
    right: -338px;
    width: 350px;
    height: 37px;
    line-height: 60px;
    box-shadow: 0 0 10px rgba(0,0,0,0.5);
    border-top: 4px solid #D80B15;
    border-radius: 0px 50px 50px 0px;
    display: none;
  }
  .togglesearch:before{
    content: "";
    position: absolute;
    top: -32px;
    right: 13px;
    border-left: 12px solid transparent;
    border-right: 12px solid transparent;
    border-top: 14px solid transparent;
    border-bottom: 14px solid #D80B15;
  }
   
  .togglesearch input[type="text"]{
    width: 200px;
    padding: 5px 10px;
    margin-left: 23px;
    border: 1px solid #D80B15;
    outline: none;
  }
   
  .togglesearch input[type="button"]{
    width: 80px;
    padding: 5px 0;
    background: #D80B15;
    color: #fff;
    margin-left: -6px;
    border: 1px solid #D80B15;
    outline: none;
    cursor: pointer;
  }
/*------    openbar nuova aggiunta     --------*/
@keyframes animazioneAltezza {
  from {
    height: 60px;
  }
  to {
    height: 364px;
  }
}
@keyframes animazioneRitorno {
  from {
    height: 364px;
  }
  to {
    height: 60px;
  }
}

.OpenNavbar{
	background-color: #D80B15;
	position: fixed !important;
  z-index: 9999;
  top: 80px;
  margin-left: 10px;
  background-color: #333;
  color: #fff;
  width: 60px;
  /*max-height: calc(100vh - 50px);*/
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  border-radius: 50px;
  height: 60px;
  transition-duration: 500ms;
  min-height: 40px;
}

.OpenNavbar.active {
  animation-name: animazioneAltezza;
  animation-duration: 250ms;
  animation-fill-mode: forwards;
  display: flex;
  min-height: 40px;
}
.OpenNavbar.active.chiusura{
  animation-name: animazioneRitorno;
  animation-duration: 250ms;
  animation-fill-mode: forwards;
  display: flex;
  height: 40px;
}
/* cambio per l'animazione
.OpenNavbar{
	background-color: #D80B15;
	position: fixed !important;
  z-index: 9999;
  top: 80px;
  margin-left: 10px;
  background-color: #333;
  color: #fff;
  width: 60px;
  <---max-height: calc(100vh - 50px);--->
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  border-radius: 50px;
  height: 50px;
  transition-duration: 500ms;
}

.OpenNavbar.active{
  height: 364px;
}
*/
.vetrina{
	border-radius: 50px;
	background-color: pink;
}

  /*             --------------         */
</style>

<script type="text/javascript" src="
http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<!--- bottone per l'apparizione della navbar-->
<div class="OpenNavbar" id="OpN">
	<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAAXNSR0IArs4c6QAAATdJREFUSEvtVokNwjAMvG7ABjACGwCTwCbAJjAJsAEjwAZsALLkqyzqNg5ElM9SJESdnH0+x6nQk1U94eJtgUcAZIntg+xM1e8EQJZrqYxXAJa6M+VLgKv+WAOQ/Z8FbKlm9BsAsqwtAMgSo99TVNvDuyjMLkmqbjbjnUaxbcl4rt9npcUVFHXtVkxcLwFmzwrVwzsKRUSklcFY+lmSs+lj9nYdfFuNKSSbJX2tkPjd0tq11wX2hFQKuCE4m7GXSSngBjM5wLni8vzrkvyBOYkOypNtp1yqbTtNdHOS6q7WiQbgtdhDwKl7nQF5w6TxX5u4vIy/D9gOc96t3oAXSi8AjsrtGMDAFN57MPDurx8RUfrkXHsHi+oZnBxK1Ypf6MyQk2bTG7AdbV1Uh57BORlH+zfk93vAN52uYh+h4fb9AAAAAElFTkSuQmCC" height="" />
</div>	
<!--                                        -->
<div class="navbar" id="123">
	<ul>
		<li><a href="#" class="ricerca"><img src="imgs/generale/search.png" alt="search"
				height="40"></a>
				<!--             tasto ricerca                -->
			<div class="togglesearch">
			   <input type="text" placeholder=""/>
			   <input type="button" value="Search"/>
			</div><!--              ---------                 -->
		<li><a href="${pageContext.request.contextPath}/mostra-tutti-prodotti?categoria=allProdotti">
<img src="imgs/generale/computer.png" alt="computer"
				height="40"></a></li>
		<li><a href="#"><img src="imgs/generale/console.png" alt="console"
				height="40"></a></li>
		<li><a href="#"><img src="imgs/generale/videogame.png" alt="videogame"
				height="40"></a></li>
		<li style="margin: 0px 10px 0px;"><a href="#"><img
				src="imgs/generale/gadget.png" alt="gadget" height="40"></a></li>
	</ul>
</div>

