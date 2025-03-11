
public class Bevanda {
    
    private int id;
    private String tipo;
    private String nome;
    private String produttore;
    private int anno;
    private double prezzo;
    private String provenienza;
    private int gradi;
    private char ed_limitata;
    private int quantita;
    private String volume;

    public Bevanda(){}

    public Bevanda(int id, String tipo, String nome, String produttore, int anno, double prezzo, String provenienza,
            int gradi, char ed_limitata, int quantita, String volume) 
    {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.produttore = produttore;
        this.anno = anno;
        this.prezzo = prezzo;
        this.provenienza = provenienza;
        this.gradi = gradi;
        this.ed_limitata = ed_limitata;
        this.quantita = quantita;
        this.volume = volume;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getProduttore() {
        return produttore;
    }


    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }


    public int getAnno() {
        return anno;
    }


    public void setAnno(int anno) {
        this.anno = anno;
    }


    public double getPrezzo() {
        return prezzo;
    }


    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }


    public String getProvenienza() {
        return provenienza;
    }


    public void setProvenienza(String provenienza) {
        this.provenienza = provenienza;
    }


    public int getGradi() {
        return gradi;
    }


    public void setGradi(int gradi) {
        this.gradi = gradi;
    }


    public char getEd_limitata() {
        return ed_limitata;
    }


    public void setEd_limitata(char ed_limitata) {
        this.ed_limitata = ed_limitata;
    }


    public int getQuantita() {
        return quantita;
    }


    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }


    public String getVolume() {
        return volume;
    }


    public void setVolume(String volume) {
        this.volume = volume;
    }


    @Override
    public String toString() {
        return "Bevande [id=" + id + ", tipo=" + tipo + ", nome=" + nome + ", produttore=" + produttore + ", anno="
                + anno + ", prezzo=" + prezzo + ", provenienza=" + provenienza + ", gradi=" + gradi + ", ed_limitata="
                + ed_limitata + ", quantita=" + quantita + ", volume=" + volume + "]";
    }


}
