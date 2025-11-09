package Model;


public class Sala {
    private int capacidade;
    private int numero;

    public Sala() {
        this.capacidade = 0;
        this.numero = 0;
    }
    public Sala(int capacidade, int numero) {
        this.capacidade = capacidade;
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getNumero() {
        return numero;
    }    

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
