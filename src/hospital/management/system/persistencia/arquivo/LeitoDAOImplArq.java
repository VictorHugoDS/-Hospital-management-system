package hospital.management.system.persistencia.arquivo;

import hospital.management.system.entidades.Leito;
import hospital.management.system.persistencia.LeitoDAO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LeitoDAOImplArq implements LeitoDAO{
    private final String filename = "Leito.dat";
    private List<Leito> leitos = new ArrayList<Leito>();
    
    private void salvarArquivo() {
        try {
            ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream(filename));
            objout.writeObject(leitos);
            objout.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeitoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
            Logger.getLogger(LeitoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void lerArquivo(){
        try {
            ObjectInputStream objin = new ObjectInputStream(new FileInputStream(filename));
            leitos = (List<Leito>)objin.readObject();
            objin.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeitoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(LeitoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Leito leito) {
        boolean existe=false;
        lerArquivo();
        for(int i=0;i<leitos.size();i++){
            Leito l= leitos.get(i);
            if (l.getId()==leito.getId()){
                existe=true;
                break;
            }
            
        }
        if(!existe){
            leitos.add(leito);
            salvarArquivo();
            System.out.println("Cadastrado com sucesso!");
        } else {
            System.out.println("Leito já cadastrada!");
        }
        
    }

    @Override
    public void editar(Leito leito) {
        boolean existe=false;
        lerArquivo();
        for (int i=0;i<leitos.size();i++){
            Leito l= leitos.get(i);
            if(l.getId()==leito.getId()){
                leitos.set(i, leito);
                existe=true;
                salvarArquivo();
                System.out.println("A alteração foi salva");
                break;
            }
        }
        if (!existe){
            System.out.println("Não foi possível encontrar a consulta");
        }
    }

    @Override
    public boolean remover(int id) {
        lerArquivo();
        for(int i=0;i<leitos.size();i++){
            Leito l= leitos.get(i);
            if(l.getId()==id){
               leitos.remove(i);
               salvarArquivo();
               return true;
            }
        }
        return false;
    }

    @Override
    public Leito getById(int id) {
        lerArquivo();
        for(int i=0;i<leitos.size();i++){
            Leito l = leitos.get(i);
            if (l.getId()==id){
                return l;
            }
        }
        return null;
    }

    @Override
    public List<Leito> listar() {
        lerArquivo();
        return leitos;
    }
}
