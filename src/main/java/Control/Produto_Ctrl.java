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
    
    public void cad_Produto(Produto produto){
        //Ainda não implementado
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
    
    public void alt_Produto(Produto produto){
        //Ainda não implementado
    }
    
    public int del_Produto(Produto produto) throws Exception{
        int retorno = 0;
        String sql_del_ponte = "DELETE FROM plano_produto p_p WHERE "
                             + " p_p.pro_id IN (SELECT p.pro_id FROM produto p"
                             + " WHERE p.pro_id = " + produto.getId(),
               sql_del_prod = "DELETE FROM produto WHERE pro_id = " + produto.getId(),
               sql_up_plano = "UPDATE FROM plano p SET pla_preco = pla_preco - " +
                              calc.calcularValor(produto.getPreco()) + " WHERE"
                            + " p.pla_id IN (SELECT p_p.pla_id FROM plano_produto p_p"
                            + " WHERE p_p.pro_id = " + produto.getId();
        Connection con = null;
        Statement st = null;
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            st = con.createStatement();
        
            con.setAutoCommit(false);
            
            retorno += st.executeUpdate(sql_up_plano);
            retorno += st.executeUpdate(sql_del_ponte);
            retorno += st.executeUpdate(sql_del_prod);
            
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
