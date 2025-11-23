package Control;

import Model.Banco;
import java.sql.*;
import Interfaces.InicializadorBD;

public class Banco_Ctrl {
    private static Banco_Ctrl instancia;
    private Banco banco;
    private InicializadorBD inicializadorBD;
    
    private Banco_Ctrl(){
        banco = null;
        inicializadorBD = null;
    }
    
    public static Banco_Ctrl getInstancia(){
        if(instancia == null) instancia = new Banco_Ctrl();        
        return instancia;
    }        
    
    public void testarConexao() throws SQLException, ClassNotFoundException{
        Class.forName(banco.getDriver());
        Connection con = DriverManager.getConnection(banco.getUrl(), banco.getUser(), banco.getSenha());        
        con.close();
    }
    
    public void criarTabelas() throws SQLException, ClassNotFoundException{
        inicializadorBD.criarTabelas();
    }
    
    public Connection getConexao() throws SQLException, ClassNotFoundException{
        Class.forName(banco.getDriver());
        return DriverManager.getConnection(banco.getUrl(), banco.getUser(), banco.getSenha());
    }
    
    public Banco getBanco(){
        return banco;
    }
    
    public InicializadorBD getInicializadorBD(){
        return inicializadorBD;
    }
    
    public void setBanco(Banco banco){
        this.banco = banco;
    }
    
    public void setInicializadorBD(InicializadorBD inicializadorBD){
        this.inicializadorBD = inicializadorBD;
    }    
    
}
