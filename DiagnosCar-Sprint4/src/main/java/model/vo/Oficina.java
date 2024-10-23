package model.vo;

public class Oficina {
    private String enderecoOficina;
    private String cnpjOficina;
    private String nomeOficina;
    private double avaliacaoOficina;
    private String especializacaoOficina;

    public Oficina(String enderecoOficina, String cnpjOficina, String nomeOficina, double avaliacaoOficina, String especializacaoOficina) {
        this.enderecoOficina = enderecoOficina;
        this.cnpjOficina = cnpjOficina;
        this.nomeOficina = nomeOficina;
        this.avaliacaoOficina = avaliacaoOficina;
        this.especializacaoOficina = especializacaoOficina;
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

	public double getAvaliacaoOficina() {
		return avaliacaoOficina;
	}

	public void setAvaliacaoOficina(double avaliacaoOficina) {
		this.avaliacaoOficina = avaliacaoOficina;
	}

	public String getEspecializacaoOficina() {
		return especializacaoOficina;
	}

	public void setEspecializacaoOficina(String especializacaoOficina) {
		this.especializacaoOficina = especializacaoOficina;
	}

    
}




