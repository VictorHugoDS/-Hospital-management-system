package hospital.management.system.persistencia.arquivo;

import hospital.management.system.persistencia.EnfermeiroDAO;
import hospital.management.system.entidades.Enfermeiro;
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

public class EnfermeiroDAOImplArq implements EnfermeiroDAO {
    private final String nomeArq = "enfermeiros.dat";
    private List<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();

    private void carregaArquivo() {
        try {
            ObjectInputStream inputArq = new ObjectInputStream(new FileInputStream(nomeArq));
            enfermeiros = (List<Enfermeiro>)inputArq.readObject();
            inputArq.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EnfermeiroDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(EnfermeiroDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void salvaArquivo() {
        try {
            ObjectOutputStream outputArq = new ObjectOutputStream(new FileOutputStream(nomeArq));
            outputArq.writeObject(enfermeiros);
            outputArq.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EnfermeiroDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EnfermeiroDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Enfermeiro novoEnfermeiro) {
        boolean jaExiste = false;
        int i, tamanho;

        carregaArquivo();
        tamanho = enfermeiros.size();
        i = 0;
        while (i < tamanho && !jaExiste) {
            if (enfermeiros.get(i).getId() == novoEnfermeiro.getId()) {
                jaExiste = true;
            }
            i++;
        }
        if (!jaExiste) {
            enfermeiros.add(novoEnfermeiro);
            salvaArquivo();
        }
    }

    @Override
    public void editar(Enfermeiro enfermeiroModificado) {
        int i, tamanho;

        carregaArquivo();
        tamanho = enfermeiros.size();
        i = 0;
        while (i < tamanho && enfermeiros.get(i).getId() != enfermeiroModificado.getId()) {
            i++;
        }
        enfermeiros.set(i, enfermeiroModificado);
        salvaArquivo();
    }

    @Override
    public boolean remover(int id) {
        int i, tamanho;

        carregaArquivo();
        tamanho = enfermeiros.size();
        i = 0;
        while (i < tamanho && enfermeiros.get(i).getId() != id) {
            i++;
        }
        if (i < tamanho && enfermeiros.get(i).getId() == id) {
            enfermeiros.remove(i);
            salvaArquivo();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Enfermeiro getById(int id) {
        int i, tamanho;

        tamanho = enfermeiros.size();
        i = 0;
        while (i < tamanho && enfermeiros.get(i).getId() != id) {
            i++;
        }
        if (i < tamanho && enfermeiros.get(i).getId() == id) {
            return enfermeiros.get(i);
        } else {
            return null;
        }
    }

    @Override
    public List<Enfermeiro> listar() {
        carregaArquivo();
        return enfermeiros;
    }
}