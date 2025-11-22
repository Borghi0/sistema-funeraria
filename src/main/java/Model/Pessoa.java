package Model;

import java.time.LocalDate;


public abstract class Pessoa {
    private String nome;
    private LocalDate dataNatalidade;

    public Pessoa(){
        this.nome = "";        
        this.dataNatalidade = null;
    }
    
    public Pessoa(String nome, LocalDate data_natalidade) {
        this.nome = nome;        
        this.dataNatalidade = data_natalidade;
    }
    
    
    public String getNome() {
        return nome;
    }

    public LocalDate getDataNatalidade() {
        return dataNatalidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    

    public void setDataNatalidade(LocalDate data_natalidade) {
        this.dataNatalidade = data_natalidade;
    }
    
}