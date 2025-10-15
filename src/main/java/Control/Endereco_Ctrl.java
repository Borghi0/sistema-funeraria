package Control;

import Model.Endereco;

public class Endereco_Ctrl {
    private static Endereco_Ctrl instancia;
    
    private Endereco_Ctrl(){}
    
    public static Endereco_Ctrl getInstancia(){
        if(instancia == null) instancia = new Endereco_Ctrl();
        
        return instancia;
    }
    
    public void cad_Endereco(Endereco endereco){
        //Ainda não implementado
    }
    
    public void ler_Endereco(Endereco endereco){
        //Ainda não implementado
    }
    
    public void alt_Endereco(Endereco endereco){
        //Ainda não implementado
    }
    
    public void del_Endereco(Endereco endereco){
        //Ainda não implementado
    }
}
