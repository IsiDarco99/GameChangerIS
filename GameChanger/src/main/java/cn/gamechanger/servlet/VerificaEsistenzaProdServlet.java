package cn.gamechanger.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.dao.ProdottoDao;

/**
 * Servlet implementation class verificaEsistenzaProdotto
 */
@WebServlet("/verifica-prodotto")
public class VerificaEsistenzaProdServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupera il codice del prodotto fornito dall'utente
        String codiceProdotto = request.getParameter("codice");
        boolean existsInDatabase = false;

        try {
            ProdottoDao prodottoDao = new ProdottoDao(DbCon.getConnection());
            existsInDatabase = prodottoDao.controllaEsistenza(codiceProdotto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Restituisci la risposta come JSON
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println("{ \"exists\": " + existsInDatabase + " }");
    }
}