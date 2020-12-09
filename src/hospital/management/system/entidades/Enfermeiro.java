package hospital.management.system.entidades;

public class Enfermeiro extends FuncionarioHospital{
    private int registro;
    private String horarioPlantao;
    private int idLeito;
    private int idAmbulatorio;

    public int getIdLeito() {
        return idLeito;
    }

    public void setIdLeito(int idLeito) {
        this.idLeito = idLeito;
    }

    public int getIdAmbulatorio() {
        return idAmbulatorio;
    }

    public void setIdAmbulatorio(int idAmbulatorio) {
        this.idAmbulatorio = idAmbulatorio;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String getHorarioPlantao() {
        return horarioPlantao;
    }

    public void setHorarioPlantao(String horarioPlantao) {
        this.horarioPlantao = horarioPlantao;
    }
}
