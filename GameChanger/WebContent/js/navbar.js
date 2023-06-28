document.addEventListener("DOMContentLoaded", function() {
  console.log("aiutami");

var ElemNav = document.getElementById("123")
var Open = document.getElementById("OpN")
var timer;

var navbarElement = document.getElementById("123");


// Ora puoi accedere all'elemento navbar e manipolarlo come desideri
/*navbarElement.style.backgroundColor = "red";
navbarElement.innerHTML = "Contenuto aggiornato";
*/

console.log("ti prego");



$(document).ready(function() {
 /*vetrina, creazione del menù */
    $(".OpenNavbar").click(function(){
      Open.classList.toggle("active");
      Open.addEventListener("animationend", ()=> { 
        if (event.animationName === "animazioneAltezza"){ 
          ElemNav.style.display = 'flex';
		      Open.style.display = 'none';
          console.log("animazione fin");
        }
      });
      
      
      /*$(".navbar").toggle();
		$(".OpenNavbar").toggle();
        */
    })

	$(".ricerca").click(function() {
	   $(".togglesearch").toggle();
	   $("input[type='text']").focus();
	 });
 
});

//evento mouseout navbar
	ElemNav.addEventListener("mouseenter", function () {
    console.log("entrato");
    clearTimeout(timer);
    //ElemNav.style.display = 'inline-block';
});

  ElemNav.addEventListener("mouseleave", function(){
	  console.log("uscito");
     timer = setTimeout(function () {
        ElemNav.style.display = 'none';
        Open.style.display = 'flex';
        Open.classList.toggle("chiusura");
        Open.addEventListener("animationend", ()=> {
          if (event.animationName === "animazioneRitorno"){
            
            Open.classList.remove("active");
            Open.classList.remove("chiusura");
            console.log("fine animazione");
          }
        });
        console.log("fine timer");
      }, 1000);
      
  });
  
  
console.log("il cazzo");
});