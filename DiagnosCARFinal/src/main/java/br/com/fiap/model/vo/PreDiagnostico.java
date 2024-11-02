package br.com.fiap.model.vo;

public class PreDiagnostico {
    private String idPreDiagnostico;
    private int nivelDiagnostico;
    private String diagnostico;
    private String assistenteIdChatbot;
    private String clienteCpfCliente;
    private String placaAutomovel;

    public PreDiagnostico(String idPreDiagnostico, int nivelDiagnostico, String diagnostico,
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
