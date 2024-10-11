package sprint4.model.vo;

import java.util.Date;

public class Chatbot {
    private String idChatbot;
    private Date horarioChat;
    private String planoChatbot;
    private String tipoDeChat;
    private String clienteCpfCliente;

    public Chatbot(String idChatbot, Date horarioChat, String planoChatbot, String tipoDeChat, String clienteCpfCliente) {
        this.idChatbot = idChatbot;
        this.horarioChat = horarioChat;
        this.planoChatbot = planoChatbot;
        this.tipoDeChat = tipoDeChat;
        this.clienteCpfCliente = clienteCpfCliente;
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

	public String getPlanoChatbot() {
		return planoChatbot;
	}

	public void setPlanoChatbot(String planoChatbot) {
		this.planoChatbot = planoChatbot;
	}

	public String getTipoDeChat() {
		return tipoDeChat;
	}

	public void setTipoDeChat(String tipoDeChat) {
		this.tipoDeChat = tipoDeChat;
	}

	public String getClienteCpfCliente() {
		return clienteCpfCliente;
	}

	public void setClienteCpfCliente(String clienteCpfCliente) {
		this.clienteCpfCliente = clienteCpfCliente;
	}

    
}




