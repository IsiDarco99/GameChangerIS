

function decreaseQuantity() {
	  let  quantityInput = document.getElementById("quantity");
	  let  quantity = parseInt(quantityInput.value);

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
	
	function validateInput(event) {
	  let   input = event.target;
	  let   value = input.value;

	  // Rimuovi i caratteri non numerici
	  let   filteredValue = value.replace(/[^0-9]/g, '');

	  // Limita il valore massimo a 99
	  if (filteredValue > 99) {
	    filteredValue = 99;
	  }

	  // Imposta il valore filtrato nell'input
	  input.value = filteredValue;
	}
	
	// Aggiungi un listener per l'evento "input" all'input della quantità
	const   qntityInput = document.getElementById("quantity");
	qntityInput.addEventListener("input", validateInput);

	
			$(document).ready(function() {
			$('.carosello').slick({
				dots : true,
				infinite : true,
				speed : 500,
				fade : true,
				cssEase : 'linear',
				prevArrow : '.arrow_prev',
				nextArrow : '.arrow_next'
			});
		});
		
		
		$(document).ready(function() {
			$('.nuove-uscite').slick({
				dots : true,
				infinite : true,
				slidesToShow : 3,
				slidesToScroll : 1,
				autoplay : true,
				autoplaySpeed : 2000,
				prevArrow : '.arrow_prev2',
				nextArrow : '.arrow_next2'
			});
		});
		console.log("aiutatemi");