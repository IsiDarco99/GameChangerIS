package cn.gamechanger.bean;

public class ProdottoOrdine {
	private int id_ordine;
	private int codice;
	private String nome;
	private float prezzo;
	private int quantita;
	
	public ProdottoOrdine(int id_ordine, int codice, String nome, float prezzo, int quantita) {
		super();
		this.id_ordine = id_ordine;
		this.codice = codice;
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantita = quantita;
	}

	public int getId_ordine() {
		return id_ordine;
	}

	public void setId_ordine(int id_ordine) {
		this.id_ordine = id_ordine;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "ProdottoOrdine [id_ordine=" + id_ordine + ", codice=" + codice + ", nome=" + nome + ", prezzo=" + prezzo
				+ ", quantita=" + quantita + "]";
	}
	
	
		
}
