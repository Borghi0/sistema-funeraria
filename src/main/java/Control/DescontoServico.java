package Control;

public class DescontoServico implements DescontoGeral{

    @Override
    public double calcDesconto(double preco) {
        return preco * 0.85;
    }
}
