
package hospital.management.system.entidades;

public class Observacao extends Base{
    private String medicacao;
    private String data_de_entrada;
    private String data_de_saida;
    private String horario_de_entrada;
    private String horario_de_saida;
    private Ambulatorio ambulatorio;
    private Paciente paciente;

    public String getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(String medicacao) {
        this.medicacao = medicacao;
    }

    public String getData_de_entrada() {
        return data_de_entrada;
    }

    public void setData_de_entrada(String data_de_entrada) {
        this.data_de_entrada = data_de_entrada;
    }

    public String getData_de_saida() {
        return data_de_saida;
    }

    public void setData_de_saida(String data_de_saida) {
        this.data_de_saida = data_de_saida;
    }

    public String getHorario_de_entrada() {
        return horario_de_entrada;
    }

    public void setHorario_de_entrada(String horario_de_entrada) {
        this.horario_de_entrada = horario_de_entrada;
    }

    public String getHorario_de_saida() {
        return horario_de_saida;
    }

    public void setHorario_de_saida(String horario_de_saida) {
        this.horario_de_saida = horario_de_saida;
    }
    
    
}
