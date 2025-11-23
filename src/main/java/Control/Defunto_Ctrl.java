package Control;

import Model.Defunto;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Defunto_Ctrl {
    private static Defunto_Ctrl instancia;
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    private Defunto_Ctrl(){
        con = null;
        ps = null;
        rs = null;
    }
    
    public static Defunto_Ctrl getInstancia(){
        if(instancia == null) instancia = new Defunto_Ctrl();
        
        return instancia;
    }
    
    public void cad_Defunto(Defunto defunto) throws Exception{
        String sql = "INSERT INTO defunto VALUES (NULL, ?, ?, ?, ?, ?)";
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            ps = con.prepareStatement(sql);

            ps.setString(1, defunto.getNome());            
            ps.setDate(2, Date.valueOf(defunto.getDataNatalidade()));
            ps.setDate(3, Date.valueOf(defunto.getDataObito()));
            ps.setString(4, defunto.getTipoObito());
            ps.setString(5, defunto.getCemiterio());
            
            ps.executeUpdate();
        }
        finally{
            rs.close();
            ps.close();
            con.close();
        }
    }
    
    public Defunto ler_Defunto(int id) throws Exception{
        String sql = "SELECT * FROM defunto WHERE def_id = ?";
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                return new Defunto(rs.getDate("def_data_obito").toLocalDate(),
                                   rs.getString("def_tipo_obito"),
                                   rs.getString("def_cemiterio"),
                                   rs.getString("def_nome"),
                                   rs.getDate("def_data_natalidade").toLocalDate(),
                                   rs.getInt("def_id")
                );
            }
            
            return null;
        } finally{
            rs.close();
            ps.close();
            con.close();
        }
    }
    
    public List<Defunto> ler_Defunto() throws Exception{
        String sql = "SELECT * FROM defunto";
        List<Defunto> retorno = new LinkedList<>();
        
        try(
            Connection con = Banco_Ctrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ){
            while(rs.next()){
                retorno.add(new Defunto(
                                    rs.getDate("def_data_obito").toLocalDate(),
                                    rs.getString("def_tipo_obito"),
                                    rs.getString("def_cemiterio"),
                                    rs.getString("def_nome"),
                                    rs.getDate("def_data_natalidade").toLocalDate(),
                                    rs.getInt("def_id")));
            }
            
            return retorno;
        }
    }
    
    public int alt_Defunto(Defunto defunto) throws Exception{
        int id = defunto.getId();
        String sql = "UPDATE defunto SET def_nome = ?,"
                + "def_data_natalidade = ?,"
                + "def_data_obito = ?,"
                + "def_tipo_obito = ?,"
                + "def_cemiterio = ?"
                + " WHERE def_id = ?";
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, defunto.getNome());
            ps.setDate(2, Date.valueOf(defunto.getDataNatalidade()));
            ps.setDate(3, Date.valueOf(defunto.getDataObito()));
            ps.setString(4, defunto.getTipoObito());
            ps.setString(5, defunto.getCemiterio());
            ps.setInt(6, id);
            
            return ps.executeUpdate();
        } finally{
            ps.close();
            con.close(); 
        }
    }
    
    public int del_Defunto(Defunto defunto) throws Exception{
        int id = defunto.getId(),
            retorno = 0;
        String sql_del_def = "DELETE FROM defunto WHERE def_id = " + id,
               sql_del_vel = "DELETE FROM velorio WHERE def_id = " + id;
        Connection con = null;
        Statement st = null;
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            st = con.createStatement();
            
            con.setAutoCommit(false);
            
            retorno += st.executeUpdate(sql_del_vel);
            retorno += st.executeUpdate(sql_del_def);
            
            con.commit();
        } catch(SQLException sqle){
            con.rollback();
        }finally{
            st.close();
            con.close();
            
            return retorno;
        }
    }
}
