package Model;

import java.util.Date;

public class Usuario extends Pessoa{
    private String login;
    private String senha;
    private String numero_Telefone;
    private boolean admin;
    private Endereco endereco;
    private Plano plano;

    
    public Usuario() {
        super();
        this.login = "";
        this.senha = "";
        this.numero_Telefone = "";
        this.admin = false;
        this.endereco = null;
        this.plano = null;
    }
    
    public Usuario(String login, String senha, String numero_Telefone, boolean admin, Endereco endereco, Plano plano, String nome, String cpf, Date data_natalidade) {
        super(nome, cpf, data_natalidade);
        this.login = login;
        this.senha = senha;
        this.numero_Telefone = numero_Telefone;
        this.admin = admin;
        this.endereco = endereco;
        this.plano = plano;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getNumero_Telefone() {
        return numero_Telefone;
    }

    public boolean isAdmin() {
        return admin;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNumero_Telefone(String numero_Telefone) {
        this.numero_Telefone = numero_Telefone;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
    
    
}
