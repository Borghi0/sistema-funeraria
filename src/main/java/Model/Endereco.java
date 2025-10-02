package Model;

public class Endereco {
    private String rua;
    private String bairro;
    private String cep;

    
    public Endereco() {
        this.rua = "";
        this.bairro = "";
        this.cep = "";
    }
    public Endereco(String rua, String bairro, String cep) {
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
}
