package cn.gamechanger.model;

import java.sql.Date;

public class Ordine {
	private int id_ordine;
	private String username;
    private String stato_ord;
    private String dataOrd;
    
    public Ordine() {
	}

	public Ordine(int id_ordine, String username, String stato_ord, String dataOrd) {
		super();
		this.id_ordine = id_ordine;
		this.username = username;
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

	public String getStato_ord() {
		return stato_ord;
	}

	public void setStato_ord(String stato_ord) {
		this.stato_ord = stato_ord;
	}

	public String getDataOrd() {
		return dataOrd;
	}

	public void setDataOrd(String dataOrdStringa) {
		this.dataOrd = dataOrdStringa;
	}

	@Override
	public String toString() {
		return "Ordine [id_ordine=" + id_ordine + ", username=" + username + ", stato_ord=" + stato_ord + ", dataOrd="
				+ dataOrd + "]";
	}
    
	
    
}
