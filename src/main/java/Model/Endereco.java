package Model;

public class Endereco {
    private int numero;
    private String rua;    
    private String cep;

    
    public Endereco() {
        this.numero = 0;
        this.rua = "";        
        this.cep = "";
    }
    public Endereco(int numero, String rua, String cep) {
        this.numero = numero;
        this.rua = rua;        
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getCep() {
        return cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
}
