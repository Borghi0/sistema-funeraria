package Model;


public class Produto extends Ofertavel{
    private boolean perecivel;
    private int quant_Estoque;

    
    public Produto(){
        super();
        this.perecivel = false;
        this.quant_Estoque = 0;
    }
    public Produto(boolean perecivel, int quant_Estoque, int preco, boolean ativo) {
        super(preco, ativo);
        this.perecivel = perecivel;
        this.quant_Estoque = quant_Estoque;
    }        

    public boolean isPerecivel() {
        return perecivel;
    }

    public int getQuant_Estoque() {
        return quant_Estoque;
    }

    public void setPerecivel(boolean perecivel) {
        this.perecivel = perecivel;
    }

    public void setQuant_Estoque(int quant_Estoque) {
        this.quant_Estoque = quant_Estoque;
    }
    
    
}