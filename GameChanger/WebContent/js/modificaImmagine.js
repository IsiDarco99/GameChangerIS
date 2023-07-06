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

function validatePassword() {
    var newPassword = document.getElementsByName("nuovapassword")[0].value;
    var repeatPassword = document.getElementsByName("ripetipassword")[0].value;

    if (newPassword !== repeatPassword) {
      document.getElementById("error").textContent = "Le password non corrispondono.";
      return false; // Impedisce l'invio del modulo se le password non sono uguali
    }

    // Le password sono uguali, il modulo può essere inviato
    return true;
  }
