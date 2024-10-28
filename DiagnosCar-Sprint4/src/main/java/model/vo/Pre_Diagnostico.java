package model.vo;

public class Pre_Diagnostico {
    private String idPreDiagnostico;              // ID_PreDiagnostico
    private int nivelDiagnostico;                  // Nivel_Diagnostico
    private String diagnostico;                     // Diagnostico
    private String assistenteIdChatbot;            // Assistente_ID_Chatbot
    private String clienteCpfCliente;               // Cliente_CPF_Cliente
    private String placaAutomovel;                  // Placa_Automovel

    public Pre_Diagnostico(String idPreDiagnostico, int nivelDiagnostico, String diagnostico,
                            String assistenteIdChatbot, String clienteCpfCliente, String placaAutomovel) {
        this.idPreDiagnostico = idPreDiagnostico;
        this.nivelDiagnostico = nivelDiagnostico;
        this.diagnostico = diagnostico;
        this.assistenteIdChatbot = assistenteIdChatbot;
        this.clienteCpfCliente = clienteCpfCliente;
        this.placaAutomovel = placaAutomovel;
    }

    public String getIdPreDiagnostico() {
        return idPreDiagnostico;
    }

    public void setIdPreDiagnostico(String idPreDiagnostico) {
        this.idPreDiagnostico = idPreDiagnostico;
    }

    public int getNivelDiagnostico() {
        return nivelDiagnostico;
    }

    public void setNivelDiagnostico(int nivelDiagnostico) {
        this.nivelDiagnostico = nivelDiagnostico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getAssistenteIdChatbot() {
        return assistenteIdChatbot;
    }

    public void setAssistenteIdChatbot(String assistenteIdChatbot) {
        this.assistenteIdChatbot = assistenteIdChatbot;
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
