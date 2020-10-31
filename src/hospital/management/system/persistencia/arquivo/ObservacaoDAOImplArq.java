
package hospital.management.system.persistencia.arquivo;

import hospital.management.system.entidades.Observacao;
import hospital.management.system.persistencia.ObservacaoDAO;
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

public class ObservacaoDAOImplArq implements ObservacaoDAO {
    
    private final String filename = "observacao.dat";
    private List<Observacao> observacoes = new ArrayList<Observacao>();
    
    private void salvarArquivo(){
        try {
            ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream(filename));
            objout.writeObject(observacoes);
            objout.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObservacaoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
            Logger.getLogger(ObservacaoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void lerArquivo(){
        try {
            ObjectInputStream objin = new ObjectInputStream(new FileInputStream(filename));
            observacoes = (List<Observacao>)objin.readObject();
            objin.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObservacaoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ObservacaoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Observacao observacao) {
       boolean existe=false;

        lerArquivo();
        for(int i=0;i<observacoes.size();i++){
            Observacao c= observacoes.get(i);
            if (c.getId()==observacao.getId()){
                existe=true;
                break;
            }
            
        }
        if(!existe){
            observacoes.add(observacao);
            salvarArquivo();
            System.out.println("Cadastrado com sucesso!");
        } else {
            System.out.println("Consulta já cadastrada!");
        }
    }

    @Override
    public void editar(Observacao observacao) {
        boolean existe=false;
        lerArquivo();
        for (int i=0;i<observacoes.size();i++){
            Observacao c= observacoes.get(i);
            if(c.getId()==observacao.getId()){
                observacoes.set(i, observacao);
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
        for(int i=0;i<observacoes.size();i++){
            Observacao c= observacoes.get(i);
            if(c.getId()==id){
               observacoes.remove(i);
               salvarArquivo();
               return true;
            }
        }
        return false;
    }

    @Override
    public Observacao getById(int id) {
       lerArquivo();
        for(int i=0;i<observacoes.size();i++){
             Observacao c = observacoes.get(i);
            if (c.getId()==id){
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Observacao> listar() {
        lerArquivo();
        return observacoes;
    }
    
}
