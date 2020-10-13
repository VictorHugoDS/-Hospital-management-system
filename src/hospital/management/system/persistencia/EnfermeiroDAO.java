package hospital.management.system.persistencia;

import hospital.management.system.entidades.Enfermeiro;
import java.util.List;

public interface EnfermeiroDAO {
    public void inserir(Enfermeiro enfermeiro);

    public void editar(Enfermeiro enfermeiro);

    public boolean remover(int id);

    public Enfermeiro getById(int id);

    public List<Enfermeiro> listar();
}