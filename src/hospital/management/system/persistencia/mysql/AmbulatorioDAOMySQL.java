
package hospital.management.system.persistencia.mysql;

import hospital.management.system.entidades.Ambulatorio;
import hospital.management.system.persistencia.AmbulatorioDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AmbulatorioDAOMySQL implements AmbulatorioDAO{
    
    private Connection conexao;
    
    private void abrirConexao() {
        try {
            String className = "com.mysql.cj.jdbc.Driver";
            Class.forName(className);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AmbulatorioDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
        } catch (SQLException ex) {
            Logger.getLogger(AmbulatorioDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(AmbulatorioDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Ambulatorio ambulatorio) {
        try {
            abrirConexao();
            
            String sql = "INSERT INTO ambulatorio (numero) VALUES (?);";
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setInt(1, ambulatorio.getNumero());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(AmbulatorioDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Ambulatorio ambulatorio) {
        try {
            abrirConexao();
            
            String sql = "UPDATE ambulatorio SET numero = ? WHERE  id = ?;";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setInt(1, ambulatorio.getNumero());
            pstm.setInt(2, ambulatorio.getId());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(AmbulatorioDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean remover(int id) {
        try {
            abrirConexao();
            
            String sql = "DELETE FROM ambulatorio WHERE id = " + id;
            
            conexao.createStatement().executeUpdate(sql);
            
            fecharConexao();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AmbulatorioDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Ambulatorio getById(int id) {
        Ambulatorio ambulatorio = null;
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM ambulatorio WHERE id = " + id;
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                ambulatorio = new Ambulatorio();
                ambulatorio.setId(id);
                ambulatorio.setNumero(rs.getInt("numero"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(AmbulatorioDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ambulatorio;
    }

    @Override
    public List<Ambulatorio> listar() {
        List<Ambulatorio> lista = new ArrayList<Ambulatorio>();
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM ambulatorio";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                Ambulatorio ambulatorio = new Ambulatorio();
                ambulatorio.setId(rs.getInt("id"));
                ambulatorio.setNumero(rs.getInt("numero"));
                lista.add(ambulatorio);
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(AmbulatorioDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
