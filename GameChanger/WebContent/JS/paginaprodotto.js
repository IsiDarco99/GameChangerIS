// Ottieni i riferimenti ai pulsanti e all'input di quantità
const increaseBtn = document.getElementById('increase-btn');
const decreaseBtn = document.getElementById('decrease-btn');
const quantityInput = document.getElementById('quantity-input');

// Aggiungi gli event listener per i pulsanti
increaseBtn.addEventListener('click', () => {
  quantityInput.value = parseInt(quantityInput.value) + 1; // Incrementa la quantità di 1
});

decreaseBtn.addEventListener('click', () => {
  let updatedQuantity = parseInt(quantityInput.value) - 1; // Decrementa la quantità di 1
  updatedQuantity = Math.max(updatedQuantity, 1); // Assicurati che la quantità non scenda sotto 1
  quantityInput.value = updatedQuantity;
});
