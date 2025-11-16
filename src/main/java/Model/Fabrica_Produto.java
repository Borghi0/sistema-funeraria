package Model;

public class Fabrica_Produto extends Fabrica_Ofertavel{
    private static Fabrica_Produto instancia = null;
    
    private Fabrica_Produto(){}
    
    public static Fabrica_Produto get_Instancia(){
        if(instancia == null) instancia = new Fabrica_Produto();
        
        return instancia;
    }
    
    @Override
    public Ofertavel criar_Ofertavel(){
        return new Produto();
    }
    
    public Produto criar_Ofertavel(boolean perecivel, int quant_Estoque, int preco, String nome, int id){
        return new Produto(perecivel, quant_Estoque, preco, nome, id);
    }
}
