package cn.gamechanger.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.gamechanger.model.dao.CarrelloDao;

@WebServlet("/aggiungi-prodotto")
public class AggiungiAlCarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarrelloDao carrelloDao;

    @Override
    public void init() throws ServletException {
        super.init();
        carrelloDao = new CarrelloDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        int codiceProdotto = Integer.parseInt(request.getParameter("codice"));
        int quantita = Integer.parseInt(request.getParameter("quantity"));

        carrelloDao.aggiungiProdottoAlCarrello(username, codiceProdotto, quantita);

        String message = "Prodotto aggiunto al carrello!";
        String redirectURL = "/pagina_prodotto?id=" + codiceProdotto + "&message=" + message;
        response.sendRedirect(redirectURL);
    }
}
