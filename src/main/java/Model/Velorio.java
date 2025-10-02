package Model;

import java.util.Date;


public class Velorio {
    private Sala sala;
    private Date data;
    private Defunto defunto;

    public Velorio() {
        this.sala = null;
        this.data = null;
        this.defunto = null;
    }
    public Velorio(Sala sala, Date data, Defunto defunto) {
        this.sala = sala;
        this.data = data;
        this.defunto = defunto;
    }

    public Sala getSala() {
        return sala;
    }

    public Date getData() {
        return data;
    }

    public Defunto getDefunto() {
        return defunto;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setDefunto(Defunto defunto) {
        this.defunto = defunto;
    }
    
    
}
