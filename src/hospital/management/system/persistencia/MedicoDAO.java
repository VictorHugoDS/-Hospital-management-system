package hospital.management.system.persistencia;

import hospital.management.system.entidades.Medico;
import java.util.List;

public interface MedicoDAO {
    public void inserir(Medico medico);

    public void editar(Medico medico);

    public boolean remover(int id);

    public Medico getById(int id);

    public List<Medico> listar();
}