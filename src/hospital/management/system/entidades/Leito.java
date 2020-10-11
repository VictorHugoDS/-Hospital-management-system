package hospital.management.system.entidades;

import java.io.Serializable;

public class Leito extends Base implements Serializable   {
    private int numero;
    private String tipo;
    private Enfermeiro enfermeiro;

    public Leito() {
    }
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }
}
