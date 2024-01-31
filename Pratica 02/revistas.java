public class revistas extends geral{
    String Org;
    int vol;
    int nro;

    public revistas(String titulo, String Org, int vol, int nro, int ano)
    {
        super(titulo,ano);
        this.Org = Org;
        this.vol = vol;
        this.nro = nro;

    }
    public String toString() {
        return "Revista: " + getTitulo() + ", Org: " + getOrg() + ", Volume: " + getVol() +
                ", Numero: " + getNro() + ", Ano: " + getAno();
    }
    public String getOrg() {
        return Org;
    }

    public int getVol() {
        return vol;
    }

    public int getNro() {
        return nro;
    }
}