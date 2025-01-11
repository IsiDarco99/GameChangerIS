package cn.gamechanger.servlet;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import cn.gamechanger.servlet.InserisciProdottoServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.StringWriter;

public class InserisciProdottoServletTest {

	private InserisciProdottoServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter responseWriter;

    @Before
    public void setUp() throws Exception {
        // Creiamo un'istanza della servlet da testare
        servlet = new InserisciProdottoServlet();

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
    public void TC_AGG_1() throws Exception {	
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("categoria")).thenReturn("videogame");
        when(request.getParameter("prezzoprodotto")).thenReturn("10");
        when(request.getParameter("nomeprodotto")).thenReturn("testNome&&");
        when(request.getParameter("marcaprodotto")).thenReturn("testMarca");
        when(request.getParameter("descrizioneprodotto")).thenReturn("testDescrizione");
        when(request.getParameter("data_usc")).thenReturn("2010-01-01");

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Sono consentiti solo caratteri alfanumerici."));

        verify(response, never()).sendRedirect("prodottoAggiunto.jsp");
    }
    
    @Test
    public void TC_AGG_2() throws Exception {	
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("categoria")).thenReturn("videogame");
        when(request.getParameter("prezzoprodotto")).thenReturn("10.22222");
        when(request.getParameter("nomeprodotto")).thenReturn("testNome");
        when(request.getParameter("marcaprodotto")).thenReturn("testMarca");
        when(request.getParameter("descrizioneprodotto")).thenReturn("testDescrizione");
        when(request.getParameter("data_usc")).thenReturn("2010-01-01");

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Inserire un prezzo valido."));

        verify(response, never()).sendRedirect("prodottoAggiunto.jsp");
    }
    
    @Test
    public void TC_AGG_3() throws Exception {	
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("categoria")).thenReturn("videogame");
        when(request.getParameter("prezzoprodotto")).thenReturn("10");
        when(request.getParameter("nomeprodotto")).thenReturn("testNome");
        when(request.getParameter("marcaprodotto")).thenReturn("testMarca&&");
        when(request.getParameter("descrizioneprodotto")).thenReturn("testDescrizione");
        when(request.getParameter("data_usc")).thenReturn("2010-01-01");

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Caratteri non validi nella marca del prodotto."));

        verify(response, never()).sendRedirect("prodottoAggiunto.jsp");
    }
    
    @Test
    public void TC_AGG_4() throws Exception {	
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("categoria")).thenReturn("videogame");
        when(request.getParameter("prezzoprodotto")).thenReturn("10");
        when(request.getParameter("nomeprodotto")).thenReturn("testNome");
        when(request.getParameter("marcaprodotto")).thenReturn("testMarca");
        when(request.getParameter("descrizioneprodotto")).thenReturn("testDescrizione");
        when(request.getParameter("data_usc")).thenReturn("01-01-2010");

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Inserisci una data nel formato corretto (YYYY-MM-DD)."));

        verify(response, never()).sendRedirect("prodottoAggiunto.jsp");
    }
    
    @Test
    public void TC_AGG_5() throws Exception {	
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("categoria")).thenReturn("videogame");
        when(request.getParameter("prezzoprodotto")).thenReturn("10");
        when(request.getParameter("nomeprodotto")).thenReturn("testNome");
        when(request.getParameter("marcaprodotto")).thenReturn("testMarca");
        when(request.getParameter("descrizioneprodotto")).thenReturn("testDescrizione§°*ç");
        when(request.getParameter("data_usc")).thenReturn("2010-01-01");
        when(request.getParameter("skipImages")).thenReturn("true");

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Caratteri non validi nella descrizione del prodotto."));

        verify(response, never()).sendRedirect("prodottoAggiunto.jsp");
    }
    
    @Test
    public void TC_AGG_6() throws Exception {	
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("categoria")).thenReturn("videogame");
        when(request.getParameter("prezzoprodotto")).thenReturn("10");
        when(request.getParameter("nomeprodotto")).thenReturn("testNome");
        when(request.getParameter("marcaprodotto")).thenReturn("testMarca");
        when(request.getParameter("descrizioneprodotto")).thenReturn("testDescrizione");
        when(request.getParameter("data_usc")).thenReturn("2010-01-01");
        when(request.getParameter("skipImages")).thenReturn("true");
        System.out.println(request.getParameter("skipImages"));
        servlet.doPost(request, response);
        
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("prodottoAggiunto.jsp")).thenReturn(dispatcher);

        servlet.doPost(request, response);

        // Verifica che il forward sia stato chiamato
        verify(dispatcher).forward(request, response);

        // Verifica che non ci siano errori nell'output
        assertTrue(stringWriter.toString().isEmpty());
    }

}
