package hospital.management.system.entidades;

public class Medico extends FuncionarioHospital{
    private int crm;
    private String especialidade;
    private String horarioPlantao;

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getHorarioPlantao() {
        return horarioPlantao;
    }

    public void setHorarioPlantao(String horarioPlantao) {
        this.horarioPlantao = horarioPlantao;
    }
}
