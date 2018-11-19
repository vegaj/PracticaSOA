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
     * Busca los nombre de los autores
     * @return Una lista con todos los autores de series
     */
    public List<String> authors(){
        TypedQuery tq = em.createQuery("SELECT DISTINCT S.autor FROM Serie S ORDER BY S.autor ASC", Serie.class);
        return tq.getResultList();      
    }
    
    /**
     * Buscar no estricta de serie por nombre
     * @param name el nombre de la serie o término de búsqueda.
     * @return una lista de las series que encajan con <i>name</i>.
     */
    public List<Serie> searchSerieByName(String name) {
        if(name == null){
            throw new RuntimeException("Null name");
        }

        name = '%' + name + '%';
        TypedQuery tq = em.createQuery("SELECT s FROM Serie S WHERE s.nombre LIKE :name", Serie.class);
        tq.setParameter("name", name);
        return tq.getResultList();
    }
    
    /**
     * Buscar lista de nombres de series por autores no estricta.
     * @param author nombre de autor o término por el que buscar
     * @return Lista con los nombres de las series que encajan con <i>author</i>
     */
    public List<String> findByAutor(String author){
        if(author == null){
            throw new RuntimeException("Null author");
        }
        String autor = '%' + author + '%';
        
        TypedQuery tq = em.createQuery("SELECT s.nombre FROM Serie S WHERE s.autor LIKE :autor", Serie.class);
        tq.setParameter("autor", autor);
        return tq.getResultList();
       
    }
    
    /**
     * Mejores series por puntuacion
     * @param limit número de series a mostrar
     * @return Hasta <i>limit</i> series ordenadas de mejor a peor puntuación
     */
    public List<Serie> topSeries(int limit) {
        if (limit < 0) limit = 5;
        
        TypedQuery tq =em.createQuery("SELECT s FROM Serie s ORDER By s.puntuacion DESC", Serie.class);
        tq.setMaxResults(limit);
        return tq.getResultList();
     
    }
}
