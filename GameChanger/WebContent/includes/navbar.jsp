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
	display: flex; /*deve essere flex*/
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
.OpenNavbar{
	background-color: #D80B15;
	position: fixed !important;
    z-index: 9999;
    top: 80px;
    margin-left: 10px;
    background-color: #333;
    color: #fff;
    width: 60px;
    max-height: calc(100vh - 50px);
    display: flex;
    align-items: center;
    justify-content: space-between;
    flex-direction: column;
    border-radius: 50px;
}
.vetrina{
	border-radius: 50px;
	background-color: pink;
}

  /*             --------------         */
</style>

<script type="text/javascript" src="
http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<!--- bottone per l'apparizione della navbar--><!--
<div class="OpenNavbar">
	<button type="button" id="vetrina" >
		</button>
</div>	-->
<!--                                        -->
<div class="navbar">
	<ul>
		<li><a href="#" class="ricerca"><img src="imgs/generale/search.png" alt="search"
				height="40"></a>
				<!--             tasto ricerca                -->
			<div class="togglesearch">
			   <input type="text" placeholder=""/>
			   <input type="button" value="Search"/>
			</div><!--              ---------                 -->
		</li>
		<li><a href="#"><img src="imgs/generale/computer.png" alt="computer"
				height="40"></a></li>
		<li><a href="#"><img src="imgs/generale/console.png" alt="console"
				height="40"></a></li>
		<li><a href="#"><img src="imgs/generale/videogame.png" alt="videogame"
				height="40"></a></li>
		<li style="margin: 0px 10px 0px;"><a href="#"><img
				src="imgs/generale/gadget.png" alt="gadget" height="40"></a></li>
	</ul>
</div>