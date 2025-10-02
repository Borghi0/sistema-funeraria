package Model;


public class Sala {
    private boolean disponibilidade;
    private int capacidade;
    private int numero;

    public Sala() {
        this.disponibilidade = false;
        this.capacidade = 0;
        this.numero = 0;
    }
    public Sala(boolean disponibilidade, int capacidade, int numero) {
        this.disponibilidade = disponibilidade;
        this.capacidade = capacidade;
        this.numero = numero;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
