package Control;

import Model.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Sala_Ctrl {
    private static Sala_Ctrl instancia;
    
    private Sala_Ctrl(){}
    
    public static Sala_Ctrl getInstancia(){
        if(instancia == null) instancia = new Sala_Ctrl();
        
        return instancia;
    }
    
    public int cad_Sala(Sala sala) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO sala (sal_capacidade) VALUES (?)";
        
        try(Connection con = Banco_Ctrl.getInstancia().getConexao();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1, sala.getCapacidade());
            
            return ps.executeUpdate();
        }
    }
    
    public Sala ler_Sala(int numero) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM sala WHERE sal_numero = ?";        
        
        try(Connection con = Banco_Ctrl.getInstancia().getConexao();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1, numero);
            try(ResultSet rs = ps.executeQuery()){
            
                while(rs.next()) 
                    return new Sala(rs.getInt("sal_capacidade"),                            
                                    rs.getInt("sal_numero"));
                return null;
            }            
        }                
    }
    
    public int alt_Sala(Sala sala) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE sala SET sal_capacidade = ? WHERE sal_numero = ?";
        
        try(
            Connection con = Banco_Ctrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql)
        ){
            ps.setInt(1, sala.getCapacidade());
            ps.setInt(2, sala.getNumero());
            
            return ps.executeUpdate();
        }
    }
    
    public int del_Sala(Sala sala) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM sala WHERE sal_numero = ?";
        
        try(
            Connection con = Banco_Ctrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql)
        ){
            ps.setInt(1, sala.getNumero());
            
            return ps.executeUpdate();
        }
    }
}
