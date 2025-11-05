package Config;

import Interfaces.I_InicializadorBD;
import Control.Banco_Ctrl;
import java.sql.*;


public class MySQLInicializadorBD implements I_InicializadorBD{
    private static MySQLInicializadorBD instancia;
    
    private MySQLInicializadorBD(){}
    
    public static MySQLInicializadorBD getInstancia(){
        if(instancia==null) instancia = new MySQLInicializadorBD();
        return instancia;
    }

    @Override
    public void criarTabelas() throws Exception{
        Connection con = Banco_Ctrl.getInstancia().getConexao();
        Statement st = con.createStatement();
        
        criarTabelaEndereco(st);
        criarTabelaPlano(st);
        criarTabelaSala(st);
        criarTabelaDefunto(st);
        
        criarTabelaProduto(st);
        criarTabelaServico(st);
        criarTabelaUsuario(st);
        criarTabelaVelorio(st);        
        
        st.close();
        con.close();
    }

    private void criarTabelaEndereco(Statement st) throws Exception {
        String sql = "CREATE TABLE IF NOT EXISTS endereco("
                + "end_id INT AUTO_INCREMENT PRIMARY KEY,"
                + "end_rua VARCHAR(255),"
                + "end_bairro VARCHAR(100),"
                + "end_cep VARCHAR(20)"
                + ");";
        st.executeUpdate(sql);
    }       

    private void criarTabelaPlano(Statement st) throws Exception {
        String sql = "CREATE TABLE IF NOT EXISTS plano("
                + "pla_id INT AUTO_INCREMENT PRIMARY KEY,"
                + "pla_preco INT DEFAULT 0,"
                + "pla_tipo VARCHAR(100)"
                + ");";
        st.executeUpdate(sql);
    }
    
    private void criarTabelaServico(Statement st) throws Exception {
        String sql = "CREATE TABLE IF NOT EXISTS servico("
                + "ser_id INT AUTO_INCREMENT PRIMARY KEY,"
                + "ser_nome VARCHAR(255),"
                + "ser_prestacao DATE,"
                + "ser_preco INT DEFAULT 0,"
                + "ser_tipo VARCHAR(100),"
                + "pla_id INT NULL,"
                + "FOREIGN KEY (pla_id) REFERENCES plano(pla_id)"
                + ");";
        st.executeUpdate(sql);
    }
    
    private void criarTabelaProduto(Statement st) throws Exception {
        String sql = "CREATE TABLE IF NOT EXISTS produto("
                + "pro_id INT AUTO_INCREMENT PRIMARY KEY,"              
                + "pro_perecivel BOOLEAN DEFAULT false,"
                + "pro_quant_estoque INT DEFAULT 0,"
                + "pro_preco INT DEFAULT 0,"
                + "pro_tipo VARCHAR(100),"
                + "pla_id INT NULL,"
                + "FOREIGN KEY (pla_id) REFERENCES plano(pla_id)"
                + ");";
        st.executeUpdate(sql);
    }

    private void criarTabelaSala(Statement st) throws Exception {
        String sql = "CREATE TABLE IF NOT EXISTS sala("
                + "sal_id INT AUTO_INCREMENT PRIMARY KEY,"
                + "sal_disponibilidade BOOLEAN DEFAULT false,"
                + "sal_capacidade INT DEFAULT 0,"
                + "sal_numero INT"
                + ");";
        st.executeUpdate(sql);
    }

    private void criarTabelaDefunto(Statement st) throws Exception {
        String sql = "CREATE TABLE IF NOT EXISTS defunto("
                + "def_id INT AUTO_INCREMENT PRIMARY KEY,"
                + "def_nome VARCHAR(255),"
                + "def_data_natalidade DATE,"
                + "def_data_obito DATE,"
                + "def_tipo_obito VARCHAR(100),"
                + "def_cemiterio VARCHAR(255)"
                + ");";
        st.executeUpdate(sql);
    }

    private void criarTabelaUsuario(Statement st) throws Exception {
        String sql = "CREATE TABLE IF NOT EXISTS usuario("
                + "usu_cpf VARCHAR(50) PRIMARY KEY,"
                + "usu_nome VARCHAR(255),"
                + "usu_data_natalidade DATE,"
                + "usu_login VARCHAR(100) UNIQUE,"
                + "usu_senha VARCHAR(255),"
                + "usu_numero_telefone VARCHAR(50),"
                + "usu_admin BOOLEAN DEFAULT false,"
                + "end_id INT,"
                + "pla_id INT,"
                + "FOREIGN KEY (end_id) REFERENCES endereco(end_id),"
                + "FOREIGN KEY (pla_id) REFERENCES plano(pla_id)"
                + ");";
        st.executeUpdate(sql);
    }

    private void criarTabelaVelorio(Statement st) throws Exception {
        String sql = "CREATE TABLE IF NOT EXISTS velorio("
                + "vel_id INT AUTO_INCREMENT PRIMARY KEY,"
                + "sal_id INT NOT NULL,"
                + "vel_data_horario DATETIME NOT NULL,"
                + "def_id INT NOT NULL,"
                + "FOREIGN KEY (sal_id) REFERENCES sala(sal_id),"
                + "FOREIGN KEY (def_id) REFERENCES defunto(def_id)"
                + ");";
        st.executeUpdate(sql);
    }        
    
}
