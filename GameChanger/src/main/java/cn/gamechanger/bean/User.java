package cn.gamechanger.bean;

public class User {
	private String username;
	private String emailPers;
	private String emailPaypal;
	private int numTel;
	private String indirizzo;
	private String stato;
	private String citta;
	private int cod_postale;
	private String password;
	private String nome;
	private String cognome;
	private String dataNascita;
	private String codFiscale;
	private int immagine;
	
	public User() {
	}

	public User(String username, String emailPers, String emailPaypal, int numTel, String indirizzo, String stato,
			String citta, int cod_postale, String password, String nome, String cognome, String dataNascita,
			String codFiscale, int immagine) {
		super();
		this.username = username;
		this.emailPers = emailPers;
		this.emailPaypal = emailPaypal;
		this.numTel = numTel;
		this.indirizzo = indirizzo;
		this.stato = stato;
		this.citta = citta;
		this.cod_postale = cod_postale;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.codFiscale = codFiscale;
		this.immagine = immagine;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailPers() {
		return emailPers;
	}

	public void setEmailPers(String emailPers) {
		this.emailPers = emailPers;
	}

	public String getEmailPaypal() {
		return emailPaypal;
	}

	public void setEmailPaypal(String emailPaypal) {
		this.emailPaypal = emailPaypal;
	}

	public int getNumTel() {
		return numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public int getCod_postale() {
		return cod_postale;
	}

	public void setCod_postale(int cod_postale) {
		this.cod_postale = cod_postale;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getCodFiscale() {
		return codFiscale;
	}

	public void setCodFiscale(String codFiscale) {
		this.codFiscale = codFiscale;
	}

	public int getImmagine() {
		return immagine;
	}

	public void setImmagine(int immagine) {
		this.immagine = immagine;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", emailPers=" + emailPers + ", emailPaypal=" + emailPaypal + ", numTel="
				+ numTel + ", indirizzo=" + indirizzo + ", stato=" + stato + ", citta=" + citta + ", cod_postale="
				+ cod_postale + ", password=" + password + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita="
				+ dataNascita + ", codFiscale=" + codFiscale + ", immagine=" + immagine + "]";
	}

	
}
