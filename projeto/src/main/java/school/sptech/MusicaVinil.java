package school.sptech;

public class MusicaVinil extends Musica {
    private int rpm;
    private String condicao;

    public MusicaVinil(int id, String titulo, String artista, int duracaoSegundos, double preco, int rpm, String condicao) {
        super(id, titulo, artista, duracaoSegundos, preco);
        this.rpm = rpm;
        this.condicao = condicao;
    }

    public int getRpm() { return rpm; }
    public String getCondicao() { return condicao; }

    @Override
    public void exibirDetalhes() {
        System.out.printf("[VINIL]   ID: %d | Título: %s | Artista: %s | Duração: %ds | Preço: R$%.2f | RPM: %d | Condição: %s%n",
                id, titulo, artista, duracaoSegundos, preco, rpm, condicao);
    }
}