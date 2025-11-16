package Model;

import java.time.LocalDate;


public abstract class Pessoa {
    private String nome;
    private LocalDate data_natalidade;

    public Pessoa(){
        this.nome = "";        
        this.data_natalidade = null;
    }
    
    public Pessoa(String nome, LocalDate data_natalidade) {
        this.nome = nome;        
        this.data_natalidade = data_natalidade;
    }
    
    
    public String getNome() {
        return nome;
    }

    public LocalDate getData_natalidade() {
        return data_natalidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    

    public void setData_natalidade(LocalDate data_natalidade) {
        this.data_natalidade = data_natalidade;
    }
    
}