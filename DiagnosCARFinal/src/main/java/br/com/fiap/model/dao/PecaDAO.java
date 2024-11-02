package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.connection.ConnDAO;
import br.com.fiap.model.vo.*;


public class PecaDAO {

    public void inserir(Peca peca) {
        String sql = "INSERT INTO Peca (ID_Peca, Tipo_Peca, Nome_Peca, Descricao_Peca, Loja_Parceira_Endereco_Loja) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, peca.getIdPeca());
            pstmt.setString(2, peca.getTipoPeca());
            pstmt.setString(3, peca.getNomePeca());
            pstmt.setString(4, peca.getDescricaoPeca());
            pstmt.setString(5, peca.getLojaParceiraEndereco());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Peca buscarPorId(String idPeca) {
        String sql = "SELECT * FROM Peca WHERE ID_Peca = ?";
        Peca peca = null;

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, idPeca);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                peca = new Peca(
                    rs.getString("ID_Peca"),
                    rs.getString("Tipo_Peca"),
                    rs.getString("Nome_Peca"),
                    rs.getString("Descricao_Peca"),
                    rs.getString("Loja_Parceira_Endereco_Loja")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return peca;
    }

    public void atualizar(Peca peca) {
        String sql = "UPDATE Peca SET Tipo_Peca = ?, Nome_Peca = ?, Descricao_Peca = ?, Loja_Parceira_Endereco_Loja = ? WHERE ID_Peca = ?";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, peca.getTipoPeca());
            pstmt.setString(2, peca.getNomePeca());
            pstmt.setString(3, peca.getDescricaoPeca());
            pstmt.setString(4, peca.getLojaParceiraEndereco());
            pstmt.setString(5, peca.getIdPeca());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(String idPeca) {
        String sql = "DELETE FROM Peca WHERE ID_Peca = ?";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, idPeca);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Peca> listarTodas() {
        String sql = "SELECT * FROM Peca";
        List<Peca> pecas = new ArrayList<>();

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
             
            while (rs.next()) {
                Peca peca = new Peca(
                    rs.getString("ID_Peca"),
                    rs.getString("Tipo_Peca"),
                    rs.getString("Nome_Peca"),
                    rs.getString("Descricao_Peca"),
                    rs.getString("Loja_Parceira_Endereco_Loja")
                );
                pecas.add(peca);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pecas;
    }
}
