package cn.gamechanger.model;

public class User {
	private String username;
	private String email;
	private String password;
	private String nome;
	private String cognome;
	private String dataNascita;
	private String codFiscale;
	private String numProdAcquist;
	
	public User() {
	}

	public User(String username, String email, String password, String nome, String cognome, String dataNascita,
			String codFiscale, String numProdAcquist) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.codFiscale = codFiscale;
		this.numProdAcquist = numProdAcquist;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getNumProdAcquist() {
		return numProdAcquist;
	}

	public void setNumProdAcquist(String numProdAcquist) {
		this.numProdAcquist = numProdAcquist;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password + ", nome=" + nome
				+ ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", codFiscale=" + codFiscale
				+ ", numProdAcquist=" + numProdAcquist + "]";
	}
	
	
	
	
}
