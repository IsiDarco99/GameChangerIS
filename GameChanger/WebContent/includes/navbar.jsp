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
.InfoNavBar{
  justify-content: center;
  background: #333;
  position: absolute;
  top: 99px;
  left: 53px;
  width: 125px;
  height: 37px;
  border-radius: 0px 50px 50px 0px;  
  box-shadow: 6.5px 5px 2px rgba(0,0,0,0.5);
  display: none;
}
p#infoName{
  padding-top: 6px;
}
/*   barra ricerca   */
.togglesearch {
    background: #333;
    position: absolute;
    top: 11px;
    left: 53px;
    width: 350px;
    height: 37px;
    /*line-height: 60px;*/
    box-shadow: 6.5px 5px 2px rgba(0,0,0,0.5);
    border-top: 4px solid #D80B15;
    border-radius: 0px 50px 50px 0px;
    display: none;
    /*   animazione */
    transition-duration: 200ms;

  }

  .togglesearch.active {
    position: absolute;
    top: 28px;
    left: 53px;
  animation-name:  ricercaAnim;
  animation-duration: 200ms;
  animation-fill-mode: forwards;
  display: flex;
  
}
  /*.togglesearch:before{
    content: "";
    position: absolute;
    top: -32px;
    right: 13px;
    border-left: 12px solid transparent;
    border-right: 12px solid transparent;
    border-top: 14px solid transparent;
    border-bottom: 14px solid #D80B15;
  }*/
   
  .togglesearch input[type="text"]{
    width: 264px;
    height: 32px;
    /*padding: 5px 10px;*/
    margin-left: 7px;
    border: 1px solid #D80B15;
    outline: none;
  }
   
  .togglesearch input[type="button"]{
    width: 86px;
    height: 32px;
    border-radius: 0px 50px 62px 0px;
    background: #D80B15;
    color: #fff;
    margin-left: -6px;
    border: 1px solid #D80B15;
    outline: none;
    cursor: pointer;
    display: none;
    /*padding: 5px 0;*/
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
@keyframes ricercaAnim {
  from{
    width: 0px;
  }
  to{
    width: 350px;
  }
  
}
@keyframes PopNav {
  from{
    width: 0px;
  }
  to{
    width: 125px;
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
img.navImg{
  border-radius:"50px";
 
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
		<li style="padding-top:13px; "><a href="#" class="ricerca"><img src="imgs\icone\ricerca.png" alt="search"
				height="40" style="border-radius:20px" ></a>
				<!--             tasto ricerca                -->
			<div class="togglesearch" id="barraRic">
			   <input type="text" placeholder=""/>
			   <input type="button" value="Search" id="BRic"/>
			</div><!--              ---------                 -->
		</li>
		<li>
      <a href="${pageContext.request.contextPath}/mostra-tutti-prodotti?categoria=allProdotti"><img src="imgs\icone\catalogoN.png" class="catalogoI" id="Cat" alt="catalogo"
				height="40" style="border-radius:20px" >
      </a>
      <div class="InfoNavBar" id="InNa1" > 
        <p id="infoName"> Catalogo</p>
      </div>
      <div class="InfoNavBar" id="InNa2" style="top: 168px;"> 
        <p id="infoName"> Console</p>
      </div>
      <div class="InfoNavBar" id="InNa3" style="top: 238px;"> 
        <p id="infoName"> videogame</p>
      </div>
      <div class="InfoNavBar" id="InNa4" style="top: 307px;" > 
        <p id="infoName"> Computer</p>
      </div>
      <div class="InfoNavBar" id="InNa5" style="top: 378px;" > 
        <p id="infoName"> Gadget</p>
      </div>
    </li>
		<li><a href="#"><img  src="imgs\icone\console.png" class= "navImg" id="Con" alt="console"height="40" style="border-radius:20px" 
				 ></a></li>
		<li><a href="#"><img  src="imgs\icone\videogame.svg" class= "navImg" id="Vid" alt="videogame"height="40"style="border-radius:20px"
				 ></a></li>
		<li style="margin: 0px 10px 30px;"><a href="#"><img src="imgs\icone\computerNav.png"  class= "navImg" id="Com"
      alt="Computer" height="40" style="border-radius:20px"></a>
    </li>
    <li style="margin-bottom: 6px;"><a href="#"><img  src="imgs\icone\gadget2.svg"  class= "navImg" id="Gad" alt="gadget" height="40" style="border-radius:20px"
          ></a>
    </li>
	</ul>
</div>

