package hospital.management.system.persistencia;

import hospital.management.system.entidades.Paciente;
import java.util.List;

public interface PacienteDAO {
    public void inserir(Paciente paciente);

    public void editar(Paciente paciente);

    public boolean remover(int id);

    public Paciente getById(int id);

    public List<Paciente> listar();
}
