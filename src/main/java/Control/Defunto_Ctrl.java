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
    
    public void ler_Defunto(Defunto defunto){
        //Ainda não implementado
    }
    
    public void alt_Defunto(Defunto defunto){
        //Ainda não implementado
    }
    
    public void del_Defunto(Defunto defunto){
        //Ainda não implementado
    }
}
