package br.com.fiap.model.bo;

import br.com.fiap.model.dao.ChatbotDAO;
import br.com.fiap.model.vo.ChatbotVO;
import java.sql.SQLException;
import java.util.List;

public class ChatbotBO {
    private ChatbotDAO chatbotDAO;

    public String cadastrarChatbot(ChatbotVO chatbot) throws SQLException {
        if (chatbot.getIdChatbot() == null || chatbot.getIdChatbot().trim().isEmpty()) {
            throw new IllegalArgumentException("ID do chatbot não pode estar vazio");
        }
        
        if (chatbot.getPlano() == null || chatbot.getPlano().trim().isEmpty()) {
            throw new IllegalArgumentException("Plano do chatbot não pode estar vazio");
        }

        return chatbotDAO.ChatbotDAO_Inserir(chatbot);
    }

    public String atualizarChatbot(ChatbotVO chatbot) throws SQLException {
        if (chatbot.getIdChatbot() == null || chatbot.getIdChatbot().trim().isEmpty()) {
            throw new IllegalArgumentException("ID do chatbot não pode estar vazio");
        }
        return chatbotDAO.ChatbotDAO_Atualizar(chatbot);
    }

    public String deletarChatbot(String id) throws SQLException {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID não pode estar vazio");
        }
        return chatbotDAO.ChatbotDAO_Deletar(id);
    }

    public List<ChatbotVO> listarChatbots() throws SQLException {
        return chatbotDAO.ChatbotDAO_Selecionar();
    }
}