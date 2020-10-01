package hospital.management.system.entidades;

public class Medico extends FuncionarioHospital{
    private int crm;
    private String especialidade;
    private String horario_plantao;

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

    public String getHorario_plantao() {
        return horario_plantao;
    }

    public void setHorario_plantao(String horario_plantao) {
        this.horario_plantao = horario_plantao;
    }
}
