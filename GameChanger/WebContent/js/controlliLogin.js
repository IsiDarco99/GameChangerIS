<% String loginError = (String) request.getAttribute("loginError");
       if (loginError != null) { %>
    window.addEventListener('DOMContentLoaded', function() {
        var errorMessage = '<%= loginError %>';
        if (errorMessage !== '') {
            alert(errorMessage);
        }
    });
    <% } %>


function validateUsername(){
   var newUsername = document.getElementsByName("login-username")[0].value;
   var errorElement = document.getElementById("errorUsername");
   
   if (newUsername.trim() === "") {
	   errorElement.textContent = "";
    return false;
  }

   var regex = /^[a-zA-Z0-9]+$/;
  var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  
  if (!regex.test(newUsername) && !emailRegex.test(newUsername)) {
    errorElement.textContent = "Sono consentiti solo caratteri alfanumerici";
    return false;
  } else {
	  document.getElementById("errorUsername").textContent = "";
	  return true;
}
}
   
   function validatePassword(){
	var newPassword = document.getElementsByName("login-password")[0].value;
    
    if (newPassword.trim() === "") {
		document.getElementById("errorPassword").textContent = "";
   		return false;
  }
    
    
    
    var regex = /^[a-zA-Z0-9]+$/;
  if (!regex.test(newPassword)) {
    document.getElementById("errorPassword").textContent = "Sono consentiti solo caratteri alfanumerici";
    return false;
  } else {
	  document.getElementById("errorPassword").textContent = "";
	  return true;
	 }
  }
  
  function validateForm() {
  var isUsernameValid = validateUsername();
  var isPasswordValid = validatePassword();

  return isUsernameValid && isPasswordValid;
}
