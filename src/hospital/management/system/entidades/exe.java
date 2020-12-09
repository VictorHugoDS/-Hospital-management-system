/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system.entidades;

import hospital.management.system.persistencia.ConsultaDAO;
import hospital.management.system.persistencia.PacienteDAO;
import hospital.management.system.utils.DAOFactory;

public class exe {
     public static void main(String args[]) {
        ConsultaDAO consultadao = DAOFactory.createConsultaDAO();
        PacienteDAO pacientedao = DAOFactory.createPacienteDAO();
        
        /*Paciente p = new Paciente();
        p.setNome("MArcus");
        p.setId(0);
        pacientedao.inserir(p);*/
         System.out.println(consultadao.getById(1).getIdPaciente());
         System.out.println(pacientedao.getById(0).getNome());
     }
    
    
}
