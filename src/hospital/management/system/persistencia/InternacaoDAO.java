
package hospital.management.system.persistencia;

import hospital.management.system.entidades.Internacao;
import java.util.List;

public interface InternacaoDAO {
    public void inserir(Internacao internacao);
    
    public void editar(Internacao internacao);
    
    public boolean remover(int id);
    
    public Internacao getById(int id);
    
    public List<Internacao> listar();
}
