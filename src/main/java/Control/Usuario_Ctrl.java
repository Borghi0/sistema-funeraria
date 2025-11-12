package Control;

import Model.Usuario;
import Model.Endereco;
import java.sql.*;


public class Usuario_Ctrl {
    private static Usuario_Ctrl instancia;
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    private Usuario_Ctrl(){
        con = null;
        ps = null;
        rs = null;
    }
    
    public static Usuario_Ctrl getInstancia(){
        if(instancia == null) instancia = new Usuario_Ctrl();
        
        return instancia;
    }
    
    public void cad_User(Usuario user) throws Exception{
        String sql = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NULL)";
        
        try{
            con = Banco_Ctrl.getInstancia().getConexao();
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
            con.close();
        }
    }
    
    public void ler_User(Usuario user){
        //Ainda não implementado
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
    
    public void alt_User(Usuario user){
        //Ainda não implementado
    }
    
    public void del_User(Usuario user){
        //Ainda não implementado
    }
}
