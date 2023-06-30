package cn.gamechanger.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.User;
import cn.gamechanger.model.dao.UserDao;

@WebServlet("/dati-profilo")
public class profiloservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public profiloservlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UserDao userDao = new UserDao(DbCon.getConnection());
            String username = (String) request.getSession().getAttribute("userSession");
            User user = userDao.getUserProfile(username);
            request.setAttribute("user", user);
            request.getRequestDispatcher("profilo.jsp").forward(request, response);
            return; // Termina l'esecuzione del metodo dopo il forward
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Puoi gestire l'eccezione in modo appropriato qui
        }
        
        String redirectURL = "/GameChanger/profilo.jsp";
        response.sendRedirect(redirectURL);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
