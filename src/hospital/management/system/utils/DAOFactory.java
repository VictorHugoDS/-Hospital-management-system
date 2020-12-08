package hospital.management.system.utils;

import hospital.management.system.persistencia.*;
import hospital.management.system.persistencia.postgresql.*;

public class DAOFactory {
    public static ConsultorioDAO createConsultorioDAO() {
        return new ConsultorioDAOPostgreSQL();
    }
    public static FuncionarioHospitalDAO createFuncionarioHospitalDAO() {
        return new FuncionarioHospitalDAOPostgreSQL();
    }
    public static EnfermeiroDAO createEnfermeiroDAO() {
        return new EnfermeiroDAOPostgreSQL();
    }
    public static MedicoDAO createMedicoDAO() {
        return new MedicoDAOPostgreSQL();
    }
    public static PacienteDAO createPacienteDAO() {
        return new PacienteDAOPostgreSQL();
    }
    public static LeitoDAO createLeitoDAO() {
        return new LeitoDAOPostgreSQL();
    }
    public static ConsultaDAO createConsultaDAO() {
        return new ConsultaDAOPostgreSQL();
    }
    public static InternacaoDAO createInternacaoDAO() {
        return new InternacaoDAOPostgreSQL();
    }
    public static ObservacaoDAO createObservacaoDAO() {
        return new ObservacaoDAOPostgreSQL();
    }
    public static AmbulatorioDAO createAmbulatorioDAO() {
        return new AmbulatorioDAOPostgreSQL();
    }
}
