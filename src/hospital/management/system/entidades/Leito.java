package hospital.management.system.entidades;

public class Leito {
    private int numero;
    private Enfermeiro enfermeiro;
    private Paciente paciente;

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }
}
