function validateNome() {
  const nomeInput = document.querySelector('input[name="nomeprodotto"]');
  const errorNome = document.getElementById('errorNome');
  const regex = /^[a-zA-Z0-9\s]+$/; // Solo lettere, numeri e spazi consentiti

  if (!regex.test(nomeInput.value)) {
    errorNome.textContent = 'Caratteri non validi nel nome del prodotto.';
    return false;
  }

  errorNome.textContent = '';
  return true;
}

function validatePrezzo() {
  const prezzoInput = document.querySelector('input[name="prezzoprodotto"]');
  const errorPrezzo = document.getElementById('errorPrezzo');
  const regex = /^[0-9]+(?:\.[0-9]{1,2})?$/; // Numeri positivi o decimali fino a 2 cifre decimali

  if (!regex.test(prezzoInput.value)) {
    errorPrezzo.textContent = 'Inserire un prezzo valido.';
    return false;
  }

  errorPrezzo.textContent = '';
  return true;
}

function validateMarca() {
  const marcaInput = document.querySelector('input[name="marcaprodotto"]');
  const errorMarca = document.getElementById('errorMarca');
  const regex = /^[a-zA-Z0-9\s]+$/; // Solo lettere, numeri e spazi consentiti

  if (!regex.test(marcaInput.value)) {
    errorMarca.textContent = 'Caratteri non validi nella marca del prodotto.';
    return false;
  }

  errorMarca.textContent = '';
  return true;
}

function validateData(){
	let nuovaDataNascita = document.getElementsByName("data_usc")[0].value;


if (nuovaDataNascita.trim() === "") {
		document.getElementById("errorData").textContent = "";
   		return false;
  }
  let regexData = /^(\d{4})-(\d{2})-(\d{2})$/;
  let match = nuovaDataNascita.match(regexData);
  if (!match) {
    document.getElementById("errorData").textContent = "Inserisci una data di nascita nel formato corretto (YYYY-MM-DD).";
    return false;
  }

  let anno = parseInt(match[1]);
  let mese = parseInt(match[2]);
  let giorno = parseInt(match[3]);

  if (anno < 1900) {
    document.getElementById("errorData").textContent = "L'anno deve essere maggiore o uguale a 1900.";
    return false;
  }

  if (mese < 1 || mese > 12) {
    document.getElementById("errorData").textContent = "Il mese deve essere compreso tra 1 e 12.";
    return false;
  }

  let giorniNelMese = new Date(anno, mese, 0).getDate();
  if (giorno < 1 || giorno > giorniNelMese) {
    document.getElementById("errorData").textContent = "Inserire un giorno valido per il mese selezionato.";
    return false;
  }

  let dataCorrente = new Date();
  let dataNascita = new Date(anno, mese - 1, giorno);
  if (dataNascita > dataCorrente) {
    document.getElementById("errorData").textContent = "Sei nato nel futuro?";
    return false;
  }else {
	  document.getElementById("errorData").textContent = "";
	  return true;
  }
}

function validateDescr() {
  const descrizioneInput = document.querySelector('textarea[name="descrizioneprodotto"]');
  const errorDescrizione = document.getElementById('errorDescrizione');
  const regex = /^[a-zA-Z0-9\s.,!?()'"-]+$/; // Solo lettere, numeri, spazi e alcuni caratteri speciali

  if (!regex.test(descrizioneInput.value)) {
    errorDescrizione.textContent = 'Caratteri non validi nella descrizione del prodotto.';
    return false;
  }

  errorDescrizione.textContent = '';
  return true;
}

function validateForm() {
  let isNomeValid = validateNome();
  let isPrezzoValid = validatePrezzo();
  let isMarcaValid = validateMarca();
  let isDataValid = validateData();
  let isDescValid = validateDescr();

  return isNomeValid && isPrezzoValid && isMarcaValid && isDataValid && isDescValid;
}