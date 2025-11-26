package Control;


import Model.Servico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoCtrl {
    private static ServicoCtrl instancia;
    private Calculadora calc;
    
    private ServicoCtrl(){
        calc = new Calculadora(new DescontoServico());
    }
    
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
    
    public int altServico(Servico servico) throws SQLException, ClassNotFoundException{
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
        int retorno = 0;
        String sqlDelPonte = "DELETE FROM plano_servico WHERE "
                             + " ser_id IN (SELECT s.ser_id FROM servico s"
                             + " WHERE s.ser_id = " + servico.getId() + ")",
                
               sqlDelSer = "DELETE FROM servico WHERE ser_id = " + servico.getId(),
               
               sqlUpPlano = "UPDATE plano SET pla_preco = pla_preco - " +
                              calc.calcularValor(servico.getPreco()) + " WHERE"
                            + " pla_id IN (SELECT p_s.pla_id FROM plano_servico p_s"
                            + " WHERE p_s.ser_id = " + servico.getId() + ")";
        
        Connection con = null;        
        try{
            con = BancoCtrl.getInstancia().getConexao();
            try(Statement st = con.createStatement()){
        
                con.setAutoCommit(false);

                retorno += st.executeUpdate(sqlUpPlano);
                retorno += st.executeUpdate(sqlDelPonte);
                retorno += st.executeUpdate(sqlDelSer);

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
