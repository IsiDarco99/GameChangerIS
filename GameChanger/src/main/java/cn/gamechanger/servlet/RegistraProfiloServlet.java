package cn.gamechanger.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.bean.User;
import cn.gamechanger.connection.DbCon;
import cn.gamechanger.dao.UserDao;

@WebServlet("/user-register")
public class RegistraProfiloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
		    response.sendRedirect("register.jsp");
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
		}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    try (PrintWriter out = response.getWriter()){
	    	
			UserDao dao = new UserDao(DbCon.getConnection());
			
	        String username = request.getParameter("nuovousername");
	        String emailPers = request.getParameter("emailPers");
	        String password = request.getParameter("password");
	        String nome = request.getParameter("nome");
	        String cognome = request.getParameter("cognome");
	        String dataNascita = request.getParameter("datanascita");
	        String ripetiPassword = request.getParameter("ripetipassword");
	        String privacyCheckbox = request.getParameter("privacy");
	        String termsCheckbox = request.getParameter("terms");

	        
	        if (!emailPers.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
	        	out.print("Formato email non valido.");
	            return;
	        }
	        
	        if (username == null || username.trim().isEmpty()) {
	            out.print("Il campo username non può essere vuoto.");
	            return;
	        }

	        if (!username.matches("^[a-zA-Z0-9]+$")) {
	            out.print("Sono consentiti solo caratteri alfanumerici.");
	            return;
	        }

	        if (username.length() > 22) {
	            out.print("Inserire un massimo di 22 caratteri.");
	            return;
	        }	
	        
	        if (!dao.checkUsername(username)) {
	        	out.print("Username presente nel database.");
	            return;
	        }
	        
	        if (password == null || password.trim().isEmpty()) {
	            out.print("Il campo password non può essere vuoto.");
	            return;
	        }

	        if (!password.matches("^[a-zA-Z0-9]+$")) {
	            out.print("Sono consentiti solo caratteri alfanumerici.");
	            return;
	        }

	        if (password.length() < 8) {
	            out.print("La password deve contenere almeno 8 caratteri.");
	            return;
	        }
	        
	        if (ripetiPassword == null || ripetiPassword.trim().isEmpty()) {
	            out.print("Il campo ripeti password non può essere vuoto.");
	            return;
	        }

	        if (!password.equals(ripetiPassword)) {
	            out.print("Le password non corrispondono.");
	            return;
	        }
	        
	        if (nome == null || nome.trim().isEmpty()) {
	            out.print("Il campo nome non può essere vuoto.");
	            return;
	        }

	        if (!nome.matches("^[A-Z][a-zA-Z\u00C0-\u00FF\\s']*$")) {
	            out.print("Il nome può contenere solo caratteri da A-Z e caratteri accentati.");
	            return;
	        }

	        if (nome.length() > 30) {
	            out.print("Il nome deve contenere al massimo 30 caratteri.");
	            return;
	        }
	        
	        if (cognome == null || cognome.trim().isEmpty()) {
	            out.print("Il campo cognome non può essere vuoto.");
	            return;
	        }

	        if (!cognome.matches("^[A-Z][a-zA-Z\u00C0-\u00FF\\s']*$")) {
	            out.print("Il cognome può contenere solo caratteri da A-Z e caratteri accentati.");
	            return;
	        }

	        if (cognome.length() > 30) {
	            out.print("Il cognome deve contenere al massimo 30 caratteri.");
	            return;
	        }
	        
	        if (emailPers == null || emailPers.trim().isEmpty()) {
	            out.print("Il campo email non può essere vuoto.");
	            return;
	        }

	        if (!emailPers.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
	            out.print("Inserisci un'email valida.");
	            return;
	        }
	        
	        if (dataNascita == null || dataNascita.trim().isEmpty()) {
	            out.print("Il campo data di nascita non può essere vuoto.");
	            return;
	        }

	        if (!dataNascita.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
	            out.print("Inserisci una data di nascita nel formato corretto (YYYY-MM-DD).");
	            return;
	        }
	        
	        if (privacyCheckbox == null || termsCheckbox == null) {
	            out.print("Devi accettare la privacy e i termini e condizioni per registrarti.");
	            return;
	        }

	        String[] dataParts = dataNascita.split("-");
	        int anno = Integer.parseInt(dataParts[0]);
	        int mese = Integer.parseInt(dataParts[1]);
	        int giorno = Integer.parseInt(dataParts[2]);

	        if (anno < 1900) {
	            out.print("L'anno deve essere maggiore o uguale a 1900.");
	            return;
	        }

	        if (mese < 1 || mese > 12) {
	            out.print("Il mese deve essere compreso tra 1 e 12.");
	            return;
	        }

	        int giorniNelMese = LocalDate.of(anno, mese, 1).lengthOfMonth();
	        if (giorno < 1 || giorno > giorniNelMese) {
	            out.print("Inserire un giorno valido per il mese selezionato.");
	            return;
	        }
	        
	        
	        User user = new User(username, emailPers, "", 0, "", "", "", 0, password, nome, cognome, dataNascita, "", 0);

	        try {
	            UserDao udao = new UserDao(DbCon.getConnection());
	            boolean registrationSuccess = udao.registerUser(user);

	            if (registrationSuccess) {
	            	response.sendRedirect("login.jsp");
	            } else {
	                out.print("Errore durante la registrazione");
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}
