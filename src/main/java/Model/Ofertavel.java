package Model;


public abstract class Ofertavel{
    private int preco;
    private String tipo;

    public Ofertavel(){
        this.preco = 0;
        this.tipo = "";
    }
    public Ofertavel(int preco, String tipo) {
        this.preco = preco;
        this.tipo = tipo;
    }

    public int getPreco() {
        return preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
