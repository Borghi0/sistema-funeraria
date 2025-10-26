package Model;

import java.util.Date;


public abstract class Pessoa {
    private String nome;
    private Date data_natalidade;

    public Pessoa(){
        this.nome = "";        
        this.data_natalidade = null;
    }
    
    public Pessoa(String nome, String cpf, Date data_natalidade) {
        this.nome = nome;        
        this.data_natalidade = data_natalidade;
    }
    
    
    public String getNome() {
        return nome;
    }

    public Date getData_natalidade() {
        return data_natalidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    

    public void setData_natalidade(Date data_natalidade) {
        this.data_natalidade = data_natalidade;
    }
    
}