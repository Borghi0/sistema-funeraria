package Model;

import java.time.LocalDateTime;


public class Velorio {
    private Sala sala;
    private LocalDateTime data;
    private Defunto defunto;

    public Velorio() {
        this.sala = null;
        this.data = null;
        this.defunto = null;
    }
    public Velorio(Sala sala, LocalDateTime data, Defunto defunto) {
        this.sala = sala;
        this.data = data;
        this.defunto = defunto;
    }

    public Sala getSala() {
        return sala;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Defunto getDefunto() {
        return defunto;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setDefunto(Defunto defunto) {
        this.defunto = defunto;
    }
    
    
}
