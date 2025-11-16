package Model;

import java.time.LocalDate;


public class Defunto extends Pessoa{
    private LocalDate data_Obito;
    private String tipo_Obito;
    private String cemiterio;
    private String id;

    public Defunto() {
        super();
        this.data_Obito = null;
        this.tipo_Obito = "";
        this.cemiterio = "";
        this.id = "";
    }
    public Defunto(LocalDate data_Obito, String tipo_Obito, String cemiterio, String id, String nome, String cpf, LocalDate data_natalidade) {
        super(nome, cpf, data_natalidade);
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
    
    public String getId(){
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
    
    public void setId(String id) {
        this.id = id;
    }
    
}
