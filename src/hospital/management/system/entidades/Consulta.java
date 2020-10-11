package hospital.management.system.entidades;

import java.io.Serializable;


public class Consulta extends Base implements Serializable {

    public Consulta() {
    }
    private String relatorio_do_paciente;
    private String tratamento;
    private String periodo_de_exames;
    private Medico medico;
    private Paciente paciente;
    private Consultorio consultorio;

    public String getRelatorio_do_paciente() {
        return relatorio_do_paciente;
    }

    public void setRelatorio_do_paciente(String relatorio_do_paciente) {
        this.relatorio_do_paciente = relatorio_do_paciente;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public String getPeriodo_de_exames() {
        return periodo_de_exames;
    }

    public void setPeriodo_de_exames(String periodo_de_exames) {
        this.periodo_de_exames = periodo_de_exames;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }
    
    
}
