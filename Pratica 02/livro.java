public class livro extends geral {

    private String autor;

    public livro(String titulo, String autor, int ano) {
        super(titulo, ano);
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro: " + getTitulo() + ", Autor: " + getAutor() + ", Ano: " + getAno();
    }


    public String getAutor() {
        return autor;
    }

}
