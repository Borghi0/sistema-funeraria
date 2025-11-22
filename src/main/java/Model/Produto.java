package Model;


public class Produto extends Ofertavel{    
    private boolean perecivel;
    private int quant_Estoque;    
    
    public Produto(){
        super();
        this.perecivel = false;
        this.quant_Estoque = 0;
    }
    public Produto(boolean perecivel, int quant_Estoque, double preco, String nome, int id) {
        super(preco, nome, id);
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
    
    @Override
    public boolean equals(Object o){        
        if(!(o instanceof Produto)) return false;        
        if(this == o) return true;
        
        Produto produto = (Produto) o;
        return this.getId() == produto.getId();
    }
}