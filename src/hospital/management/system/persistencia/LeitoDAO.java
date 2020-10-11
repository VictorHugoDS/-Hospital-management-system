
package hospital.management.system.persistencia;

import hospital.management.system.entidades.Leito;
import java.util.List;

public interface LeitoDAO {
    public void inserir(Leito leito);
    
    public void editar(Leito leito);
    
    public boolean remover(int id);
    
    public Leito getById(int id);
    
    public List<Leito> listar();
}
