package Control;

import Model.Pessoa;
import Model.Usuario;
import java.sql.*;

public class Usuario_Ctrl {
    private static Usuario_Ctrl instancia;
    private static Connection con;
    private static Statement st;
    
    private Usuario_Ctrl(){
        con = null;
        st = null;
    }
    
    public static Usuario_Ctrl getInstancia(){
        if(instancia == null) instancia = new Usuario_Ctrl();
        
        return instancia;
    }
    
    public void cad_User(Usuario user) throws Exception{
        String sql = "INSERT INTO usuario VALUES("
                + "'" + user.getCpf() + "',"
                + "'" + user.getNome() + "',"
                + "NULL" + ","  // data de natalidade
                + "'" + user.getLogin() + "',"
                + "'" + user.getSenha() + "',"
                + "'" + user.getNumero_Telefone() + "',"
                + user.isAdmin() + ","
                + "NULL" + ","  // id do endereco
                + "NULL"       // id do plano
                + ");";
        
        con = Banco_Ctrl.getInstancia().getConexao();
        st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
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
