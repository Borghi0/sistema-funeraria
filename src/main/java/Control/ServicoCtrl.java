package Control;


import Model.Servico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoCtrl {
    private static ServicoCtrl instancia;
    
    private ServicoCtrl(){}
    
    public static ServicoCtrl getInstancia(){
        if(instancia == null) instancia = new ServicoCtrl();
        
        return instancia;
    }
    
    public void cadServico(Servico servico) throws SQLException, ClassNotFoundException{
        
        try(Connection con = BancoCtrl.getInstancia().getConexao()){
            
            String sql = "INSERT INTO servico (ser_nome, ser_prestacao, ser_preco, ser_tipo) "
                    + "VALUES (?, ?, ?, ?)";
            
            try(PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1, servico.getNome());
                
                if(servico.getPrestacao()!=null) ps.setDate(2, Date.valueOf(servico.getPrestacao()));
                else ps.setDate(2, null);
                
                ps.setDouble(3, servico.getPreco());
                ps.setString(4, servico.getTipo());
                
                ps.executeUpdate();
            }            
        }
    }
    
    public List<Servico> lerServico() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM servico";
        List<Servico> servicos = new ArrayList();
                
        try(Connection con = BancoCtrl.getInstancia().getConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
        
            while(rs.next()){
                servicos.add(new Servico(
                                rs.getDate("ser_prestacao")==null ? null : rs.getDate("ser_prestacao").toLocalDate(),
                                rs.getString("ser_tipo"),
                                rs.getDouble("ser_preco"),
                                rs.getString("ser_nome"),
                                rs.getInt("ser_id")                                
                            ));
            }        
        }
        return servicos;                            
    }
    
    public Servico lerServico(int id) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM servico WHERE ser_id = ?";
                
        try(Connection con = BancoCtrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            
            try(ResultSet rs = ps.executeQuery()){
                Servico servico = null;
        
                if(rs.next())
                    servico = new Servico(
                            rs.getDate("ser_prestacao")==null ? null : rs.getDate("ser_prestacao").toLocalDate(),
                            rs.getString("ser_tipo"),
                            rs.getDouble("ser_preco"),
                            rs.getString("ser_nome"),
                            rs.getInt("ser_id")
                    );
                return servico;
            }
        }
    }
    
    public List<Servico> lerServicoGenerico() throws SQLException, ClassNotFoundException{        
        String sql = "SELECT * FROM servico WHERE ser_prestacao IS NULL";
        List<Servico> servicos = new ArrayList();
                
        try(Connection con = BancoCtrl.getInstancia().getConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
        
            while(rs.next()){
                servicos.add(new Servico(
                                null,
                                rs.getString("ser_tipo"),
                                rs.getDouble("ser_preco"),
                                rs.getString("ser_nome"),
                                rs.getInt("ser_id")                                
                            ));
            }        
        }
        return servicos;                            
    }
    
    public List<Servico> lerServicoProgramado() throws SQLException, ClassNotFoundException{        
        String sql = "SELECT * FROM servico WHERE ser_prestacao IS NOT NULL";
        List<Servico> servicos = new ArrayList();
                
        try(Connection con = BancoCtrl.getInstancia().getConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
        
            while(rs.next()){
                servicos.add(new Servico(
                                rs.getDate("ser_prestacao").toLocalDate(),
                                rs.getString("ser_tipo"),
                                rs.getDouble("ser_preco"),
                                rs.getString("ser_nome"),
                                rs.getInt("ser_id")                                
                            ));
            }        
        }
        return servicos;
    }
    
    public int alt_Servico(Servico servico) throws SQLException, ClassNotFoundException{
        String sql = "UPDRATE servico SET ser_tipo = ?, ser_prestacao = ?"
                + " WHERE ser_id = ?";
        
        try(
            Connection con = BancoCtrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1, servico.getTipo());
            ps.setDate(2, Date.valueOf(servico.getPrestacao()));
            ps.setInt(3, servico.getId());
            
            return ps.executeUpdate();
        }
    }
    
    public int delServico(Servico servico) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM servico WHERE ser_id = ?";
        
        try(Connection con = BancoCtrl.getInstancia().getConexao();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1, servico.getId());
            return ps.executeUpdate();
        }
    }
}
