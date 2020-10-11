package hospital.management.system.entidades;

public class Leito {
    private int numero;
    private String tipo;
    private Enfermeiro enfermeiro;

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }
}
