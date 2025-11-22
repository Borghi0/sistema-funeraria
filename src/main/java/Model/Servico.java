package Model;

import java.time.LocalDate;


public class Servico extends Ofertavel{
    private LocalDate prestacao;
    private String tipo;
    
    public Servico(){
        super();
        this.prestacao = null;
        this.tipo = "";
    }
    public Servico(LocalDate prestacao, String tipo, double preco, String nome, int id) {
        super(preco, nome, id);
        this.prestacao = prestacao;
        this.tipo = tipo;
    }

    public LocalDate getPrestacao() {
        return prestacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setPrestacao(LocalDate prestacao) {
        this.prestacao = prestacao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o){        
        if(!(o instanceof Servico)) return false;        
        if(this == o) return true;
        
        Servico servico = (Servico) o;
        return this.getId() == servico.getId();
    }
    
}
