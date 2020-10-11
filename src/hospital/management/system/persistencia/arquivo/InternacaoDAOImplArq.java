package hospital.management.system.persistencia.arquivo;

import hospital.management.system.entidades.Internacao;
import hospital.management.system.persistencia.InternacaoDAO;
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

public class InternacaoDAOImplArq implements InternacaoDAO{
     private final String filename = "Internação.dat";
    private List<Internacao> internacoes = new ArrayList<Internacao>();
    
    private void salvarArquivo() {
        try {
            ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream(filename));
            objout.writeObject(internacoes);
            objout.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InternacaoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
            Logger.getLogger(InternacaoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void lerArquivo(){
        try {
            ObjectInputStream objin = new ObjectInputStream(new FileInputStream(filename));
            internacoes = (List<Internacao>)objin.readObject();
            objin.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InternacaoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(InternacaoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Internacao internacao) {
        boolean existe=false;
        lerArquivo();
        for(int i=0;i<internacoes.size();i++){
            Internacao l= internacoes.get(i);
            if (l.getId()==internacao.getId()){
                existe=true;
                break;
            }
            
        }
        if(!existe){
            internacoes.add(internacao);
            salvarArquivo();
            System.out.println("Cadastrado com sucesso!");
        } else {
            System.out.println("Internação já cadastrada!");
        }
        
    }

    @Override
    public void editar(Internacao internacao) {
        boolean existe=false;
        lerArquivo();
        for (int i=0;i<internacoes.size();i++){
            Internacao l= internacoes.get(i);
            if(l.getId()==internacao.getId()){
                internacoes.set(i, internacao);
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
        for(int i=0;i<internacoes.size();i++){
            Internacao l= internacoes.get(i);
            if(l.getId()==id){
               internacoes.remove(i);
               salvarArquivo();
               return true;
            }
        }
        return false;
    }

    @Override
    public Internacao getById(int id) {
        lerArquivo();
        for(int i=0;i<internacoes.size();i++){
            Internacao l = internacoes.get(i);
            if (l.getId()==id){
                return l;
            }
        }
        return null;
    }

    @Override
    public List<Internacao> listar() {
        lerArquivo();
        return internacoes;
    }
}
