package hospital.management.system.persistencia.mysql;

import hospital.management.system.entidades.FuncionarioHospital;
import hospital.management.system.persistencia.FuncionarioHospitalDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioHospitalDAOMySQL implements FuncionarioHospitalDAO {
    
    private Connection conexao;
    
    private void abrirConexao() {
        try {
            String className = "com.mysql.cj.jdbc.Driver";
            Class.forName(className);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioHospitalDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioHospitalDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioHospitalDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(FuncionarioHospital funcionarioHospital) {
        try {
            abrirConexao();
            
            String sql = "INSERT INTO funcionarioHospital (nome, cpf, telefone, funcao, horario, salario) VALUES (?, ?, ?, ?, ?, ?);";
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, funcionarioHospital.getNome());
            pstm.setString(2, funcionarioHospital.getCpf());
            pstm.setString(3, funcionarioHospital.getTelefone());
            pstm.setString(4, funcionarioHospital.getFuncao());
            pstm.setString(5, funcionarioHospital.getHorario());
            pstm.setDouble(6, funcionarioHospital.getSalario());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioHospitalDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(FuncionarioHospital funcionarioHospital) {
        try {
            abrirConexao();
            
            String sql = "UPDATE funcionarioHospital SET nome = ?, cpf = ?, telefone = ?, funcao = ?, horario = ?, salario = ? WHERE  id = ?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, funcionarioHospital.getNome());
            pstm.setString(2, funcionarioHospital.getCpf());
            pstm.setString(3, funcionarioHospital.getTelefone());
            pstm.setString(4, funcionarioHospital.getFuncao());
            pstm.setString(5, funcionarioHospital.getHorario());
            pstm.setDouble(6, funcionarioHospital.getSalario());
            pstm.setInt(7, funcionarioHospital.getId());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioHospitalDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean remover(int id) {
        try {
            abrirConexao();
            
            String sql = "DELETE FROM funcionarioHospital WHERE id = " + id;
            
            conexao.createStatement().executeUpdate(sql);
            
            fecharConexao();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioHospitalDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public FuncionarioHospital getById(int id) {
        FuncionarioHospital funcionarioHospital = null;
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM funcionarioHospital WHERE id = " + id;
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                funcionarioHospital = new FuncionarioHospital();
                funcionarioHospital.setId(id);
                funcionarioHospital.setNome(rs.getString("nome"));
                funcionarioHospital.setCpf(rs.getString("cpf"));
                funcionarioHospital.setTelefone(rs.getString("telefone"));
                funcionarioHospital.setFuncao(rs.getString("funcao"));
                funcionarioHospital.setHorario(rs.getString("horario"));
                funcionarioHospital.setSalario(rs.getDouble("salario"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioHospitalDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarioHospital;
    }

    @Override
    public List<FuncionarioHospital> listar() {
        List<FuncionarioHospital> lista = new ArrayList<FuncionarioHospital>();
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM funcionarioHospital";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                FuncionarioHospital funcionarioHospital = new FuncionarioHospital();
                funcionarioHospital.setId(rs.getInt("id"));
                funcionarioHospital.setNome(rs.getString("nome"));
                funcionarioHospital.setCpf(rs.getString("cpf"));
                funcionarioHospital.setTelefone(rs.getString("telefone"));
                funcionarioHospital.setFuncao(rs.getString("funcao"));
                funcionarioHospital.setHorario(rs.getString("horario"));
                funcionarioHospital.setSalario(rs.getDouble("salario"));
                lista.add(funcionarioHospital);
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioHospitalDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}