package hospital.management.system.persistencia.arquivo;

import hospital.management.system.persistencia.MedicoDAO;
import hospital.management.system.entidades.Medico;

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

public class MedicoDAOImplArq implements MedicoDAO {
    private final String nomeArq = "medicos.dat";
    private List<Medico> medicos = new ArrayList<Medico>();

    private void carregaArquivo() {
        try {
            ObjectInputStream inputArq = new ObjectInputStream(new FileInputStream(nomeArq));
            medicos = (List<Medico>)inputArq.readObject();
            inputArq.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MedicoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MedicoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void salvaArquivo() {
        try {
            ObjectOutputStream outputArq = new ObjectOutputStream(new FileOutputStream(nomeArq));
            outputArq.writeObject(medicos);
            outputArq.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MedicoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MedicoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Medico novoMedico) {
        boolean jaExiste = false;
        int i, tamanho;

        carregaArquivo();
        tamanho = medicos.size();
        i = 0;
        while (i < tamanho && !jaExiste) {
            if (medicos.get(i).getId() == novoMedico.getId()) {
                jaExiste = true;
            }
            i++;
        }
        if (!jaExiste) {
            medicos.add(novoMedico);
            salvaArquivo();
        }
    }

    @Override
    public void editar(Medico medicoModificado) {
        int i, tamanho;

        carregaArquivo();
        tamanho = medicos.size();
        i = 0;
        while (i < tamanho && medicos.get(i).getId() != medicoModificado.getId()) {
            i++;
        }
        medicos.set(i, medicoModificado);
        salvaArquivo();
    }

    @Override
    public boolean remover(int id) {
        int i, tamanho;

        carregaArquivo();
        tamanho = medicos.size();
        i = 0;
        while (i < tamanho && medicos.get(i).getId() != id) {
            i++;
        }
        if (i < tamanho && medicos.get(i).getId() == id) {
            medicos.remove(i);
            salvaArquivo();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Medico getById(int id) {
        int i, tamanho;
        carregaArquivo();
        tamanho = medicos.size();
        i = 0;
        while (i < tamanho && medicos.get(i).getId() != id) {
            i++;
        }
        if (i < tamanho && medicos.get(i).getId() == id) {
            return medicos.get(i);
        } else {
            return null;
        }
    }

    @Override
    public List<Medico> listar() {
        carregaArquivo();
        return medicos;
    }
}