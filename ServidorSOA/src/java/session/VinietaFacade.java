/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.sql.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import jpa.Vinieta;

/**
 *
 * @author jose
 */
@Stateless
public class VinietaFacade extends AbstractFacade<Vinieta> {

    @PersistenceContext(unitName = "ServidorSOAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VinietaFacade() {
        super(Vinieta.class);
    }
    
    
    public List<Vinieta> findByDate(Date date){
        if (date == null) {
            throw new RuntimeException("Null date");
        }
        
        List<Vinieta> result;
        
        TypedQuery tq = em.createQuery("SELECT v FROM Vinieta V WHERE v.fecha = :date", Vinieta.class);
        tq.setParameter("date", date);
        result = tq.getResultList();
        return result;
    }
    
    
    public List<Vinieta> findBetweenDates(Date from, Date to) {
         if (from == null || to == null) {
            throw new RuntimeException("Null date");
        }
         
        List<Vinieta> result;
        
        TypedQuery tq = em.createQuery("SELECT v FROM Vinieta V WHERE v.fecha BETWEEN :from AND :to", Vinieta.class);
        tq.setParameter("from", from);
        tq.setParameter("to", to);
        result = tq.getResultList();
        
        return result;
    }
    
    public List<Vinieta> topVinietas() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    
    public List<Vinieta> latestVinietas(){
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

