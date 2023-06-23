package cn.gamechanger.model;

public class Accessorio extends Prodotto{
	private String tipo;

	public Accessorio(String tipo) {
		super();
		this.tipo = tipo;
	}

	public Accessorio() {
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Accessorio [tipo=" + tipo + "]";
	}
	
}
