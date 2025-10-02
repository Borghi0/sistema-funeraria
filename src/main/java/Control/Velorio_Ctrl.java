package Control;

import Model.Velorio;

public class Velorio_Ctrl {
    private static Velorio_Ctrl instancia;
    
    private Velorio_Ctrl(){}
    
    public static Velorio_Ctrl getInstancia(){
        if(instancia == null) instancia = new Velorio_Ctrl();
        
        return instancia;
    }
    
    public void cad_Velorio(Velorio velorio){
        //Ainda não implementado
    }
    
    public void ler_Velorio(Velorio velorio){
        //Ainda não implementado
    }
    
    public void alt_Velorio(Velorio velorio){
        //Ainda não implementado
    }
    
    public void del_Velorio(Velorio velorio){
        //Ainda não implementado
    }
}
