package hospital.management.system.entidades;

public class Consulta {
    private String relatorio_do_paciente;
    private String tratamento;
    private String periodo_de_exames;
    private Medico medico;
    private Paciente paciente;
    private Consultorio Consultorio;


    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

}
