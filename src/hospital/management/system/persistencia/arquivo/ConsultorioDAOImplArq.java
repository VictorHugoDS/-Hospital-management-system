package hospital.management.system.persistencia.arquivo;

import hospital.management.system.persistencia.ConsultorioDAO;
import hospital.management.system.entidades.Consultorio;

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

public class ConsultorioDAOImplArq implements ConsultorioDAO {
    private final String nomeArq = "consultorios.dat";
    private List<Consultorio> consultorios = new ArrayList<Consultorio>();

    private void carregaArquivo() {
        try {
            ObjectInputStream inputArq = new ObjectInputStream(new FileInputStream(nomeArq));
            consultorios = (List<Consultorio>)inputArq.readObject();
            inputArq.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConsultorioDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultorioDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void salvaArquivo() {
        try {
            ObjectOutputStream outputArq = new ObjectOutputStream(new FileOutputStream(nomeArq));
            outputArq.writeObject(consultorios);
            outputArq.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConsultorioDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConsultorioDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Consultorio novoConsultorio) {
        boolean jaExiste = false;
        int i, tamanho;

        carregaArquivo();
        tamanho = consultorios.size();
        i = 0;
        while (i < tamanho && !jaExiste) {
            if (consultorios.get(i).getId() == novoConsultorio.getId()) {
                jaExiste = true;
            }
            i++;
        }
        if (!jaExiste) {
            consultorios.add(novoConsultorio);
            salvaArquivo();
        }
    }

    @Override
    public void editar(Consultorio consultorioModificado) {
        int i, tamanho;

        carregaArquivo();
        tamanho = consultorios.size();
        i = 0;
        while (i < tamanho && consultorios.get(i).getId() != consultorioModificado.getId()) {
            i++;
        }
        consultorios.set(i, consultorioModificado);
        salvaArquivo();
    }

    @Override
    public boolean remover(int id) {
        int i, tamanho;

        carregaArquivo();
        tamanho = consultorios.size();
        i = 0;
        while (i < tamanho && consultorios.get(i).getId() != id) {
            i++;
        }
        if (i < tamanho && consultorios.get(i).getId() == id) {
            consultorios.remove(i);
            salvaArquivo();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Consultorio getById(int id) {
        int i, tamanho;
        carregaArquivo();
        tamanho = consultorios.size();
        i = 0;
        while (i < tamanho && consultorios.get(i).getId() != id) {
            i++;
        }
        if (i < tamanho && consultorios.get(i).getId() == id) {
            return consultorios.get(i);
        } else {
            return null;
        }
    }

    @Override
    public List<Consultorio> listar() {
        carregaArquivo();
        return consultorios;
    }
}