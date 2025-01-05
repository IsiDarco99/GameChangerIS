function validateIndirizzo() {
  let indirizzoInput = document.getElementById("adr");
  let indirizzo = indirizzoInput.value.trim();

  if (indirizzo.trim() === "") {
    document.getElementById("errorIndirizzo").textContent = "Campo obbligatorio.";
    return false;
  } else {
    document.getElementById("errorIndirizzo").textContent = "";
    return true;
  }
}

function validateCitta() {
  let cittaInput = document.getElementById("city");
  let citta = cittaInput.value.trim();

  if (citta.trim() === "") {
    document.getElementById("errorCitta").textContent = "Campo obbligatorio.";
    return false;
  } else {
    document.getElementById("errorCitta").textContent = "";
    return true;
  }
}

function validateStato() {
  let statoInput = document.getElementById("state");
  let stato = statoInput.value.trim();

  if (stato.trim() === "") {
    document.getElementById("errorStato").textContent = "Campo obbligatorio.";
    return false;
  } else {
    document.getElementById("errorStato").textContent = "";
    return true;
  }
}

function validateCodicePostale() {
  let codicePostaleInput = document.getElementById("zip");
  let codicePostale = codicePostaleInput.value.trim();

  if (codicePostale.trim() === "") {
    document.getElementById("errorCodicePostale").textContent = "Campo obbligatorio.";
    return false;
  }

  let regex = /^\d{5}$/; // Codice postale composto da 5 cifre
  if (!regex.test(codicePostale)) {
    document.getElementById("errorCodicePostale").textContent = "Inserisci un codice postale valido (5 cifre).";
    return false;
  } else {
    document.getElementById("errorCodicePostale").textContent = "";
    return true;
  }
}

function validateNome() {
  let nomeInput = document.getElementById("fname");
  let nome = nomeInput.value.trim();

  if (nome.trim() === "") {
    document.getElementById("errorNome").textContent = "Campo obbligatorio.";
    return false;
  }

  let regex = /^[A-Za-z\u00C0-\u00FF\s']*$/;
  if (!regex.test(nome)) {
    document.getElementById("errorNome").textContent = "Il nome deve contenere solo caratteri da A-Z e i caratteri accentati.";
    return false;
  }

  if (nome.length > 30) {
    document.getElementById("errorNome").textContent = "Il nome deve contenere al massimo 30 caratteri.";
    return false;
  } else {
    document.getElementById("errorNome").textContent = "";
    return true;
  }
}

function validateEmail() {
  let emailInput = document.getElementById("email");
  let email = emailInput.value.trim();

  if (email.trim() === "") {
    document.getElementById("errorEmail").textContent = "Campo obbligatorio.";
    return false;
  }

  let regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!regex.test(email)) {
    document.getElementById("errorEmail").textContent = "Inserisci un'email valida.";
    return false;
  } else {
    document.getElementById("errorEmail").textContent = "";
    return true;
  }
}


document.getElementById("myForm").addEventListener("submit", function (event) {
  const isNomeValid = validateNome();
  const isEmailValid = validateEmail();
  const isIndirizzoValid = validateIndirizzo();
  const isCittaValid = validateCitta();
  const isStatoValid = validateStato();
  const isCodicePostaleValid = validateCodicePostale();

  if (!isNomeValid || !isEmailValid || !isIndirizzoValid || !isCittaValid || !isStatoValid || !isCodicePostaleValid) {
    event.preventDefault();
  }
});

