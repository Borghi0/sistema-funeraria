package Control;

import Model.Defunto;
import Model.Sala;
import Model.Velorio;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    
    public Velorio ler_Velorio(int numero, LocalDateTime data) throws Exception{
        String sql = "SELECT * FROM velorio AS ve NATURAL JOIN sala  "
                   + "NATURAL JOIN defunto WHERE "
                   + "ve.sal_numero = ? AND "
                   + "vel_data_horario = ?";
        Sala intermediarioS = new Sala();
        Defunto intermediarioD = new Defunto();
        ResultSet rs = null;
        
        try(
            Connection con = Banco_Ctrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql)
        ){
            ps.setInt(1, numero);
            ps.setTimestamp(2, Timestamp.valueOf(data));
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                intermediarioS.setCapacidade(rs.getInt("sal_capacidade"));
                intermediarioS.setNumero(numero);
                
                intermediarioD.setCemiterio(rs.getString("end_cemiterio"));
                intermediarioD.setId(rs.getInt("def_id"));
                intermediarioD.setNome(rs.getString("def_nome"));
                intermediarioD.setData_natalidade(rs.getDate("def_data_natalidade").toLocalDate());
                intermediarioD.setData_Obito(rs.getDate("def_data_obito").toLocalDate());
                intermediarioD.setTipo_Obito(rs.getString("def_tipo_obito"));
                
                return new Velorio(intermediarioS, data, intermediarioD);
            }
        }
        return null;
    }
    
    public List<Velorio> ler_Velorio(){
        return new ArrayList();
    }
    
    public void alt_Velorio(Velorio velorio){
        //Ainda não implementado
    }
    
    public boolean del_Velorio(Velorio velorio){
        //Ainda não implementado
        return false;
    }
    
    public boolean del_Velorio(int numero, LocalDateTime data){
        //Ainda não implementado
        return false;
    }
}
