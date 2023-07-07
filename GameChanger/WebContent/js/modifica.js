function submitFormMario(action) {
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	var hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'mario';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormPeach(action) {
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	var hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'peach';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormHunter(action) {
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	var hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'hunter';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormKratos(action) {
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	var hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'kratos';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormCody(action) {
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	var hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'cody';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormMay(action) {
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	var hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'may';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormLink(action) {
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	var hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'link';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormZoro(action) {
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	var hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'zoro';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

var isFunctionExecuted = false;

function validateUsername() {
   var newUsername = document.getElementsByName("nuovousername")[0].value;
   var errorElement = document.getElementById("error");
   var errorUser = document.getElementById("errorUserInput").value;
   

   var regex = /^[a-zA-Z0-9]+$/;
   if (!regex.test(newUsername)) {
      errorElement.textContent = "Sono consentiti solo caratteri alfanumerici";
      return false;
   }

   if (newUsername.length > 22) {
      errorElement.textContent = "Inserire un massimo di 22 caratteri.";
      return false;
   }
   
   if (isFunctionExecuted) {
      return true;
   }
   
   if (errorUser !== "null") {
      errorElement.textContent = errorUser;
      isFunctionExecuted = true;
      return false;
   }
   
   return true;
}

document.addEventListener("DOMContentLoaded", function() {
	var errorElement = document.getElementById("error");
   var errorUser = document.getElementById("errorUserInput").value;

   if (errorUser !== "null") {
      errorElement.textContent = errorUser;
      return false;
   }
});

function validatePassword() {
	var oldPassword = document.getElementById("oldPassword").value;
	var inputPassword = document.getElementsByName("vecchiapassword")[0].value;
    var newPassword = document.getElementsByName("nuovapassword")[0].value;
    var repeatPassword = document.getElementsByName("ripetipassword")[0].value;
	console.log(oldPassword);
    if (newPassword !== repeatPassword) {
      document.getElementById("error").textContent = "Le nuove password non corrispondono.";
      return false;
    }
    
    var regex = /^[a-zA-Z0-9]+$/;
  if (!regex.test(inputPassword) || !regex.test(newPassword) || !regex.test(repeatPassword)) {
    document.getElementById("error").textContent = "Sono consentiti solo caratteri alfanumerici";
    return false;
  }
  
  if (oldPassword.length > 22 || inputPassword.length > 22 || newPassword.length > 22 || repeatPassword.length > 22) {
    document.getElementById("error").textContent = "Inserire un massimo di 22 caratteri.";
    return false;
  }

    var xhr = new XMLHttpRequest();
  xhr.open("POST", "verifica-password", true);
  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === XMLHttpRequest.DONE) {
      if (xhr.status === 200) {
        var response = JSON.parse(xhr.responseText);
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
  var email = document.getElementsByName("emailpers")[0].value;

  var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!regex.test(email)) {
    document.getElementById("error").textContent = "Inserisci un'email valida.";
    return false;
  }

  return true;
}

function validateEmailPaypal() {
  var email = document.getElementsByName("emailpaypal")[0].value;

  var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!regex.test(email)) {
    document.getElementById("error").textContent = "Inserisci un'email valida.";
    return false;
  }

  return true;
}

function validateNumero() {
  var phoneNumber = document.getElementsByName("nuovonum")[0].value;

  var regex = /^\d{9}$/;
  if (!regex.test(phoneNumber)) {
    document.getElementById("error").textContent = "Inserisci un numero di telefono valido (9 cifre).";
    return false;
  }

  return true;
}

function validateNomeCognome() {
  var nomeInput = document.getElementsByName("nuovonome")[0];
  var cognomeInput = document.getElementsByName("nuovocognome")[0];

  var nome = nomeInput.value.trim();
  var cognome = cognomeInput.value.trim();

  nome = nome.replace(/\b\w/g, function(match) {
    return match.toUpperCase();
  });

  cognome = cognome.replace(/\b\w/g, function(match) {
    return match.toUpperCase();
  });

  nomeInput.value = nome;
  cognomeInput.value = cognome;

  var regex = /^[A-Z][a-zA-ZÀ-ÿ\s']*$/;
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
  var nuovoStato = document.getElementsByName("nuovoStato")[0].value;
  var nuovaCitta = document.getElementsByName("nuovaCitta")[0].value;
  var nuovaVia = document.getElementsByName("nuovaVia")[0].value;
  var nuovoCAP = document.getElementsByName("nuovoCAP")[0].value;

  var regexLettere = /^[A-Za-z]+$/;
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

  var regexCAP = /^\d{5}$/;
  if (!regexCAP.test(nuovoCAP)) {
     document.getElementById("error").textContent = ("Il CAP deve essere composto da 5 cifre numeriche.");
    return false;
  }

  return true;
}

function validateData() {
  var nuovaDataNascita = document.getElementsByName("nuovadata")[0].value;

  var regexData = /^(\d{4})-(\d{2})-(\d{2})$/;
  var match = nuovaDataNascita.match(regexData);
  if (!match) {
    document.getElementById("error").textContent = "Inserisci una data di nascita nel formato corretto (YYYY-MM-DD).";
    return false;
  }

  var anno = parseInt(match[1]);
  var mese = parseInt(match[2]);
  var giorno = parseInt(match[3]);

  if (anno < 1900) {
    document.getElementById("error").textContent = "L'anno deve essere maggiore o uguale a 1900.";
    return false;
  }

  if (mese < 1 || mese > 12) {
    document.getElementById("error").textContent = "Il mese deve essere compreso tra 1 e 12.";
    return false;
  }

  var giorniNelMese = new Date(anno, mese, 0).getDate();
  if (giorno < 1 || giorno > giorniNelMese) {
    document.getElementById("error").textContent = "Inserire un giorno valido per il mese selezionato.";
    return false;
  }

  var dataCorrente = new Date();
  var dataNascita = new Date(anno, mese - 1, giorno);
  if (dataNascita > dataCorrente) {
    document.getElementById("error").textContent = "Sei nato nel futuro?";
    return false;
  }

  return true;
}

function validateCodiceFiscale() {
  var nuovoCodiceFiscale = document.getElementsByName("nuovocodice")[0].value;

  if (nuovoCodiceFiscale.length !== 16) {
    document.getElementById("error").textContent = "Il codice fiscale deve essere composto da esattamente 16 caratteri.";
    return false;
  }

  nuovoCodiceFiscale = nuovoCodiceFiscale.toUpperCase();

  var regexCodiceFiscale = /^[A-Z0-9]{16}$/;
  if (!regexCodiceFiscale.test(nuovoCodiceFiscale)) {
    document.getElementById("error").textContent = "Inserisci un codice fiscale valido (16 caratteri alfanumerici).";
    return false;
  }


  return true;
}




