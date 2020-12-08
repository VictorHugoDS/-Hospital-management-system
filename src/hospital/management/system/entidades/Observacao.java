
package hospital.management.system.entidades;

public class Observacao extends Base{
    String medicacao;
    String data_de_entrada;
    String data_de_saida;
    String horario_de_entrada;
    String horario_de_saida;
    int id_ambulatorio;
    int id_paciente;

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

    public int getId_ambulatorio() {
        return id_ambulatorio;
    }

    public void setId_ambulatorio(int id_ambulatorio) {
        this.id_ambulatorio = id_ambulatorio;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
    
    
}
