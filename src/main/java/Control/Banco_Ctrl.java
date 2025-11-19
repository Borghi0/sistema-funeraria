package Control;

import Model.Banco;
import Interfaces.I_InicializadorBD;
import java.sql.*;

public class Banco_Ctrl {
    private static Banco_Ctrl instancia;
    private Banco banco;
    private I_InicializadorBD inicializadorBD;
    
    private Banco_Ctrl(){
        banco = null;
        inicializadorBD = null;
    }
    
    public static Banco_Ctrl getInstancia(){
        if(instancia == null) instancia = new Banco_Ctrl();        
        return instancia;
    }        
    
    public void testarConexao() throws Exception{
        Class.forName(banco.getDriver());
        Connection con = DriverManager.getConnection(banco.getUrl(), banco.getUser(), banco.getSenha());        
        con.close();
    }
    
    public void criarTabelas() throws Exception{
        inicializadorBD.criarTabelas();
    }
    
    public Connection getConexao() throws ClassNotFoundException, SQLException{
        Class.forName(banco.getDriver());
        return DriverManager.getConnection(banco.getUrl(), banco.getUser(), banco.getSenha());
    }
    
    public Banco getBanco(){
        return banco;
    }
    
    public I_InicializadorBD getInicializadorBD(){
        return inicializadorBD;
    }
    
    public void setBanco(Banco banco){
        this.banco = banco;
    }
    
    public void setInicializadorBD(I_InicializadorBD inicializadorBD){
        this.inicializadorBD = inicializadorBD;
    }    
    
}
