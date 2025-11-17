package Control;

import Model.Defunto;
import java.sql.*;

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
            ps.setDate(2, Date.valueOf(defunto.getData_natalidade()));
            ps.setDate(3, Date.valueOf(defunto.getData_Obito()));
            ps.setString(4, defunto.getTipo_Obito());
            ps.setString(5, defunto.getCemiterio());
            
            ps.executeUpdate();
        }
        finally{
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
            ps.close();
            con.close();
        }
    }
    
    public Defunto[] ler_Defunto() throws Exception{
        int num_lin = 0;
        String sql = "SELECT * FROM defunto";
        Defunto[] def = null;
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.last();
            num_lin = rs.getRow();
            rs.beforeFirst();
            def = new Defunto[num_lin];
            
            for(int i = 0; i < num_lin; i++){
                rs.next();
                def[i] = new Defunto(rs.getDate("def_data_obito").toLocalDate(),
                                   rs.getString("def_tipo_obito"),
                                   rs.getString("def_cemiterio"),
                                   rs.getString("def_nome"),
                                   rs.getDate("def_data_natalidade").toLocalDate(),
                                   rs.getInt("def_id")
                                    );
            }
           
            return def;
        } finally{
            rs.close();
            ps.close();
            con.close();
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
            ps.setDate(2, Date.valueOf(defunto.getData_natalidade()));
            ps.setDate(3, Date.valueOf(defunto.getData_Obito()));
            ps.setString(4, defunto.getTipo_Obito());
            ps.setString(5, defunto.getCemiterio());
            ps.setInt(6, id);
            
            return ps.executeUpdate();
        } finally{
            ps.close();
            con.close(); 
        }
    }
    
    public int del_Defunto(Defunto defunto) throws Exception{
        int id = defunto.getId();
        String sql_del = "DELETE FROM defunto WHERE def_id = ?";
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            ps = con.prepareStatement(sql_del);
            
            ps.setInt(1, id);
            
            return ps.executeUpdate();
        } finally{
            ps.close();
            con.close();
        }
    }
}
