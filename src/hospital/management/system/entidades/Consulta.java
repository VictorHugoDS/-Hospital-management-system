package hospital.management.system.entidades;

import java.io.Serializable;


public class Consulta extends Base implements Serializable {

    public Consulta() {
    }
    private String relatorio_do_paciente;
    private String tratamento;
    private String periodo_de_exames;
    private int id_medico;
    private int id_paciente;
    private int id_consultorio;

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

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_consultorio() {
        return id_consultorio;
    }

    public void setId_consultorio(int id_consultorio) {
        this.id_consultorio = id_consultorio;
    }
    
    
}
