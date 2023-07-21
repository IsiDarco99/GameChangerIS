function validateUploadImmagini() {
  const immagine1Input = document.querySelector('input[name="immagine1"]');
  const immagine2Input = document.querySelector('input[name="immagine2"]');
  const immagine3Input = document.querySelector('input[name="immagine3"]');
  const errorMessaggio = document.getElementById('errorMessaggio');

  if (!immagine1Input.files.length || !immagine2Input.files.length || !immagine3Input.files.length) {
    errorMessaggio.textContent = 'Caricare tutte e tre le immagini prima di procedere.';
    return false;
  }

  errorMessaggio.textContent = '';
  return true;
}