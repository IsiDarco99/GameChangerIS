
function effettuaRicerca() {
  let searchString = document.getElementById("ricerca-item").value;
  sessionStorage.setItem("searchString", searchString);
  window.location.href = contextPath + "/mostra-tutti-prodotti?categoria=allProdotti&searchString=" + encodeURIComponent(searchString);
}
document.addEventListener("DOMContentLoaded", function() {
  
  let   ricercaItem = document.getElementById("ricerca-item");
  ricercaItem.addEventListener("keypress", function(event) {
    if (event.key === "Enter") {
      effettuaRicerca();
    }
  });
let   ElemNav = document.getElementById("123")
let   Open = document.getElementById("OpN")
let   Ric = document.getElementById("barraRic")
let   searchString = sessionStorage.getItem("searchString");
document.getElementById("ricerca-item").value = searchString;

let   timer;

$(document).ready(function() {
 
    $(".OpenNavbar").click(function(){
      Open.classList.toggle("active");
      Open.addEventListener("animationend", ()=> { 
        if (event.animationName === "animazioneAltezza"){ 
          ElemNav.style.display = 'flex';
		      Open.style.display = 'none';
          
        }
      });
      
      
      
    })

	$(".ricerca").click(function() {
    Ric.classList.toggle("active");
    BRic.style.display = 'none';
    Ric.addEventListener("animationend", ()=>{
      if (event.animationName === "ricercaAnim"){ 
        BRic.style.display = 'flex';
        $("input[type='text']").focus();
      }
    } )
	   
	 });
 
});

//evento mouseout navbar
	ElemNav.addEventListener("mouseenter", function () {
    clearTimeout(timer);
    
    let   Con = document.getElementById("Con")
    let   InfCon = document.getElementById("InNa2")
    let   Vid = document.getElementById("Vid")
    let   InfVid = document.getElementById("InNa3")
    let   Com = document.getElementById("Com")
    let   InfCom = document.getElementById("InNa4")
    let   Gad = document.getElementById("Gad")
    let   InfGad = document.getElementById("InNa5")
    
    Con.addEventListener("mouseenter", function () {
      
      InfCon.style.display='flex';
    })
    Con.addEventListener("mouseleave", function () {
      
      InfCon.style.display='none';
    })
    Vid.addEventListener("mouseenter", function () {
      
      InfVid.style.display='flex';
    })
    Vid.addEventListener("mouseleave", function () {
      
      InfVid.style.display='none';
    })
    Com.addEventListener("mouseenter", function () {
      
      InfCom.style.display='flex';
    })
    Com.addEventListener("mouseleave", function () {
      
      InfCom.style.display='none';
    })
    Gad.addEventListener("mouseenter", function () {
      
      InfGad.style.display='flex';
    })
    Gad.addEventListener("mouseleave", function () {
      
      InfGad.style.display='none';
    })
    
    
  
});

  ElemNav.addEventListener("mouseleave", function(){
     timer = setTimeout(function () {
        ElemNav.style.display = 'none';
        Open.style.display = 'flex';
        Open.classList.toggle("chiusura");
        Open.addEventListener("animationend", ()=> {
          if (event.animationName === "animazioneRitorno"){
            
            Open.classList.remove("active");
            Open.classList.remove("chiusura");
            
          }
        });
        
      }, 1500);
      
  });
  //informazioni navbar
  
  

});
