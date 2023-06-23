package cn.gamechanger.model;

public class Computer extends Prodotto {
    private String casa;
    private String ufficio;
    private String gaming;
	public Computer(String casa, String ufficio, String gaming) {
		super();
		this.casa = casa;
		this.ufficio = ufficio;
		this.gaming = gaming;
	}
	public Computer() {
	}
	public String getCasa() {
		return casa;
	}
	public void setCasa(String casa) {
		this.casa = casa;
	}
	public String getUfficio() {
		return ufficio;
	}
	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}
	public String getGaming() {
		return gaming;
	}
	public void setGaming(String gaming) {
		this.gaming = gaming;
	}
	@Override
	public String toString() {
		return "Computer [casa=" + casa + ", ufficio=" + ufficio + ", gaming=" + gaming + "]";
	}
    
}
