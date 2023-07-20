function validateSvilupp() {
  const sviluppInput = document.querySelector('input[name="sviluppatore"]');
  const errorSvilupp = document.getElementById('errorSvilupp');
  const regex = /^[a-zA-Z0-9\s]+$/; // Solo lettere, numeri e spazi consentiti

  if (!regex.test(sviluppInput.value)) {
    errorSvilupp.textContent = 'Caratteri non validi nel campo sviluppatore.';
    return false;
  }

  errorSvilupp.textContent = '';
  return true;
}

function validateGenere() {
  const genereInput = document.querySelector('input[name="genere"]');
  const errorGenere = document.getElementById('errorGenere');
  const regex = /^[a-zA-Z0-9\s]+$/; // Solo lettere, numeri e spazi consentiti

  if (!regex.test(genereInput.value)) {
    errorGenere.textContent = 'Caratteri non validi nel campo genere.';
    return false;
  }

  errorGenere.textContent = '';
  return true;
}

function validateTipo() {
  const tipoInput = document.querySelector('input[name="tipo"]');
  const errorTipo = document.getElementById('errorTipo');
  const regex = /^[a-zA-Z0-9\s]+$/; // Solo lettere, numeri e spazi consentiti

  if (!regex.test(tipoInput.value)) {
    errorTipo.textContent = 'Caratteri non validi nel campo tipologia.';
    return false;
  }

  errorTipo.textContent = '';
  return true;
}

function validateGen() {
  const genInput = document.querySelector('input[name="generazione"]');
  const errorGen = document.getElementById('errorGen');
  const regex = /^(?:[1-9]|[1-9][0-9])$/; // Numeri interi da 1 a 99

  if (!regex.test(genInput.value)) {
    errorGen.textContent = 'Inserire un numero intero da 1 a 99.';
    return false;
  }

  errorGen.textContent = '';
  return true;
}

function validateFormVideogames() {
  let isSviluppValid = validateSvilupp();
  let isGenereValid = validateGenere();

  return isSviluppValid && isGenereValid ;
}

function validateFormAccessori() {
  let isTipoValid = validateTipo();

  return isTipoValid;
}

function validateFormGen() {
  let isGenValid = validateGen();

  return isGenValid;
}

function validateFormComputer() {
  const casaCheckbox = document.querySelector('input[name="casa"]');
  const ufficioCheckbox = document.querySelector('input[name="ufficio"]');
  const gamingCheckbox = document.querySelector('input[name="gaming"]');
  const errorCategoria = document.getElementById('errorCategoria');

  if (!casaCheckbox.checked && !ufficioCheckbox.checked && !gamingCheckbox.checked) {
    errorCategoria.textContent = 'Selezionare almeno una categoria.';
    return false;
  }

  errorCategoria.textContent = '';
  return true;
}