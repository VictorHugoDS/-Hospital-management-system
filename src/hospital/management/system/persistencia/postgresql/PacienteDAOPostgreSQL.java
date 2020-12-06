package hospital.management.system.persistencia.postgresql;

import hospital.management.system.entidades.Paciente;
import hospital.management.system.persistencia.PacienteDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PacienteDAOPostgreSQL implements PacienteDAO {
    
    private Connection conexao;
    
    private void abrirConexao() {
        try {
            conexao = DriverManager.getConnection("jdbc:postgresql://", "postgre", "");
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Paciente paciente) {
        try {
            abrirConexao();
            
            String sql = "INSERT INTO paciente (nome, cpf, endereco, telefone, convenio) VALUES ('?', '?', '?', '?', '?');";
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, paciente.getNome());
            pstm.setString(2, paciente.getCpf());
            pstm.setString(2, paciente.getEndereco());
            pstm.setString(3, paciente.getTelefone());
            pstm.setString(4, paciente.getConvenio());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Paciente paciente) {
        try {
            abrirConexao();
            
            String sql = "UPDATE pacienteSET nome = ?, cpf = ?, endereco = ?, telefone = ?, convenio = ? WHERE  id = ?;";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, paciente.getNome());
            pstm.setString(2, paciente.getCpf());
            pstm.setString(2, paciente.getEndereco());
            pstm.setString(3, paciente.getTelefone());
            pstm.setString(4, paciente.getConvenio());
            pstm.setInt(5, paciente.getId());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean remover(int id) {
        try {
            abrirConexao();
            
            String sql = "DELETE FROM paciente WHERE id = " + id + ";";
            
            conexao.createStatement().executeUpdate(sql);
            
            fecharConexao();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Paciente getById(int id) {
        Paciente paciente = null;
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM paciente WHERE id = " + id + ";";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                paciente = new Paciente();
                paciente.setId(id);
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setConvenio(rs.getString("convenio"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paciente;
    }

    @Override
    public List<Paciente> listar() {
        List<Paciente> lista = new ArrayList<Paciente>();
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM paciente;";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setConvenio(rs.getString("convenio"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}