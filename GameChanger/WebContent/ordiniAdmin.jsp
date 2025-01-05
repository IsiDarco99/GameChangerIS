<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="cn.gamechanger.bean.*"%>
<%@ page import="cn.gamechanger.servlet.ProdottiAcquistatiServlet" %>
<% 
    Map<Ordine, List<ProdottoOrdine>> ordiniEProdotti = (Map<Ordine, List<ProdottoOrdine>>) request.getAttribute("ordiniEProdotti"); 
    boolean hasOrdini = (ordiniEProdotti != null && !ordiniEProdotti.isEmpty());
%>
<!DOCTYPE html>
<html lang="it">
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
                <img src="imgs\prodottiacquistati\noOrdini.png" alt="Nessun prodotto">
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
                                <div >
                                    <hr class="dvdOrd">
                                    <h5 class="idOrdInf">Id ordine: <%= ordine.getId_ordine()%> </h5>
                                </div>
                            <%} %>
                            <table>
                            <caption>Tabella ordini</caption>
                                <thead>
                                    <tr>
                                        <th class="nm">Prodotto</th>
                                        <th class="qnt">Quantit&aacute;</th>
                                        <th class="prz">Prezzo</th>
                                        <th class="prg">Stato:</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Ciclo for dei prodotti corrispondenti all'ordine -->
                                    <% 
                                    for (ProdottoOrdine prodotto : prodottiOrdine) {
                                    %>
                                    <tr>
                                        <td class="nm"><%= prodotto.getNome() %></td>
                                        <td class="qnt"><%= prodotto.getQuantita() %></td>
                                        <td class="prz"><%= String.format("%.2f", prodotto.getPrezzo() * prodotto.getQuantita()) %>&#x20AC;</td>
                                        <td class="prg"><%= ordine.getStato_ord()%></th>
                                    </tr>
                                    <% 
                                    } 
                                    %>
                                </tbody>
                            </table>
                            <hr>
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
