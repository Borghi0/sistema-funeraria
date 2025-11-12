package Model;

import java.time.LocalDate;


public class Defunto extends Pessoa{
    private LocalDate data_Obito;
    private String tipo_Obito;
    private String cemiterio;

    public Defunto() {
        super();
        this.data_Obito = null;
        this.tipo_Obito = "";
        this.cemiterio = "";
    }
    public Defunto(LocalDate data_Obito, String tipo_Obito, String cemiterio, String nome, String cpf, LocalDate data_natalidade) {
        super(nome, cpf, data_natalidade);
        this.data_Obito = data_Obito;
        this.tipo_Obito = tipo_Obito;
        this.cemiterio = cemiterio;
    }

    public LocalDate getData_Obito() {
        return data_Obito;
    }

    public String getTipo_Obito() {
        return tipo_Obito;
    }

    public String getCemiterio() {
        return cemiterio;
    }

    public void setData_Obito(LocalDate data_Obito) {
        this.data_Obito = data_Obito;
    }

    public void setTipo_Obito(String tipo_Obito) {
        this.tipo_Obito = tipo_Obito;
    }

    public void setCemiterio(String cemiterio) {
        this.cemiterio = cemiterio;
    }
    
    
}
