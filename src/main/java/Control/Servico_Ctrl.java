package Control;

import Model.Ofertavel;
import Model.Servico;

public class Servico_Ctrl {
    private static Servico_Ctrl instancia;
    
    private Servico_Ctrl(){}
    
    public static Servico_Ctrl getInstancia(){
        if(instancia == null) instancia = new Servico_Ctrl();
        
        return instancia;
    }
    
    public void cad_Servico(Servico servico){
        //Ainda não implementado
    }
    
    public void ler_Servico(Servico servico){
        //Ainda não implementado
    }
    
    public void alt_Servico(Servico servico){
        //Ainda não implementado
    }
    
    public void del_Servico(Servico servico){
        //Ainda não implementado
    }
}
