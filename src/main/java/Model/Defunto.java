package Model;

import java.time.LocalDate;


public class Defunto extends Pessoa{
    private LocalDate dataObito;
    private String tipoObito;
    private String cemiterio;
    private int id;

    public Defunto() {
        super();
        this.dataObito = null;
        this.tipoObito = "";
        this.cemiterio = "";
        this.id = 0;
    }
    public Defunto(LocalDate data_Obito, String tipo_Obito, String cemiterio, String nome, LocalDate data_natalidade, int id) {
        super(nome, data_natalidade);
        this.dataObito = data_Obito;
        this.tipoObito = tipo_Obito;
        this.cemiterio = cemiterio;
        this.id = id;
    }

    public LocalDate getDataObito() {
        return dataObito;
    }

    public String getTipoObito() {
        return tipoObito;
    }

    public String getCemiterio() {
        return cemiterio;
    }
    
    public int getId(){
        return id;
    }

    public void setDataObito(LocalDate data_Obito) {
        this.dataObito = data_Obito;
    }

    public void setTipoObito(String tipo_Obito) {
        this.tipoObito = tipo_Obito;
    }

    public void setCemiterio(String cemiterio) {
        this.cemiterio = cemiterio;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
}
