package br.com.fiap.model.vo;

import java.util.Date;

public class ChatbotVO {
    private String idChatbot;
    private Date horarioChat;
    private String plano;
    private String clienteCpfCliente;
    private String placaAutomovel;

    public ChatbotVO(String idChatbot, Date horarioChat, String plano, String clienteCpfCliente, String placaAutomovel) {
        this.idChatbot = idChatbot;
        this.horarioChat = horarioChat;
        this.plano = plano;
        this.clienteCpfCliente = clienteCpfCliente;
        this.placaAutomovel = placaAutomovel;
    }

    public String getIdChatbot() {
        return idChatbot;
    }

    public void setIdChatbot(String idChatbot) {
        this.idChatbot = idChatbot;
    }

    public Date getHorarioChat() {
        return horarioChat;
    }

    public void setHorarioChat(Date horarioChat) {
        this.horarioChat = horarioChat;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getClienteCpfCliente() {
        return clienteCpfCliente;
    }

    public void setClienteCpfCliente(String clienteCpfCliente) {
        this.clienteCpfCliente = clienteCpfCliente;
    }

    public String getPlacaAutomovel() {
        return placaAutomovel;
    }

    public void setPlacaAutomovel(String placaAutomovel) {
        this.placaAutomovel = placaAutomovel;
    }
}
