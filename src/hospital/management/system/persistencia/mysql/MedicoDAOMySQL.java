package hospital.management.system.persistencia.mysql;

import hospital.management.system.entidades.Medico;
import hospital.management.system.persistencia.MedicoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicoDAOMySQL implements MedicoDAO {
    
    private Connection conexao;
    
    private void abrirConexao() {
        try {
            String className = "com.mysql.cj.jdbc.Driver";
            Class.forName(className);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Medico medico) {
        try {
            abrirConexao();
            
            String sql = "INSERT INTO medico (nome, cpf, telefone, funcao, horario, salario, crm, especialidade, horarioPlantao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, medico.getNome());
            pstm.setString(2, medico.getCpf());
            pstm.setString(3, medico.getTelefone());
            pstm.setString(4, medico.getFuncao());
            pstm.setString(5, medico.getHorario());
            pstm.setDouble(6, medico.getSalario());
            pstm.setInt(7, medico.getCrm());
            pstm.setString(8, medico.getEspecialidade());
            pstm.setString(9, medico.getHorarioPlantao());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Medico medico) {
        try {
            abrirConexao();
            
            String sql = "UPDATE medicoSET nome = ?, cpf = ?, telefone = ?, funcao = ?, horario = ?, salario = ?, crm = ?, especialidade = ?, horarioPlantao = ? WHERE  id = ?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, medico.getNome());
            pstm.setString(2, medico.getCpf());
            pstm.setString(3, medico.getTelefone());
            pstm.setString(4, medico.getFuncao());
            pstm.setString(5, medico.getHorario());
            pstm.setDouble(6, medico.getSalario());
            pstm.setInt(7, medico.getCrm());
            pstm.setString(8, medico.getEspecialidade());
            pstm.setString(9, medico.getHorarioPlantao());
            pstm.setInt(10, medico.getId());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean remover(int id) {
        try {
            abrirConexao();
            
            String sql = "DELETE FROM medico WHERE id = " + id;
            
            conexao.createStatement().executeUpdate(sql);
            
            fecharConexao();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Medico getById(int id) {
        Medico medico = null;
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM medico WHERE id = " + id;
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                medico = new Medico();
                medico.setId(id);
                medico.setNome(rs.getString("nome"));
                medico.setCpf(rs.getString("cpf"));
                medico.setTelefone(rs.getString("telefone"));
                medico.setFuncao(rs.getString("funcao"));
                medico.setHorario(rs.getString("horario"));
                medico.setSalario(rs.getDouble("salario"));
                medico.setCrm(rs.getInt("crm"));
                medico.setEspecialidade(rs.getString("especialidade"));
                medico.setHorarioPlantao(rs.getString("horarioPlantao"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medico;
    }

    @Override
    public List<Medico> listar() {
        List<Medico> lista = new ArrayList<Medico>();
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM medico";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getInt("id"));
                medico.setNome(rs.getString("nome"));
                medico.setCpf(rs.getString("cpf"));
                medico.setTelefone(rs.getString("telefone"));
                medico.setFuncao(rs.getString("funcao"));
                medico.setHorario(rs.getString("horario"));
                medico.setSalario(rs.getDouble("salario"));
                medico.setCrm(rs.getInt("crm"));
                medico.setEspecialidade(rs.getString("especialidade"));
                medico.setHorarioPlantao(rs.getString("horarioPlantao"));
                lista.add(medico);
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}