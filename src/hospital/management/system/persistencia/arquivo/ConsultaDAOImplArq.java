
package hospital.management.system.persistencia.arquivo;

import hospital.management.system.entidades.Consulta;
import hospital.management.system.persistencia.ConsultaDAO;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

public class ConsultaDAOImplArq implements ConsultaDAO {
    
    private final String filename = "consulta.dat";
    private List<Consulta> consultas = new ArrayList<Consulta>();

    @Override
    public void inserir(Consulta consulta) {
        boolean existe=false;
        for(Consulta c:consultas){
            if (c.getId()==consulta.getId()){
                existe=true;
            }
            
        }
        if(!existe){
            System.out.println("Cadastrado com sucesso!");
        } else {
            System.out.println("Consulta já cadastrada!");
        }
        
    }

    @Override
    public void editar(Consulta curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consulta getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consulta> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
