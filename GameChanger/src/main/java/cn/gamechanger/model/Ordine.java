package cn.gamechanger.model;

import java.sql.Date;

public class Ordine {
	private int id_ordine;
	private String username;
	private int codiceProdotto;
	private int quantitàProdotto;
    private float prezzo;
    private String stato_ord;
    private Date dataOrd;
    
    public Ordine() {
	}
    
	public Ordine(int id_ordine, String username, int codiceProdotto, int quantitàProdotto, float prezzo,
			String stato_ord, Date dataOrd) {
		super();
		this.id_ordine = id_ordine;
		this.username = username;
		this.codiceProdotto = codiceProdotto;
		this.quantitàProdotto = quantitàProdotto;
		this.prezzo = prezzo;
		this.stato_ord = stato_ord;
		this.dataOrd = dataOrd;
	}

	public int getId_ordine() {
		return id_ordine;
	}

	public void setId_ordine(int id_ordine) {
		this.id_ordine = id_ordine;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCodiceProdotto() {
		return codiceProdotto;
	}

	public void setCodiceProdotto(int codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}

	public int getQuantitàProdotto() {
		return quantitàProdotto;
	}

	public void setQuantitàProdotto(int quantitàProdotto) {
		this.quantitàProdotto = quantitàProdotto;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public String getStato_ord() {
		return stato_ord;
	}

	public void setStato_ord(String stato_ord) {
		this.stato_ord = stato_ord;
	}

	public Date getDataOrd() {
		return dataOrd;
	}

	public void setDataOrd(Date dataOrd) {
		this.dataOrd = dataOrd;
	}

	@Override
	public String toString() {
		return "Ordine [id_ordine=" + id_ordine + ", username=" + username + ", codiceProdotto=" + codiceProdotto
				+ ", quantitàProdotto=" + quantitàProdotto + ", prezzo=" + prezzo + ", stato_ord=" + stato_ord
				+ ", dataOrd=" + dataOrd + "]";
	}
    
}
