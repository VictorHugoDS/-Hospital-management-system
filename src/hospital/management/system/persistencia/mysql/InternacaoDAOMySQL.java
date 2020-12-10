package hospital.management.system.persistencia.mysql;

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

public class InternacaoDAOMySQL implements InternacaoDAO {
    
     private Connection conexao;
    
    private void abrirConexao() {
        try {
            String className = "com.mysql.cj.jdbc.Driver";
            Class.forName(className);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InternacaoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
        } catch (SQLException ex) {
            Logger.getLogger(InternacaoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(InternacaoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Internacao internacao) {
        try {
            abrirConexao();
            
            String sql = "INSERT INTO internacao (medicacao, dataEntrada, dataSaida, horarioEntrada, horarioSaida, idLeito, idPaciente ) VALUES (?,?,?,?,?,?,?)";
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, internacao.getMedicacao());
            pstm.setString(2, internacao.getDataEntrada());
            pstm.setString(3, internacao.getDataSaida());
            pstm.setString(4, internacao.getHorarioEntrada());
            pstm.setString(5, internacao.getHorarioSaida());
            pstm.setInt(6, internacao.getIdLeito());
            pstm.setInt(7, internacao.getIdPaciente());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(InternacaoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Internacao internacao) {
        try {
            abrirConexao();
            
            String sql = "UPDATE internacao SET medicacao = ?, dataEntrada = ?, dataSaida = ?,horarioEntrada = ?,horarioSaida = ?, idLeito = ?, idPaciente = ?  WHERE  id = ?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, internacao.getMedicacao());
            pstm.setString(2, internacao.getDataEntrada());
            pstm.setString(3, internacao.getDataSaida());
            pstm.setString(4, internacao.getHorarioEntrada());
            pstm.setString(5, internacao.getHorarioSaida());
            pstm.setInt(6, internacao.getIdLeito());
            pstm.setInt(7, internacao.getIdPaciente());
            pstm.setInt(8, internacao.getId());
            
            pstm.execute();
            
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(InternacaoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean remover(int id) {
        try {
            abrirConexao();
            
            String sql = "DELETE FROM internacao WHERE id = " + id;
            
            conexao.createStatement().executeUpdate(sql);
            
            fecharConexao();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(InternacaoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Internacao getById(int id) {
        Internacao internacao = null;
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM internacao WHERE id = " + id;
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            if (rs.next()) {
                internacao = new Internacao();
                internacao.setId(id);
                internacao.setMedicacao(rs.getString("medicacao"));
                internacao.setDataEntrada(rs.getString("dataEntrada"));
                internacao.setDataSaida(rs.getString("dataSaida"));
                internacao.setHorarioEntrada(rs.getString("horarioEntrada"));
                internacao.setHorarioSaida(rs.getString("horarioSaida"));
                internacao.setIdLeito(rs.getInt("idLeito"));
                internacao.setIdPaciente(rs.getInt("idPaciente"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(InternacaoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return internacao;
    }

    @Override
    public List<Internacao> listar() {
        List<Internacao> lista = new ArrayList<Internacao>();
        try {
            abrirConexao();
            
            String sql = "SELECT * FROM internacao";
            
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                Internacao internacao = new Internacao();
                internacao.setId(rs.getInt("id"));
                internacao.setMedicacao(rs.getString("medicacao"));
                internacao.setDataEntrada(rs.getString("dataEntrada"));
                internacao.setDataSaida(rs.getString("dataSaida"));
                internacao.setHorarioEntrada(rs.getString("horarioEntrada"));
                internacao.setHorarioSaida(rs.getString("horarioSaida"));
                internacao.setIdLeito(rs.getInt("idLeito"));
                internacao.setIdPaciente(rs.getInt("idPaciente"));
                lista.add(internacao);
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(InternacaoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
