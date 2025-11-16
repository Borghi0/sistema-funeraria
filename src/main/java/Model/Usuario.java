package Model;

import java.time.LocalDate;


public class Usuario extends Pessoa{
    private String email;
    private String senha;
    private String numero_Telefone;
    private boolean admin;
    private Endereco endereco;
    private Plano plano;
    private String cpf;

    
    public Usuario() {
        super();
        this.email = "";
        this.senha = "";
        this.numero_Telefone = "";
        this.admin = false;
        this.endereco = null;
        this.plano = null;
        this.cpf = "";
    }
    
    public Usuario(String email, String senha, String numero_Telefone, boolean admin, Endereco endereco, Plano plano, String cpf, String nome, LocalDate data_natalidade) {
        super(nome, data_natalidade);
        this.email = email;
        this.senha = senha;
        this.numero_Telefone = numero_Telefone;
        this.admin = admin;
        this.endereco = endereco;
        this.plano = plano;
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
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
    
    public String getCpf() {
        return cpf;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }    
    
}
