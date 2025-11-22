package Control;


import Model.Plano;
import Model.Produto;
import Model.Servico;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class Plano_Ctrl {
    private static Plano_Ctrl instancia;    
    
    private Plano_Ctrl(){}
    
    public static Plano_Ctrl getInstancia(){
        if(instancia == null) instancia = new Plano_Ctrl();
        
        return instancia;
    }
    
    public void cad_Plano(Plano plano) throws Exception{
        Connection con = null;
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            con.setAutoCommit(false);                        
            
            String sql = "INSERT INTO plano VALUES (NULL, ?, ?)";
            
            try(PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){            
                ps.setString(1, plano.getNome());
                ps.setDouble(2, plano.getPreco());
                
                ps.executeUpdate();
                
                try(ResultSet rs = ps.getGeneratedKeys()){
                    if(rs.next()) plano.setId(rs.getInt(1));
                }
            }
            
            cad_Relacionamentos(plano, con);
            
            con.commit();
            
        }catch(Exception e){            
            if(con!=null) try{con.rollback();} catch(SQLException ex){}
            throw e;            
        }finally{
            if(con!=null) try{con.close();} catch(SQLException ex){}
        }
    }
    
    public List<Plano> ler_Plano() throws Exception{        
        String sql = "SELECT * FROM plano";
        List<Plano> planos = new ArrayList();
        
        try(Connection con = Banco_Ctrl.getInstancia().getConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){                                                    
                
                while(rs.next()){
                    planos.add(new Plano(
                                    getServicos(rs.getInt("pla_id")),
                                    getProdutos(rs.getInt("pla_id")),
                                    rs.getDouble("pla_preco"),
                                    rs.getString("pla_nome"),
                                    rs.getInt("pla_id")
                    ));
                }
        }
        return planos;        
    }
    
    public Plano ler_Plano(int id) throws Exception{
        String sql = "SELECT * FROM plano WHERE pla_id = ?";
                
        Connection con = Banco_Ctrl.getInstancia().getConexao();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
      
        Plano plano = null;
        
        if(rs.next())
            plano = new Plano(
                    getServicos(rs.getInt("pla_id")),
                    getProdutos(rs.getInt("pla_id")),
                    rs.getDouble("pla_preco"),
                    rs.getString("pla_nome"),
                    rs.getInt("pla_id")
            );
        
        rs.close();
        ps.close();
        con.close();
        
        return plano;
    }
    
    public void alt_Plano(Plano plano) throws Exception{
        Connection con = null;
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            con.setAutoCommit(false);
            
            String sql = "UPDATE plano SET pla_nome = ?, pla_preco = ?";
            
            try(PreparedStatement ps = con.prepareStatement(sql)){            
                ps.setString(1, plano.getNome());
                ps.setDouble(2, plano.getPreco());
                
                ps.executeUpdate();                
            }
            
            del_Relacionamentos(plano, con);
            cad_Relacionamentos(plano, con);
            
            con.commit();
        }catch(Exception e){            
            if(con!=null) try{con.rollback();} catch(SQLException ex){}
            throw e;            
        }finally{
            if(con!=null) try{con.close();} catch(SQLException ex){}
        }
    }
    
    public boolean del_Plano(Plano plano) throws Exception{
        Connection con = null;
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            con.setAutoCommit(false);
            
            del_Relacionamentos(plano, con);
            
            String sql = "DELETE FROM plano WHERE pla_id = ?";
            
            int delCol = 0;
            
            try(PreparedStatement ps = con.prepareStatement(sql)){                            
                ps.setInt(1, plano.getId());
                
                delCol = ps.executeUpdate();                
            }                        
            
            con.commit();
            
            return delCol>0;
            
        }catch(Exception e){            
            if(con!=null) try{con.rollback();} catch(SQLException ex){}
            throw e;            
        }finally{
            if(con!=null) try{con.close();} catch(SQLException ex){}
        }
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

    private void cad_Relacionamentos(Plano plano, Connection con) throws Exception{
        if(plano.getListaServicos()!=null){        
            String sqlSer = "INSERT INTO plano_servico (pla_id, ser_id) VALUES (?, ?)";
                
            try (PreparedStatement ps = con.prepareStatement(sqlSer)) {

                for(Servico servico : plano.getListaServicos()){
                    ps.setInt(1, plano.getId());
                    ps.setInt(2, servico.getId());
                    ps.addBatch();
                }
                ps.executeBatch();
            }            
        }
        
        if(plano.getListaProdutos()!=null){
            String sqlPro = "INSERT INTO plano_produto (pla_id, pro_id) VALUES (?, ?)";

            try (PreparedStatement ps = con.prepareStatement(sqlPro)) {

                for(Produto produto : plano.getListaProdutos()){
                    ps.setInt(1, plano.getId());
                    ps.setInt(2, produto.getId());
                    ps.addBatch();
                }
                ps.executeBatch();
            }
        }
    }

    private void del_Relacionamentos(Plano plano, Connection con) throws Exception{
        String sqlSer = "DELETE FROM plano_servico WHERE pla_id = ?";
        
        try(PreparedStatement ps = con.prepareStatement(sqlSer)){
            ps.setInt(1, plano.getId());
            ps.executeUpdate();
        }
        
        
        String sqlPro = "DELETE FROM plano_produto WHERE pla_id = ?";
        
        try(PreparedStatement ps = con.prepareStatement(sqlPro)){
            ps.setInt(1, plano.getId());
            ps.executeUpdate();
        }
    }
}
