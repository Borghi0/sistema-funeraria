package Model;

import java.time.LocalDate;


public class Defunto extends Pessoa{
    private LocalDate data_Obito;
    private String tipo_Obito;
    private String cemiterio;
    private int id;

    public Defunto() {
        super();
        this.data_Obito = null;
        this.tipo_Obito = "";
        this.cemiterio = "";
        this.id = 0;
    }
    public Defunto(LocalDate data_Obito, String tipo_Obito, String cemiterio, String nome, LocalDate data_natalidade, int id) {
        super(nome, data_natalidade);
        this.data_Obito = data_Obito;
        this.tipo_Obito = tipo_Obito;
        this.cemiterio = cemiterio;
        this.id = id;
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
    
    public int getId(){
        return id;
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
    
    public void setId(int id) {
        this.id = id;
    }
    
}
