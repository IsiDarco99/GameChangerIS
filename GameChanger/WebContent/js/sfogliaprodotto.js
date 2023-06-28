 <script>
  function handleKeyPress(event, prezzoMinId, prezzoMaxId) {
	  if (event.keyCode === 13) { // 13 è il codice del tasto Invio
      const prezzoMin = document.getElementById(prezzoMinId).value;
      const prezzoMax = document.getElementById(prezzoMaxId).value;
      
      // Costruisci l'URL con i valori dei prezzi
      const url = `sfogliaProdotti.jsp?categoria=<%= categoria %>&min=${prezzoMin}&max=${prezzoMax}`;
      
      // Reindirizza alla stessa pagina con l'URL aggiornato
      window.location.href = url;
    }
  }
  </script>
