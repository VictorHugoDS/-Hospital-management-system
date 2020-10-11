package hospital.management.system.entidades;

public class Leito {
    private int numero;
<<<<<<< HEAD
    private String tipo;
    private Enfermeiro enfermeiro;
=======
    private Enfermeiro enfermeiro;
    private Paciente paciente;
>>>>>>> 581f525e8033f6ec0893d8ee15e715a12ab530e8

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }
}
