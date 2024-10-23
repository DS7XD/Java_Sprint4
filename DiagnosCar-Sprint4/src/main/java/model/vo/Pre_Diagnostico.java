package model.vo;

public class Pre_Diagnostico {
    private String idPreDiagnostico;
    private int nivelDiagnostico;
    private String diagnostico;
    private String assistenteIdChatbot;

    public Pre_Diagnostico(String idPreDiagnostico, int nivelDiagnostico, String diagnostico, String assistenteIdChatbot) {
        this.idPreDiagnostico = idPreDiagnostico;
        this.nivelDiagnostico = nivelDiagnostico;
        this.diagnostico = diagnostico;
        this.assistenteIdChatbot = assistenteIdChatbot;
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

    
}