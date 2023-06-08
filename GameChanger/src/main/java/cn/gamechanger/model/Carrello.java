package cn.gamechanger.model;

public class Carrello {
	private int idCarrello;
	private String username;
	private int idProdotto;
	private int quantitàProdotto;
	
	public Carrello() {
	}

	public Carrello(int idCarrello, String username, int idProdotto, int quantitàProdotto) {
		super();
		this.idCarrello = idCarrello;
		this.username = username;
		this.idProdotto = idProdotto;
		this.quantitàProdotto = quantitàProdotto;
	}

	public int getIdCarrello() {
		return idCarrello;
	}

	public void setIdCarrello(int idCarrello) {
		this.idCarrello = idCarrello;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public int getQuantitàProdotto() {
		return quantitàProdotto;
	}

	public void setQuantitàProdotto(int quantitàProdotto) {
		this.quantitàProdotto = quantitàProdotto;
	}
	
	
}
