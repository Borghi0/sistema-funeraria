package Control;


import Model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProdutoCtrl {
    private static ProdutoCtrl instancia;
    private Calculadora calc;
    
    private ProdutoCtrl(){
        calc = new Calculadora(new DescontoProduto());
    }
    
    public static ProdutoCtrl getInstancia(){
        if(instancia == null) instancia = new ProdutoCtrl();
        
        return instancia;
    }
    
    public void cadProduto(Produto produto) throws SQLException, ClassNotFoundException{
        try(Connection con = BancoCtrl.getInstancia().getConexao()){
            
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
    
    public List<Produto> lerProduto() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList();
                
        try(Connection con = BancoCtrl.getInstancia().getConexao();
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
    
    public Produto lerProduto(int id) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM produto WHERE pro_id = ?";
                
        try(Connection con = BancoCtrl.getInstancia().getConexao();
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
    
    public int altProduto(Produto produto) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE produto SET pro_nome = ? "
                + "pro_perecivel = ? "
                + "pro_quant_estoque = ? "
                + "pro_preco = ? "
                + "WHERE pro_id = ?";
        
        try(
            Connection con = BancoCtrl.getInstancia().getConexao();
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
    
    public int delProduto(Produto produto) throws Exception{
        int retorno = 0;
        String sqlDelPonte = "DELETE FROM plano_produto WHERE"
                             + " pro_id IN (SELECT p.pro_id FROM produto p"
                             + " WHERE p.pro_id = " + produto.getId() + ")",
               sqlDelProd = "DELETE FROM produto WHERE pro_id = " + produto.getId(),
               sqlUpPlano = "UPDATE plano SET pla_preco = pla_preco - " +
                              calc.calcularValor(produto.getPreco()) + " WHERE"
                            + " pla_id IN (SELECT p_p.pla_id FROM plano_produto p_p"
                            + " WHERE p_p.pro_id = " + produto.getId() + ")";
        Connection con = null;
        Statement st = null;
        
        try{
            con = BancoCtrl.getInstancia().getConexao();
            st = con.createStatement();
        
            con.setAutoCommit(false);
            
            retorno += st.executeUpdate(sqlUpPlano);
            retorno += st.executeUpdate(sqlDelPonte);
            retorno += st.executeUpdate(sqlDelProd);
            
            con.commit();
            
        } catch(SQLException sqle){
            con.rollback();
        } finally{
            con.close();
            st.close();
            
            return retorno;
        }
    }
}
