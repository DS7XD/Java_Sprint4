package model.dao;

import connection.ConnDAO;
import model.vo.Loja_Parceira;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Loja_ParceiraDAO {

    public void inserir(Loja_Parceira lojaParceira) {
        String sql = "INSERT INTO Loja_Parceira (Endereco_Loja, Cnpj_Loja, Nome_Loja, Avaliacao_Loja, Especializacao_Loja) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, lojaParceira.getEnderecoLoja());
            pstmt.setString(2, lojaParceira.getCnpjLoja());
            pstmt.setString(3, lojaParceira.getNomeLoja());
            pstmt.setDouble(4, lojaParceira.getAvaliacaoLoja());
            pstmt.setString(5, lojaParceira.getEspecializacaoLoja());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Loja_Parceira buscarPorEndereco(String enderecoLoja) {
        String sql = "SELECT * FROM Loja_Parceira WHERE Endereco_Loja = ?";
        Loja_Parceira lojaParceira = null;

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, enderecoLoja);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                lojaParceira = new Loja_Parceira(
                    rs.getString("Endereco_Loja"),
                    rs.getString("Cnpj_Loja"),
                    rs.getString("Nome_Loja"),
                    rs.getDouble("Avaliacao_Loja"),
                    rs.getString("Especializacao_Loja")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lojaParceira;
    }

    public void atualizar(Loja_Parceira lojaParceira) {
        String sql = "UPDATE Loja_Parceira SET Cnpj_Loja = ?, Nome_Loja = ?, Avaliacao_Loja = ?, Especializacao_Loja = ? WHERE Endereco_Loja = ?";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, lojaParceira.getCnpjLoja());
            pstmt.setString(2, lojaParceira.getNomeLoja());
            pstmt.setDouble(3, lojaParceira.getAvaliacaoLoja());
            pstmt.setString(4, lojaParceira.getEspecializacaoLoja());
            pstmt.setString(5, lojaParceira.getEnderecoLoja());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(String enderecoLoja) {
        String sql = "DELETE FROM Loja_Parceira WHERE Endereco_Loja = ?";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, enderecoLoja);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Loja_Parceira> listarTodas() {
        String sql = "SELECT * FROM Loja_Parceira";
        List<Loja_Parceira> lojasParceiras = new ArrayList<>();

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
             
            while (rs.next()) {
                Loja_Parceira lojaParceira = new Loja_Parceira(
                    rs.getString("Endereco_Loja"),
                    rs.getString("Cnpj_Loja"),
                    rs.getString("Nome_Loja"),
                    rs.getDouble("Avaliacao_Loja"),
                    rs.getString("Especializacao_Loja")
                );
                lojasParceiras.add(lojaParceira);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lojasParceiras;
    }
}
