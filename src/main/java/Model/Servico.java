package Model;

import java.time.LocalDate;


public class Servico extends Ofertavel{
    private String nome;
    private LocalDate prestacao;
    private String tipo;
    
    public Servico(){
        super();        
        this.prestacao = null;
        this.tipo = "";
    }
    public Servico(String nome, LocalDate prestacao, String tipo, int preco, boolean ativo) {
        super(preco, ativo);
        this.nome = nome;
        this.prestacao = prestacao;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getPrestacao() {
        return prestacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrestacao(LocalDate prestacao) {
        this.prestacao = prestacao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
}
