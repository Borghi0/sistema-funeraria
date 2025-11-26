package Control;

import Model.Usuario;
import Model.Endereco;
import Model.Plano;
import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class UsuarioCtrl {
    private static UsuarioCtrl instancia;    
    
    private UsuarioCtrl(){}
    
    public static UsuarioCtrl getInstancia(){
        if(instancia == null) instancia = new UsuarioCtrl();
        
        return instancia;
    }
    
    private void cadUser(Usuario user, Connection con) throws Exception{
        String sql = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NULL)";
        
        try(PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, user.getCpf());
            ps.setString(2, user.getNome());
            ps.setDate(3, Date.valueOf(user.getDataNatalidade()));
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getSenha());
            ps.setString(6, user.getNumeroTelefone());
            ps.setBoolean(7, user.isAdmin());
            ps.setInt(8, user.getEndereco().getNumero());
            ps.setString(9, user.getEndereco().getRua());
            ps.setString(10, user.getEndereco().getCep());
            
            ps.executeUpdate();
        }
    }
    
    public void cadUser(Usuario user, Endereco ender) throws Exception{
        Connection con = null;
        try{
            con = BancoCtrl.getInstancia().getConexao();
            con.setAutoCommit(false);
            
            EnderecoCtrl.getInstancia().cadEndereco(ender, con);
            cadUser(user, con);
            
            con.commit();
        }catch(Exception e){
            if(con!=null) con.rollback();
            throw e;
        }finally{
            if(con!=null) con.close();
        }
    }
    
    public List<Usuario> lerUser() throws Exception{        
        String sql = "SELECT * FROM usuario NATURAL JOIN plano";
        Endereco intermediarioE = new Endereco();
        Plano intermediarioP = new Plano();
        List<Usuario> retorno = new LinkedList<>();
        
        try(
            Connection con = BancoCtrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){
            while(rs.next()){
                intermediarioE.setNumero(rs.getInt("end_numero"));
                intermediarioE.setCep(rs.getString("end_cep"));
                intermediarioE.setRua(rs.getString("end_rua"));
                
                intermediarioP = PlanoCtrl.getInstancia().lerPlano(rs.getInt("pla_id"));
                
                retorno.add(new Usuario(
                                    rs.getString("usu_login"),
                                    rs.getString("usu_senha"),
                                    rs.getString("usu_numero_telefone"),
                                    rs.getBoolean("usu_admin"),
                                    intermediarioE,
                                    intermediarioP,
                                    rs.getString("usu_cpf"),
                                    rs.getString("usu_nome"),
                                    rs.getDate("usu_data_natalidade").toLocalDate()));
            }
            
            return retorno;
        }
    }
    
    public Usuario lerUser(String cpf) throws Exception{
        String sql = "SELECT * FROM usuario WHERE usu_cpf = " + cpf;
        
        try(
            Connection con = BancoCtrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){
            
            while(rs.next()){
                if(rs.getString("usu_cpf").equals(cpf)) 
                    return new Usuario(
                            rs.getString("usu_login"),
                            rs.getString("usu_senha"),
                            rs.getString("usu_numero_telefone"),
                            rs.getBoolean("usu_admin"),
                            new Endereco(rs.getInt("end_numero"), rs.getString("end_rua"), rs.getString("end_cep")),
                            PlanoCtrl.getInstancia().lerPlano(rs.getInt("pla_id")),
                            rs.getString("usu_cpf"),
                            rs.getString("usu_nome"),
                            rs.getDate("usu_data_natalidade").toLocalDate()
                    );
            }
            return null;
        }       
    }
    
    public Usuario lerUserLogin(String email) throws Exception{
        String sql = "SELECT * FROM usuario WHERE usu_login = ?";
        
        try(Connection con = BancoCtrl.getInstancia().getConexao();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, email);
            
            try(ResultSet rs = ps.executeQuery()){            
                while(rs.next()){
                    if(rs.getString("usu_login").equals(email)) 
                        return new Usuario(
                                rs.getString("usu_login"),
                                rs.getString("usu_senha"),
                                rs.getString("usu_numero_telefone"),
                                rs.getBoolean("usu_admin"),
                                new Endereco(rs.getInt("end_numero"), rs.getString("end_rua"), rs.getString("end_cep")),
                                PlanoCtrl.getInstancia().lerPlano(rs.getInt("pla_id")),
                                rs.getString("usu_cpf"),
                                rs.getString("usu_nome"),
                                rs.getDate("usu_data_natalidade").toLocalDate()
                        );
                }
            }
            return null;
        }       
    }
    
    public int altUser(Usuario user) throws Exception{
        int retorno = 0;
        String sqlUpdtUs = "UPDATE usuario SET usu_nome = " + user.getNome()
                           + " usu_data_natalidade = " + Date.valueOf(user.getDataNatalidade())
                            + " usu_login = " + user.getEmail()
                            + " usu_senha = " + user.getSenha()
                            + " usu_numero_telefone = " + user.getNumeroTelefone()
                            + " usu_admin = " + (user.isAdmin() ? "TRUE" : "FALSE")
                            + " pla_id = " + (user.getPlano()==null ? null : user.getPlano().getId())
                            + " WHERE usu_cpf = " + user.getCpf(),
                sqlUpdtEnd = "UPDATE endereco SET end_numero = " + user.getEndereco().getNumero()
                             + ", end_rua = " + user.getEndereco().getRua()
                             + ", end_cep = " + user.getEndereco().getCep()
                             + " WHERE (end_numero, end_rua, end_cep) IN "
                             + "(SELECT end_numero, end_rua, end_cep FROM usuario"
                             + " WHERE usu_cpf = " + user.getCpf() + ")";
        
        Connection con = null;
        try{ 
            con = BancoCtrl.getInstancia().getConexao();            
            
            try(Statement st = con.createStatement()){   
                con.setAutoCommit(false);
                
                retorno += st.executeUpdate(sqlUpdtEnd);
                retorno += st.executeUpdate(sqlUpdtUs);
                
                con.commit();
            }
            return retorno;
        } catch(Exception e){
            if(con!=null) con.rollback();
            throw e;
        } finally{
            if(con!=null) con.close();
        }
    }
    
    public int altUserSetAdmin(Usuario user) throws SQLException, ClassNotFoundException{        
        String sql = "UPDATE usuario SET usu_admin = " + (user.isAdmin() ? "TRUE" : "FALSE")                            
                            + " WHERE usu_cpf = " + user.getCpf();                
        
        try(
            Connection con = BancoCtrl.getInstancia().getConexao();
            Statement st = con.createStatement();
        ){                        
            return st.executeUpdate(sql);                        
        }
    }

    public int delUser(Usuario user) throws Exception{
        int retorno = 0;
        String cpf = user.getCpf(),
               sql_del_us = "DELETE FROM usuario WHERE usu_cpf = " + user.getCpf(),
               sql_del_end = "DELETE FROM endereco WHERE end_numero = " +
                user.getEndereco().getNumero() + " AND end_rua = " + user.getEndereco().getRua()
                + " AND end_cep = " + user.getEndereco().getCep();
        
        Connection con = null;
        try{
            con = BancoCtrl.getInstancia().getConexao();
            
            try(Statement st = con.createStatement()){
                con.setAutoCommit(false);

                retorno += st.executeUpdate(sql_del_us);
                retorno += st.executeUpdate(sql_del_end);

                con.commit();
            }
            return retorno;            
        } catch(Exception e){
            if(con!=null) con.rollback();
            throw e;
        } finally{
            if(con!=null) con.close();
        }
    }
    
    public int adquirirPlano(Usuario user, Plano plano) throws Exception{
        String sql = "UPDATE usuario SET pla_id = ? WHERE usu_cpf = ?";
        
        try(
            Connection con = BancoCtrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql)
        ){
            ps.setInt(1, plano.getId());
            ps.setString(2, user.getCpf());
            
            return ps.executeUpdate();
        }       
    }
}
