function submitFormUsername(event, action) {
	event.preventDefault();
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	document.body.appendChild(form);
	form.submit();
}
function submitFormPassword(event, action) {
	event.preventDefault();
	var form = document.createElement('form');
	form.method = 'POST';
	form.action = action;
	document.body.appendChild(form);
	form.submit();
}
