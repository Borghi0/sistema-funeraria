package Control;

import Model.Ofertavel;
import Model.Plano;

public class Plano_Ctrl {
    private static Plano_Ctrl instancia;
    
    private Plano_Ctrl(){}
    
    public static Plano_Ctrl getInstancia(){
        if(instancia == null) instancia = new Plano_Ctrl();
        
        return instancia;
    }
    
    public void cad_Plano(Plano plano){
        //Ainda não implementado
    }
    
    public void ler_Plano(Plano plano){
        //Ainda não implementado
    }
    
    public void alt_Plano(Plano plano){
        //Ainda não implementado
    }
    
    public void del_Plano(Plano plano){
        //Ainda não implementado
    }
}
