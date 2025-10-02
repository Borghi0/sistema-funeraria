package Control;

import Model.Pessoa;
import Model.Usuario;

public class Usuario_Ctrl {
    private static Usuario_Ctrl instancia;
    
    private Usuario_Ctrl(){}
    
    public static Usuario_Ctrl getInstancia(){
        if(instancia == null) instancia = new Usuario_Ctrl();
        
        return instancia;
    }
    
    public void cad_User(Usuario user){
        //Ainda não implementado
    }
    
    public void ler_User(Usuario user){
        //Ainda não implementado
    }
    
    public void alt_User(Usuario user){
        //Ainda não implementado
    }
    
    public void del_User(Usuario user){
        //Ainda não implementado
    }
}
