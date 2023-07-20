<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>GameChanger</title>
<%@include file="includes/head.jsp"%>
<link rel="stylesheet" href="css/modifica.css" type="text/css">
</head>
<body>
<%@include file="includes/topbar.jsp"%>
</head>
<body>
<div class="container">
    <div class="blocco">
        <h2><strong>Inserisci immagini prodotto</strong></h2>
        <form action="upload-immagini" method="post" enctype="multipart/form-data">
            
            <p>Immagine 1:<br>
                <input type="file" name="immagine1">
            </p>
            <p>Immagine 2:<br>
                <input type="file" name="immagine2">
            </p>
            <p>Immagine 3:<br>
                <input type="file" name="immagine3">
            </p>
            <button type="submit">Avanti</button>
        </form>
    </div>
</div>
<%@ include file="includes/footer.jsp"%>
</body>
</html>