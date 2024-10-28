package model.vo;

public class Automovel {
    private String placaAutomovel;    
    private String marcaAutomovel;    
    private String modeloAutomovel;    
    private String corAutomovel;       
    private int anoAutomovel;          
    private String clienteCpfCliente;  

    public Automovel(String placaAutomovel, String marcaAutomovel, String modeloAutomovel, String corAutomovel, int anoAutomovel, String clienteCpfCliente) {
        this.placaAutomovel = placaAutomovel;
        this.marcaAutomovel = marcaAutomovel;
        this.modeloAutomovel = modeloAutomovel;
        this.corAutomovel = corAutomovel;
        this.anoAutomovel = anoAutomovel;
        this.clienteCpfCliente = clienteCpfCliente;
    }

    public String getPlacaAutomovel() {
        return placaAutomovel;
    }

    public void setPlacaAutomovel(String placaAutomovel) {
        this.placaAutomovel = placaAutomovel;
    }

    public String getMarcaAutomovel() {
        return marcaAutomovel;
    }

    public void setMarcaAutomovel(String marcaAutomovel) {
        this.marcaAutomovel = marcaAutomovel;
    }

    public String getModeloAutomovel() {
        return modeloAutomovel;
    }

    public void setModeloAutomovel(String modeloAutomovel) {
        this.modeloAutomovel = modeloAutomovel;
    }

    public String getCorAutomovel() {
        return corAutomovel;
    }

    public void setCorAutomovel(String corAutomovel) {
        this.corAutomovel = corAutomovel;
    }

    public int getAnoAutomovel() {
        return anoAutomovel;
    }

    public void setAnoAutomovel(int anoAutomovel) {
        this.anoAutomovel = anoAutomovel;
    }

    public String getClienteCpfCliente() {
        return clienteCpfCliente;
    }

    public void setClienteCpfCliente(String clienteCpfCliente) {
        this.clienteCpfCliente = clienteCpfCliente;
    }
}
