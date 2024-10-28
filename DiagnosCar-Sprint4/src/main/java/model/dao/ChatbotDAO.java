package model.dao;

import connection.ConnDAO;
import model.vo.Chatbot;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChatbotDAO {

    public void inserir(Chatbot chatbot) {
        String sql = "INSERT INTO Chatbot (ID_Chatbot, Horario_Chat, Plano, Cliente_CPF_Cliente, Placa_Automovel) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, chatbot.getIdChatbot());
            pstmt.setDate(2, new Date(chatbot.getHorarioChat().getTime()));
            pstmt.setString(3, chatbot.getPlano());
            pstmt.setString(4, chatbot.getClienteCpfCliente());
            pstmt.setString(5, chatbot.getPlacaAutomovel());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Chatbot buscarPorId(String idChatbot, String clienteCpfCliente) {
        String sql = "SELECT * FROM Chatbot WHERE ID_Chatbot = ? AND Cliente_CPF_Cliente = ?";
        Chatbot chatbot = null;

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, idChatbot);
            pstmt.setString(2, clienteCpfCliente);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                chatbot = new Chatbot(
                    rs.getString("ID_Chatbot"),
                    rs.getDate("Horario_Chat"),
                    rs.getString("Plano"),
                    rs.getString("Cliente_CPF_Cliente"),
                    rs.getString("Placa_Automovel")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return chatbot;
    }

    public void atualizar(Chatbot chatbot) {
        String sql = "UPDATE Chatbot SET Horario_Chat = ?, Plano = ?, Placa_Automovel = ? WHERE ID_Chatbot = ? AND Cliente_CPF_Cliente = ?";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setDate(1, new Date(chatbot.getHorarioChat().getTime()));
            pstmt.setString(2, chatbot.getPlano());
            pstmt.setString(3, chatbot.getPlacaAutomovel());
            pstmt.setString(4, chatbot.getIdChatbot());
            pstmt.setString(5, chatbot.getClienteCpfCliente());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(String idChatbot, String clienteCpfCliente) {
        String sql = "DELETE FROM Chatbot WHERE ID_Chatbot = ? AND Cliente_CPF_Cliente = ?";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, idChatbot);
            pstmt.setString(2, clienteCpfCliente);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Chatbot> listarTodos() {
        String sql = "SELECT * FROM Chatbot";
        List<Chatbot> chatbots = new ArrayList<>();

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
             
            while (rs.next()) {
                Chatbot chatbot = new Chatbot(
                    rs.getString("ID_Chatbot"),
                    rs.getDate("Horario_Chat"),
                    rs.getString("Plano"),
                    rs.getString("Cliente_CPF_Cliente"),
                    rs.getString("Placa_Automovel")
                );
                chatbots.add(chatbot);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return chatbots;
    }
}
