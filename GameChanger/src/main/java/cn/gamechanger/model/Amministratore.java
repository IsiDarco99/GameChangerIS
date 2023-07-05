package cn.gamechanger.model;

public class Amministratore {
	private int idAmministratore;
	private String nome;
	private String cognome;
	private String password;
	private String email;
	
	public Amministratore(int idAmministratore, String nome, String cognome, String password, String email) {
		super();
		this.idAmministratore = idAmministratore;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.email = email;
	}

	public Amministratore() {
	}

	public int getIdAmministratore() {
		return idAmministratore;
	}

	public void setIdAmministratore(int idAmministratore) {
		this.idAmministratore = idAmministratore;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Amministratore [idAmministratore=" + idAmministratore + ", nome=" + nome + ", cognome=" + cognome
				+ ", password=" + password + ", email=" + email + "]";
	}
	
}
