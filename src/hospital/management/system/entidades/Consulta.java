package hospital.management.system.entidades;

public class Consulta extends Base {
    private String relatorioPaciente;
    private String tratamento;
    private String periodoDeExames;
    private int idConsultorio;
    private int idMedico;
    private int idPaciente;

    public String getRelatorioPaciente() {
        return relatorioPaciente;
    }

    public void setRelatorioPaciente(String relatorioPaciente) {
        this.relatorioPaciente = relatorioPaciente;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public String getPeriodoDeExames() {
        return periodoDeExames;
    }

    public void setPeriodoDeExames(String periodoDeExames) {
        this.periodoDeExames = periodoDeExames;
    }
}
