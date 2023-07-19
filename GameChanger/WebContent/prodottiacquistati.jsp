<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="cn.gamechanger.model.*"%>
<%@ page import="cn.gamechanger.servlet.ProdottiAcquistatiServlet" %>
<% 
    Map<Ordine, List<ProdottoOrdine>> ordiniEProdotti = (Map<Ordine, List<ProdottoOrdine>>) request.getAttribute("ordiniEProdotti"); 
    boolean hasOrdini = (ordiniEProdotti != null && !ordiniEProdotti.isEmpty());
%>
<!DOCTYPE html>
<html>
<head>
    <title>GameChanger</title>
    <%@ include file="includes/head.jsp"%>
    <link rel="stylesheet" href="css/prodottiacquistati.css" type="text/css">
</head>
<body>
    <%@ include file="includes/topbar.jsp"%>
    <%@ include file="includes/navbar.jsp"%>

    <div class="scritta-principale">
        <h1>
            <span> Prodotti Acquistati </span>
        </h1>
    </div>

    <div class="container">
        <div class="prodotti">
            <% 
            int lastOrderId = -1;
            if (!hasOrdini) {
            %>
            <div class="immagine-prodotto">
                <img src="imgs/prodottiacquistati/prodottovuoto.png" alt="Nessun prodotto">
            </div>
            <div class="scritta-prodotto">
                <h1>
                    <span> Non hai acquistato nessun prodotto<br>Da un'occhiata ai
                        nostri <a href="sfogliaProdotti.jsp?categoria=allProdotti">prodotti</a>
                    </span>
                </h1>
            </div>
            <% 
            } else {
                // Ciclo for degli ordini
                for (java.util.Map.Entry<Ordine, java.util.List<ProdottoOrdine>> entry : ordiniEProdotti.entrySet()) {
                    Ordine ordine = entry.getKey();
                    java.util.List<ProdottoOrdine> prodottiOrdine = entry.getValue();
                    
                    // Stampa l'ID dell'ordine solo se ci sono prodotti
                    if (!prodottiOrdine.isEmpty()) {
                        %>
                        <!-- INIZIO ORDINE -->
                        <div class="container-prodotto">
                        	<%if (ordine.getId_ordine() != lastOrderId){ %>
                            <h1>Ordine ID: <%= ordine.getId_ordine()%></h1>
                            <%} %>
                            <table>
                                <thead>
                                    <tr>
                                        <th>Prodotto</th>
                                        <th>Quantità</th>
                                        <th>Prezzo</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Ciclo for dei prodotti corrispondenti all'ordine -->
                                    <% 
                                    for (ProdottoOrdine prodotto : prodottiOrdine) {
                                    %>
                                    <tr>
                                        <td><%= prodotto.getNome() %></td>
                                        <td><%= prodotto.getQuantita() %></td>
                                        <td><%= String.format("%.2f", prodotto.getPrezzo() * prodotto.getQuantita()) %>&#x20AC;</td>
                                    </tr>
                                    <% 
                                    } 
                                    %>
                                </tbody>
                            </table>
                        </div>
                        <!-- FINE ORDINE -->
                        <% 
                        lastOrderId = ordine.getId_ordine();
                    }
                }
            }
            %>
        </div>
    </div>

    <%@ include file="includes/footer.jsp"%>
</body>
</html>
