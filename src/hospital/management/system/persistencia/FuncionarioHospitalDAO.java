package hospital.management.system.persistencia;

import hospital.management.system.entidades.FuncionarioHospital;
import java.util.List;

public interface FuncionarioHospitalDAO {
    public void inserir(FuncionarioHospital funcionarioHospital);

    public void editar(FuncionarioHospital funcionarioHospital);

    public boolean remover(int id);

    public FuncionarioHospital getById(int id);

    public List<FuncionarioHospital> listar();
}