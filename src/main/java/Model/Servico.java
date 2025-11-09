package Model;

import java.util.Date;


public class Servico extends Ofertavel{
    private String nome;
    private Date prestacao;
    private String tipo;
    
    public Servico(){
        super();        
        this.prestacao = null;
        this.tipo = "";
    }
    public Servico(String nome, Date prestacao, String tipo, int preco, boolean ativo) {
        super(preco, ativo);
        this.nome = nome;
        this.prestacao = prestacao;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public Date getPrestacao() {
        return prestacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrestacao(Date prestacao) {
        this.prestacao = prestacao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
}
