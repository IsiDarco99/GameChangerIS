package cn.gamechanger.model;

public class Prodotto {
    private int codice;
    private float prezzo;
    private String nome;
    private String marca;
    private String descrizione;
    private String dataUscita;

    public Prodotto() {
    }

    public Prodotto(int codice, float prezzo, String nome, String marca, String descrizione, String dataUscita) {
        this.codice = codice;
        this.prezzo = prezzo;
        this.nome = nome;
        this.marca = marca;
        this.descrizione = descrizione;
        this.dataUscita = dataUscita;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDataUscita() {
        return dataUscita;
    }

    public void setDataUscita(String dataUscita) {
        this.dataUscita = dataUscita;
    }

    @Override
    public String toString() {
        return "Prodotto [codice=" + codice + ", prezzo=" + prezzo + ", nome=" + nome + ", marca=" + marca
                + ", descrizione=" + descrizione + ", dataUscita=" + dataUscita + "]";
    }
}
