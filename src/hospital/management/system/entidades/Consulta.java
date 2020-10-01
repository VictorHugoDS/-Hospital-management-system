package hospital.management.system.entidades;

public class Consulta {
    private String relatorio;
    private String tratamento;
    private Medico medico;
    private Paciente paciente;

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

}
