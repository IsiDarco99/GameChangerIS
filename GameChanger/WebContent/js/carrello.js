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