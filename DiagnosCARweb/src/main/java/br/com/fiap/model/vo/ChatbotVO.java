package br.com.fiap.model.vo;

import java.util.Date;

public class ChatbotVO {
    private String idChatbot;
    private Date dataChat;
    private String plano;
    private String cpfClienteCpf;
    private String placaAutomovel;

    public ChatbotVO() {}
    
    public ChatbotVO(String idChatbot, Date dataChat, String plano, String clienteCpf, String placaAutomovel) {
        this.idChatbot = idChatbot;
        this.dataChat = dataChat;
        this.plano = plano;
        this.cpfClienteCpf = clienteCpf;
        this.placaAutomovel = placaAutomovel;
    }

	public String getIdChatbot() {
		return idChatbot;
	}

	public void setIdChatbot(String idChatbot) {
		this.idChatbot = idChatbot;
	}

	public Date getDataChat() {
		return dataChat;
	}

	public void setDataChat(Date dataChat) {
		this.dataChat = dataChat;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public String getCpfClienteCpf() {
		return cpfClienteCpf;
	}

	public void setCpfClienteCpf(String cpfClienteCpf) {
		this.cpfClienteCpf = cpfClienteCpf;
	}

	public String getPlacaAutomovel() {
		return placaAutomovel;
	}

	public void setPlacaAutomovel(String placaAutomovel) {
		this.placaAutomovel = placaAutomovel;
	}
    
    

}
