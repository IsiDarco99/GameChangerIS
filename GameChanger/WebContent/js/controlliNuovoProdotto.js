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

function validateTipo() {
  const nomeInput = document.querySelector('input[name="tipo"]');
  const errorNome = document.getElementById('errorTipo');
  const regex = /^[a-zA-Z0-9\s]+$/; // Solo lettere, numeri e spazi consentiti

  if (!regex.test(nomeInput.value)) {
    errorNome.textContent = 'Caratteri non validi nel nome del tipo di accessorio.';
    return false;
  }

  errorNome.textContent = '';
  return true;
}

function validateGen() {
  const consoleInput = document.querySelector('input[name="gen"]');
  const errorConsole = document.getElementById('errorGen');
  const regex = /^\d{1,2}$/; // Numeri da 1 a 99

  if (!regex.test(consoleInput.value) || parseInt(consoleInput.value) < 1 || parseInt(consoleInput.value) > 99) {
    errorConsole.textContent = 'Inserire un valore valido per la generazione (da 1 a 99).';
    return false;
  }

  errorConsole.textContent = '';
  return true;
}


function validatePEGI() {
  const pegiInput = document.querySelector('input[name="pegi"]');
  const errorPEGI = document.getElementById('errorPEGI');
  const allowedPEGI = ["3", "7", "12", "16", "18"];

  if (!allowedPEGI.includes(pegiInput.value)) {
    errorPEGI.textContent = 'Il PEGI deve essere "3", "7", "12", "16" o "18".';
    return false;
  }

  errorPEGI.textContent = '';
  return true;
}

function validateSvilup() {
  const nomeInput = document.querySelector('input[name="sviluppatore"]');
  const errorNome = document.getElementById('errorSvilupp');
  const regex = /^[a-zA-Z0-9\s]+$/; // Solo lettere, numeri e spazi consentiti

  if (!regex.test(nomeInput.value)) {
    errorNome.textContent = 'Caratteri non validi nel nome dello sviluppatore.';
    return false;
  }

  errorNome.textContent = '';
  return true;
}

function validateGenere() {
  const nomeInput = document.querySelector('input[name="genere"]');
  const errorNome = document.getElementById('errorGenere');
  const regex = /^[a-zA-Z0-9\s]+$/; // Solo lettere, numeri e spazi consentiti

  if (!regex.test(nomeInput.value)) {
    errorNome.textContent = 'Caratteri non validi nel nome del genere.';
    return false;
  }

  errorNome.textContent = '';
  return true;
}

