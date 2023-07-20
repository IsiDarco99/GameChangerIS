 document.addEventListener("DOMContentLoaded", function() {
    let   searchString = sessionStorage.getItem("searchString");
    let   ricercaItem = document.getElementById("ricerca-item");
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

  for (let   i = 0; i < prodotti.length; i++) {
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