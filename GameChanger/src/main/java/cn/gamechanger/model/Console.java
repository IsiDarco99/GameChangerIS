package cn.gamechanger.model;

public class Console extends Prodotto {
    private int generazione;

	public Console(int generazione) {
		super();
		this.generazione = generazione;
	}

	public Console() {
	}

	public int getGenerazione() {
		return generazione;
	}

	public void setGenerazione(int generazione) {
		this.generazione = generazione;
	}

	@Override
	public String toString() {
		return "Console [generazione=" + generazione + "]";
	}
    
}
