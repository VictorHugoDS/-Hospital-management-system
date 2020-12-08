package hospital.management.system.persistencia.postgresql;

import hospital.management.system.entidades.Internacao;
import hospital.management.system.persistencia.InternacaoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InternacaoDAOPostgreSQL implements InternacaoDAO {
    
     private Connection conexao;
    
    private void abrirConexao() {
        try {
            conexao = DriverManager.getConnection("jdbc:postgresql://", "postgre", "");
        } catch (SQLException ex) {
            Logger.getLogger(InternacaoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(InternacaoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Internacao internacao) {
        try {
            abrirConexao();
            
            String sql = "INSERT INTO internacao (medicacao, data_de_entrada, data_de_saida, horario_de_entrada, horario_de_saida, id_leito, id_paciente ) VALUES ('?','?','?','?','?',?,?);";
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, internacao.getMedicacao());
            pstm.setString(2, internacao.getData_de_entrada());
            pstm.setString(3, internacao.getData_de_saida());
            pstm.setString(4, internacao.getHorario_de_entrada());
            pstm.setString(5, internacao.getHorario_de_saida());
            pstm.setInt(6, internacao.getId_leito());
            pstm.setInt(7, internacao.getId_paciente());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(InternacaoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Internacao internacao) {
        try {
            abrirConexao();
            
            String sql = "UPDATE internacao SET medicacao = ?, data_de_entrada = ?, data_de_saida = ?,horario_de_entrada = ?,horario_de_saida = ?, id_leito = ?, id_paciente = ?  WHERE  id = ?;";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, internacao.getMedicacao());
            pstm.setString(2, internacao.getData_de_entrada());
            pstm.setString(3, internacao.getData_de_saida());
            pstm.setString(4, internacao.getHorario_de_entrada());
            pstm.setString(5, internacao.getHorario_de_saida());
            pstm.setInt(6, internacao.getId_leito());
            pstm.setInt(7, internacao.getId_paciente());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(InternacaoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean remover(int id) {
        try {
            abrirConexao();
            
            String sql = "DELETE FROM internacao WHERE id = " + id + ";";
            
            conexao.createStatement().executeUpdate(sql);
            
            fecharConexao();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(InternacaoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Internacao getById(int id) {
        Internacao internacao = null;
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM internacao WHERE id = " + id + ";";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                internacao = new Internacao();
                internacao.setId(id);
                internacao.setMedicacao(rs.getString("medicacao"));
                internacao.setData_de_entrada(rs.getString("data_de_entrada"));
                internacao.setData_de_saida(rs.getString("data_de_saida"));
                internacao.setHorario_de_entrada(rs.getString("horario_de_entrada"));
                internacao.setHorario_de_saida(rs.getString("horario_de_saida"));
                internacao.setId_leito(rs.getInt("id_leito"));
                internacao.setId_paciente(rs.getInt("id_paciente"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(InternacaoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return internacao;
    }

    @Override
    public List<Internacao> listar() {
        List<Internacao> lista = new ArrayList<Internacao>();
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM internacao;";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                Internacao internacao = new Internacao();
                internacao.setMedicacao(rs.getString("medicacao"));
                internacao.setData_de_entrada(rs.getString("data_de_entrada"));
                internacao.setData_de_saida(rs.getString("data_de_saida"));
                internacao.setHorario_de_entrada(rs.getString("horario_de_entrada"));
                internacao.setHorario_de_saida(rs.getString("horario_de_saida"));
                internacao.setId_leito(rs.getInt("id_leito"));
                internacao.setId_paciente(rs.getInt("id_paciente"));
                lista.add(internacao);
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(InternacaoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
