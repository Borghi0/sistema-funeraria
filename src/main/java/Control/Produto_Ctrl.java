package Control;

import Model.Ofertavel;
import Model.Produto;

public class Produto_Ctrl {
    private static Produto_Ctrl instancia;
    
    private Produto_Ctrl(){}
    
    public static Produto_Ctrl getInstancia(){
        if(instancia == null) instancia = new Produto_Ctrl();
        
        return instancia;
    }
    
    public void cad_Produto(Produto produto){
        //Ainda não implementado
    }
    
    public void ler_Produto(Produto produto){
        //Ainda não implementado
    }
    
    public void alt_Produto(Produto produto){
        //Ainda não implementado
    }
    
    public void del_Produto(Produto produto){
        //Ainda não implementado
    }
}
