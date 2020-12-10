package hospital.management.system.persistencia;

import hospital.management.system.entidades.Ambulatorio;
import java.util.List;

public interface AmbulatorioDAO {
    public void inserir(Ambulatorio ambulatorio);
    
    public void editar(Ambulatorio ambulatorio);
    
    public boolean remover(int id);
    
    public Ambulatorio getById(int id);
    
    public List<Ambulatorio> listar();
}
