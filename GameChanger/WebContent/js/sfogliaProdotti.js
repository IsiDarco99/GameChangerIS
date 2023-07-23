let searchString = null;

document.addEventListener("DOMContentLoaded", function() {
  let urlParams = new URLSearchParams(window.location.search);
  let searchString = urlParams.get("searchString");
  let ricercaItem = document.getElementById("ricerca-item");
  ricercaItem.value = searchString;

  if (searchString && searchString.trim() !== "") {
    ricerca();
  }

  // Aggiungi un listener per l'evento beforeunload
  window.addEventListener("beforeunload", function() {
    cleanUpVariables();
  });

  // Aggiungi un listener per l'evento pageshow
  window.addEventListener("pageshow", function(event) {
    // Verifica se l'utente torna alla pagina utilizzando il tasto "Back" del browser
    if (event.persisted) {
      cleanUpVariables();
    }
  });
});
const cleanUpVariables = () => {
  searchString = null;
};

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







