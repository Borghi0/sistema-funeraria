package Control;

import Interfaces.DescontoGeral;

public class DescontoServico implements DescontoGeral{
    @Override
    public double calcDesconto(double preco) {
        return preco * 0.10; // 10% de desconto
    }
}
