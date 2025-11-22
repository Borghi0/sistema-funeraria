package Model;


public class Produto extends Ofertavel{    
    private boolean perecivel;
    private int quantEstoque;    
    
    public Produto(){
        super();
        this.perecivel = false;
        this.quantEstoque = 0;
    }
    public Produto(boolean perecivel, int quant_Estoque, double preco, String nome, int id) {
        super(preco, nome, id);
        this.perecivel = perecivel;
        this.quantEstoque = quant_Estoque;
    }        
    
    public boolean isPerecivel() {
        return perecivel;
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }
  
    public void setPerecivel(boolean perecivel) {
        this.perecivel = perecivel;
    }

    public void setQuantEstoque(int quant_Estoque) {
        this.quantEstoque = quant_Estoque;
    }
    
    @Override
    public boolean equals(Object o){        
        if(!(o instanceof Produto)) return false;        
        if(this == o) return true;
        
        Produto produto = (Produto) o;
        return this.getId() == produto.getId();
    }
}