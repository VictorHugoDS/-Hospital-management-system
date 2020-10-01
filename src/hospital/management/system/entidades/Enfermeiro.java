package hospital.management.system.entidades;

public class Enfermeiro extends FuncionarioHospital{
    private int registro;
    private String horario_plantao;

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String getHorario_plantao() {
        return horario_plantao;
    }

    public void setHorario_plantao(String horario_plantao) {
        this.horario_plantao = horario_plantao;
    }
}
