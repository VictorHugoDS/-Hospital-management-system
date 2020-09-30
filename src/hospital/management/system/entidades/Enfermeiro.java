/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system.entidades;

/**
 *
 * @author victor
 */
public class Enfermeiro extends FuncionarioHospital{
    int registro;
    String horario_plantao;

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String getHorario_plantao() {
        return horario_plantao;
    }

    public void setHorario_plantao(String horario_plantao) {
        this.horario_plantao = horario_plantao;
    }
}
