package Control;

import Model.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SalaCtrl {
    private static SalaCtrl instancia;
    
    private SalaCtrl(){}
    
    public static SalaCtrl getInstancia(){
        if(instancia == null) instancia = new SalaCtrl();
        
        return instancia;
    }
    
    public int cadSala(Sala sala) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO sala (sal_capacidade) VALUES (?)";
        
        try(Connection con = BancoCtrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1, sala.getCapacidade());
            
            return ps.executeUpdate();
        }
    }
    
    public Sala lerSala(int numero) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM sala WHERE sal_numero = ?";
        ResultSet rs = null;
        
        try(Connection con = BancoCtrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1, numero);
            rs = ps.executeQuery();
            
            while(rs.next()) return new Sala(rs.getInt("sal_capacidade"), 
                                             rs.getInt("sal_numero"));
        } finally{
            rs.close();
        }
        
        return null;
    }
    
    public List<Sala> lerSala() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM sala ORDER BY sal_numero DESC";
        List<Sala> retorno = new LinkedList<>();
        
        try(
            Connection con = BancoCtrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){
            while(rs.next()){
                retorno.add(new Sala(rs.getInt("sal_capacidade"),
                                     rs.getInt("sal_numero")));
            }
            
            return retorno;
        }
    }
    
    public int altSala(Sala sala) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE sala SET sal_capacidade = ? WHERE sal_numero = ?";
        
        try(
            Connection con = BancoCtrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql)
        ){
            ps.setInt(1, sala.getCapacidade());
            ps.setInt(2, sala.getNumero());
            
            return ps.executeUpdate();
        }
    }
    
    public int delSala(Sala sala) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM sala WHERE sal_numero = ?";
        
        try(
            Connection con = BancoCtrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql)
        ){
            ps.setInt(1, sala.getNumero());
            
            return ps.executeUpdate();
        }
    }
    
    public int delSala(int sala) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM sala WHERE sal_numero = ?";
        
        try(
            Connection con = BancoCtrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql)
        ){
            ps.setInt(1, sala);
            
            return ps.executeUpdate();
        }
    }
}
