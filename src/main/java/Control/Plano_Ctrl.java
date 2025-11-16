package Control;


import Model.Plano;
import Model.Produto;
import Model.Servico;
import java.sql.*;
import java.util.ArrayList;

public class Plano_Ctrl {
    private static Plano_Ctrl instancia;    
    
    private Plano_Ctrl(){}
    
    public static Plano_Ctrl getInstancia(){
        if(instancia == null) instancia = new Plano_Ctrl();
        
        return instancia;
    }
    
    public void cad_Plano(Plano plano){
        //Ainda não implementado
    }
    
    public Plano[] ler_Plano() throws Exception{
        int num_lin = 0;
        String sql = "SELECT * FROM usuario";
        Plano[] us = null;
        
        
        Connection con = Banco_Ctrl.getInstancia().getConexao();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.last();
        num_lin = rs.getRow();
        rs.beforeFirst();
        us = new Plano[num_lin];

        for(int i = 0; rs.next(); i++){
            us[i] = new Plano(
                            getServicos(rs.getInt("pla_id")),
                            getProdutos(rs.getInt("pla_id")),
                            rs.getInt("pla_preco"),
                            rs.getString("pla_nome"),
                            rs.getInt("pla_id")
                        );
        }

        rs.close();
        ps.close();
        con.close();

        return us;        
    }
    public Plano ler_Plano(int id) throws Exception{
        String sql = "SELECT * FROM plano WHERE ser_id = ?";
                
        Connection con = Banco_Ctrl.getInstancia().getConexao();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
      
        Plano plano = null;
        
        if(rs.next())
            plano = new Plano(
                    getServicos(rs.getInt("pla_id")),
                    getProdutos(rs.getInt("pla_id")),
                    rs.getInt("pla_preco"),
                    rs.getString("pla_nome"),
                    rs.getInt("pla_id")
            );
        
        rs.close();
        ps.close();
        con.close();
        
        return plano;
    }
    
    public void alt_Plano(Plano plano){
        //Ainda não implementado
    }
    
    public boolean del_Plano(Plano plano) throws Exception{
        return false;
    }
    
    public ArrayList<Servico> getServicos(int id) throws Exception{
        ArrayList<Servico> Servicos = new ArrayList();
        
        String sql = "SELECT * FROM plano_servico WHERE pla_id = ?";
             
        Connection con = Banco_Ctrl.getInstancia().getConexao();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){            
            Servicos.add(Servico_Ctrl.getInstancia().ler_Servico(rs.getInt("ser_id")));
        }
         
        return Servicos;
    }
    public ArrayList<Produto> getProdutos(int id) throws Exception{
        ArrayList<Produto> Produtos = new ArrayList();
        
        String sql = "SELECT * FROM plano_produto WHERE pla_id = ?";
             
        Connection con = Banco_Ctrl.getInstancia().getConexao();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){            
            Produtos.add(Produto_Ctrl.getInstancia().ler_Produto(rs.getInt("pro_id")));
        }
        
        rs.close();
        ps.close();
        con.close();
        
        return Produtos;
    }
}
