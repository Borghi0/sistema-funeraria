package Model;

import java.util.ArrayList;


public class Plano extends Ofertavel{
    private ArrayList<Servico> lista_Servico;
    private ArrayList<Produto> lista_Produto;

    public Plano(){
        super();
        this.lista_Servico = null;
        this.lista_Produto = null;
    }
    public Plano(ArrayList<Servico> lista_Servico, ArrayList<Produto> lista_Produto, int preco, boolean ativo) {
        super(preco, ativo);
        this.lista_Servico = lista_Servico;
        this.lista_Produto = lista_Produto;
    }


    public ArrayList<Servico> getLista_Servico() {
        return lista_Servico;
    }

    public ArrayList<Produto> getLista_Produto() {
        return lista_Produto;
    }

    public void setLista_Servico(ArrayList<Servico> lista_Servico) {
        this.lista_Servico = lista_Servico;
    }

    public void setLista_Produto(ArrayList<Produto> lista_Produto) {
        this.lista_Produto = lista_Produto;
    }
    
    
}
