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
    public Plano(ArrayList<Servico> listaServico, ArrayList<Produto> listaProduto, double preco, String nome, int id) {
        super(preco, nome, id);
        this.listaServicos = listaServico;
        this.listaProdutos = listaProduto;
    }


    public ArrayList<Servico> getListaServicos() {
        return listaServicos;
    }

    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaServicos(ArrayList<Servico> listaServico) {
        this.listaServicos = listaServico;
    }

    public void setListaProdutos(ArrayList<Produto> listaProduto) {
        this.listaProdutos = listaProduto;
    }    
}
