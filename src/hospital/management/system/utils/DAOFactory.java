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
}
