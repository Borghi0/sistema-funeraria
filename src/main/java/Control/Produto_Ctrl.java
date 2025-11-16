package Control;


import Model.Produto;
import java.sql.*;


public class Produto_Ctrl {
    private static Produto_Ctrl instancia;
    
    private Produto_Ctrl(){}
    
    public static Produto_Ctrl getInstancia(){
        if(instancia == null) instancia = new Produto_Ctrl();
        
        return instancia;
    }
    
    public void cad_Produto(Produto produto){
        //Ainda não implementado
    }
    
    public Produto[] ler_Produto() throws Exception{
        int num_lin = 0;
        String sql = "SELECT * FROM usuario";
        Produto[] produtos = null;
        
        
        Connection con = Banco_Ctrl.getInstancia().getConexao();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.last();
        num_lin = rs.getRow();
        rs.beforeFirst();
        produtos = new Produto[num_lin];

        for(int i = 0; rs.next(); i++){                
            produtos[i] = new Produto(
                            rs.getBoolean("ser_perecivel"),
                            rs.getInt("usu_quant_estoque"),
                            rs.getInt("usu_preco"),
                            rs.getString("usu_nome"),
                            rs.getInt("usu_id")                                
                        );
        }

        rs.close();
        ps.close();
        con.close();

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
    
    public void del_Produto(Produto produto){
        //Ainda não implementado
    }
}
