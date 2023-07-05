function submitFormUsername(action) {
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	var hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'username';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormPassword(action) {
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	var hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'password';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormImg(action) {
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	var hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'immagine';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormEmail(action) {
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	var hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'mail';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormEmailPaypal(action) {
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	var hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'paypal';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormNumero(action) {
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	var hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'numero';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormIndirizzo(action) {
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	var hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'indirizzo';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}