function validateUsername(){
   let   newUsername = document.getElementsByName("login-username")[0].value;
   let   errorElement = document.getElementById("errorUsername");
   
   if (newUsername.trim() === "") {
	   errorElement.textContent = "";
    return false;
  }

   let   regex = /^[a-zA-Z0-9]+$/;
  let   emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  
  if (!regex.test(newUsername) && !emailRegex.test(newUsername)) {
    errorElement.textContent = "Sono consentiti solo caratteri alfanumerici";
    return false;
  } else {
	  document.getElementById("errorUsername").textContent = "";
	  return true;
}
}
   
   function validatePassword(){
	let   newPassword = document.getElementsByName("login-password")[0].value;
    
    if (newPassword.trim() === "") {
		document.getElementById("errorPassword").textContent = "";
   		return false;
  }
    
    
    
    let   regex = /^[a-zA-Z0-9]+$/;
  if (!regex.test(newPassword)) {
    document.getElementById("errorPassword").textContent = "Sono consentiti solo caratteri alfanumerici";
    return false;
  } else {
	  document.getElementById("errorPassword").textContent = "";
	  return true;
	 }
  }
  
  function validateForm() {
  let   isUsernameValid = validateUsername();
  let   isPasswordValid = validatePassword();

  return isUsernameValid && isPasswordValid;
}
