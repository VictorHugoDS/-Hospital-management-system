package hospital.management.system.persistencia.arquivo;

import hospital.management.system.persistencia.FuncionarioHospitalDAO;
import hospital.management.system.entidades.FuncionarioHospital;

import java.util.List;
import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioHospitalDAOImplArq implements FuncionarioHospitalDAO {
    private final String nomeArq = "funcionariosHospital.dat";
    private List<FuncionarioHospital> funcionarios = new ArrayList<FuncionarioHospital>();

    private void carregaArquivo() {
        try {
            ObjectInputStream inputArq = new ObjectInputStream(new FileInputStream(nomeArq));
            funcionarios = (List<FuncionarioHospital>)inputArq.readObject();
            inputArq.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FuncionarioHospitalDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioHospitalDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void salvaArquivo() {
        try {
            ObjectOutputStream outputArq = new ObjectOutputStream(new FileOutputStream(nomeArq));
            outputArq.writeObject(funcionarios);
            outputArq.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FuncionarioHospitalDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FuncionarioHospitalDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(FuncionarioHospital novoFuncionario) {
        boolean jaExiste = false;
        int i, tamanho;

        carregaArquivo();
        tamanho = funcionarios.size();
        i = 0;
        while (i < tamanho && !jaExiste) {
            if (funcionarios.get(i).getId() == novoFuncionario.getId()) {
                jaExiste = true;
            }
            i++;
        }
        if (!jaExiste) {
            funcionarios.add(novoFuncionario);
            salvaArquivo();
        }
    }

    @Override
    public void editar(FuncionarioHospital funcionarioModificado) {
        int i, tamanho;

        carregaArquivo();
        tamanho = funcionarios.size();
        i = 0;
        while (i < tamanho && funcionarios.get(i).getId() != funcionarioModificado.getId()) {
            i++;
        }
        funcionarios.set(i, funcionarioModificado);
        salvaArquivo();
    }

    @Override
    public boolean remover(int id) {
        int i, tamanho;

        carregaArquivo();
        tamanho = funcionarios.size();
        i = 0;
        while (i < tamanho && funcionarios.get(i).getId() != id) {
            i++;
        }
        if (i < tamanho && funcionarios.get(i).getId() == id) {
            funcionarios.remove(i);
            salvaArquivo();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public FuncionarioHospital getById(int id) {
        int i, tamanho;

        tamanho = funcionarios.size();
        i = 0;
        while (i < tamanho && funcionarios.get(i).getId() != id) {
            i++;
        }
        if (i < tamanho && funcionarios.get(i).getId() == id) {
            return funcionarios.get(i);
        } else {
            return null;
        }
    }

    @Override
    public List<FuncionarioHospital> listar() {
        carregaArquivo();
        return funcionarios;
    }
}