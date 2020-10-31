
package hospital.management.system.persistencia;

import hospital.management.system.entidades.Observacao;

import java.util.List;

public interface ObservacaoDAO {
    public void inserir(Observacao observacao);
    
    public void editar(Observacao observacao);
    
    public boolean remover(int id);
    
    public Observacao getById(int id);
    
    public List<Observacao> listar();
}
