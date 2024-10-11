package sprint4.model.vo;

public class Cliente {
    private String cpfCliente;
    private long cnhCliente;
    private String nomeCliente;
    private String sobrenomeCliente;
    private String emailCliente;
    private String telefoneCliente;
    private String enderecoCliente;

    public Cliente(String cpfCliente, long cnhCliente, String nomeCliente, String sobrenomeCliente, String emailCliente, String telefoneCliente, String enderecoCliente) {
        this.cpfCliente = cpfCliente;
        this.cnhCliente = cnhCliente;
        this.nomeCliente = nomeCliente;
        this.sobrenomeCliente = sobrenomeCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
        this.enderecoCliente = enderecoCliente;
    }

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public long getCnhCliente() {
		return cnhCliente;
	}

	public void setCnhCliente(long cnhCliente) {
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

    
}



