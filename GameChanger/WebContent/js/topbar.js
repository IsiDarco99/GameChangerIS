function submitForm(action) {
	let   form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	document.body.appendChild(form);
	form.submit();
}
function logout() {
	let   form = document.createElement('form');
	form.method = 'POST';
	form.action = 'user-logout';

	document.body.appendChild(form);
	form.submit();
}