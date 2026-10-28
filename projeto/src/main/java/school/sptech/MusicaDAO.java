package school.sptech;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicaDAO {

    public void salvarDigital(MusicaDigital m) {
        String sql = "INSERT INTO musica (titulo, artista, duracao_segundos, preco, tipo, tamanho_mb, formato) VALUES (?, ?, ?, ?, 'DIGITAL', ?, ?)";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, m.getTitulo());
            stmt.setString(2, m.getArtista());
            stmt.setInt(3, m.getDuracaoSegundos());
            stmt.setDouble(4, m.getPreco());
            stmt.setDouble(5, m.getTamanhoMB());
            stmt.setString(6, m.getFormato());
            stmt.executeUpdate();
            System.out.println("Música digital cadastrada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao salvar música digital: " + e.getMessage());
        }
    }

    public void salvarVinil(MusicaVinil m) {
        String sql = "INSERT INTO musica (titulo, artista, duracao_segundos, preco, tipo, rpm, condicao) VALUES (?, ?, ?, ?, 'VINIL', ?, ?)";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, m.getTitulo());
            stmt.setString(2, m.getArtista());
            stmt.setInt(3, m.getDuracaoSegundos());
            stmt.setDouble(4, m.getPreco());
            stmt.setInt(5, m.getRpm());
            stmt.setString(6, m.getCondicao());
            stmt.executeUpdate();
            System.out.println("Música em vinil cadastrada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao salvar música em vinil: " + e.getMessage());
        }
    }

    public List<Musica> listarTodas() {
        List<Musica> lista = new ArrayList<>();
        String sql = "SELECT * FROM musica";
        try (Connection conn = ConexaoBD.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String tipo = rs.getString("tipo");
                if ("DIGITAL".equals(tipo)) {
                    lista.add(new MusicaDigital(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("artista"),
                            rs.getInt("duracao_segundos"),
                            rs.getDouble("preco"),
                            rs.getDouble("tamanho_mb"),
                            rs.getString("formato")
                    ));
                } else if ("VINIL".equals(tipo)) {
                    lista.add(new MusicaVinil(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("artista"),
                            rs.getInt("duracao_segundos"),
                            rs.getDouble("preco"),
                            rs.getInt("rpm"),
                            rs.getString("condicao")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar músicas: " + e.getMessage());
        }
        return lista;
    }

    public List<Musica> buscarPorTituloOuArtista(String termo) {
        List<Musica> lista = new ArrayList<>();
        String sql = "SELECT * FROM musica WHERE titulo LIKE ? OR artista LIKE ?";

        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + termo + "%");
            stmt.setString(2, "%" + termo + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String tipo = rs.getString("tipo");
                if ("DIGITAL".equals(tipo)) {
                    lista.add(new MusicaDigital(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("artista"),
                            rs.getInt("duracao_segundos"),
                            rs.getDouble("preco"),
                            rs.getDouble("tamanho_mb"),
                            rs.getString("formato")
                    ));
                } else if ("VINIL".equals(tipo)) {
                    lista.add(new MusicaVinil(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("artista"),
                            rs.getInt("duracao_segundos"),
                            rs.getDouble("preco"),
                            rs.getInt("rpm"),
                            rs.getString("condicao")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar músicas: " + e.getMessage());
        }
        return lista;
    }
}