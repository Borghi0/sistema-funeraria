package Model;

import java.util.ArrayList;


public class Plano extends Ofertavel{
    private ArrayList<Servico> listaServicos;
    private ArrayList<Produto> listaProdutos;

    public Plano(){
        super();
        this.listaServicos = null;
        this.listaProdutos = null;
    }
    public Plano(ArrayList<Servico> lista_Servico, ArrayList<Produto> lista_Produto, double preco, String nome, int id) {
        super(preco, nome, id);
        this.listaServicos = lista_Servico;
        this.listaProdutos = lista_Produto;
    }


    public ArrayList<Servico> getListaServicos() {
        return listaServicos;
    }

    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaServicos(ArrayList<Servico> lista_Servico) {
        this.listaServicos = lista_Servico;
    }

    public void setListaProdutos(ArrayList<Produto> lista_Produto) {
        this.listaProdutos = lista_Produto;
    }    
}
