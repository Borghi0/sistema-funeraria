package Control;

import Model.Endereco;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class EnderecoCtrl {
    private static EnderecoCtrl instancia;    
    
    private EnderecoCtrl(){}
    
    public static EnderecoCtrl getInstancia(){
        if(instancia == null) instancia = new EnderecoCtrl();
        
        return instancia;
    }
    
    public void cadEndereco(Endereco endereco, Connection con) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO endereco VALUES (?, ?, ?)";
        
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, endereco.getNumero());
            ps.setString(2, endereco.getRua());
            ps.setString(3, endereco.getCep());
            
            ps.executeUpdate();
        }        
    }
    
    public boolean lerEndereco(Endereco endereco) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM endereco WHERE end_numero = ? AND"
                + " end_rua = ? AND"
                + " end_cep = ?";
        
        try(Connection con = BancoCtrl.getInstancia().getConexao();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, Integer.toString(endereco.getNumero()));
            ps.setString(2, endereco.getRua());
            ps.setString(2, endereco.getCep());
            
            try(ResultSet rs = ps.executeQuery()){
                rs.last();
                return rs.getRow() >= 1;
            }
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
        
        try(Connection con = BancoCtrl.getInstancia().getConexao();
                PreparedStatement ps = con.prepareStatement(sql)){            

            ps.setInt(1, novo.getNumero());
            ps.setString(2, novo.getCep());
            ps.setString(3, novo.getRua());
            ps.setInt(4, antigo.getNumero());
            ps.setString(5, antigo.getCep());
            ps.setString(6, antigo.getRua());
            
            return ps.executeUpdate();
        }        
    }
    
    public boolean delEndereco(Endereco endereco) throws SQLException, ClassNotFoundException{
        String sql_del = "DELETE FROM endereco WHERE end_numero = ?"
                       + " AND end_rua = ?"
                       + " AND end_cep = ?",
                sql_busca = "SELECT * FROM endereco WHERE end_numero = ? AND"
                          + " end_rua = ? AND"
                          + " end_cep = ?";
        
        try(Connection con = BancoCtrl.getInstancia().getConexao();
                PreparedStatement ps_busca = con.prepareStatement(sql_busca)){            
            
            ps_busca.setInt(1, endereco.getNumero());
            ps_busca.setString(2, endereco.getRua());
            ps_busca.setString(3, endereco.getCep());
            
            try(ResultSet rs = ps_busca.executeQuery()){
            
                if(!rs.next()) return false;
                else{
                    try(PreparedStatement ps_del = con.prepareStatement(sql_del)){
                        ps_del.setInt(1, endereco.getNumero());
                        ps_del.setString(2, endereco.getRua());
                        ps_del.setString(3, endereco.getCep());
                        ps_del.executeUpdate();

                        return true;
                    }
                }
            }
        }
    }
}
