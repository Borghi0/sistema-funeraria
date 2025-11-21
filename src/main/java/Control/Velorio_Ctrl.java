package Control;

import Model.Defunto;
import Model.Sala;
import Model.Velorio;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Velorio_Ctrl {
    private static Velorio_Ctrl instancia;
    
    private Velorio_Ctrl(){}
    
    public static Velorio_Ctrl getInstancia(){
        if(instancia == null) instancia = new Velorio_Ctrl();
        
        return instancia;
    }
    
    public int cad_Velorio(Velorio velorio) throws Exception{
        String sql = "INSERT INTO velorio VALUES ((SELECT sal_numero FROM sala s"
                + " WHERE s.sal_numero = ?), ?, (SELECT def_id FROM "
                + "defunto d WHERE d.def_id = ?))";
        
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
    
    public List<Velorio> ler_Velorio() throws Exception{
        String sql = "SELECT * FROM velorio NATURAL JOIN sala NATURAL JOIN defunto";
        Sala intermediarioS = null;
        Defunto intermediarioD = null;
        List<Velorio> retorno = new LinkedList<>();
        
        try(
            Connection con = Banco_Ctrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ){
            while(rs.next()){
                intermediarioS = new Sala(rs.getInt("sal_capacidade"), 
                                                    rs.getInt("sal_numero"));
                intermediarioD = new Defunto(rs.getDate("def_data_obito").toLocalDate(),
                                             rs.getString("def_tipo_obito"),
                                             rs.getString("def_cemiterio"),
                                             rs.getString("def_nome"),
                                             rs.getDate("def_data_natalidade").toLocalDate(),
                                             rs.getInt("def_id"));
                retorno.add(new Velorio(intermediarioS, 
                                        rs.getTimestamp("vel_data_horario").toLocalDateTime(),
                                        intermediarioD));
            }
            
            return retorno;
        }
    }
    
    public int alt_Velorio(Velorio velorio) throws Exception{
        String sql = "UPDATE velorio SET sal_numero = (SELECT sal_numero"
                + " FROM sala s WHERE s.sal_numero = ?), "
                + "vel_data_horario = ? WHERE def_id = ?";
        
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
    

    public int del_Velorio(Velorio velorio) throws Exception{
        String sql = "DELETE FROM velorio WHERE sal_numero = ? AND vel_data_horario = ?";
        
        try(
            Connection con = Banco_Ctrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setInt(1, velorio.getSala().getNumero());
            ps.setTimestamp(2, Timestamp.valueOf(velorio.getData()));
            
            return ps.executeUpdate();
        }
    }
}
