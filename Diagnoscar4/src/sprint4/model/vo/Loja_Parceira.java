package sprint4.model.vo;

public class Loja_Parceira {
    private String endereco_loja;
    private String cnpj;
    private String nome_loja;
    private double avaliacao;
    private String especializacao;

    public Loja_Parceira(String endereco_loja, String cnpj, String nome_loja, double avaliacao, String especializacao) {
        this.endereco_loja = endereco_loja;
        this.cnpj = cnpj;
        this.nome_loja = nome_loja;
        this.avaliacao = avaliacao;
        this.especializacao = especializacao;
    }

    public String getEndereco_loja() {
        return endereco_loja;
    }

    public void setEndereco_loja(String endereco_loja) {
        this.endereco_loja = endereco_loja;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome_loja() {
        return nome_loja;
    }

    public void setNome_loja(String nome_loja) {
        this.nome_loja = nome_loja;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

}



