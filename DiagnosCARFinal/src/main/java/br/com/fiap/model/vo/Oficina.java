package br.com.fiap.model.vo;

public class Oficina {
    private String enderecoOficina;         // Endereco_Oficina
    private String cnpjOficina;             // Cnpj_Oficina
    private String nomeOficina;              // Nome_Oficina
    private Double avaliacaoOficina;        // Avaliacao_Oficina
    private String especializacaoOficina;   // Especializacao_Oficina
    private String chatbotId;                // Chatbot_ID_Chatbot
    private String chatbotClienteCpf;        // Chatbot_Cliente_CPF_Cliente

    public Oficina(String enderecoOficina, String cnpjOficina, String nomeOficina, Double avaliacaoOficina, String especializacaoOficina, String chatbotId, String chatbotClienteCpf) {
        this.enderecoOficina = enderecoOficina;
        this.cnpjOficina = cnpjOficina;
        this.nomeOficina = nomeOficina;
        this.avaliacaoOficina = avaliacaoOficina;
        this.especializacaoOficina = especializacaoOficina;
        this.chatbotId = chatbotId;
        this.chatbotClienteCpf = chatbotClienteCpf;
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

    public String getChatbotId() {
        return chatbotId;
    }

    public void setChatbotId(String chatbotId) {
        this.chatbotId = chatbotId;
    }

    public String getChatbotClienteCpf() {
        return chatbotClienteCpf;
    }

    public void setChatbotClienteCpf(String chatbotClienteCpf) {
        this.chatbotClienteCpf = chatbotClienteCpf;
    }
}
