package Model;


public abstract class Ofertavel{
    private int preco;    
    private boolean ativo;

    public Ofertavel(){
        this.preco = 0;
        this.ativo = true;
    }
    public Ofertavel(int preco, boolean ativo) {
        this.preco = preco;
        this.ativo = ativo;
    }

    public int getPreco() {
        return preco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
}
