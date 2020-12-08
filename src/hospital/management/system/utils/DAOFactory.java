package hospital.management.system.utils;

import hospital.management.system.persistencia.*;
import hospital.management.system.persistencia.arquivo.*;
import hospital.management.system.persistencia.postgresql.ConsultorioDAOPostgreSQL;

public class DAOFactory {
    public static ConsultorioDAO createConsultorioDAO() {
        return new ConsultorioDAOPostgreSQL();
    }
    public static FuncionarioHospitalDAO createFuncionarioHospitalDAO() {
        return new FuncionarioHospitalDAOImplArq();
    }
    public static EnfermeiroDAO createEnfermeiroDAO() {
        return new EnfermeiroDAOImplArq();
    }
    public static MedicoDAO createMedicoDAO() {
        return new MedicoDAOImplArq();
    }
    public static PacienteDAO createPacienteDAO() {
        return new PacienteDAOImplArq();
    }
    public static LeitoDAO createLeitoDAO() {
        return new LeitoDAOImplArq();
    }
    public static ConsultaDAO createConsultaDAO() {
        return new ConsultaDAOImplArq();
    }
    public static InternacaoDAO createInternacaoDAO() {
        return new InternacaoDAOImplArq();
    }
    public static ObservacaoDAO createObservacaoDAO() {
        return new ObservacaoDAOImplArq();
    }
    public static AmbulatorioDAO createAmbulatorioDAO() {
        return new AmbulatorioDAOImplArq();
    }
}
