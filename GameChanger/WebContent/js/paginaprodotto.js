
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

	  if (quantity < 99) {
	    quantityInput.value = quantity + 1;
	  }
	}

	function validateInput(event) {
	  var input = event.target;
	  var value = input.value;

	  // Rimuovi i caratteri non numerici
	  var filteredValue = value.replace(/[^0-9]/g, '');

	  // Limita il valore massimo a 99
	  if (filteredValue > 99) {
	    filteredValue = 99;
	  }

	  // Imposta il valore filtrato nell'input
	  input.value = filteredValue;
	}

	// Aggiungi un listener per l'evento "input" all'input della quantità
	var quantityInput = document.getElementById("quantity");
	quantityInput.addEventListener("input", validateInput);
