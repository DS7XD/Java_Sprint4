package model.vo;

public class Cliente {
    private String cpfCliente;
    private String cnhCliente;
    private String rgCliente;
    private String nomeCliente;
    private String sobrenomeCliente;
    private String senhaCliente;
    private String emailCliente;
    private String telefoneCliente;
    private String enderecoCliente;

    public Cliente(String cpfCliente, String cnhCliente, String rgCliente, String nomeCliente, String sobrenomeCliente, String emailCliente, String senhaCliente, String telefoneCliente, String enderecoCliente) {
        this.cpfCliente = cpfCliente;
        this.cnhCliente = cnhCliente;
        this.rgCliente = rgCliente;
        this.nomeCliente = nomeCliente;
        this.sobrenomeCliente = sobrenomeCliente;
        this.emailCliente = emailCliente;
        this.senhaCliente = senhaCliente;
        this.telefoneCliente = telefoneCliente;
        this.enderecoCliente = enderecoCliente;
    }

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getCnhCliente() {
		return cnhCliente;
	}

	public void setCnhCliente(String cnhCliente) {
		this.cnhCliente = cnhCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getSobrenomeCliente() {
		return sobrenomeCliente;
	}

	public void setSobrenomeCliente(String sobrenomeCliente) {
		this.sobrenomeCliente = sobrenomeCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getSenhaCliente() {
		return senhaCliente;
	}

	public void setSenhaCliente(String senhaCliente) {
		this.senhaCliente = senhaCliente;
	}

	public String getRgCliente() {
		return rgCliente;
	}

	public void setRgCliente(String rgCliente) {
		this.rgCliente = rgCliente;
	} 
}
