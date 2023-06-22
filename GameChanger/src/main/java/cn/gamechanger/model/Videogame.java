package cn.gamechanger.model;

import java.sql.Date;

public class Videogame extends Prodotto {
    private String pegi;
    private String sviluppatore;
    private String genere;

    public Videogame(int codice, float prezzo, String nome, String marca, String descrizione, Date dataUscita, String pegi, String sviluppatore, String genere) {
        super(codice, prezzo, nome, marca, descrizione, dataUscita);
        this.pegi = pegi;
        this.sviluppatore = sviluppatore;
        this.genere = genere;
    }
    
    public Videogame() {
	}

	public String getPegi() {
        return pegi;
    }

    public void setPegi(String pegi) {
        this.pegi = pegi;
    }

    public String getSviluppatore() {
        return sviluppatore;
    }

    public void setSviluppatore(String sviluppatore) {
        this.sviluppatore = sviluppatore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

	@Override
	public String toString() {
		return "Videogame [pegi=" + pegi + ", sviluppatore=" + sviluppatore + ", genere=" + genere + "]";
	}
    
    
}
