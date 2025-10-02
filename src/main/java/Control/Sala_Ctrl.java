package Control;

import Model.Sala;

public class Sala_Ctrl {
    private static Sala_Ctrl instancia;
    
    private Sala_Ctrl(){}
    
    public static Sala_Ctrl getInstancia(){
        if(instancia == null) instancia = new Sala_Ctrl();
        
        return instancia;
    }
    
    public void cad_Sala(Sala sala){
        //Ainda não implementado
    }
    
    public void ler_Sala(Sala sala){
        //Ainda não implementado
    }
    
    public void alt_Sala(Sala sala){
        //Ainda não implementado
    }
    
    public void del_Sala(Sala sala){
        //Ainda não implementado
    }
}
