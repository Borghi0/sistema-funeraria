package Control;

import Model.Pessoa;
import Model.Defunto;
import java.sql.*;

public class Defunto_Ctrl {
    private static Defunto_Ctrl instancia;
    
    private Defunto_Ctrl(){}
    
    public static Defunto_Ctrl getInstancia(){
        if(instancia == null) instancia = new Defunto_Ctrl();
        
        return instancia;
    }
    
    public void cad_Defunto(Defunto defunto){
        //Ainda não implementado
    }
    
    public void ler_Defunto(Defunto defunto){
        //Ainda não implementado
    }
    
    public void alt_Defunto(Defunto defunto){
        //Ainda não implementado
    }
    
    public void del_Defunto(Defunto defunto){
        //Ainda não implementado
    }
}
