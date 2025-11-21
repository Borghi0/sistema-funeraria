package Control;


import Model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Produto_Ctrl {
    private static Produto_Ctrl instancia;
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    private Produto_Ctrl(){
        con = null;
        ps = null;
        rs = null;
    }
    
    public static Produto_Ctrl getInstancia(){
        if(instancia == null) instancia = new Produto_Ctrl();
        
        return instancia;
    }
    
    public void cad_Produto(Produto produto) throws Exception{
        String sql = "INSERT INTO defunto VALUES (NULL, ?, ?, ?, ?, ?)";
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            ps = con.prepareStatement(sql);

            ps.setInt(1, produto.getPreco());            
            ps.setString(2, produto.getNome());
            ps.setInt(3, produto.getId());
            ps.setBoolean(4, produto.isPerecivel());
            ps.setInt(5, produto.getQuant_Estoque());
            
            ps.executeUpdate();
        }
        finally{
            rs.close();
            ps.close();
            con.close();
        }
    }
    
    public List<Produto> ler_Produto() throws Exception{
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
    
    public Produto ler_Produto(int id) throws Exception{
        String sql = "SELECT * FROM produto WHERE ser_id = ?";
                
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
    
    public int alt_Produto(Produto produto) throws Exception{
        int id = produto.getId();
        String sql = "UPDATE produto SET def_perecivel = ?,"
                + "def_quantidade = ?,"
                + "def_preco = ?,"
                + "def_nome = ?,"
                + " WHERE def_id = ?";
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, produto.getPreco());
            ps.setString(2, produto.getNome());
            ps.setInt(3, produto.getId());
            ps.setBoolean(4, produto.isPerecivel());
            ps.setInt(5, id);
            
            return ps.executeUpdate();
        } finally{
            ps.close();
            con.close(); 
        }
    }
    
    public int del_Produto(Produto produto) throws Exception{
        int id = produto.getId();
        String sql_del = "DELETE FROM produto WHERE def_id = ?";
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            ps = con.prepareStatement(sql_del);
            
            ps.setInt(1, id);
            
            return ps.executeUpdate();
        } finally{
            ps.close();
            con.close();
        }
    }
}
