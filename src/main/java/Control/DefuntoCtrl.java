package Control;

import Model.Defunto;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class DefuntoCtrl {
    private static DefuntoCtrl instancia;
        
    private DefuntoCtrl(){}
    
    public static DefuntoCtrl getInstancia(){
        if(instancia == null) instancia = new DefuntoCtrl();
        
        return instancia;
    }
    
    public void cadDefunto(Defunto defunto) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO defunto VALUES (NULL, ?, ?, ?, ?, ?)";
        
        try(Connection con = BancoCtrl.getInstancia().getConexao();
                PreparedStatement ps = con.prepareStatement(sql)){            

            ps.setString(1, defunto.getNome());            
            ps.setDate(2, Date.valueOf(defunto.getDataNatalidade()));
            ps.setDate(3, Date.valueOf(defunto.getDataObito()));
            ps.setString(4, defunto.getTipoObito());
            ps.setString(5, defunto.getCemiterio());
            
            ps.executeUpdate();
        }        
    }
    
    public Defunto lerDefunto(int id) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM defunto WHERE def_id = ?";
        
        try(Connection con = BancoCtrl.getInstancia().getConexao();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1, id);
            
            try(ResultSet rs = ps.executeQuery()){            
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
            }
        }
    }
    
    public List<Defunto> lerDefunto() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM defunto";
        List<Defunto> retorno = new LinkedList<>();
        
        try(
            Connection con = BancoCtrl.getInstancia().getConexao();
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
    
    public int altDefunto(Defunto defunto) throws SQLException, ClassNotFoundException{
        int id = defunto.getId();
        String sql = "UPDATE defunto SET def_nome = ?,"
                + "def_data_natalidade = ?,"
                + "def_data_obito = ?,"
                + "def_tipo_obito = ?,"
                + "def_cemiterio = ?"
                + " WHERE def_id = ?";
        
        try(Connection con = BancoCtrl.getInstancia().getConexao();
                PreparedStatement ps = con.prepareStatement(sql)){            
            
            ps.setString(1, defunto.getNome());
            ps.setDate(2, Date.valueOf(defunto.getDataNatalidade()));
            ps.setDate(3, Date.valueOf(defunto.getDataObito()));
            ps.setString(4, defunto.getTipoObito());
            ps.setString(5, defunto.getCemiterio());
            ps.setInt(6, id);
            
            return ps.executeUpdate();
        }
    }
    
    public int delDefunto(Defunto defunto) throws SQLException, ClassNotFoundException{
        int id = defunto.getId(),
            retorno = 0;
        String sql_del_def = "DELETE FROM defunto WHERE def_id = " + id,
               sql_del_vel = "DELETE FROM velorio WHERE def_id = " + id;
        
        Connection con = null;
        try{
            con = BancoCtrl.getInstancia().getConexao();
            try(Statement st = con.createStatement()){
            
                con.setAutoCommit(false);

                retorno += st.executeUpdate(sql_del_vel);
                retorno += st.executeUpdate(sql_del_def);

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
