/**
 * 
 */
/*var searchString = sessionStorage.getItem("searchString");
	console.log(searchString);
	document.getElementById("ricerca-item").value = searchString;
	const barraricerca = document.getElementById("ricerca-item").value.toUpperCase();
  barraricerca.value= searchString;*/




  document.addEventListener("DOMContentLoaded", function() {
    var searchString = sessionStorage.getItem("searchString");
    var ricercaItem = document.getElementById("ricerca-item");
	  document.getElementById("ricerca-item").value = searchString;
	  if (searchString && searchString.trim() !== ""){
      ricercaItem.value = searchString;
      ricerca();
     }
    
    
   
  })

const ricerca = () => {
  const barraricerca = document.getElementById("ricerca-item").value.toUpperCase();
  const prodotti = document.querySelectorAll(".prodotto");
  const pnome = document.querySelectorAll(".prodotto strong");

  for (var i = 0; i < prodotti.length; i++) {
    let match = pnome[i];
    if (match) {
      let textvalue = match.textContent || match.innerHTML;

      if (textvalue.toUpperCase().indexOf(barraricerca) > -1) {
        prodotti[i].style.display = "";
      } else {
        prodotti[i].style.display = "none";
      }
    }
  }
};