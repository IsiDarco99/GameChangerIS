/**
 * 
 */
const ricerca = ()=>{
    const barraricerca = document.getElementById("ricerca-item").ariaValueMax.toUpperCase();
    const storeitems = document.getElementById("lista-prod")
    const prodotti = document.querySelectorAll(".container-prodotti")
    const pnome = storeitems.getElementsByTagName("strong")

    for(var i=0; i < pnome.length; i++){
        let match = prodotti[i].getElementsByTagName('strong')[0];
        if(match){
            let textvalue = match.textContent || match.innerHTML

            if(textvalue.toUpperCase().indexOf(barraricerca) > -1){
                prodotti[i].style.display = "";
            } else {
                prodotti[i].style.display = "none";
            }
        }
    }
}