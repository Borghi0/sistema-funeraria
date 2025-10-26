package Control;

import Model.Banco;
import java.sql.*;

public class Banco_Ctrl {
    private static Banco_Ctrl instancia;
    private static Banco banco;    
    
    private Banco_Ctrl(){}
    
    public static Banco_Ctrl getInstancia(){
        if(instancia == null) instancia = new Banco_Ctrl();        
        return instancia;
    }
    
    public void testarConexao() throws Exception{
        Class.forName(banco.getDriver());
        Connection con = DriverManager.getConnection(banco.getUrl(), banco.getUser(), banco.getSenha());        
        con.close();
    }
    
    public Connection getConexao() throws Exception{
        Class.forName(banco.getDriver());
        return DriverManager.getConnection(banco.getUrl(), banco.getUser(), banco.getSenha());
    }
    
    public Banco getBanco(){
        return banco;
    }
    
    public void setBanco(Banco banco){
        this.banco = banco;
    }
}
