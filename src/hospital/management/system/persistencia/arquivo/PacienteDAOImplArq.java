package hospital.management.system.persistencia.arquivo;

import hospital.management.system.persistencia.PacienteDAO;
import hospital.management.system.entidades.Paciente;

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
public class PacienteDAOImplArq implements PacienteDAO {
    private final String nomeArq = "pacientes.dat";
    private List<Paciente> pacientes = new ArrayList<Paciente>();

    private void carregaArquivo() {
        try {
            ObjectInputStream inputArq = new ObjectInputStream(new FileInputStream(nomeArq));
            pacientes = (List<Paciente>)inputArq.readObject();
            inputArq.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PacienteDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PacienteDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void salvaArquivo() {
        try {
            ObjectOutputStream outputArq = new ObjectOutputStream(new FileOutputStream(nomeArq));
            outputArq.writeObject(pacientes);
            outputArq.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PacienteDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PacienteDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Paciente novoPaciente) {
        boolean jaExiste = false;
        int i, tamanho;

        carregaArquivo();
        tamanho = pacientes.size();
        i = 0;
        while (i < tamanho && !jaExiste) {
            if (pacientes.get(i).getId() == novoPaciente.getId()) {
                jaExiste = true;
            }
            i++;
        }
        if (!jaExiste) {
            pacientes.add(novoPaciente);
            salvaArquivo();
        }
    }

    @Override
    public void editar(Paciente pacienteModificado) {
        int i, tamanho;

        carregaArquivo();
        tamanho = pacientes.size();
        i = 0;
        while (i < tamanho && pacientes.get(i).getId() != pacienteModificado.getId()) {
            i++;
        }
        pacientes.set(i, pacienteModificado);
        salvaArquivo();
    }

    @Override
    public boolean remover(int id) {
        int i, tamanho;

        carregaArquivo();
        tamanho = pacientes.size();
        i = 0;
        while (i < tamanho && pacientes.get(i).getId() != id) {
            i++;
        }
        if (i < tamanho && pacientes.get(i).getId() == id) {
            pacientes.remove(i);
            salvaArquivo();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Paciente getById(int id) {
        int i, tamanho;
        carregaArquivo();

        tamanho = pacientes.size();
        i = 0;
        while (i < tamanho && pacientes.get(i).getId() != id) {
            i++;
        }
        if (i < tamanho && pacientes.get(i).getId() == id) {
            return pacientes.get(i);
        } else {
            return null;
        }
    }

    @Override
    public List<Paciente> listar() {
        carregaArquivo();
        return pacientes;
    }
}
