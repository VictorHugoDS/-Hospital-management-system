package hospital.management.system.persistencia.postgresql;

import hospital.management.system.entidades.Observacao;
import hospital.management.system.persistencia.ObservacaoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObservacaoDAOPostgreSQL implements ObservacaoDAO {
    
    private Connection conexao;
    
    private void abrirConexao() {
        try {
            conexao = DriverManager.getConnection("jdbc:postgresql://", "postgre", "");
        } catch (SQLException ex) {
            Logger.getLogger(ObservacaoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ObservacaoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Observacao observacao) {
        try {
            abrirConexao();
            
            String sql = "INSERT INTO observacao (medicacao, data_de_entrada, data_de_saida, horario_de_entrada, horario_de_saida, id_ambulatorio, id_paciente) VALUES ('?', '?', '?', '?', '?', ?, ?);";
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, observacao.getMedicacao());
            pstm.setString(2, observacao.getData_de_entrada());
            pstm.setString(3, observacao.getData_de_saida());
            pstm.setString(4, observacao.getHorario_de_entrada());
            pstm.setString(5, observacao.getHorario_de_saida());
            pstm.setInt(6, observacao.getId_ambulatorio());
            pstm.setInt(7, observacao.getId_paciente());
            
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ObservacaoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Observacao observacao) {
        try {
            abrirConexao();
            
            String sql = "UPDATE observacao SET medicacao = ?, data_de_entrada = ?, data_de_saida= ?, horario_de_entrada= ?, horario_de_saida= ?, id_ambulatorio= ?, id_paciente= ?  WHERE  id = ?;";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, observacao.getMedicacao());
            pstm.setString(2, observacao.getData_de_entrada());
            pstm.setString(3, observacao.getData_de_saida());
            pstm.setString(4, observacao.getHorario_de_entrada());
            pstm.setString(5, observacao.getHorario_de_saida());
            pstm.setInt(6, observacao.getId_ambulatorio());
            pstm.setInt(7, observacao.getId_paciente());
            pstm.setInt(8, observacao.getId());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ObservacaoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean remover(int id) {
        try {
            abrirConexao();
            
            String sql = "DELETE FROM observacao WHERE id = " + id + ";";
            
            conexao.createStatement().executeUpdate(sql);
            
            fecharConexao();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ObservacaoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Observacao getById(int id) {
        Observacao observacao = null;
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM observacao WHERE id = " + id + ";";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                observacao = new Observacao();
                observacao.setId(id);
                observacao.setMedicacao(rs.getString("medicacao"));
                observacao.setData_de_entrada(rs.getString("data_de_entrada"));
                observacao.setData_de_saida(rs.getString("data_de_saida"));
                observacao.setHorario_de_entrada(rs.getString("horario_de_entrada"));
                observacao.setHorario_de_saida(rs.getString("horario_de_saida"));
                observacao.setId_ambulatorio(rs.getInt("id_ambulatorio"));
                observacao.setId_paciente(rs.getInt("id_paciente"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ObservacaoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return observacao;
    }

    @Override
    public List<Observacao> listar() {
        List<Observacao> lista = new ArrayList<Observacao>();
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM observacao;";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                Observacao observacao = new Observacao();
                observacao.setMedicacao(rs.getString("medicacao"));
                observacao.setData_de_entrada(rs.getString("data_de_entrada"));
                observacao.setData_de_saida(rs.getString("data_de_saida"));
                observacao.setHorario_de_entrada(rs.getString("horario_de_entrada"));
                observacao.setHorario_de_saida(rs.getString("horario_de_saida"));
                observacao.setId_ambulatorio(rs.getInt("id_ambulatorio"));
                observacao.setId_paciente(rs.getInt("id_paciente"));
                lista.add(observacao);
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ObservacaoDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
        
}
