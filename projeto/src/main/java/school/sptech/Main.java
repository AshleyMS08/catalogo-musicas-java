package school.sptech;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicaDAO dao = new MusicaDAO();
        int opcao;

        do {
            System.out.println("\n=== CATÁLOGO DE MÚSICAS ===");
            System.out.println("1. Cadastrar Música Digital");
            System.out.println("2. Cadastrar Música em Vinil");
            System.out.println("3. Listar Todas as Músicas");
            System.out.println("4. Buscar Música (por Título ou Artista)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> {
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Duração (segundos): ");
                    int duracao = Integer.parseInt(scanner.nextLine());
                    System.out.print("Preço: ");
                    double preco = Double.parseDouble(scanner.nextLine());
                    System.out.print("Tamanho (MB): ");
                    double tamanho = Double.parseDouble(scanner.nextLine());
                    System.out.print("Formato (ex: MP3, FLAC): ");
                    String formato = scanner.nextLine();

                    dao.salvarDigital(new MusicaDigital(0, titulo, artista, duracao, preco, tamanho, formato));
                }
                case 2 -> {
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Duração (segundos): ");
                    int duracao = Integer.parseInt(scanner.nextLine());
                    System.out.print("Preço: ");
                    double preco = Double.parseDouble(scanner.nextLine());
                    System.out.print("RPM (33 ou 45): ");
                    int rpm = Integer.parseInt(scanner.nextLine());
                    System.out.print("Condição (ex: Novo, Usado): ");
                    String condicao = scanner.nextLine();

                    dao.salvarVinil(new MusicaVinil(0, titulo, artista, duracao, preco, rpm, condicao));
                }
                case 3 -> {
                    System.out.println("\n--- Músicas Cadastradas ---");
                    List<Musica> musicas = dao.listarTodas();
                    if (musicas.isEmpty()) {
                        System.out.println("Nenhuma música cadastrada.");
                    } else {
                        musicas.forEach(Musica::exibirDetalhes);
                    }
                }
                case 4 -> {
                    System.out.print("Digite o título ou artista para buscar: ");
                    String termo = scanner.nextLine();
                    List<Musica> resultados = dao.buscarPorTituloOuArtista(termo);
                    if (resultados.isEmpty()) {
                        System.out.println("Nenhuma música encontrada.");
                    } else {
                        System.out.println("\n--- Músicas Encontradas ---");
                        resultados.forEach(Musica::exibirDetalhes);
                    }
                }
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}