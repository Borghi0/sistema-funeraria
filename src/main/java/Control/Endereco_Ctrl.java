package Control;

import Model.Endereco;
import java.sql.*;


public class Endereco_Ctrl {
    private static Endereco_Ctrl instancia;
    private static Connection con;
    private static PreparedStatement ps;
    
    private Endereco_Ctrl(){
        con = null;
        ps = null;
    }
    
    public static Endereco_Ctrl getInstancia(){
        if(instancia == null) instancia = new Endereco_Ctrl();
        
        return instancia;
    }
    
    public void cad_Endereco(Endereco endereco, Connection con) throws Exception{
        String sql = "INSERT INTO endereco VALUES (?, ?, ?)";
        
        try{            
            ps = con.prepareStatement(sql);

            ps.setInt(1, endereco.getNumero());
            ps.setString(2, endereco.getRua());
            ps.setString(3, endereco.getCep());
            
            ps.executeUpdate();
        }
        finally{
            ps.close();
            con.close();
        }
    }
    
    public void ler_Endereco(Endereco endereco){
        //Ainda não implementado
    }
    
    public void alt_Endereco(Endereco endereco){
        //Ainda não implementado
    }
    
    public void del_Endereco(Endereco endereco){
        //Ainda não implementado
    }
}
