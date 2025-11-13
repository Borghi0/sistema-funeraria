package Control;

import Model.Usuario;
import Model.Endereco;
import java.sql.*;

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
    
    public void cad_User(Usuario user) throws Exception{
        String sql = "INSERT INTO usuario VALUES("
                + "'" + user.getCpf() + "',"
                + "'" + user.getNome() + "',"
                + "NULL" + ","  // data de natalidade
                + "'" + user.getEmail() + "',"
                + "'" + user.getSenha() + "',"
                + "'" + user.getNumero_Telefone() + "',"
                + user.isAdmin() + ","
                + "NULL" + ","  // id do endereco
                + "NULL"       // id do plano
                + ");";
        
        con = Banco_Ctrl.getInstancia().getConexao();
        st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
    }
    
    public Usuario[] ler_User() throws Exception{
        int num_lin = 0;
        String sql = "SELECT * FROM usuario";
        Usuario[] us = null;
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.last();
            num_lin = rs.getRow();
            rs.beforeFirst();
            us = new Usuario[num_lin];
            
            for(int i = 0; i < num_lin; i++){
                rs.next();
                us[i] = new Usuario(
                                rs.getString("usu_login"),
                                rs.getString("usu_senha"),
                                rs.getString("usu_numero_telefone"),
                                rs.getBoolean("usu_admin"),
                                new Endereco(rs.getInt("end_numero"), rs.getString("end_rua"), rs.getString("end_cep")),
                                null, // usar metodo de busca de plano por id
                                rs.getString("usu_nome"),
                                rs.getString("usu_cpf"),
                                rs.getDate("usu_data_natalidade").toLocalDate()
                            );
            }
            
            return us;
        } finally{
            rs.close();
            ps.close();
            con.close();
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
                            null, // usar metodo de busca de plano por id
                            rs.getString("usu_nome"),
                            rs.getString("usu_cpf"),
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
    
    public void alt_User(Usuario user) throws Exception{
        String cpf = user.getCpf(),
               sql = "UPDATE usuario SET usu_nome = ?,"
                     + "usu_data_natalidade = ?,"
                     + "usu_login = ?,"
                     + "usu_senha = ?,"
                     + "usu_numero_telefone = ?,"
                     + "usu_admin = ?,"
                     + "end_numero = ?,"
                     + "end_rua = ?,"
                     + "end_cep = ?,"
                     + "pla_id = ?,"
                     + "WHERE usu_cpf = ?";
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            ps = con.prepareStatement(sql);

            ps.setString(1, user.getNome());
            ps.setDate(2, Date.valueOf(user.getData_natalidade()));
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getSenha());
            ps.setString(5, user.getNumero_Telefone());
            ps.setBoolean(6, user.isAdmin());
            ps.setInt(7, user.getEndereco().getNumero());
            ps.setString(8, user.getEndereco().getRua());
            ps.setString(9, user.getEndereco().getCep());
            ps.setString(10, cpf);
            
            ps.executeUpdate();
        }
        finally{
            ps.close();
            con.close();
        }
    }

    public boolean del_User(Usuario user) throws Exception{
        String cpf = user.getCpf(),
               sql_del = "DELETE FROM user WHERE usu_cpf = ?",
               sql_busca = "SELECT usu_nome, usu_cpf FROM usuario WHERE ?";
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
            ps = con.prepareStatement(sql_busca);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            
            if(!rs.next()) return false;
            else{
                ps = con.prepareStatement(sql_del);
                ps.setString(1, cpf);
                ps.executeUpdate();
                
                return true;
            }
        } finally{
            ps.close();
            con.close();
        }
    }
}
