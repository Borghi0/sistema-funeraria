package Model;

import java.util.Date;


public class Defunto extends Pessoa{
    private Date data_Obito;
    private String tipo_Obito;
    private String cemiterio;

    public Defunto() {
        super();
        this.data_Obito = null;
        this.tipo_Obito = "";
        this.cemiterio = "";
    }
    public Defunto(Date data_Obito, String tipo_Obito, String cemiterio, String nome, String cpf, Date data_natalidade) {
        super(nome, cpf, data_natalidade);
        this.data_Obito = data_Obito;
        this.tipo_Obito = tipo_Obito;
        this.cemiterio = cemiterio;
    }

    public Date getData_Obito() {
        return data_Obito;
    }

    public String getTipo_Obito() {
        return tipo_Obito;
    }

    public String getCemiterio() {
        return cemiterio;
    }

    public void setData_Obito(Date data_Obito) {
        this.data_Obito = data_Obito;
    }

    public void setTipo_Obito(String tipo_Obito) {
        this.tipo_Obito = tipo_Obito;
    }

    public void setCemiterio(String cemiterio) {
        this.cemiterio = cemiterio;
    }
    
    
}
