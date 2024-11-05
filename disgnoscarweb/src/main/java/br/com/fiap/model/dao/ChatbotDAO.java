package br.com.fiap.model.dao;

import br.com.fiap.model.vo.ChatbotVO;
import br.com.fiap.connection.ConnDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChatbotDAO {

    private Connection conexao;

    public ChatbotDAO() throws ClassNotFoundException, SQLException {
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
    public String ChatbotDAO_Inserir(ChatbotVO chatbot) throws SQLException {
        String sql = "INSERT INTO CHATBOT (ID_CHATBOT, HORARIO_CHAT, PLANO, CPF_CLIENTE, PLACA_AUTOMOVEL) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, chatbot.getIdChatbot());
            stmt.setTimestamp(2, new java.sql.Timestamp(chatbot.getHorarioChat().getTime()));
            stmt.setString(3, chatbot.getPlano());
            stmt.setString(4, chatbot.getClienteCpfCliente());
            stmt.setString(5, chatbot.getPlacaAutomovel());
            stmt.executeUpdate();
        } finally {
            fecharConexao();
        }
        return "Chatbot cadastrado com sucesso!";
    }

    // Deletar
    public String ChatbotDAO_Deletar(String idChatbot) throws SQLException {
        String sql = "DELETE FROM CHATBOT WHERE ID_CHATBOT = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, idChatbot);
            stmt.executeUpdate();
        } finally {
            fecharConexao();
        }
        return "Chatbot deletado com sucesso!";
    }

    // Atualizar
    public String ChatbotDAO_Atualizar(ChatbotVO chatbot) throws SQLException {
        String sql = "UPDATE CHATBOT SET HORARIO_CHAT = ?, PLANO = ?, CPF_CLIENTE = ?, PLACA_AUTOMOVEL = ? WHERE ID_CHATBOT = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setTimestamp(1, new java.sql.Timestamp(chatbot.getHorarioChat().getTime()));
            stmt.setString(2, chatbot.getPlano());
            stmt.setString(3, chatbot.getClienteCpfCliente());
            stmt.setString(4, chatbot.getPlacaAutomovel());
            stmt.setString(5, chatbot.getIdChatbot());
            stmt.executeUpdate();
        } finally {
            fecharConexao();
        }
        return "Chatbot atualizado com sucesso!";
    }

    // Selecionar
    public List<ChatbotVO> ChatbotDAO_Selecionar() throws SQLException {
        List<ChatbotVO> listaChatbot = new ArrayList<>();
        String sql = "SELECT * FROM CHATBOT";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                ChatbotVO chatbot = new ChatbotVO(
                    rs.getString("ID_CHATBOT"),
                    rs.getTimestamp("HORARIO_CHAT"),
                    rs.getString("PLANO"),
                    rs.getString("CPF_CLIENTE"),
                    rs.getString("PLACA_AUTOMOVEL")
                );
                listaChatbot.add(chatbot);
            }
        } finally {
            fecharConexao();
        }
        return listaChatbot;
    }
}
