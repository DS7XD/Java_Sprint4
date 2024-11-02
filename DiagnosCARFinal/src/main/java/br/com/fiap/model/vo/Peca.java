package br.com.fiap.model.vo;

public class Peca {
    private String idPeca; 
    private String tipoPeca;
    private String nomePeca;             
    private String descricaoPeca;       
    private String lojaParceiraEndereco; 

    public Peca(String idPeca, String tipoPeca, String nomePeca, String descricaoPeca, String lojaParceiraEndereco) {
        this.idPeca = idPeca;
        this.tipoPeca = tipoPeca;
        this.nomePeca = nomePeca;
        this.descricaoPeca = descricaoPeca;
        this.lojaParceiraEndereco = lojaParceiraEndereco;
    }

    public String getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(String idPeca) {
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

    public String getDescricaoPeca() {
        return descricaoPeca;
    }

    public void setDescricaoPeca(String descricaoPeca) {
        this.descricaoPeca = descricaoPeca;
    }

    public String getLojaParceiraEndereco() {
        return lojaParceiraEndereco;
    }

    public void setLojaParceiraEndereco(String lojaParceiraEndereco) {
        this.lojaParceiraEndereco = lojaParceiraEndereco;
    }
}
