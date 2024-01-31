public class video extends geral {
    String autor;
    String duracao;
    public video(String titulo, int ano, String autor, String duracao)
    {
        super(titulo,ano);
        this.autor = autor;
        this.duracao = duracao;
    }
}
