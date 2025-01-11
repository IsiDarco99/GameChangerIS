package cn.gamechanger.servlet;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import cn.gamechanger.bean.Ordine;
import cn.gamechanger.bean.Prodotto;
import cn.gamechanger.bean.User;
import cn.gamechanger.connection.DbCon;
import cn.gamechanger.dao.CarrelloDao;
import cn.gamechanger.dao.ProdottoDao;
import cn.gamechanger.dao.UserDao;
import cn.gamechanger.servlet.CheckoutServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;


public class CheckoutServletTest {

	private CheckoutServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter responseWriter;

    @Before
    public void setUp() throws Exception {
        // Creiamo un'istanza della servlet da testare
        servlet = new CheckoutServlet();

        // Mockiamo la request e la response
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);

        // Mockiamo la sessione
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);

        // Mockiamo il RequestDispatcher
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        // Prepariamo un writer per catturare l'output della response
        responseWriter = new StringWriter();
        when(response.getWriter()).thenReturn(new PrintWriter(responseWriter));
    }
    
    @Test
    public void TC_CHECK_1() throws Exception {	
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        when(request.getParameter("step")).thenReturn("2");
        when(request.getParameter("firstname")).thenReturn("nomeTest&&");
        when(request.getParameter("email")).thenReturn("user1@example.com");
        when(request.getParameter("address")).thenReturn("indirizzoTest");
        when(request.getParameter("city")).thenReturn("cittaTest");
        when(request.getParameter("state")).thenReturn("statoTest");
        when(request.getParameter("zip")).thenReturn("11111");

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Il nome può contenere solo caratteri da A-Z e caratteri accentati."));

        verify(response, never()).sendRedirect("checkout4.jsp");
    }
    
    @Test
    public void TC_CHECK_2() throws Exception {	
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("step")).thenReturn("2");
        when(request.getParameter("firstname")).thenReturn("nomeTest");
        when(request.getParameter("email")).thenReturn("formatoSbagliatoEmail");
        when(request.getParameter("address")).thenReturn("indirizzoTest");
        when(request.getParameter("city")).thenReturn("cittaTest");
        when(request.getParameter("state")).thenReturn("statoTest");
        when(request.getParameter("zip")).thenReturn("11111");

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Formato email non valido."));

        verify(response, never()).sendRedirect("checkout4.jsp");
    }
    
    @Test
    public void TC_CHECK_3() throws Exception {	
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("step")).thenReturn("2");
        when(request.getParameter("firstname")).thenReturn("nomeTest");
        when(request.getParameter("email")).thenReturn("user1@example.com");
        when(request.getParameter("address")).thenReturn("indirizzoTest&&");
        when(request.getParameter("city")).thenReturn("cittaTest");
        when(request.getParameter("state")).thenReturn("statoTest");
        when(request.getParameter("zip")).thenReturn("11111");

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("L'indirizzo può contenere solo lettere, numeri, spazi, virgole, punti e trattini."));

        verify(response, never()).sendRedirect("checkout4.jsp");
    }
    
    @Test
    public void TC_CHECK_4() throws Exception {	
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("step")).thenReturn("2");
        when(request.getParameter("firstname")).thenReturn("nomeTest");
        when(request.getParameter("email")).thenReturn("user1@example.com");
        when(request.getParameter("address")).thenReturn("indirizzoTest");
        when(request.getParameter("city")).thenReturn("cittaTest&&");
        when(request.getParameter("state")).thenReturn("statoTest");
        when(request.getParameter("zip")).thenReturn("11111");

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("La città può contenere solo lettere, spazi e apostrofi."));

        verify(response, never()).sendRedirect("checkout4.jsp");
    }
    
    @Test
    public void TC_CHECK_5() throws Exception {	
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("step")).thenReturn("2");
        when(request.getParameter("firstname")).thenReturn("nomeTest");
        when(request.getParameter("email")).thenReturn("user1@example.com");
        when(request.getParameter("address")).thenReturn("indirizzoTest");
        when(request.getParameter("city")).thenReturn("cittaTest");
        when(request.getParameter("state")).thenReturn("statoTest&&");
        when(request.getParameter("zip")).thenReturn("11111");

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Lo stato può contenere solo lettere e spazi."));

        verify(response, never()).sendRedirect("checkout4.jsp");
    }
    
    @Test
    public void TC_CHECK_6() throws Exception {	
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("step")).thenReturn("2");
        when(request.getParameter("firstname")).thenReturn("nomeTest");
        when(request.getParameter("email")).thenReturn("user1@example.com");
        when(request.getParameter("address")).thenReturn("indirizzoTest");
        when(request.getParameter("city")).thenReturn("cittaTest");
        when(request.getParameter("state")).thenReturn("statoTest");
        when(request.getParameter("zip")).thenReturn("111121");

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Il codice postale deve contenere esattamente 5 cifre."));

        verify(response, never()).sendRedirect("checkout4.jsp");
    }
    
    @Test
    public void TC_CHECK_7() throws Exception {	
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("step")).thenReturn("3");
        when(request.getParameter("emailPayPal")).thenReturn("payPalFormatoSbagliato");

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Inserisci un'email valida."));

        verify(response, never()).sendRedirect("checkout4.jsp");
    }
    
    @Test
    public void TC_CHECK_8() throws Exception {	
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        Connection con = DbCon.getConnection();
        User user = new User();
		user.setUsername("testUserCheckout");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		UserDao udao = new UserDao(con);
		udao.registerUser(user);
		CarrelloDao cdao = new CarrelloDao(con);
		cdao.aggiungiProdottoAlCarrello("testUserCheckout", 1, 1);
		
        
		when(request.getSession().getAttribute("userSession")).thenReturn(user.getUsername());
        when(request.getParameter("step")).thenReturn("4");
        when(request.getParameter("salva-dati")).thenReturn(null);
        when(request.getParameter("firstname")).thenReturn("nomeTest");
        when(request.getParameter("email")).thenReturn("user1@example.com");
        when(request.getParameter("address")).thenReturn("indirizzoTest");
        when(request.getParameter("city")).thenReturn("cittaTest");
        when(request.getParameter("state")).thenReturn("statoTest");
        when(request.getParameter("zip")).thenReturn("11111");
        

        servlet.doPost(request, response);
        
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("checkout4.jsp")).thenReturn(dispatcher);

        servlet.doPost(request, response);

        // Verifica che il forward sia stato chiamato
        verify(dispatcher).forward(request, response);

        // Verifica che non ci siano errori nell'output
        assertTrue(stringWriter.toString().isEmpty());
    }
}
