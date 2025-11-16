package Model;


public abstract class Ofertavel{    
    private int preco;    
    private String nome;
    private int id;

    public Ofertavel(){        
        this.preco = 0;
        this.nome = "";
        this.id = 0;
    }
    public Ofertavel(int preco, String nome, int id) {
        this.preco = preco;
        this.nome = nome;
        this.id = id;
    }

    public int getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
    
    public int getId() {
        return id;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    
}
