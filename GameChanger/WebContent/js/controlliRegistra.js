function validateUsername() {
  return new Promise(function(resolve, reject) {
    var newUsername = document.getElementsByName("nuovousername")[0].value;
    var errorElement = document.getElementById("errorUsername");

    if (newUsername.trim() === "") {
      errorElement.textContent = "";
      resolve(false);
    }

    var regex = /^[a-zA-Z0-9]+$/;
    if (!regex.test(newUsername)) {
      errorElement.textContent = "Sono consentiti solo caratteri alfanumerici";
      resolve(false);
    }

    if (newUsername.length > 22) {
      errorElement.textContent = "Inserire un massimo di 22 caratteri.";
      resolve(false);
    }

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "verifica-username", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function() {
      if (xhr.readyState === XMLHttpRequest.DONE) {
        if (xhr.status === 200) {
          var response = JSON.parse(xhr.responseText);
          if (response.valid) {
            errorElement.textContent = "";
            resolve(false);
          } else {
            errorElement.textContent = "Esiste gi\u00E1 un username con questo nome.";
            console.log("cazzono");
            resolve(false);
          }
        } else {
          errorElement.textContent = "Si è verificato un errore. Riprova più tardi.";
          resolve(false);
        }
      }
    };
    xhr.send("nuovousername=" + encodeURIComponent(newUsername));
  });
}


function validatePassword(){
	var newPassword = document.getElementsByName("password")[0].value;
    
    var regex = /^[a-zA-Z0-9]+$/;
  if (!regex.test(newPassword)) {
    document.getElementById("errorPassword").textContent = "Sono consentiti solo caratteri alfanumerici";
    return false;
  }
    
  
  if (newPassword.length > 22) {
    document.getElementById("errorPassword").textContent = "Inserire un massimo di 22 caratteri.";
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
          document.getElementById("errorPassword").textContent = "";
          return true;
        } else {
          document.getElementById("errorPassword").textContent = "La vecchia password non è esatta.";
          return false;
        }
      } else {
        document.getElementById("errorPassword").textContent = "Si è verificato un errore. Riprova più tardi.";
        return false;
      }
    }
  };

  
  if (newPassword.trim() === "") {
		document.getElementById("errorPassword").textContent = "";
   		return true;
  }
}

function validatePasswordRepeat(){
	var newPassword = document.getElementsByName("password")[0].value;
    var repeatPassword = document.getElementsByName("ripetipassword")[0].value;
  
	if (newPassword !== repeatPassword) {
      document.getElementById("errorPasswordRepeat").textContent = "Le password non corrispondono.";
    }
    
    if (newPassword === repeatPassword) {
      document.getElementById("errorPasswordRepeat").textContent = "";
    }
    
    if (repeatPassword.trim() === "") {
		document.getElementById("errorPasswordRepeat").textContent = "";
  } else {
	  return true;
  }
}

function validateNome(){
  var nomeInput = document.getElementsByName("nome")[0];
  var nome = nomeInput.value.trim();

  nome = nome.replace(/\b\w/g, function(match) {
    return match.toUpperCase();
  });

  nomeInput.value = nome;
  
  if (nome.trim() === "") {
	  document.getElementById("errorNome").textContent = "";
    return false;
  }

  var regex = /^[A-Z][a-zA-Z\u00C0-\u00FF\s']*$/;
  if (!regex.test(nome)) {
    document.getElementById("errorNome").textContent = "Il nome pu\u00F2 contenere solo caratteri da A-Z e i caratteri accentati.";
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

function validateCognome(){
  var cognomeInput = document.getElementsByName("cognome")[0];
  var cognome = cognomeInput.value.trim();

  cognome = cognome.replace(/\b\w/g, function(match) {
    return match.toUpperCase();
  });

  cognomeInput.value = cognome;
  
  if (cognome.trim() === "") {
		document.getElementById("errorCognome").textContent = "";
   		return false;
  }

  var regex = /^[A-Z][a-zA-Z\u00C0-\u00FF\s']*$/;
  if (!regex.test(cognome)) {
    document.getElementById("errorCognome").textContent = "Il cognome pu\u00F2 contenere solo caratteri da A-Z e i caratteri accentati.";
    return false;
  }

  if (cognome.length > 30) {
    document.getElementById("errorCognome").textContent = "Il cognome e il cognome devono contenere al massimo 30 caratteri.";
    return false;
  }else {
	  document.getElementById("errorCognome").textContent = "";
	  return true;
  }
}

function validateMail(){
	var email = document.getElementsByName("emailPers")[0].value;

	if (email.trim() === "") {
		document.getElementById("errorMail").textContent = "";
   		return false;
  }
  var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!regex.test(email)) {
    document.getElementById("errorMail").textContent = "Inserisci un'email valida.";
    return false;
  }else {
	  document.getElementById("errorMail").textContent = "";
	  return true;
  }
}

function validateData(){
	var nuovaDataNascita = document.getElementsByName("datanascita")[0].value;


if (nuovaDataNascita.trim() === "") {
		document.getElementById("errorData").textContent = "";
   		return false;
  }
  var regexData = /^(\d{4})-(\d{2})-(\d{2})$/;
  var match = nuovaDataNascita.match(regexData);
  if (!match) {
    document.getElementById("errorData").textContent = "Inserisci una data di nascita nel formato corretto (YYYY-MM-DD).";
    return false;
  }

  var anno = parseInt(match[1]);
  var mese = parseInt(match[2]);
  var giorno = parseInt(match[3]);

  if (anno < 1900) {
    document.getElementById("errorData").textContent = "L'anno deve essere maggiore o uguale a 1900.";
    return false;
  }

  if (mese < 1 || mese > 12) {
    document.getElementById("errorData").textContent = "Il mese deve essere compreso tra 1 e 12.";
    return false;
  }

  var giorniNelMese = new Date(anno, mese, 0).getDate();
  if (giorno < 1 || giorno > giorniNelMese) {
    document.getElementById("errorData").textContent = "Inserire un giorno valido per il mese selezionato.";
    return false;
  }

  var dataCorrente = new Date();
  var dataNascita = new Date(anno, mese - 1, giorno);
  if (dataNascita > dataCorrente) {
    document.getElementById("errorData").textContent = "Sei nato nel futuro?";
    return false;
  }else {
	  document.getElementById("errorData").textContent = "";
	  return true;
  }
}

  function validateForm() {
	  var privacyCheckbox = document.getElementsByName("privacy")[0];
  var termsCheckbox = document.getElementsByName("terms")[0];

  if (!privacyCheckbox.checked || !termsCheckbox.checked) {
    document.getElementById("errorPrivacy").textContent = "Devi accettare la privacy e i termini e le condizioni per registrarti";
    return false;
  }
  
  if (privacyCheckbox.checked && termsCheckbox.checked) {
    document.getElementById("errorPrivacy").textContent = "";
  }

    var errorFields = document.querySelectorAll("p[id^='error']");
    var isValid = true;

    errorFields.forEach(function(field) {
      if (field.innerText !== '') {
        isValid = false;
      }
    });

    if (!isValid) {
      document.getElementById("errMex").textContent = "Si prega di correggere gli errori prima di inviare il modulo.";
      return false;
    }

    return true;
  }




