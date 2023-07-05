function submitForm(action) {
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	document.body.appendChild(form);
	form.submit();
}
function logout() {
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = 'user-logout';

	document.body.appendChild(form);
	form.submit();
}