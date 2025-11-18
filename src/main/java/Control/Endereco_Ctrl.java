package Control;

import Model.Endereco;
import java.sql.*;


public class Endereco_Ctrl {
    private static Endereco_Ctrl instancia;
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    private Endereco_Ctrl(){
        con = null;
        ps = null;
        rs = null;
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
        }
    }
    
    public boolean ler_Endereco(Endereco endereco) throws Exception{
        String sql = "SELECT * FROM endereco WHERE end_numero = ? AND"
                + " end_rua = ? AND"
                + " end_cep = ?";
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            ps = con.prepareStatement(sql);
            ps.setString(1, Integer.toString(endereco.getNumero()));
            ps.setString(2, endereco.getRua());
            ps.setString(2, endereco.getCep());
            
            rs = ps.executeQuery();
            rs.last();
            
            return rs.getRow() >= 1 ? true : false;
        }
        finally{
            rs.close();
            ps.close();
            con.close();
        }
    }
    
    public Endereco[] ler_Endereco() throws Exception{
        int num_lin = 0;
        String sql = "SELECT * FROM endereco";
        Endereco[] end = null;
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            rs.last();
            num_lin = rs.getRow();
            end = new Endereco[num_lin];
            rs.beforeFirst();
            
            for(int i = 0; i < num_lin; i++){
                rs.next();
                end[i] = new Endereco(
                                rs.getInt("end_numero"),
                                rs.getString("end_rua"),
                                rs.getString("end_cep"));
                
            }
            
            return end;
                
        }
        finally{
            rs.close();
            ps.close();
            con.close();
        }
    }
    
    public int alt_Endereco(Endereco novo, Endereco antigo) throws Exception{
        String sql = "UPDATE endereco SET end_numero = ?,"
              + "end_cep = ?,"
              + "end_rua = ?,"
              + "WHERE end_numero = ?"
              + " AND end_cep = ?"
              + " AND end_rua = ?";
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            ps = con.prepareStatement(sql);

            ps.setInt(1, novo.getNumero());
            ps.setString(2, novo.getCep());
            ps.setString(3, novo.getRua());
            ps.setInt(4, antigo.getNumero());
            ps.setString(5, antigo.getCep());
            ps.setString(6, antigo.getRua());
            
            return ps.executeUpdate();
        }
        finally{
            ps.close();
            con.close();
        }
    }
    
    public boolean del_Endereco(Endereco endereco) throws Exception{
        String sql_del = "DELETE FROM endereco WHERE end_numero = ?"
                       + " AND end_rua = ?"
                       + " AND end_cep = ?",
                sql_busca = "SELECT * FROM endereco WHERE end_numero = ? AND"
                          + " end_rua = ? AND"
                          + " end_cep = ?";
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            ps = con.prepareStatement(sql_busca);
            
            ps.setInt(1, endereco.getNumero());
            ps.setString(2, endereco.getRua());
            ps.setString(3, endereco.getCep());
            
            rs = ps.executeQuery();
            
            if(!rs.next()) return false;
            else{
                ps = con.prepareStatement(sql_del);
                ps.setInt(1, endereco.getNumero());
                ps.setString(2, endereco.getRua());
                ps.setString(3, endereco.getCep());
                ps.executeUpdate();
                
                return true;
            }
        } finally{
            ps.close();
            con.close();
        }
    }
}
