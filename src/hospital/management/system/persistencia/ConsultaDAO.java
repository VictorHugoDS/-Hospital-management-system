
package hospital.management.system.persistencia;

import hospital.management.system.entidades.Consulta;
import java.util.List;

public interface ConsultaDAO {
    public void inserir(Consulta consulta);
    
    public void editar(Consulta curso);
    
    public boolean remover(int id);
    
    public Consulta getById(int id);
    
    public List<Consulta> listar();
    
}
