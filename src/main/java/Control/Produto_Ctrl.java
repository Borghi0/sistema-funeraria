package Control;


import Model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Produto_Ctrl {
    private static Produto_Ctrl instancia;
    
    private Produto_Ctrl(){}
    
    public static Produto_Ctrl getInstancia(){
        if(instancia == null) instancia = new Produto_Ctrl();
        
        return instancia;
    }
    
    public void cad_Produto(Produto produto) throws SQLException, ClassNotFoundException{
        try(Connection con = Banco_Ctrl.getInstancia().getConexao()){
            
            String sql = "INSERT INTO produto (pro_nome, pro_perecivel, pro_quant_estoque, pro_preco) "
                    + "VALUES (?, ?, ?, ?)";
            
            try(PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1, produto.getNome());                
                ps.setBoolean(2, produto.isPerecivel());                
                ps.setInt(3, produto.getQuantEstoque());
                ps.setDouble(4, produto.getPreco());
                
                ps.executeUpdate();
            }            
        }
    }
    
    public List<Produto> ler_Produto() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList();
                
        try(Connection con = Banco_Ctrl.getInstancia().getConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
        
            while(rs.next()){
                produtos.add(new Produto(
                                rs.getBoolean("ser_perecivel"),
                                rs.getInt("usu_quant_estoque"),
                                rs.getInt("usu_preco"),
                                rs.getString("usu_nome"),
                                rs.getInt("usu_id")                                 
                            ));
            }        
        }
        return produtos;                                         
    }
    
    public Produto ler_Produto(int id) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM produto WHERE ser_id = ?";
                
        try(Connection con = Banco_Ctrl.getInstancia().getConexao();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            
            try(ResultSet rs = ps.executeQuery()){                
                Produto produto = null;
                
                if(rs.next())
                    produto = new Produto(
                            rs.getBoolean("pro_perecivel"),                
                            rs.getInt("pro_quant_estoque"),
                            rs.getInt("pro_preco"),
                            rs.getString("pro_nome"),
                            rs.getInt("pro_id")
                    );                                
                return produto;
            }
        }
    }
    
    public int alt_Produto(Produto produto) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE produto SET pro_nome = ? "
                + "pro_perecivel = ? "
                + "pro_quant_estoque = ? "
                + "pro_preco = ? "
                + "WHERE pro_id = ?";
        
        try(
            Connection con = Banco_Ctrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql)
        ){
            ps.setString(1, produto.getNome());
            ps.setBoolean(2, produto.isPerecivel());
            ps.setInt(3, produto.getQuantEstoque());
            ps.setDouble(4, produto.getPreco());
            ps.setInt(5, produto.getId());
            
            return ps.executeUpdate();
        }
    }
    
    public int del_Produto(Produto produto) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM produto WHERE pro_id = ?";
        
        try(Connection con = Banco_Ctrl.getInstancia().getConexao();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1, produto.getId());
            return ps.executeUpdate();
        }
    }
}
