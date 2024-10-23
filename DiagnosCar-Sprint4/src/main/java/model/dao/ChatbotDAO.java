package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.vo.Chatbot;
import conection.ConnDAO;

public class ChatbotDAO {

    public boolean inserirChatbot(Chatbot chatbot) {
	    String sql = "INSERT INTO Chatbot (ID_Chatbot, Horario_Chat_Chatbot, Plano_Chatbot, Tipodechat_Chatbot, Cliente_CPF_Cliente) VALUES (?, ?, ?, ?, ?)";

	    Connection conn = null;
	    PreparedStatement ps = null;

	    try {
	        conn = ConnDAO.conectar();
	        conn.setAutoCommit(false);

	        ps = conn.prepareStatement(sql);
	        ps.setString(1, chatbot.getIdChatbot());
	        ps.setTimestamp(2, new Timestamp(chatbot.getHorarioChat().getTime()));
	        ps.setString(3, chatbot.getPlanoChatbot());
	        ps.setString(4, chatbot.getTipoDeChat());
	        ps.setString(5, chatbot.getClienteCpfCliente());

	        int rowsInserted = ps.executeUpdate();
	        conn.commit();

	        if (rowsInserted > 0) {
	            System.out.println("Chatbot inserido com sucesso!");
	            return true;
	        } else {
	            System.out.println("Nenhum chatbot foi inserido.");
	            return false;
	        }
	    } catch (SQLException e) {
	        try {
	            if (conn != null) conn.rollback();
	        } catch (SQLException rollbackEx) {
	            rollbackEx.printStackTrace();
	        }
	        e.printStackTrace();
	        System.out.println("Erro ao inserir chatbot: " + e.getMessage());
	        return false;
	    } finally {
	        try {
	            if (ps != null) ps.close();
	            if (conn != null) ConnDAO.desconectar(conn);
	        } catch (SQLException closeEx) {
	            closeEx.printStackTrace();
	        }
	    }
	}

}




