package school.sptech;

public abstract class Musica {
    protected int id;
    protected String titulo;
    protected String artista;
    protected int duracaoSegundos;
    protected double preco;

    public Musica(int id, String titulo, String artista, int duracaoSegundos, double preco) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoSegundos = duracaoSegundos;
        this.preco = preco;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public int getDuracaoSegundos() { return duracaoSegundos; }
    public double getPreco() { return preco; }

    public abstract void exibirDetalhes();
}