package Model;

import java.util.Date;


public class Servico extends Ofertavel{
    private String nome;
    private Date prestacao;

    
    public Servico(){
        super();
        this.nome = null;
        this.prestacao = null;
    }

    public Servico(String nome, Date prestacao, int preco, String tipo) {
        super(preco, tipo);
        this.nome = nome;
        this.prestacao = prestacao;
    }

    public String getNome() {
        return nome;
    }

    public Date getPrestacao() {
        return prestacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrestacao(Date prestacao) {
        this.prestacao = prestacao;
    }
    
    
}
