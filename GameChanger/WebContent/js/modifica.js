function submitForm(valore, action) {
  let form = document.createElement('form');
  form.method = 'POST';
  form.action = action;
  let hiddenInput = document.createElement('input');
  hiddenInput.type = 'hidden';
  hiddenInput.name = 'valore';
  hiddenInput.value = valore;
  form.appendChild(hiddenInput);
  document.body.appendChild(form);
  form.submit();
}

function submitFormMario(action) {
  submitForm('mario', action);
}

function submitFormPeach(action) {
  submitForm('peach', action);
}

function submitFormHunter(action) {
  submitForm('hunter', action);
}

function submitFormKratos(action) {
  submitForm('kratos', action);
}

function submitFormCody(action) {
  submitForm('cody', action);
}

function submitFormMay(action) {
  submitForm('may', action);
}

function submitFormLink(action) {
  submitForm('link', action);
}

function submitFormZoro(action) {
  submitForm('zoro', action);
}

function validateUsername() {
   let   newUsername = document.getElementsByName("nuovousername")[0].value;
   let   errorElement = document.getElementById("error");

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
          document.getElementById("error").textContent = "";
          document.querySelector("form").submit();
        } else {
          document.getElementById("error").textContent = "Esiste gi\u00E0 un username con questo nome.";
        }
      } else {
        document.getElementById("error").textContent = "Si è verificato un errore. Riprova più tardi.";
      }
    }
  };
  xhr.send("nuovousername=" + encodeURIComponent(newUsername));

  return false;
}

function validatePassword() {
	let   oldPassword = document.getElementById("oldPassword").value;
	let   inputPassword = document.getElementsByName("vecchiapassword")[0].value;
    let   newPassword = document.getElementsByName("nuovapassword")[0].value;
    let   repeatPassword = document.getElementsByName("ripetipassword")[0].value;
	console.log(oldPassword);
    if (newPassword !== repeatPassword) {
      document.getElementById("error").textContent = "Le nuove password non corrispondono.";
      return false;
    }
    
    let   regex = /^[a-zA-Z0-9]+$/;
  if (!regex.test(inputPassword) || !regex.test(newPassword) || !regex.test(repeatPassword)) {
    document.getElementById("error").textContent = "Sono consentiti solo caratteri alfanumerici";
    return false;
  }
  
  if (oldPassword.length > 22 || inputPassword.length > 22 || newPassword.length > 22 || repeatPassword.length > 22) {
    document.getElementById("error").textContent = "Inserire un massimo di 22 caratteri.";
    return false;
  }

    let   xhr = new XMLHttpRequest();
  xhr.open("POST", "verifica-password", true);
  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === XMLHttpRequest.DONE) {
      if (xhr.status === 200) {
        let   response = JSON.parse(xhr.responseText);
        if (response.valid) {
          document.getElementById("error").textContent = "";
          document.querySelector("form").submit();
        } else {
          document.getElementById("error").textContent = "La vecchia password non è esatta.";
        }
      } else {
        document.getElementById("error").textContent = "Si è verificato un errore. Riprova più tardi.";
      }
    }
  };
  xhr.send("password=" + encodeURIComponent(inputPassword));

  return false;
  }
  
function validateEmailPers() {
  let   email = document.getElementsByName("emailpers")[0].value;

  let   regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!regex.test(email)) {
    document.getElementById("error").textContent = "Inserisci un'email valida.";
    return false;
  }

  return true;
}

function validateEmailPaypal() {
  let   email = document.getElementsByName("emailpaypal")[0].value;

  let   regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!regex.test(email)) {
    document.getElementById("error").textContent = "Inserisci un'email valida.";
    return false;
  }

  return true;
}

function validateNumero() {
  let   phoneNumber = document.getElementsByName("nuovonum")[0].value;

  let   regex = /^\d{9}$/;
  if (!regex.test(phoneNumber)) {
    document.getElementById("error").textContent = "Inserisci un numero di telefono valido (9 cifre).";
    return false;
  }

  return true;
}

