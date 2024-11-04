package br.com.fiap.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OficinaVO {
    @JsonProperty("Endereco_Oficina")
    private String enderecoOficina;

    @JsonProperty("Cnpj_Oficina")
    private String cnpjOficina;

    @JsonProperty("Nome_Oficina")
    private String nomeOficina;

    @JsonProperty("Avaliacao_Oficina")
    private Double avaliacaoOficina;

    @JsonProperty("Especializacao_Oficina")
    private String especializacaoOficina;

    @JsonProperty("Chatbot_ID_Chatbot")
    private String chatbotIdChatbot;

    @JsonProperty("Chatbot_Cliente_CPF_Cliente")
    private String chatbotClienteCpfCliente;

    public OficinaVO() {
    }

    public OficinaVO(String enderecoOficina, String cnpjOficina, String nomeOficina, 
                     Double avaliacaoOficina, String especializacaoOficina, 
                     String chatbotIdChatbot, String chatbotClienteCpfCliente) {
        this.enderecoOficina = enderecoOficina;
        this.cnpjOficina = cnpjOficina;
        this.nomeOficina = nomeOficina;
        this.avaliacaoOficina = avaliacaoOficina;
        this.especializacaoOficina = especializacaoOficina;
        this.chatbotIdChatbot = chatbotIdChatbot;
        this.chatbotClienteCpfCliente = chatbotClienteCpfCliente;
    }

    public String getEnderecoOficina() {
        return enderecoOficina;
    }

    public void setEnderecoOficina(String enderecoOficina) {
        this.enderecoOficina = enderecoOficina;
    }

    public String getCnpjOficina() {
        return cnpjOficina;
    }

    public void setCnpjOficina(String cnpjOficina) {
        this.cnpjOficina = cnpjOficina;
    }

    public String getNomeOficina() {
        return nomeOficina;
    }

    public void setNomeOficina(String nomeOficina) {
        this.nomeOficina = nomeOficina;
    }

    public Double getAvaliacaoOficina() {
        return avaliacaoOficina;
    }

    public void setAvaliacaoOficina(Double avaliacaoOficina) {
        this.avaliacaoOficina = avaliacaoOficina;
    }

    public String getEspecializacaoOficina() {
        return especializacaoOficina;
    }

    public void setEspecializacaoOficina(String especializacaoOficina) {
        this.especializacaoOficina = especializacaoOficina;
    }

    public String getChatbotIdChatbot() {
        return chatbotIdChatbot;
    }

    public void setChatbotIdChatbot(String chatbotIdChatbot) {
        this.chatbotIdChatbot = chatbotIdChatbot;
    }

    public String getChatbotClienteCpfCliente() {
        return chatbotClienteCpfCliente;
    }

    public void setChatbotClienteCpfCliente(String chatbotClienteCpfCliente) {
        this.chatbotClienteCpfCliente = chatbotClienteCpfCliente;
    }
}
