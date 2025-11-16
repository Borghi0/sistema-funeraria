package Control;


import Model.Servico;
import java.sql.*;

public class Servico_Ctrl {
    private static Servico_Ctrl instancia;
    
    private Servico_Ctrl(){}
    
    public static Servico_Ctrl getInstancia(){
        if(instancia == null) instancia = new Servico_Ctrl();
        
        return instancia;
    }
    
    public void cad_Servico(Servico servico){
        //Ainda não implementado
    }
    
    public Servico ler_Servico(int id) throws Exception{
        String sql = "SELECT * FROM servico WHERE ser_id = ?";
                
        Connection con = Banco_Ctrl.getInstancia().getConexao();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
      
        Servico servico = null;
        
        if(rs.next())
            servico = new Servico(
                    rs.getDate("ser_prestacao").toLocalDate(),
                    rs.getString("ser_tipo"),
                    rs.getInt("ser_preco"),
                    rs.getString("ser_nome"),
                    rs.getInt("ser_id")
            );
        
        rs.close();
        ps.close();
        con.close();
        
        return servico;
    }
    
    public void alt_Servico(Servico servico){
        //Ainda não implementado
    }
    
    public void del_Servico(Servico servico){
        //Ainda não implementado
    }
}
