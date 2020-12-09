package hospital.management.system.utils;

import hospital.management.system.persistencia.*;
import hospital.management.system.persistencia.mysql.*;

public class DAOFactory {
    public static ConsultorioDAO createConsultorioDAO() {
        return new ConsultorioDAOMySQL();
    }
    public static FuncionarioHospitalDAO createFuncionarioHospitalDAO() {
        return new FuncionarioHospitalDAOMySQL();
    }
    public static EnfermeiroDAO createEnfermeiroDAO() {
        return new EnfermeiroDAOMySQL();
    }
    public static MedicoDAO createMedicoDAO() {
        return new MedicoDAOMySQL();
    }
    public static PacienteDAO createPacienteDAO() {
        return new PacienteDAOMySQL();
    }
    public static LeitoDAO createLeitoDAO() {
        return new LeitoDAOMySQL();
    }
    public static ConsultaDAO createConsultaDAO() {
        return new ConsultaDAOMySQL();
    }
    public static InternacaoDAO createInternacaoDAO() {
        return new InternacaoDAOMySQL();
    }
    public static ObservacaoDAO createObservacaoDAO() {
        return new ObservacaoDAOMySQL();
    }
    public static AmbulatorioDAO createAmbulatorioDAO() {
        return new AmbulatorioDAOMySQL();
    }
}
