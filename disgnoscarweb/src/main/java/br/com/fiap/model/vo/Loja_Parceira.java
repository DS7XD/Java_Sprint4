package br.com.fiap.model.vo;

public class Loja_Parceira {
    private String enderecoLoja;          // Endereco_Loja
    private String cnpjLoja;              // Cnpj_Loja
    private String nomeLoja;              // Nome_Loja
    private Double avaliacaoLoja;         // Avaliacao_Loja
    private String especializacaoLoja;    // Especializacao_Loja

    public Loja_Parceira(String enderecoLoja, String cnpjLoja, String nomeLoja, Double avaliacaoLoja, String especializacaoLoja) {
        this.enderecoLoja = enderecoLoja;
        this.cnpjLoja = cnpjLoja;
        this.nomeLoja = nomeLoja;
        this.avaliacaoLoja = avaliacaoLoja;
        this.especializacaoLoja = especializacaoLoja;
    }

    public String getEnderecoLoja() {
        return enderecoLoja;
    }

    public void setEnderecoLoja(String enderecoLoja) {
        this.enderecoLoja = enderecoLoja;
    }

    public String getCnpjLoja() {
        return cnpjLoja;
    }

    public void setCnpjLoja(String cnpjLoja) {
        this.cnpjLoja = cnpjLoja;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public Double getAvaliacaoLoja() {
        return avaliacaoLoja;
    }

    public void setAvaliacaoLoja(Double avaliacaoLoja) {
        this.avaliacaoLoja = avaliacaoLoja;
    }

    public String getEspecializacaoLoja() {
        return especializacaoLoja;
    }

    public void setEspecializacaoLoja(String especializacaoLoja) {
        this.especializacaoLoja = especializacaoLoja;
    }
}
