
document.addEventListener("DOMContentLoaded", function() {
  console.log("aiutami");

var ElemNav = document.getElementById("123")
var Open = document.getElementById("OpN")
var Ric = document.getElementById("barraRic")
var Bric = document.getElementById("BRic")

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
      
      
      
    })

	$(".ricerca").click(function() {
    Ric.classList.toggle("active");
    BRic.style.display = 'none';
    Ric.addEventListener("animationend", ()=>{
      if (event.animationName === "ricercaAnim"){ 
        console.log("bella li");
        BRic.style.display = 'flex';
        $("input[type='text']").focus();
      }
    } )
	   
	 });
 
});

//evento mouseout navbar
	ElemNav.addEventListener("mouseenter", function () {
    console.log("entrato");
    clearTimeout(timer);
    var mouseenterValue = this.id;
    var Cat = document.getElementById("Cat")
    var InfCat= document.getElementById("InNa1")
    var Con = document.getElementById("Con")
    var InfCon = document.getElementById("InNa2")
    var Vid = document.getElementById("Vid")
    var InfVid = document.getElementById("InNa3")
    var Com = document.getElementById("Com")
    var InfCom = document.getElementById("InNa4")
    var Gad = document.getElementById("Gad")
    var InfGad = document.getElementById("InNa5")
    //ElemNav.style.display = 'inline-block';
    Cat.addEventListener("mouseenter", function () {
      
      InfCat.style.display='flex';
    })
    Cat.addEventListener("mouseleave", function () {
      
      InfCat.style.display='none';
    })
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
    
    /*switch (mouseenterValue) {
      case 'Cat':
        console.log('Oranges are $0.59 a pound.');
        break;
      case 'icona2':
        console.log('Apples are $0.32 a pound.');
        break;
      case 'icona3':
        console.log('Bananas are $0.48 a pound.');
        break;
      case 'Cat':
        console.log('Cats are adorable!');
        break;
      default:
        console.log('No icon selected.');
    }*/
  
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
      }, 755500);
      
  });
  //informazioni navbar
  
  
console.log("il cazzo")
});