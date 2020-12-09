package hospital.management.system.persistencia.mysql;

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

public class ObservacaoDAOMySQL implements ObservacaoDAO {
    
    private Connection conexao;
    
    private void abrirConexao() {
        try {
            String className = "com.mysql.cj.jdbc.Driver";
            Class.forName(className);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObservacaoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
        } catch (SQLException ex) {
            Logger.getLogger(ObservacaoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ObservacaoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Observacao observacao) {
        try {
            abrirConexao();
            
            String sql = "INSERT INTO observacao (medicacao, dataEntrada, dataSaida, horarioEntrada, horarioSaida, idAmbulatorio, idPaciente) VALUES (?, ?, ?, ?, ?, ?, ?);";
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, observacao.getMedicacao());
            pstm.setString(2, observacao.getDataEntrada());
            pstm.setString(3, observacao.getDataSaida());
            pstm.setString(4, observacao.getHorarioEntrada());
            pstm.setString(5, observacao.getHorarioSaida());
            pstm.setInt(6, observacao.getIdAmbulatorio());
            pstm.setInt(7, observacao.getIdPaciente());
            
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ObservacaoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Observacao observacao) {
        try {
            abrirConexao();
            
            String sql = "UPDATE observacao SET medicacao = ?, dataEntrada = ?, dataSaida= ?, horarioEntrada= ?, horarioSaida= ?, idAmbulatorio= ?, idPaciente= ?  WHERE  id = ?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, observacao.getMedicacao());
            pstm.setString(2, observacao.getDataEntrada());
            pstm.setString(3, observacao.getDataSaida());
            pstm.setString(4, observacao.getHorarioEntrada());
            pstm.setString(5, observacao.getHorarioSaida());
            pstm.setInt(6, observacao.getIdAmbulatorio());
            pstm.setInt(7, observacao.getIdPaciente());
            pstm.setInt(8, observacao.getId());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ObservacaoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean remover(int id) {
        try {
            abrirConexao();
            
            String sql = "DELETE FROM observacao WHERE id = " + id;
            
            conexao.createStatement().executeUpdate(sql);
            
            fecharConexao();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ObservacaoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Observacao getById(int id) {
        Observacao observacao = null;
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM observacao WHERE id = " + id;
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                observacao = new Observacao();
                observacao.setId(id);
                observacao.setMedicacao(rs.getString("medicacao"));
                observacao.setDataEntrada(rs.getString("dataEntrada"));
                observacao.setDataSaida(rs.getString("dataSaida"));
                observacao.setHorarioEntrada(rs.getString("horarioEntrada"));
                observacao.setHorarioSaida(rs.getString("horarioSaida"));
                observacao.setIdAmbulatorio(rs.getInt("idAmbulatorio"));
                observacao.setIdPaciente(rs.getInt("idPaciente"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ObservacaoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return observacao;
    }

    @Override
    public List<Observacao> listar() {
        List<Observacao> lista = new ArrayList<Observacao>();
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM observacao";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                Observacao observacao = new Observacao();
                observacao.setId(rs.getInt("id"));
                observacao.setMedicacao(rs.getString("medicacao"));
                observacao.setDataEntrada(rs.getString("dataEntrada"));
                observacao.setDataSaida(rs.getString("dataSaida"));
                observacao.setHorarioEntrada(rs.getString("horarioEntrada"));
                observacao.setHorarioSaida(rs.getString("horarioSaida"));
                observacao.setIdAmbulatorio(rs.getInt("idAmbulatorio"));
                observacao.setIdPaciente(rs.getInt("idPaciente"));
                lista.add(observacao);
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ObservacaoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
        
}
