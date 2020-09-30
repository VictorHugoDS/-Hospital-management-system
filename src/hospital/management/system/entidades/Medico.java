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
public class Medico extends FuncionarioHospital{
    int crm;
    String especialidade;
    String horario_plantao;

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
