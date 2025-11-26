package Control;

import Model.Plano;
import Model.Produto;
import Model.Servico;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;


public class PlanoCtrl {
    private static PlanoCtrl instancia;    
    
    private PlanoCtrl(){}
    
    public static PlanoCtrl getInstancia(){
        if(instancia == null) instancia = new PlanoCtrl();
        
        return instancia;
    }
    
    public void cadPlano(Plano plano) throws SQLException, ClassNotFoundException{
        Connection con = null;
        try{
            con = BancoCtrl.getInstancia().getConexao();
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
            
            cadRelacionamentos(plano, con);
            
            con.commit();
            
        }catch(Exception e){            
            if(con!=null) try{con.rollback();} catch(SQLException ex){}
            throw e;            
        }finally{
            if(con!=null) try{con.close();} catch(SQLException ex){}
        }
    }
    
    public List<Plano> lerPlano() throws SQLException, ClassNotFoundException{        
        String sql = "SELECT * FROM plano";
        List<Plano> planos = new ArrayList();
        
        try(Connection con = BancoCtrl.getInstancia().getConexao();
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
    
    public Plano lerPlano(int id) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM plano WHERE pla_id = ?";
                
        try(Connection con = BancoCtrl.getInstancia().getConexao();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            
            try(ResultSet rs = ps.executeQuery()){
                Plano plano = null;
                
                if(rs.next())
                    plano = new Plano(
                            getServicos(rs.getInt("pla_id")),
                            getProdutos(rs.getInt("pla_id")),
                            rs.getDouble("pla_preco"),
                            rs.getString("pla_nome"),
                            rs.getInt("pla_id")
                    );
                return plano;
            }            
        }
    }
    
    public void altPlano(Plano plano) throws SQLException, ClassNotFoundException{
        Connection con = null;
        try{
            con = BancoCtrl.getInstancia().getConexao();
            con.setAutoCommit(false);
            
            String sql = "UPDATE plano SET pla_nome = ?, pla_preco = ? WHERE pla_id = ?";
            
            try(PreparedStatement ps = con.prepareStatement(sql)){            
                ps.setString(1, plano.getNome());
                ps.setDouble(2, plano.getPreco());
                ps.setInt(3, plano.getId());
                
                ps.executeUpdate();                
            }
            
            delRelacionamentos(plano, con);
            cadRelacionamentos(plano, con);
            
            con.commit();
        }catch(Exception e){            
            if(con!=null) try{con.rollback();} catch(SQLException ex){}
            throw e;            
        }finally{
            if(con!=null) try{con.close();} catch(SQLException ex){}
        }
    }
    
    public boolean delPlano(Plano plano) throws SQLException, ClassNotFoundException{
        Connection con = null;
        try{
            con = BancoCtrl.getInstancia().getConexao();
            con.setAutoCommit(false);
            
            delRelacionamentos(plano, con);
            
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
    
    public ArrayList<Servico> getServicos(int id) throws SQLException, ClassNotFoundException{
        ArrayList<Servico> Servicos = new ArrayList();
        
        String sql = "SELECT * FROM plano_servico WHERE pla_id = ?";
             
        try(Connection con = BancoCtrl.getInstancia().getConexao();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){            
                    Servicos.add(ServicoCtrl.getInstancia().lerServico(rs.getInt("ser_id")));
                }
                return Servicos;
            }
        }
    }
    
    public ArrayList<Produto> getProdutos(int id) throws SQLException, ClassNotFoundException{
        ArrayList<Produto> Produtos = new ArrayList();
        
        String sql = "SELECT * FROM plano_produto WHERE pla_id = ?";
             
        try(Connection con = BancoCtrl.getInstancia().getConexao();                
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){            
                    Produtos.add(ProdutoCtrl.getInstancia().lerProduto(rs.getInt("pro_id")));
                }
            }
            return Produtos;
        }
    }

    private void cadRelacionamentos(Plano plano, Connection con) throws SQLException, ClassNotFoundException{
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

    private void delRelacionamentos(Plano plano, Connection con) throws SQLException, ClassNotFoundException{
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
