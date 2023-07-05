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
	
	function handleBlur(prodottoId) {
    var quantityInput = document.getElementById("quantity-" + prodottoId);
    var quantityValue = quantityInput.value.trim();

    if (quantityValue === "" || isNaN(quantityValue)) {
        quantityInput.value = quantityInput.getAttribute("data-previous-value");
        return;
    }
    var form = document.createElement("form");
    form.method = "POST"; 
    form.action = "modifica-quantita";

    var quantityInput = document.createElement("input");
    quantityInput.type = "hidden";
    quantityInput.name = "quantity";
    quantityInput.value = document.getElementById("quantity-" + prodottoId).value;;

    var usernameInput = document.createElement("input");
    usernameInput.type = "hidden";
    usernameInput.name = "username";
    usernameInput.value = "<%= username %>";

    var codiceInput = document.createElement("input");
    codiceInput.type = "hidden";
    codiceInput.name = "codice";
    codiceInput.value = prodottoId; 
    
    form.appendChild(quantityInput);
    form.appendChild(usernameInput);
    form.appendChild(codiceInput);

    document.body.appendChild(form);
    form.submit();
}


function submitForm(event, prodottoId) {
        event.preventDefault();

        document.getElementById("rimuoviProdottoForm-" + prodottoId).submit();
    }