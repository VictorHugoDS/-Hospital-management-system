
package hospital.management.system.persistencia.postgresql;

import hospital.management.system.entidades.Consulta;
import hospital.management.system.persistencia.ConsultaDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultaDAOPostgreSQL implements ConsultaDAO {
    
     private Connection conexao;
    
    private void abrirConexao() {
        try {
            conexao = DriverManager.getConnection("jdbc:postgresql://", "postgre", "");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Consulta consulta) {
        try {
            abrirConexao();
            
            String sql = "INSERT INTO consulta (relatorio_do_paciente, tratamento, periodo_de_exames, id_medico, id_paciente, id_consultorio) VALUES ('?', '?', '?', ?, ?, ?);";
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, consulta.getRelatorio_do_paciente());
            pstm.setString(2, consulta.getTratamento());
            pstm.setString(3, consulta.getPeriodo_de_exames());
            pstm.setInt(4, consulta.getId_medico());
            pstm.setInt(5, consulta.getId_paciente());
            pstm.setInt(6, consulta.getId_consultorio());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Consulta consulta) {
        try {
            abrirConexao();
            
            String sql = "UPDATE consulta SET relatorio_do_paciente = ?, tratamento = ?, periodo_de_exames = ?, id_medico = ?, id_paciente = ?, id_consultorio = ? WHERE  id = ?;";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, consulta.getRelatorio_do_paciente());
            pstm.setString(2, consulta.getTratamento());
            pstm.setString(3, consulta.getPeriodo_de_exames());
            pstm.setInt(4, consulta.getId_medico());
            pstm.setInt(5, consulta.getId_paciente());
            pstm.setInt(6, consulta.getId_consultorio());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean remover(int id) {
        try {
            abrirConexao();
            
            String sql = "DELETE FROM consulta WHERE id = " + id + ";";
            
            conexao.createStatement().executeUpdate(sql);
            
            fecharConexao();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Consulta getById(int id) {
        Consulta consulta = null;
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM consulta WHERE id = " + id + ";";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                consulta = new Consulta();
                consulta.setId(id);
                consulta.setRelatorio_do_paciente(rs.getString("relatorio_do_paciente"));
                consulta.setPeriodo_de_exames(rs.getString("periodo_de_exames"));
                consulta.setTratamento(rs.getString("tratamento"));
                consulta.setId_consultorio(rs.getInt("id_consultorio"));
                consulta.setId_medico(rs.getInt("id_medico"));
                consulta.setId_paciente(rs.getInt("id_paciente"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consulta;
    }

    @Override
    public List<Consulta> listar() {
        List<Consulta> lista = new ArrayList<Consulta>();
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM consulta;";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setRelatorio_do_paciente(rs.getString("relatorio_do_paciente"));
                consulta.setPeriodo_de_exames(rs.getString("periodo_de_exames"));
                consulta.setTratamento(rs.getString("tratamento"));
                consulta.setId_consultorio(rs.getInt("id_consultorio"));
                consulta.setId_medico(rs.getInt("id_medico"));
                consulta.setId_paciente(rs.getInt("id_paciente"));
                lista.add(consulta);
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
