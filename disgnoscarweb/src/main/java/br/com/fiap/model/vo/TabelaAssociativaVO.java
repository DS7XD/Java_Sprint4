package br.com.fiap.model.vo;

public class TabelaAssociativaVO {
    private String cpfCliente;
    private String idChatbot;
    private String enderecoLoja;

    public TabelaAssociativaVO() {}
    
    public TabelaAssociativaVO(String cpfCliente, String idChatbot, String enderecoLoja) {
        this.cpfCliente = cpfCliente;
        this.idChatbot = idChatbot;
        this.enderecoLoja = enderecoLoja;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getIdChatbot() {
        return idChatbot;
    }

    public void setIdChatbot(String idChatbot) {
        this.idChatbot = idChatbot;
    }

    public String getEnderecoLoja() {
        return enderecoLoja;
    }

    public void setEnderecoLoja(String enderecoLoja) {
        this.enderecoLoja = enderecoLoja;
    }
}

