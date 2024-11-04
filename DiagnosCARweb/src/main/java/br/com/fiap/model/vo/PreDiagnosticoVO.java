package br.com.fiap.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PreDiagnosticoVO {

    @JsonProperty("idPreDiagnostico")
    private String ID_PreDiagnostico;

    @JsonProperty("nivelDiagnostico")
    private int Nivel_Diagnostico;

    @JsonProperty("diagnostico")
    private String Diagnostico;

    @JsonProperty("assistente_ID_Chatbot")
    private String Assistente_ID_Chatbot;

    @JsonProperty("cliente_CPF_Cliente")
    private String Cliente_CPF_Cliente;

    @JsonProperty("placa_Automovel")
    private String Placa_Automovel;

    // Construtor vazio
    public PreDiagnosticoVO() {
    }

    // Construtor completo com todos os campos
    public PreDiagnosticoVO(String ID_PreDiagnostico, int Nivel_Diagnostico, String Diagnostico,String Assistente_ID_Chatbot, String Cliente_CPF_Cliente, String Placa_Automovel) {
        this.ID_PreDiagnostico = ID_PreDiagnostico;
        this.Nivel_Diagnostico = Nivel_Diagnostico;
        this.Diagnostico = Diagnostico;
        this.Assistente_ID_Chatbot = Assistente_ID_Chatbot;
        this.Cliente_CPF_Cliente = Cliente_CPF_Cliente;
        this.Placa_Automovel = Placa_Automovel;
    }

    // Getters e Setters

    public String getID_PreDiagnostico() {
        return ID_PreDiagnostico;
    }

    public void setID_PreDiagnostico(String ID_PreDiagnostico) {
        this.ID_PreDiagnostico = ID_PreDiagnostico;
    }

    public int getNivel_Diagnostico() {
        return Nivel_Diagnostico;
    }

    public void setNivel_Diagnostico(int Nivel_Diagnostico) {
        this.Nivel_Diagnostico = Nivel_Diagnostico;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }

    public String getAssistente_ID_Chatbot() {
        return Assistente_ID_Chatbot;
    }

    public void setAssistente_ID_Chatbot(String Assistente_ID_Chatbot) {
        this.Assistente_ID_Chatbot = Assistente_ID_Chatbot;
    }

    public String getCliente_CPF_Cliente() {
        return Cliente_CPF_Cliente;
    }

    public void setCliente_CPF_Cliente(String Cliente_CPF_Cliente) {
        this.Cliente_CPF_Cliente = Cliente_CPF_Cliente;
    }

    public String getPlaca_Automovel() {
        return Placa_Automovel;
    }

    public void setPlaca_Automovel(String Placa_Automovel) {
        this.Placa_Automovel = Placa_Automovel;
    }

}
