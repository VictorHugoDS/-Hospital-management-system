
package hospital.management.system.persistencia.arquivo;

import hospital.management.system.entidades.Ambulatorio;
import hospital.management.system.persistencia.AmbulatorioDAO;
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

public class AmbulatorioDAOImplArq implements AmbulatorioDAO {

    private final String filename = "ambulatorio.dat";
    private List<Ambulatorio> ambulatorios = new ArrayList<Ambulatorio>();
    
    private void salvarArquivo(){
        try {
            ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream(filename));
            objout.writeObject(ambulatorios);
            objout.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AmbulatorioDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
            Logger.getLogger(AmbulatorioDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void lerArquivo(){
        try {
            ObjectInputStream objin = new ObjectInputStream(new FileInputStream(filename));
            ambulatorios = (List<Ambulatorio>)objin.readObject();
            objin.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AmbulatorioDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AmbulatorioDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Ambulatorio ambulatorio) {
        boolean existe=false;

        lerArquivo();
        for(int i=0;i<ambulatorios.size();i++){
            Ambulatorio c= ambulatorios.get(i);
            if (c.getId()==ambulatorio.getId()){
                existe=true;
                break;
            }
            
        }
        if(!existe){
            ambulatorios.add(ambulatorio);
            salvarArquivo();
            System.out.println("Cadastrado com sucesso!");
        } else {
            System.out.println("Consulta já cadastrada!");
        }
        
    }

    @Override
    public void editar(Ambulatorio ambulatorio) {
        boolean existe=false;
        lerArquivo();
        for (int i=0;i<ambulatorios.size();i++){
            Ambulatorio c= ambulatorios.get(i);
            if(c.getId()==ambulatorio.getId()){
                ambulatorios.set(i, ambulatorio);
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
        for(int i=0;i<ambulatorios.size();i++){
            Ambulatorio c= ambulatorios.get(i);
            if(c.getId()==id){
               ambulatorios.remove(i);
               salvarArquivo();
               return true;
            }
        }
        return false;
    }

    @Override
    public Ambulatorio getById(int id) {
        lerArquivo();
        for(int i=0;i<ambulatorios.size();i++){
            Ambulatorio c = ambulatorios.get(i);
            if (c.getId()==id){
                return c;
            }
        }
        return null;    
    }

    @Override
    public List<Ambulatorio> listar() {
        lerArquivo();
        return ambulatorios;
    }
    
}
