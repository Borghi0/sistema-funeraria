package Control;

import Model.Servico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Servico_Ctrl {
    private static Servico_Ctrl instancia;
    private Calculadora calc;
    
    private Servico_Ctrl(){
        calc = new Calculadora(new DescontoServico());
    }
    
    public static Servico_Ctrl getInstancia(){
        if(instancia == null) instancia = new Servico_Ctrl();
        
        return instancia;
    }
    
    public void cad_Servico(Servico servico) throws SQLException, ClassNotFoundException{
        
        try(Connection con = Banco_Ctrl.getInstancia().getConexao()){
            
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
    
    public List<Servico> ler_Servico() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM servico";
        List<Servico> servicos = new ArrayList();
                
        try(Connection con = Banco_Ctrl.getInstancia().getConexao();
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
    
    public Servico ler_Servico(int id) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM servico WHERE ser_id = ?";
                
        try(Connection con = Banco_Ctrl.getInstancia().getConexao();
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
    
    public List<Servico> ler_ServicoGenerico() throws SQLException, ClassNotFoundException{        
        String sql = "SELECT * FROM servico WHERE ser_prestacao IS NULL";
        List<Servico> servicos = new ArrayList();
                
        try(Connection con = Banco_Ctrl.getInstancia().getConexao();
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
    
    public List<Servico> ler_ServicoProgramado() throws SQLException, ClassNotFoundException{        
        String sql = "SELECT * FROM servico WHERE ser_prestacao IS NOT NULL";
        List<Servico> servicos = new ArrayList();
                
        try(Connection con = Banco_Ctrl.getInstancia().getConexao();
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
        String sql = "UPDATE servico SET ser_nome = ? "
                + "ser_preco = ? "
                + "ser_tipo = ? "
                + "ser_prestacao = ? "
                + "WHERE ser_id = ?";
        
        try(
            Connection con = Banco_Ctrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql)
        ){
            ps.setString(1, servico.getNome());
            ps.setDouble(2, servico.getPreco());
            ps.setString(3, servico.getTipo());
            ps.setDate(4, Date.valueOf(servico.getPrestacao()));
            ps.setInt(5, servico.getId());
            
            return ps.executeUpdate();
        }
    }
    
    public int del_Servico(Servico servico) throws SQLException, ClassNotFoundException{
        int retorno = 0;
        String sql_del_ponte = "DELETE FROM plano_servico p_s WHERE "
                             + " p_s.ser_id IN (SELECT s.ser_id FROM servico s"
                             + " WHERE s.ser_id = " + servico.getId(),
                
               sql_del_ser = "DELETE FROM servico WHERE ser_id = " + servico.getId(),
               
               sql_up_plano = "UPDATE FROM plano SET pla_preco = pla_preco - " +
                              calc.calcularValor(servico.getPreco()) + " WHERE"
                            + " pla_id IN (SELECT p_s.pla_id FROM plano_servico p_s"
                            + " WHERE p_s.ser_id = " + servico.getId() + ")";
        
        Connection con = null;        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            try(Statement st = con.createStatement()){
        
                con.setAutoCommit(false);

                retorno += st.executeUpdate(sql_up_plano);
                retorno += st.executeUpdate(sql_del_ponte);
                retorno += st.executeUpdate(sql_del_ser);

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
