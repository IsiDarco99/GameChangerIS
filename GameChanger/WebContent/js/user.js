function submitFormUsername(action, valore) {
	let   form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	let   hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = valore;
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormPassword(action) {
	let   form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	let   hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'password';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormImg(action) {
	let   form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	let   hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'immagine';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormEmail(action) {
	let   form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	let   hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'mail';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormEmailPaypal(action) {
	let   form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	let   hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'paypal';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormData(action) {
	let   form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	let   hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'data';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormCodFisc(action) {
	let   form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	let   hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'codfisc';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormNumero(action) {
	let   form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	let   hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'numero';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}

function submitFormIndirizzo(action) {
	let   form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	let   hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'indirizzo';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}
function submitFormnomeAmm(action){
	let   form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	let   hiddenInput = document.createElement('input');
 	hiddenInput.type = 'hidden';
 	hiddenInput.name = 'valore';
 	hiddenInput.value = 'nomeamm';
 	form.appendChild(hiddenInput)
	document.body.appendChild(form);
	form.submit();
}