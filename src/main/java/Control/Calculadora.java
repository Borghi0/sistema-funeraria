package Control;

import Interfaces.DescontoGeral;


public class Calculadora {
    private DescontoGeral descontoGeral;
    
    public Calculadora(DescontoGeral descontoGeral){
        this.descontoGeral = descontoGeral;
    }
    
    public double calcularValor(double valor){
        return valor - descontoGeral.calcDesconto(valor);
    }
}
