package hospital.management.system.persistencia.mysql;

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

public class LeitoDAOMySQL implements LeitoDAO{
    private Connection conexao;
    
    private void abrirConexao() {
        try {
            String className = "com.mysql.cj.jdbc.Driver";
            Class.forName(className);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LeitoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
        } catch (SQLException ex) {
            Logger.getLogger(LeitoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(LeitoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void inserir(Leito leito) {
        try {
            abrirConexao();
            
            String sql = "INSERT INTO leito (numero, tipo) VALUES (?, ?);";
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setInt(1, leito.getNumero());
            pstm.setString(2, leito.getTipo());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(LeitoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void editar(Leito leito) {
        try {
            abrirConexao();
            
            String sql = "UPDATE leito SET numero = ?, tipo = ? WHERE  id = ?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setInt(1, leito.getNumero());
            pstm.setString(2, leito.getTipo());
            pstm.setInt(3, leito.getId());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(LeitoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public boolean remover(int id) {
        try {
            abrirConexao();
            
            String sql = "DELETE FROM leito WHERE id = " + id;
            
            conexao.createStatement().executeUpdate(sql);
            
            fecharConexao();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LeitoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Leito getById(int id) {
        Leito leito = null;
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM leito WHERE id = " + id;
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                leito = new Leito();
                leito.setId(id);
                leito.setNumero(rs.getInt("numero"));
                leito.setTipo(rs.getString("tipo"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(LeitoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return leito;
    }

    @Override
    public List<Leito> listar() {
        List<Leito> lista = new ArrayList<Leito>();
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM leito";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                Leito leito = new Leito();
                leito.setId(rs.getInt("id"));
                leito.setNumero(rs.getInt("numero"));
                leito.setTipo(rs.getString("tipo"));
                lista.add(leito);
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(LeitoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
