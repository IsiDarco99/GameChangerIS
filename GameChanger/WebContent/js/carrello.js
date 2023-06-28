function decreaseQuantity() {
  var quantityInput = document.getElementById("quantity");
  var quantity = parseInt(quantityInput.value);

  if (quantity > 1) {
    quantityInput.value = quantity - 1;
  }
}

function increaseQuantity() {
  var quantityInput = document.getElementById("quantity");
  var quantity = parseInt(quantityInput.value);

  quantityInput.value = quantity + 1;
}

    function validateInput(event) {
      const input = event.target;
      const value = input.value;

      // Rimuovi i caratteri non numerici
      const filteredValue = value.replace(/[^0-9]/g, '');

      // Imposta il valore filtrato nell'input
      input.value = filteredValue;
    }
