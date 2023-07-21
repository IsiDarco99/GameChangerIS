function decreaseQuantity() {
  let   quantityInput = document.getElementById("quantity");
  let   quantity = parseInt(quantityInput.value);

  if (quantity > 1) {
    quantityInput.value = quantity - 1;
  }
}

function increaseQuantity() {
  let   quantityInput = document.getElementById("quantity");
  let   quantity = parseInt(quantityInput.value);

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
	  let   quantityInput = document.getElementById("quantity");
	  let   quantity = parseInt(quantityInput.value);

	  if (quantity > 1) {
	    quantityInput.value = quantity - 1;
	  }
	}

	function increaseQuantity() {
	  let   quantityInput = document.getElementById("quantity");
	  let   quantity = parseInt(quantityInput.value);

	  if (quantity < 99) {
	    quantityInput.value = quantity + 1;
	  }
	}
	
	function handleBlur(prodottoId) {
    let   qntityInput = document.getElementById("quantity-" + prodottoId);
    let   qntityValue = qntityInput.value.trim();

    if (qntityValue === "" || isNaN(qntityValue)) {
        qntityInput.value = qntityInput.getAttribute("data-previous-value");
        return;
    }
    let   form = document.createElement("form");
    form.method = "POST"; 
    form.action = "modifica-quantita";

    let   quantityInput = document.createElement("input");
    quantityInput.type = "hidden";
    quantityInput.name = "quantity";
    quantityInput.value = document.getElementById("quantity-" + prodottoId).value;;

    let   usernameInput = document.createElement("input");
    usernameInput.type = "hidden";
    usernameInput.name = "username";
    usernameInput.value = "<%= username %>";

    let   codiceInput = document.createElement("input");
    codiceInput.type = "hidden";
    codiceInput.name = "codice";
    codiceInput.value = prodottoId; 
    
    form.appendChild(quantityInput);
    form.appendChild(usernameInput);
    form.appendChild(codiceInput);

    document.body.appendChild(form);
    form.submit();
}


function submitFormCart(event, prodottoId) {
        event.preventDefault();

        document.getElementById("rimuoviProdottoForm-" + prodottoId).submit();
    }