function validatePrezzo() {
  const prezzoInput = document.querySelector('input[name="prezzoprodotto"]');
  const errorPrezzo = document.getElementById('errorPrezzo');
  const regex = /^\d+(?:\.\d{1,2})?$/; // Numeri positivi o decimali fino a 2 cifre decimali

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

function validateDataIniz(){
	let nuovaDataNascita = document.getElementsByName("dataIniz")[0].value;


if (nuovaDataNascita.trim() === "") {
		document.getElementById("errorDataIniz").textContent = "";
   		return false;
  }
  let regexData = /^(\d{4})-(\d{2})-(\d{2})$/;
  let match = nuovaDataNascita.match(regexData);
  if (!match) {
    document.getElementById("errorDataIniz").textContent = "Inserisci una data di nascita nel formato corretto (YYYY-MM-DD).";
    return false;
  }

  let anno = parseInt(match[1]);
  let mese = parseInt(match[2]);
  let giorno = parseInt(match[3]);

  if (anno < 1900) {
    document.getElementById("errorDataIniz").textContent = "L'anno deve essere maggiore o uguale a 1900.";
    return false;
  }

  if (mese < 1 || mese > 12) {
    document.getElementById("errorDataIniz").textContent = "Il mese deve essere compreso tra 1 e 12.";
    return false;
  }

  let giorniNelMese = new Date(anno, mese, 0).getDate();
  if (giorno < 1 || giorno > giorniNelMese) {
    document.getElementById("errorDataIniz").textContent = "Inserire un giorno valido per il mese selezionato.";
    return false;
  }

  let dataCorrente = new Date();
  let dataNascita = new Date(anno, mese - 1, giorno);
  if (dataNascita > dataCorrente) {
    document.getElementById("errorDataIniz").textContent = "Sei nato nel futuro?";
    return false;
  }else {
	  document.getElementById("errorDataIniz").textContent = "";
	  return true;
  }
}

function validateDataFin(){
	let nuovaDataNascita = document.getElementsByName("dataFin")[0].value;


if (nuovaDataNascita.trim() === "") {
		document.getElementById("errorDataFin").textContent = "";
   		return false;
  }
  let regexData = /^(\d{4})-(\d{2})-(\d{2})$/;
  let match = nuovaDataNascita.match(regexData);
  if (!match) {
    document.getElementById("errorDataFin").textContent = "Inserisci una data di nascita nel formato corretto (YYYY-MM-DD).";
    return false;
  }

  let anno = parseInt(match[1]);
  let mese = parseInt(match[2]);
  let giorno = parseInt(match[3]);

  if (anno < 1900) {
    document.getElementById("errorDataFin").textContent = "L'anno deve essere maggiore o uguale a 1900.";
    return false;
  }

  if (mese < 1 || mese > 12) {
    document.getElementById("errorDataFin").textContent = "Il mese deve essere compreso tra 1 e 12.";
    return false;
  }

  let giorniNelMese = new Date(anno, mese, 0).getDate();
  if (giorno < 1 || giorno > giorniNelMese) {
    document.getElementById("errorDataFin").textContent = "Inserire un giorno valido per il mese selezionato.";
    return false;
  }

  let dataCorrente = new Date();
  let dataNascita = new Date(anno, mese - 1, giorno);
  if (dataNascita > dataCorrente) {
    document.getElementById("errorDataFin").textContent = "Sei nato nel futuro?";
    return false;
  }else {
	  document.getElementById("errorDataFin").textContent = "";
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

function validateFormNuovo() {
  let isCodiceValid = validateCodice();

  return isCodiceValid;
}

function validateFormModifica() {
  let isNomeValid = validateNome();
  let isPrezzoValid = validatePrezzo();
  let isMarcaValid = validateMarca();
  let isDataValid = validateData();
  let isDescValid = validateDescr();

  return isNomeValid && isPrezzoValid && isMarcaValid && isDataValid && isDescValid;
}

function validateFormElimina() {
  let isCodiceValid = validateCodice();

  return isCodiceValid;
}

function validateFormOrdiniData() {
  let isDataInizValid = validateDataIniz();
  let isDataFinValid = validateDataFin();

  return isDataInizValid && isDataFinValid;
}

function validateFormOrdiniUser() {
  let isUsernameValid = validateUsername();

  return isUsernameValid;
}

function checkProductExists(event) {
  return new Promise(function(resolve, reject) {
	event.preventDefault();
    let newCodiceProdotto = document.getElementsByName("codice")[0].value;
    let errorElement = document.getElementById("errorCodice"); // Assuming you have an element to display error messages

    if (newCodiceProdotto.trim() === "") {
      errorElement.textContent = "";
      resolve(false);
    }

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "verifica-prodotto", true); // Replace "verifica-prodotto" with the actual server endpoint to check the product
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function() {
      if (xhr.readyState === XMLHttpRequest.DONE) {
        if (xhr.status === 200) {
          let response = JSON.parse(xhr.responseText);
          if (response.exists) {
            resolve(true);
          } else {
            errorElement.textContent = "Il prodotto non esiste nel database.";
            resolve(false);
          }
        } else {
          errorElement.textContent = "Si è verificato un errore. Riprova più tardi.";
          resolve(false);
        }
      }
    };
    xhr.send("codice=" + encodeURIComponent(newCodiceProdotto));
  });
}

function submitForm() {
    checkProductExists(event)
        .then(function(result) {
            if (result) {
                document.getElementById("deleteProductForm").submit();
            }
        })
        .catch(function(error) {
            console.error("Error:", error);
        });
}

function validateCodice(inputElement) {
    const inputRegex = /^[1-9]\d{0,8}$/; // Regex per controllare i numeri da 1 a 9 con massimo 9 cifre
    const maxNumber = 2147483647;

    const value = inputElement.value.trim();
    const errorElement = document.getElementById("errorCodice");

    if (!inputRegex.test(value)) {
        errorElement.textContent = "Inserisci un numero da 1 a 9 con un massimo di 2147483647.";
        inputElement.setCustomValidity("Invalid");
    } else {
        const numberValue = parseInt(value, 10);
        if (numberValue > maxNumber) {
            errorElement.textContent = "Il numero deve essere minore o uguale a 2147483647.";
            inputElement.setCustomValidity("Invalid");
        } else {
            errorElement.textContent = "";
            inputElement.setCustomValidity("");
        }
    }
}

function validateUsername() {
   let   newUsername = document.getElementsByName("username")[0].value;
   let   errorElement = document.getElementById("errorUsername");

   let   regex = /^[a-zA-Z0-9]+$/;
   if (!regex.test(newUsername)) {
      errorElement.textContent = "Sono consentiti solo caratteri alfanumerici";
      return false;
   }

   if (newUsername.length > 22) {
      errorElement.textContent = "Inserire un massimo di 22 caratteri.";
      return false;
   }
   
   let   xhr = new XMLHttpRequest();
  xhr.open("POST", "verifica-username", true);
  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === XMLHttpRequest.DONE) {
      if (xhr.status === 200) {
        let   response = JSON.parse(xhr.responseText);
        if (response.valid) {
			document.getElementById("errorUsername").textContent = "Non esiste un username con questo nome.";
        } else {
          document.getElementById("errorUsername").textContent = "";
          document.querySelector("form").submit();
        }
      } else {
        document.getElementById("errorUsername").textContent = "Si è verificato un errore. Riprova più tardi.";
      }
    }
  };
  xhr.send("nuovousername=" + encodeURIComponent(newUsername));

  return false;
}

