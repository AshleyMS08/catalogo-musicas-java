package school.sptech;

public class MusicaDigital extends Musica {
    private double tamanhoMB;
    private String formato;

    public MusicaDigital(int id, String titulo, String artista, int duracaoSegundos, double preco, double tamanhoMB, String formato) {
        super(id, titulo, artista, duracaoSegundos, preco);
        this.tamanhoMB = tamanhoMB;
        this.formato = formato;
    }

    public double getTamanhoMB() { return tamanhoMB; }
    public String getFormato() { return formato; }

    @Override
    public void exibirDetalhes() {
        System.out.printf("[DIGITAL] ID: %d | Título: %s | Artista: %s | Duração: %ds | Preço: R$%.2f | Tamanho: %.1fMB | Formato: %s%n",
                id, titulo, artista, duracaoSegundos, preco, tamanhoMB, formato);
    }
}