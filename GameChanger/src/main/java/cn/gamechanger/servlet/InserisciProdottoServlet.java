package cn.gamechanger.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

import cn.gamechanger.bean.Prodotto;
import cn.gamechanger.connection.DbCon;
import cn.gamechanger.dao.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;

@WebServlet("/Inserisci-Prodotto")
@MultipartConfig
public class InserisciProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "C:\\Users\\isida\\git\\GameChangerRep\\GameChanger\\WebContent\\imgs\\prodotti";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String categoria = request.getParameter("categoria");
		float prezzo = Float.parseFloat(request.getParameter("prezzoprodotto"));
		String nome = request.getParameter("nomeprodotto");
		String marca = request.getParameter("marcaprodotto");
		String descrizione = request.getParameter("descrizioneprodotto");
		String dataUscita = request.getParameter("data_usc");
		String skipImages = request.getParameter("skipImages");

		PrintWriter out = response.getWriter();

		if (!nome.matches("^[a-zA-Z0-9\\s]+$")) {
			out.print("Sono consentiti solo caratteri alfanumerici.");
			return;
		}

		String prezzoStr = String.valueOf(prezzo);
		if (!prezzoStr.matches("^\\d+(?:\\.\\d{1,2})?$")) {
			out.print("Inserire un prezzo valido."); // oppure throw new IllegalArgumentException("Inserire un prezzo
														// valido.");
			return;
		}

		if (!marca.matches("^[a-zA-Z0-9\\s]+$")) {
			out.print("Caratteri non validi nella marca del prodotto.");
			return;
		}

		if (!dataUscita.matches("^(\\d{4})-(\\d{2})-(\\d{2})$")) {
			out.print("Inserisci una data nel formato corretto (YYYY-MM-DD).");
			return;
		}

		if (!descrizione.matches("^[a-zA-Z0-9\\s.,!?()'\"-]+$")) {
			out.print("Caratteri non validi nella descrizione del prodotto.");
			return;
		}
		ProdottoDao prodottoDao = null;
		try {
			prodottoDao = new ProdottoDao(DbCon.getConnection());
			prodottoDao.insertProdotto(prezzo, nome, marca, descrizione, dataUscita, categoria);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		if (skipImages == null || !skipImages.equals("true")) {
			Collection<Part> parts = request.getParts();
			Iterator<Part> iterator = parts.iterator();
			String nomeIniziale = null;
			ProdottoDao pDao = null;
			try {
				pDao = new ProdottoDao(DbCon.getConnection());
				Prodotto ultimoProdotto = pDao.getUltimoProdotto();
				nomeIniziale = ultimoProdotto.getNome();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			int imageNumber = 1;

			while (iterator.hasNext() && imageNumber <= 3) {
				Part part = iterator.next();
				String fileName = part.getSubmittedFileName();

				if (fileName == null || fileName.trim().isEmpty()) {
					System.out.println("Part senza file, salto al successivo.");
					continue; // Salta i `Part` senza file
				}

				String fileExtension = getFileExtension(fileName);
				String destinationFileName = nomeIniziale + " " + imageNumber + fileExtension;
				String destinationPath = UPLOAD_DIRECTORY + File.separator + destinationFileName;

				System.out.println("Caricamento file: " + destinationFileName);

				// Assicurati che la cartella di destinazione esista
				File destinationDir = new File(UPLOAD_DIRECTORY);
				if (!destinationDir.exists()) {
					destinationDir.mkdirs();
				}

				// Copia il file nella cartella di destinazione
				File destinationFile = new File(destinationPath);
				FileUtils.copyInputStreamToFile(part.getInputStream(), destinationFile);

				imageNumber++;
			}

		}
		request.getRequestDispatcher("prodottoAggiunto.jsp").forward(request, response);
	}

	private String getFileExtension(String fileName) {
		if (fileName == null || fileName.isEmpty() || !fileName.contains(".")) {
			return ""; // Restituisci una stringa vuota se il nome del file non è valido
		}
		return fileName.substring(fileName.lastIndexOf("."));
	}

}
