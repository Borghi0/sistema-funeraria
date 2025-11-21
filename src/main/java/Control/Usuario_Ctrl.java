package Control;

import Model.Usuario;
import Model.Endereco;
import Model.Plano;
import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class Usuario_Ctrl {
    private static Usuario_Ctrl instancia;
    private static Connection con;
    private static Statement st;
    private static ResultSet rs;
    private static PreparedStatement ps;
    
    private Usuario_Ctrl(){
        con = null;
        st = null;
        rs = null;
        ps = null;
    }
    
    public static Usuario_Ctrl getInstancia(){
        if(instancia == null) instancia = new Usuario_Ctrl();
        
        return instancia;
    }
    
    private void cad_User(Usuario user, Connection con) throws Exception{
        String sql = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NULL)";
        
        try{            
            ps = con.prepareStatement(sql);

            ps.setString(1, user.getCpf());
            ps.setString(2, user.getNome());
            ps.setDate(3, Date.valueOf(user.getData_natalidade()));
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getSenha());
            ps.setString(6, user.getNumero_Telefone());
            ps.setBoolean(7, user.isAdmin());
            ps.setInt(8, user.getEndereco().getNumero());
            ps.setString(9, user.getEndereco().getRua());
            ps.setString(10, user.getEndereco().getCep());
            
            ps.executeUpdate();
        }
        finally{
            ps.close();            
        }        
    }
    
    public void cad_User(Usuario user, Endereco ender) throws Exception{
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            con.setAutoCommit(false);
            
            Endereco_Ctrl.getInstancia().cad_Endereco(ender, con);
            cad_User(user, con);
            
            con.commit();
        }catch(Exception e){
            if(con!=null) con.rollback();
            throw e;
        }finally{
            if(con!=null) con.close();
        }
    }
    
    public List<Usuario> ler_User() throws Exception{        
        String sql = "SELECT * FROM usuario NATURAL JOIN plano";
        Endereco intermediarioE = new Endereco();
        Plano intermediarioP = new Plano();
        List<Usuario> retorno = new LinkedList<>();
        
        try(
            Connection con = Banco_Ctrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){
            while(rs.next()){
                intermediarioE.setNumero(rs.getInt("end_numero"));
                intermediarioE.setCep(rs.getString("end_cep"));
                intermediarioE.setRua(rs.getString("end_rua"));
                
                intermediarioP = Plano_Ctrl.getInstancia().ler_Plano(rs.getInt("pla_id"));
                
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
    
    public Usuario ler_User(String email) throws Exception{
        String sql = "SELECT * FROM usuario WHERE usu_login = ?";
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
            while(rs.next()){
                if(rs.getString("usu_login").equals(email)) 
                    return new Usuario(
                            rs.getString("usu_login"),
                            rs.getString("usu_senha"),
                            rs.getString("usu_numero_telefone"),
                            rs.getBoolean("usu_admin"),
                            new Endereco(rs.getInt("end_numero"), rs.getString("end_rua"), rs.getString("end_cep")),
                            Plano_Ctrl.getInstancia().ler_Plano(rs.getInt("pla_id")),
                            rs.getString("usu_cpf"),
                            rs.getString("usu_nome"),
                            rs.getDate("usu_data_natalidade").toLocalDate()
                    );
            }
            return null;
        }
        finally{
            rs.close();
            ps.close();
            con.close();
        }
    }
    
    public int alt_User(Usuario user) throws Exception{
        int retorno = 0;
        String sql_updt_us = "UPDATE usuario SET usu_nome = " + user.getNome()
                           + " usu_data_natalidade = " + Date.valueOf(user.getData_natalidade())
                            + " usu_login = " + user.getEmail()
                            + " usu_senha = " + user.getSenha()
                            + " usu_numero_telefone = " + user.getNumero_Telefone()
                            + " usu_admin = " + (user.isAdmin() ? "TRUE" : "FALSE")
                            + " pla_id = " + (user.getPlano()==null ? null : user.getPlano().getId())
                            + " WHERE usu_cpf = " + user.getCpf(),
                sql_updt_end = "UPDATE endereco SET end_numero = " + user.getEndereco().getNumero()
                             + ", end_rua = " + user.getEndereco().getRua()
                             + ", end_cep = " + user.getEndereco().getCep()
                             + " WHERE (end_numero, end_rua, end_cep) IN "
                             + "(SELECT end_numero, end_rua, end_cep FROM usuario"
                             + " WHERE usu_cpf = " + user.getCpf() + ")";
        
        try(
            Connection con = Banco_Ctrl.getInstancia().getConexao();
            Statement st = con.createStatement();
        ){
            con.setAutoCommit(false);
            
            retorno += st.executeUpdate(sql_updt_end);
            retorno += st.executeUpdate(sql_updt_us);
            
            con.commit();
        } catch(Exception e){
            con.rollback();
        } finally{
            return retorno;
        }
    }

    public int del_User(Usuario user) throws Exception{
        int retorno = 0;
        String cpf = user.getCpf(),
               sql_del_us = "DELETE FROM usuario WHERE usu_cpf = " + user.getCpf(),
               sql_del_end = "DELETE FROM endereco WHERE end_numero = " +
                user.getEndereco().getNumero() + " AND end_rua = " + user.getEndereco().getRua()
                + " AND end_cep = " + user.getEndereco().getCep();
        
        try(Connection con = Banco_Ctrl.getInstancia().getConexao();
            Statement st = con.createStatement()){
            con.setAutoCommit(false);
            
            retorno += st.executeUpdate(sql_del_us);
            retorno += st.executeUpdate(sql_del_end);
            
            con.commit();
        } catch(Exception e){
            con.rollback();
        } finally{
            return retorno;
        }
    }
    
    public int adquirir_plano(Usuario user, Plano plano) throws Exception{
        String sql = "UPDATE usuario SET pla_id = ? WHERE usu_cpf = ?";
        
        try(
            Connection con = Banco_Ctrl.getInstancia().getConexao();
            PreparedStatement ps = con.prepareStatement(sql)
        ){
            ps.setInt(1, plano.getId());
            ps.setString(2, user.getCpf());
            
            return ps.executeUpdate();
        }       
    }
}
