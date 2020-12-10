package hospital.management.system.persistencia.arquivo;

import hospital.management.system.entidades.Consulta;
import hospital.management.system.persistencia.ConsultaDAO;
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

public class ConsultaDAOImplArq implements ConsultaDAO {
    private final String filename = "consulta.dat";
    private List<Consulta> consultas = new ArrayList<Consulta>();
    
    private void salvarArquivo(){
        try {
            ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream(filename));
            objout.writeObject(consultas);
            objout.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConsultaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
            Logger.getLogger(ConsultaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void lerArquivo(){
        try {
            ObjectInputStream objin = new ObjectInputStream(new FileInputStream(filename));
            consultas = (List<Consulta>)objin.readObject();
            objin.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConsultaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void inserir(Consulta consulta) {
        boolean existe=false;

        lerArquivo();
        for(int i=0;i<consultas.size();i++){
            Consulta c= consultas.get(i);
            if (c.getId()==consulta.getId()){
                existe=true;
                break;
            }
            
        }
        if(!existe){
            consultas.add(consulta);
            salvarArquivo();
            System.out.println("Cadastrado com sucesso!");
        } else {
            System.out.println("Consulta já cadastrada!");
        }
        
    }

    @Override
    public void editar(Consulta consulta) {
        boolean existe=false;
        lerArquivo();
        for (int i=0;i<consultas.size();i++){
            Consulta c= consultas.get(i);
            if(c.getId()==consulta.getId()){
                consultas.set(i, consulta);
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
        for(int i=0;i<consultas.size();i++){
            Consulta c= consultas.get(i);
            if(c.getId()==id){
               consultas.remove(i);
               salvarArquivo();
               return true;
            }
        }
        return false;
    }

    @Override
    public Consulta getById(int id) {
        lerArquivo();
        for(int i=0;i<consultas.size();i++){
            Consulta c = consultas.get(i);
            if (c.getId()==id){
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Consulta> listar() {

        lerArquivo();
        return consultas;
    }
    
}
