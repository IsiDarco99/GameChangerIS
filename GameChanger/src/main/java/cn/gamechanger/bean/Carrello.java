package cn.gamechanger.bean;

public class Carrello {
	private int id_carrello;
	private String username;
	private int idProdotto;
	private int quantitàProdotto;
	private String nomeProdotto;
    private float prezzo;
    
	public Carrello() {
	}

	public Carrello(int id_carrello, String username, int idProdotto, int quantitàProdotto, String nomeProdotto,
			float prezzo) {
		super();
		this.id_carrello = id_carrello;
		this.username = username;
		this.idProdotto = idProdotto;
		this.quantitàProdotto = quantitàProdotto;
		this.nomeProdotto = nomeProdotto;
		this.prezzo = prezzo;
	}

	public int getId_carrello() {
		return id_carrello;
	}

	public void setId_carrello(int id_carrello) {
		this.id_carrello = id_carrello;
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

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Carrello [id_carrello=" + id_carrello + ", username=" + username + ", idProdotto=" + idProdotto
				+ ", quantitàProdotto=" + quantitàProdotto + ", nomeProdotto=" + nomeProdotto + ", prezzo=" + prezzo
				+ "]";
	}
	
	
}
