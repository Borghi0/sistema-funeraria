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
    
    public Servico[] ler_Servico() throws Exception{
        int num_lin = 0;
        String sql = "SELECT * FROM usuario";
        Servico[] servicos = null;
        
        
        Connection con = Banco_Ctrl.getInstancia().getConexao();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.last();
        num_lin = rs.getRow();
        rs.beforeFirst();
        servicos = new Servico[num_lin];

        for(int i = 0; rs.next(); i++){                
            servicos[i] = new Servico(
                            rs.getDate("ser_prestacao").toLocalDate(),
                            rs.getString("usu_tipo"),
                            rs.getInt("usu_preco"),
                            rs.getString("usu_nome"),
                            rs.getInt("usu_id")                                
                        );
        }

        rs.close();
        ps.close();
        con.close();

        return servicos;                            
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
    

    public Servico[] ler_ServicoGenerico() throws Exception{
        int num_lin = 0;
        String sql = "SELECT * FROM usuario WHERE ser_prestacao IS NULL";
        Servico[] servicos = null;
        
        
        Connection con = Banco_Ctrl.getInstancia().getConexao();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.last();
        num_lin = rs.getRow();
        rs.beforeFirst();
        servicos = new Servico[num_lin];

        for(int i = 0; rs.next(); i++){                
            servicos[i] = new Servico(
                            rs.getDate("ser_prestacao").toLocalDate(),
                            rs.getString("usu_tipo"),
                            rs.getInt("usu_preco"),
                            rs.getString("usu_nome"),
                            rs.getInt("usu_id")                                
                        );
        }

        rs.close();
        ps.close();
        con.close();

        return servicos;                            
    }
    
    public void alt_Servico(Servico servico){
        //Ainda não implementado
    }
    
    public int del_Servico(Servico servico){
        return 0;
    }
}
