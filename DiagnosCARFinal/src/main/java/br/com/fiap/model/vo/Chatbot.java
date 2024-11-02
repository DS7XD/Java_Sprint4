package br.com.fiap.model.vo;

import java.util.Date;

public class Chatbot {
    private String idChatbot;          // ID_Chatbot
    private Date horarioChat;          // Horario_Chat
    private String plano;              // Plano
    private String clienteCpfCliente;  // Cliente_CPF_Cliente
    private String placaAutomovel;     // Placa_Automovel

    public Chatbot(String idChatbot, Date horarioChat, String plano, String clienteCpfCliente, String placaAutomovel) {
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
