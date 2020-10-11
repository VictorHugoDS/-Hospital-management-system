package hospital.management.system.entidades;

<<<<<<< HEAD
public class Consulta extends Base {
    private String relatorio_do_paciente;
    private String tratamento;
    private String periodo_de_exames;
    private Medico medico;
    private Paciente paciente;
    private Consultorio consultorio;
=======
public class Consulta {
    private String relatorio;
    private String tratamento;
    private Medico medico;
    private Paciente paciente;
>>>>>>> 581f525e8033f6ec0893d8ee15e715a12ab530e8


    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

}
