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
