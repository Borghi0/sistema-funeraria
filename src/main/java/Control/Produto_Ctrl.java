package Control;

import Model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Produto_Ctrl {
    private static Produto_Ctrl instancia;
    private Calculadora calc;
    
    private Produto_Ctrl(){
        calc = new Calculadora(new DescontoProduto());
    }
    
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
    
    public Produto ler_Produto(int id) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM produto WHERE pro_id = ?";
                
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
        int retorno = 0;
        String sql_del_ponte = "DELETE FROM plano_produto WHERE"
                             + " pro_id IN (SELECT p.pro_id FROM produto p"
                             + " WHERE p.pro_id = " + produto.getId() + ")",
               sql_del_prod = "DELETE FROM produto WHERE pro_id = " + produto.getId(),
               sql_up_plano = "UPDATE plano SET pla_preco = pla_preco - " +
                              calc.calcularValor(produto.getPreco()) + " WHERE"
                            + " pla_id IN (SELECT p_p.pla_id FROM plano_produto p_p"
                            + " WHERE p_p.pro_id = " + produto.getId() + ")";        
                
        Connection con = null;        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            try(Statement st = con.createStatement()){
        
                con.setAutoCommit(false);

                retorno += st.executeUpdate(sql_up_plano);
                retorno += st.executeUpdate(sql_del_ponte);
                retorno += st.executeUpdate(sql_del_prod);

                con.commit();
                return retorno;
            }
        }catch(SQLException e){
            if(con!=null) try{con.rollback();} catch(SQLException ex){}
            throw e;
        }finally{
            if(con!=null) try{con.close();} catch(SQLException ex){}            
        }
    }
}
