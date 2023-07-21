<head>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
  <script type="text/javascript" src="js/navbar.js"></script>
  <link rel="stylesheet" href="css/navbar.css" type="text/css">
  <script>
    var contextPath = "${pageContext.request.contextPath}";
  </script>
</head>


<script type="text/javascript" src="
http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<!--- bottone per l'apparizione della navbar-->
<div class="OpenNavbar" id="OpN">
	<img src="imgs\icone\OpenNav.png" height="40" alt="icone" />
</div>	
<!--                                        -->
<div class="navbar" id="123">
	<ul>
		<li style="padding-top:13px; "><a href="#" class="ricerca"><img src="imgs\icone\ricerca.png" alt="search"
				height="40" style="border-radius:20px" ></a>
				<!--             tasto ricerca                -->
			<div class="togglesearch" id="barraRic">
			   <input type="text" placeholder="" id="ricerca-item" />
			   <input type="button" value="Search" id="BRic" onclick="effettuaRicerca()"/>
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
		<li><a href="${pageContext.request.contextPath}/mostra-tutti-prodotti?categoria=console"><img  src="imgs\icone\console.png" class= "navImg" id="Con" alt="console"height="40" style="border-radius:20px" 
				 ></a></li>
		<li><a href="${pageContext.request.contextPath}/mostra-tutti-prodotti?categoria=videogiochi"><img  src="imgs\icone\videogame.svg" class= "navImg" id="Vid" alt="videogame"height="40"style="border-radius:20px"
				 ></a></li>
		<li style="margin: 0px 10px 30px;"><a href="${pageContext.request.contextPath}/mostra-tutti-prodotti?categoria=computer"><img src="imgs\icone\computerNav.png"  class= "navImg" id="Com"
      alt="Computer" height="40" style="border-radius:20px"></a>
    </li>
    <li style="margin-bottom: 6px;"><a href="${pageContext.request.contextPath}/mostra-tutti-prodotti?categoria=accessori"><img  src="imgs\icone\gadget2.svg"  class= "navImg" id="Gad" alt="gadget" height="40" style="border-radius:20px"
          ></a>
    </li>
	</ul>
  
</div>

