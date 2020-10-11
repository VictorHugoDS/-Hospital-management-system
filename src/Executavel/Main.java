package Executavel;

import hospital.management.system.entidades.Consulta;
import hospital.management.system.entidades.Internacao;
import hospital.management.system.entidades.Leito;
import hospital.management.system.persistencia.ConsultaDAO;
import hospital.management.system.persistencia.InternacaoDAO;
import hospital.management.system.persistencia.LeitoDAO;
import hospital.management.system.persistencia.arquivo.ConsultaDAOImplArq;
import hospital.management.system.persistencia.arquivo.InternacaoDAOImplArq;
import hospital.management.system.persistencia.arquivo.LeitoDAOImplArq;

public class Main {
   public static void main(String[] args) {
      Internacao inte =new Internacao();
      inte.setId(0);
      inte.setData_de_entrada("Chegou bem cedo!!!");
      InternacaoDAO banco_inte= new InternacaoDAOImplArq();
      banco_inte.inserir(inte);
      System.out.println(banco_inte.getById(0).getData_de_entrada());
   }
}
