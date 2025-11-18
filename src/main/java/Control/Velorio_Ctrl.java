package Control;

import Model.Velorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class Velorio_Ctrl {
    private static Velorio_Ctrl instancia;
    
    private Velorio_Ctrl(){}
    
    public static Velorio_Ctrl getInstancia(){
        if(instancia == null) instancia = new Velorio_Ctrl();
        
        return instancia;
    }
    
    public int cad_Velorio(Velorio velorio) throws Exception{
        String sql = "INSERT INTO velorio VALUES (?, ?, ?)";
        
        try(
            Connection con = Banco_Ctrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql)
        ){
            ps.setInt(1, velorio.getSala().getNumero());
            ps.setTimestamp(2, Timestamp.valueOf(velorio.getData()));
            ps.setInt(3, velorio.getDefunto().getId());
            
            return ps.executeUpdate();
        }
    }
    
    public void ler_Velorio(Velorio velorio){
        //Ainda não implementado
    }
    
    public void alt_Velorio(Velorio velorio){
        //Ainda não implementado
    }
    
    public void del_Velorio(Velorio velorio){
        //Ainda não implementado
    }
}
