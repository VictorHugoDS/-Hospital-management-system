
package hospital.management.system.persistencia.mysql;

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

public class ConsultaDAOMySQL implements ConsultaDAO {
    
     private Connection conexao;
    
    private void abrirConexao() {
        try {
            String className = "com.mysql.cj.jdbc.Driver";
            Class.forName(className);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConsultaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Consulta consulta) {
        try {
            abrirConexao();
            
            String sql = "INSERT INTO consulta (relatorioPaciente, tratamento, periodoDeExames, idMedico, idPaciente, idConsultorio) VALUES (?, ?, ?, ?, ?, ?);";
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, consulta.getRelatorioPaciente());
            pstm.setString(2, consulta.getTratamento());
            pstm.setString(3, consulta.getPeriodoDeExames());
            pstm.setInt(4, consulta.getIdMedico());
            pstm.setInt(5, consulta.getIdPaciente());
            pstm.setInt(6, consulta.getIdConsultorio());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Consulta consulta) {
        try {
            abrirConexao();
            
            String sql = "UPDATE consulta SET relatorioPaciente = ?, tratamento = ?, periodoDeExames = ?, idMedico = ?, idPaciente = ?, idConsultorio = ? WHERE  id = ?;";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, consulta.getRelatorioPaciente());
            pstm.setString(2, consulta.getTratamento());
            pstm.setString(3, consulta.getPeriodoDeExames());
            pstm.setInt(4, consulta.getIdMedico());
            pstm.setInt(5, consulta.getIdPaciente());
            pstm.setInt(6, consulta.getIdConsultorio());
            pstm.setInt(7, consulta.getId());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean remover(int id) {
        try {
            abrirConexao();
            
            String sql = "DELETE FROM consulta WHERE id = " + id;
            
            conexao.createStatement().executeUpdate(sql);
            
            fecharConexao();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Consulta getById(int id) {
        Consulta consulta = null;
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM consulta WHERE id = " + id;
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                consulta = new Consulta();
                consulta.setId(id);
                consulta.setRelatorioPaciente(rs.getString("relatorioPaciente"));
                consulta.setPeriodoDeExames(rs.getString("periodoDeExames"));
                consulta.setTratamento(rs.getString("tratamento"));
                consulta.setIdConsultorio(rs.getInt("idConsultorio"));
                consulta.setIdMedico(rs.getInt("idMedico"));
                consulta.setIdPaciente(rs.getInt("idPaciente"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consulta;
    }

    @Override
    public List<Consulta> listar() {
        List<Consulta> lista = new ArrayList<Consulta>();
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM consulta";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setId(rs.getInt("id"));
                consulta.setRelatorioPaciente(rs.getString("relatorioPaciente"));
                consulta.setPeriodoDeExames(rs.getString("periodoDeExames"));
                consulta.setTratamento(rs.getString("tratamento"));
                consulta.setIdConsultorio(rs.getInt("idConsultorio"));
                consulta.setIdMedico(rs.getInt("idMedico"));
                consulta.setIdPaciente(rs.getInt("idPaciente"));
                lista.add(consulta);
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
