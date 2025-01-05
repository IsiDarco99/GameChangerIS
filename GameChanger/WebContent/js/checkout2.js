function validateEmailPayPal() {
  let emailPayPalInput = document.getElementById("cname");
  let emailPayPal = emailPayPalInput.value.trim();

  if (emailPayPal.trim() === "") {
    document.getElementById("errorEmailPayPal").textContent = "Campo obbligatorio.";
    return false;
  }

  let regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!regex.test(emailPayPal)) {
    document.getElementById("errorEmailPayPal").textContent = "Inserisci un'email PayPal valida.";
    return false;
  } else {
    document.getElementById("errorEmailPayPal").textContent = "";
    return true;
  }
}

document.getElementById("myForm").addEventListener("submit", function (event) {
  const isEmailPayPalValid = validateEmailPayPal();

  if (!isEmailPayPalValid) {
    event.preventDefault();
  }
});
