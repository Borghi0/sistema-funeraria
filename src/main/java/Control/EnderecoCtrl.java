package Control;

import Model.Endereco;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class EnderecoCtrl {
    private static EnderecoCtrl instancia;
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    private EnderecoCtrl(){
        con = null;
        ps = null;
        rs = null;
    }
    
    public static EnderecoCtrl getInstancia(){
        if(instancia == null) instancia = new EnderecoCtrl();
        
        return instancia;
    }
    
    public void cadEndereco(Endereco endereco, Connection con) throws SQLException, ClassNotFoundException{
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
    
    public boolean lerEndereco(Endereco endereco) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM endereco WHERE end_numero = ? AND"
                + " end_rua = ? AND"
                + " end_cep = ?";
        
        try{
            con = BancoCtrl.getInstancia().getConexao();
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
    
    public List<Endereco> lerEndereco() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM endereco";
        List<Endereco> retorno = new LinkedList<>();
        
        try(
            Connection con = BancoCtrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ){
            while(rs.next()){
                retorno.add(new Endereco(
                                    rs.getInt("end_numero"),
                                    rs.getString("end_rua"),
                                    rs.getString("end_cep")));
            }
            
            return retorno;
        }
    }
    
    public int altEndereco(Endereco novo, Endereco antigo) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE endereco SET end_numero = ?,"
              + "end_cep = ?,"
              + "end_rua = ?,"
              + "WHERE end_numero = ?"
              + " AND end_cep = ?"
              + " AND end_rua = ?";
        
        try{
            con = BancoCtrl.getInstancia().getConexao();
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
    
    public boolean delEndereco(Endereco endereco) throws SQLException, ClassNotFoundException{
        String sqlDel = "DELETE FROM endereco WHERE end_numero = ?"
                       + " AND end_rua = ?"
                       + " AND end_cep = ?",
                sqlBusca = "SELECT * FROM endereco WHERE end_numero = ? AND"
                          + " end_rua = ? AND"
                          + " end_cep = ?";
        
        try{
            con = BancoCtrl.getInstancia().getConexao();
            ps = con.prepareStatement(sqlBusca);
            
            ps.setInt(1, endereco.getNumero());
            ps.setString(2, endereco.getRua());
            ps.setString(3, endereco.getCep());
            
            rs = ps.executeQuery();
            
            if(!rs.next()) return false;
            else{
                ps = con.prepareStatement(sqlDel);
                ps.setInt(1, endereco.getNumero());
                ps.setString(2, endereco.getRua());
                ps.setString(3, endereco.getCep());
                ps.executeUpdate();
                
                return true;
            }
        } finally{
            rs.close();
            ps.close();
            con.close();
        }
    }
}
