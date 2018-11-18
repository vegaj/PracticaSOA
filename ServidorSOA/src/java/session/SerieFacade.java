/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import jpa.Serie;
import jpa.Vinieta;

/**
 *
 * @author jose
 */
@Stateless
public class SerieFacade extends AbstractFacade<Serie> {

    @PersistenceContext(unitName = "ServidorSOAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SerieFacade() {
        super(Serie.class);
    }
        
    /**
     * @return a list with all the different authors
     */
    public List<String> authors(){
        TypedQuery tq = em.createQuery("SELECT DISTINCT S.autor FROM Serie S ORDER BY S.autor ASC", Serie.class);
        return tq.getResultList();      
    }
    
    /**
     * @param name
     * @return a list of series with the given name in it.
     */
    public List<Serie> searchSerieByName(String name) {
        if(name == null){
            throw new RuntimeException("Null name");
        }
        List<Serie> result;
        
        TypedQuery tq = em.createQuery("SELECT s FROM Serie S WHERE s.nombre = :name", Serie.class);
        tq.setParameter("name", name);
        result = tq.getResultList();
        return result;        
    }
    
    public List<String> findByAutor(String author){
        if(author == null){
            throw new RuntimeException("Null author");
        }
        
        List<String> result;
        String autor = '%' + author + '%';
        
        TypedQuery tq = em.createQuery("SELECT s.nombre FROM Serie S WHERE s.autor LIKE :autor", Serie.class);
        tq.setParameter("autor", autor);
        result = tq.getResultList();
        return result;
    }
    
}
