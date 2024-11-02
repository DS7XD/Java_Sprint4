package br.com.fiap.model.dao;

import br.com.fiap.connection.ConnDAO;
import br.com.fiap.model.vo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OficinaDAO {

    public void inserir(Oficina oficina) {
        String sql = "INSERT INTO Oficina (Endereco_Oficina, Cnpj_Oficina, Nome_Oficina, Avaliacao_Oficina, Especializacao_Oficina, Chatbot_ID_Chatbot, Chatbot_Cliente_CPF_Cliente) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, oficina.getEnderecoOficina());
            pstmt.setString(2, oficina.getCnpjOficina());
            pstmt.setString(3, oficina.getNomeOficina());
            pstmt.setDouble(4, oficina.getAvaliacaoOficina());
            pstmt.setString(5, oficina.getEspecializacaoOficina());
            pstmt.setString(6, oficina.getChatbotId());
            pstmt.setString(7, oficina.getChatbotClienteCpf());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Oficina buscarPorEndereco(String enderecoOficina) {
        String sql = "SELECT * FROM Oficina WHERE Endereco_Oficina = ?";
        Oficina oficina = null;

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, enderecoOficina);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                oficina = new Oficina(
                    rs.getString("Endereco_Oficina"),
                    rs.getString("Cnpj_Oficina"),
                    rs.getString("Nome_Oficina"),
                    rs.getDouble("Avaliacao_Oficina"),
                    rs.getString("Especializacao_Oficina"),
                    rs.getString("Chatbot_ID_Chatbot"),
                    rs.getString("Chatbot_Cliente_CPF_Cliente")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return oficina;
    }

    public void atualizar(Oficina oficina) {
        String sql = "UPDATE Oficina SET Cnpj_Oficina = ?, Nome_Oficina = ?, Avaliacao_Oficina = ?, Especializacao_Oficina = ?, Chatbot_ID_Chatbot = ?, Chatbot_Cliente_CPF_Cliente = ? WHERE Endereco_Oficina = ?";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, oficina.getCnpjOficina());
            pstmt.setString(2, oficina.getNomeOficina());
            pstmt.setDouble(3, oficina.getAvaliacaoOficina());
            pstmt.setString(4, oficina.getEspecializacaoOficina());
            pstmt.setString(5, oficina.getChatbotId());
            pstmt.setString(6, oficina.getChatbotClienteCpf());
            pstmt.setString(7, oficina.getEnderecoOficina());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(String enderecoOficina) {
        String sql = "DELETE FROM Oficina WHERE Endereco_Oficina = ?";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, enderecoOficina);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Oficina> listarTodas() {
        String sql = "SELECT * FROM Oficina";
        List<Oficina> oficinas = new ArrayList<>();

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
             
            while (rs.next()) {
                Oficina oficina = new Oficina(
                    rs.getString("Endereco_Oficina"),
                    rs.getString("Cnpj_Oficina"),
                    rs.getString("Nome_Oficina"),
                    rs.getDouble("Avaliacao_Oficina"),
                    rs.getString("Especializacao_Oficina"),
                    rs.getString("Chatbot_ID_Chatbot"),
                    rs.getString("Chatbot_Cliente_CPF_Cliente")
                );
                oficinas.add(oficina);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return oficinas;
    }
}
