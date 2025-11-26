package Control;

import Model.Banco;
import java.sql.*;
import Interfaces.InicializadorBD;

public class BancoCtrl {
    private static BancoCtrl instancia;
    private Banco banco;
    private InicializadorBD inicializadorBD;
    
    private BancoCtrl(){
        banco = null;
        inicializadorBD = null;
    }
    
    public static BancoCtrl getInstancia(){
        if(instancia == null) instancia = new BancoCtrl();        
        return instancia;
    }        
    
    public void testarConexao() throws ClassNotFoundException, SQLException{
        Class.forName(banco.getDriver());
        Connection con = DriverManager.getConnection(banco.getUrl(), banco.getUser(), banco.getSenha());        
        con.close();
    }
    
    public void criarTabelas() throws ClassNotFoundException, SQLException{
        inicializadorBD.criarTabelas();
    }
    
    public Connection getConexao() throws ClassNotFoundException, SQLException{
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