function validateNomeCognome() {
  let   nomeInput = document.getElementsByName("nuovonome")[0];
  let   cognomeInput = document.getElementsByName("nuovocognome")[0];

  let   nome = nomeInput.value.trim();
  let   cognome = cognomeInput.value.trim();

  nome = nome.replace(/\b\w/g, function(match) {
    return match.toUpperCase();
  });

  cognome = cognome.replace(/\b\w/g, function(match) {
    return match.toUpperCase();
  });

  nomeInput.value = nome;
  cognomeInput.value = cognome;

  let   regex = /^[A-Z][a-zA-Z\u00C0-\u00FF\s']*$/;
  if (!regex.test(nome) || !regex.test(cognome)) {
    document.getElementById("error").textContent = "Inserisci un nome e un cognome validi.";
    return false;
  }

  if (nome.length > 30 || cognome.length > 30) {
    document.getElementById("error").textContent = "Il nome e il cognome devono contenere al massimo 30 caratteri.";
    return false;
  }

  return true;
}



function validateIndirizzo() {
  let   nuovoStato = document.getElementsByName("nuovoStato")[0].value;
  let   nuovaCitta = document.getElementsByName("nuovaCitta")[0].value;
  let   nuovaVia = document.getElementsByName("nuovaVia")[0].value;
  let   nuovoCAP = document.getElementsByName("nuovoCAP")[0].value;

  let   regexLettere = /^[A-Za-z]+$/;
  if (!regexLettere.test(nuovoStato) || !regexLettere.test(nuovaCitta)) {
     document.getElementById("error").textContent = ("Stato e città devono essere composti solo da lettere.");
    return false;
  }
  nuovoStato = nuovoStato.charAt(0).toUpperCase() + nuovoStato.slice(1).toLowerCase();
  nuovaCitta = nuovaCitta.charAt(0).toUpperCase() + nuovaCitta.slice(1).toLowerCase();

  if (nuovoStato.length > 50 || nuovaCitta.length > 50) {
     document.getElementById("error").textContent = ("Stato e città devono contenere al massimo 50 caratteri.");
    return false;
  }

  if (nuovaVia.length > 100) {
     document.getElementById("error").textContent = ("L'indirizzo deve contenere al massimo 100 caratteri.");
    return false;
  }

  let   regexCAP = /^\d{5}$/;
  if (!regexCAP.test(nuovoCAP)) {
     document.getElementById("error").textContent = ("Il CAP deve essere composto da 5 cifre numeriche.");
    return false;
  }

  return true;
}

function validateData() {
  let   nuovaDataNascita = document.getElementsByName("nuovadata")[0].value;

  let   regexData = /^(\d{4})-(\d{2})-(\d{2})$/;
  let   match = nuovaDataNascita.match(regexData);
  if (!match) {
    document.getElementById("error").textContent = "Inserisci una data di nascita nel formato corretto (YYYY-MM-DD).";
    return false;
  }

  let   anno = parseInt(match[1]);
  let   mese = parseInt(match[2]);
  let   giorno = parseInt(match[3]);

  if (anno < 1900) {
    document.getElementById("error").textContent = "L'anno deve essere maggiore o uguale a 1900.";
    return false;
  }

  if (mese < 1 || mese > 12) {
    document.getElementById("error").textContent = "Il mese deve essere compreso tra 1 e 12.";
    return false;
  }

  let   giorniNelMese = new Date(anno, mese, 0).getDate();
  if (giorno < 1 || giorno > giorniNelMese) {
    document.getElementById("error").textContent = "Inserire un giorno valido per il mese selezionato.";
    return false;
  }

  let   dataCorrente = new Date();
  let   dataNascita = new Date(anno, mese - 1, giorno);
  if (dataNascita > dataCorrente) {
    document.getElementById("error").textContent = "Sei nato nel futuro?";
    return false;
  }

  return true;
}

function validateCodiceFiscale() {
  let   nuovoCodiceFiscale = document.getElementsByName("nuovocodice")[0].value;

  if (nuovoCodiceFiscale.length !== 16) {
    document.getElementById("error").textContent = "Il codice fiscale deve essere composto da esattamente 16 caratteri.";
    return false;
  }

  nuovoCodiceFiscale = nuovoCodiceFiscale.toUpperCase();

  let   regexCodiceFiscale = /^[A-Z0-9]{16}$/;
  if (!regexCodiceFiscale.test(nuovoCodiceFiscale)) {
    document.getElementById("error").textContent = "Inserisci un codice fiscale valido (16 caratteri alfanumerici).";
    return false;
  }


  return true;
}
function validateNomeCognomeAdmin(){
  let   nomeInput = document.getElementsByName("nuovonome")[0];
  let   cognomeInput = document.getElementsByName("nuovocognome")[0];

  let   nome = nomeInput.value.trim();
  let   cognome = cognomeInput.value.trim();

  nome = nome.replace(/\b\w/g, function(match) {
    return match.toUpperCase();
  });

  cognome = cognome.replace(/\b\w/g, function(match) {
    return match.toUpperCase();
  });

  nomeInput.value = nome;
  cognomeInput.value = cognome;

  let   regex = /^[A-Z][a-zA-Z\u00C0-\u00FF\s']*$/;
  if (!regex.test(nome) || !regex.test(cognome)) {
    document.getElementById("error").textContent = "Inserisci un nome e un cognome validi.";
    return false;
  }

  if (nome.length > 30 || cognome.length > 30) {
    document.getElementById("error").textContent = "Il nome e il cognome devono contenere al massimo 30 caratteri.";
    return false;
  }

  return true;
}



