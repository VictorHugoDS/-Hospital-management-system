package hospital.management.system.persistencia.postgresql;

import hospital.management.system.entidades.Leito;
import hospital.management.system.persistencia.LeitoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeitoDAOPostgreSQL implements LeitoDAO{
    private Connection conexao;
    
    private void abrirConexao() {
        try {
            conexao = DriverManager.getConnection("jdbc:postgresql://", "postgre", "");
        } catch (SQLException ex) {
            Logger.getLogger(LeitoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(LeitoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void inserir(Leito leito) {
        try {
            abrirConexao();
            
            String sql = "INSERT INTO leito (numero, tipo, enfermeiro) VALUES (?, '?', ?);";
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setInt(1, leito.getNumero());
            pstm.setString(2, leito.getTipo());
            pstm.setInt(3, leito.getEnfermeiro());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(LeitoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void editar(Leito leito) {
        try {
            abrirConexao();
            
            String sql = "UPDATE leito SET numero = ?, tipo = ?, enfermeiro = ? WHERE  id = ?;";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setInt(1, leito.getNumero());
            pstm.setString(2, leito.getTipo());
            pstm.setInt(3, leito.getEnfermeiro());
            pstm.setInt(4, leito.getId());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(LeitoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public boolean remover(int id) {
        try {
            abrirConexao();
            
            String sql = "DELETE FROM leito WHERE id = " + id + ";";
            
            conexao.createStatement().executeUpdate(sql);
            
            fecharConexao();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LeitoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Leito getById(int id) {
        Leito leito = null;
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM leito WHERE id = " + id + ";";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                leito = new Leito();
                leito.setId(id);
                leito.setNumero(rs.getInt("numero"));
                leito.setTipo(rs.getString("tipo"));
                leito.setEnfermeiro(rs.getInt("enfermeiro"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(LeitoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return leito;
    }

    @Override
    public List<Leito> listar() {
        List<Leito> lista = new ArrayList<Leito>();
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM leito;";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                Leito leito = new Leito();
                leito.setNumero(rs.getInt("numero"));
                leito.setTipo(rs.getString("tipo"));
                leito.setEnfermeiro(rs.getInt("enfermeiro"));
                lista.add(leito);
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(LeitoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
