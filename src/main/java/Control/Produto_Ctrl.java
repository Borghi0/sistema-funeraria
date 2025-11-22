package Control;


import Model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Produto_Ctrl {
    private static Produto_Ctrl instancia;
    
    private Produto_Ctrl(){
    }
    
    public static Produto_Ctrl getInstancia(){
        if(instancia == null) instancia = new Produto_Ctrl();
        
        return instancia;
    }
    
    public void cad_Produto(Produto produto) throws SQLException, ClassNotFoundException{
        try(Connection con = Banco_Ctrl.getInstancia().getConexao()){
            String sql = "INSERT INTO produto VALUES (?, ?, ?, ?, ?)";
            
            try(PreparedStatement ps = con.prepareStatement(sql)){
                ps.setDouble(1, produto.getPreco());            
                ps.setString(2, produto.getNome());
                ps.setInt(3, produto.getId());
                ps.setBoolean(4, produto.isPerecivel());
                ps.setInt(5, produto.getQuant_Estoque());

                ps.executeUpdate();
            }
        }
    }
    
    public Produto ler_Produto(int id) throws Exception{
        String sql = "SELECT * FROM produto WHERE pro_id = ?";
                
        Connection con = Banco_Ctrl.getInstancia().getConexao();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Produto produto = null;
        
        if(rs.next())
            produto = new Produto(
                    rs.getBoolean("pro_perecivel"),                
                    rs.getInt("pro_quant_estoque"),
                    rs.getInt("pro_preco"),
                    rs.getString("pro_nome"),
                    rs.getInt("pro_id")
            );
        
        rs.close();
        ps.close();
        con.close();
        
        return produto;
    }
    
    public List<Produto> ler_Produto() throws Exception{
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList();
                
        try(Connection con = Banco_Ctrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
        
            while(rs.next()){
                produtos.add(new Produto(
                                rs.getBoolean("pro_perecivel"),
                                rs.getInt("pro_quant_estoque"),
                                rs.getInt("pro_preco"),
                                rs.getString("pro_nome"),
                                rs.getInt("pro_id")                                 
                            ));
            }        
        }
        
        return produtos;                                         
    }
    
    public int alt_Produto(Produto produto) throws Exception{
        try(Connection con = Banco_Ctrl.getInstancia().getConexao()){
            int id = produto.getId();
            String sql = "UPDATE produto SET pro_perecivel = ?,"
                    + "pro_quantidade = ?,"
                    + "pro_preco = ?,"
                    + "pro_nome = ?,"
                    + " WHERE pro_id = ?";
        
            try(PreparedStatement ps = con.prepareStatement(sql)){
                ps.setDouble(1, produto.getPreco());
                ps.setString(2, produto.getNome());
                ps.setInt(3, produto.getId());
                ps.setBoolean(4, produto.isPerecivel());
                ps.setInt(5, id);

                return ps.executeUpdate();
            } 
        }
    }
    
    public int del_Produto(Produto produto) throws Exception{
        int id = produto.getId();
        String sql = "DELETE FROM produto WHERE pro_id = ?";
        
        try(Connection con = Banco_Ctrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1, produto.getId());
            
            return ps.executeUpdate();
        }
    }
}
