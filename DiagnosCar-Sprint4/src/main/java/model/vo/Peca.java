package model.vo;

public class Peca {
    private int idPeca;
    private String tipoPeca;
    private String nomePeca;
    private String Endereco_Peca; 

    public Peca(int idPeca, String tipoPeca, String nomePeca, String Endereco_Peca) {
        this.idPeca = idPeca;
        this.tipoPeca = tipoPeca;
        this.nomePeca = nomePeca;
        this.Endereco_Peca = Endereco_Peca;
    }

	public int getIdPeca() {
		return idPeca;
	}

	public void setIdPeca(int idPeca) {
		this.idPeca = idPeca;
	}

	public String getTipoPeca() {
		return tipoPeca;
	}

	public void setTipoPeca(String tipoPeca) {
		this.tipoPeca = tipoPeca;
	}

	public String getNomePeca() {
		return nomePeca;
	}

	public void setNomePeca(String nomePeca) {
		this.nomePeca = nomePeca;
	}

	public String getEndereco_Peca() {
		return Endereco_Peca;
	}

	public void setEndereco_Peca(String enderecoPeca) {
		this.Endereco_Peca = enderecoPeca;
	}

    
}




