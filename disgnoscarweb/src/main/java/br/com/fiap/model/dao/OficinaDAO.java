package br.com.fiap.model.dao;

import br.com.fiap.model.vo.Oficina;
import br.com.fiap.connection.ConnDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OficinaDAO {

    private Connection conexao;

    public OficinaDAO() throws ClassNotFoundException, SQLException {
        this.conexao = new ConnDAO().conexao();
    }

    // Método para fechar a conexão
    private void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Inserir
    public String OficinaDAO_Inserir(Oficina oficina) throws SQLException {
        String sql = "INSERT INTO OFICINA (ENDERECO_OFICINA, CNPJ_OFICINA, NOME_OFICINA, AVALIACAO_OFICINA, ESPECIALIZACAO_OFICINA, CHATBOT_ID, CHATBOT_CLIENTE_CPF) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, oficina.getEnderecoOficina());
            stmt.setString(2, oficina.getCnpjOficina());
            stmt.setString(3, oficina.getNomeOficina());
            stmt.setDouble(4, oficina.getAvaliacaoOficina());
            stmt.setString(5, oficina.getEspecializacaoOficina());
            stmt.setString(6, oficina.getChatbotId());
            stmt.setString(7, oficina.getChatbotClienteCpf());
            stmt.executeUpdate();
        } finally {
            fecharConexao();
        }
        return "Oficina cadastrada com sucesso!";
    }

    // Deletar
    public String OficinaDAO_deletar(String cnpjOficina) throws SQLException {
        String sql = "DELETE FROM OFICINA WHERE CNPJ_OFICINA = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cnpjOficina);
            stmt.executeUpdate();
        } finally {
            fecharConexao();
        }
        return "Oficina deletada com sucesso!";
    }

    // Atualizar
    public String OficinaDAO_Atualizar(Oficina oficina) throws SQLException {
        String sql = "UPDATE OFICINA SET ENDERECO_OFICINA = ?, NOME_OFICINA = ?, AVALIACAO_OFICINA = ?, ESPECIALIZACAO_OFICINA = ?, CHATBOT_ID = ?, CHATBOT_CLIENTE_CPF = ? WHERE CNPJ_OFICINA = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, oficina.getEnderecoOficina());
            stmt.setString(2, oficina.getNomeOficina());
            stmt.setDouble(3, oficina.getAvaliacaoOficina());
            stmt.setString(4, oficina.getEspecializacaoOficina());
            stmt.setString(5, oficina.getChatbotId());
            stmt.setString(6, oficina.getChatbotClienteCpf());
            stmt.setString(7, oficina.getCnpjOficina());
            stmt.executeUpdate();
        } finally {
            fecharConexao();
        }
        return "Oficina atualizada com sucesso!";
    }

    // Selecionar
    public List<Oficina> OficinaDAO_Selecionar() throws SQLException {
        List<Oficina> listaOficinas = new ArrayList<>();
        String sql = "SELECT * FROM OFICINA";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                Oficina oficina = new Oficina(
                    rs.getString("ENDERECO_OFICINA"),
                    rs.getString("CNPJ_OFICINA"),
                    rs.getString("NOME_OFICINA"),
                    rs.getDouble("AVALIACAO_OFICINA"),
                    rs.getString("ESPECIALIZACAO_OFICINA"),
                    rs.getString("CHATBOT_ID"),
                    rs.getString("CHATBOT_CLIENTE_CPF")
                );
                listaOficinas.add(oficina);
            }
        } finally {
            fecharConexao();
        }
        return listaOficinas;
    }
}
