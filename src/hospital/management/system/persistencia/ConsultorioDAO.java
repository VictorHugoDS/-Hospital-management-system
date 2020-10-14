package hospital.management.system.persistencia;

import hospital.management.system.entidades.Consultorio;
import java.util.List;

public interface ConsultorioDAO {
    public void inserir(Consultorio consultorio);

    public void editar(Consultorio consultorio);

    public boolean remover(int id);

    public Consultorio getById(int id);

    public List<Consultorio> listar();
}