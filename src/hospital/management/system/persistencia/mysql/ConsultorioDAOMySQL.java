package hospital.management.system.persistencia.mysql;

import hospital.management.system.entidades.Consultorio;
import hospital.management.system.persistencia.ConsultorioDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultorioDAOMySQL implements ConsultorioDAO {
    
    private Connection conexao;
    
    private void abrirConexao() {
        try {
            String className = "com.mysql.cj.jdbc.Driver";
            Class.forName(className);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConsultorioDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultorioDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultorioDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Consultorio consultorio) {
        try {
            abrirConexao();
            
            String sql = "INSERT INTO consultorio (numero, tipo) VALUES (?, ?);";
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setInt(1, consultorio.getNumero());
            pstm.setString(2, consultorio.getTipo());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultorioDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Consultorio consultorio) {
        try {
            abrirConexao();
            
            String sql = "UPDATE consultorio SET numero = ?, tipo = ? WHERE  id = ?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setInt(1, consultorio.getNumero());
            pstm.setString(2, consultorio.getTipo());
            pstm.setInt(3, consultorio.getId());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultorioDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean remover(int id) {
        try {
            abrirConexao();
            
            String sql = "DELETE FROM consultorio WHERE id = " + id;
            
            conexao.createStatement().executeUpdate(sql);
            
            fecharConexao();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultorioDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Consultorio getById(int id) {
        Consultorio consultorio = null;
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM consultorio WHERE id = " + id;
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                consultorio = new Consultorio();
                consultorio.setId(id);
                consultorio.setNumero(rs.getInt("numero"));
                consultorio.setTipo(rs.getString("tipo"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultorioDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consultorio;
    }

    @Override
    public List<Consultorio> listar() {
        List<Consultorio> lista = new ArrayList<Consultorio>();
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM consultorio";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                Consultorio consultorio = new Consultorio();
                consultorio.setId(rs.getInt("id"));
                consultorio.setNumero(rs.getInt("numero"));
                consultorio.setTipo(rs.getString("tipo"));
                lista.add(consultorio);
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultorioDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}