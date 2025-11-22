package Control;

import Interfaces.DescontoGeral;

public class DescontoProduto implements DescontoGeral{
    @Override
    public double calcDesconto(double preco){
        return preco * 0.05; // 5% de desconto
    }
}
