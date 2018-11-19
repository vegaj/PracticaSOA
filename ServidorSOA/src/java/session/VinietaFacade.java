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
    
    /**
     * Búsqueda de Viñeta por fecha.
     * @param date La fecha que buscar
     * @return Una lista con las viñetas creadas en esa fecha.
     */
    public List<Vinieta> findByDate(Date date){
        if (date == null) {
            throw new RuntimeException("Null date");
        }
        
        TypedQuery tq = em.createQuery("SELECT v FROM Vinieta V WHERE v.fecha = :date", Vinieta.class);
        tq.setParameter("date", date);
        return tq.getResultList();
    }
    
    /**
     * Búsqueda entre rango de fechas
     * @param from Inicio del rango. Por defecto la menor fecha posible.
     * @param to Fin del rango. Por defecto el mayor rango posible.
     * @return La lista de Viñetas con fechas en ese rango.
     */
    public List<Vinieta> findBetweenDates(Date from, Date to) {
         if (from == null || to == null) {
            throw new RuntimeException("Null date");
        }
         
        List<Vinieta> result;
        
        TypedQuery tq = em.createQuery("SELECT v FROM Vinieta v WHERE v.fecha BETWEEN :from AND :to", Vinieta.class);
        tq.setParameter("from", from);
        tq.setParameter("to", to);
        result = tq.getResultList();
        
        return result;
    }
    
    /**
     * Devuelve las mejores Viñetas
     * @param limit el número de Viñetas
     * @return hasta <i>limit</i> Viñetas ordenadas de mejor a peor puntuación
     */
    public List<Vinieta> topVinietas(int limit) {  
        TypedQuery tq = em.createQuery("SELECT v from Vinieta v ORDER BY v.puntuacion DESC", Vinieta.class);
        tq.setMaxResults(limit);
        return tq.getResultList();
    }
    
    /**
     * Últimas viñetas
     * @param limit el número de Viñetas
     * @return Una lista con las <i>limit</i> últimas Viñetas, de más nuevas a más antiguas.
     */
    public List<Vinieta> latestVinietas(int limit){
        TypedQuery tq = em.createQuery("SELECT v FROM Vinieta v ORDER BY v.fecha DESC", Vinieta.class);
        tq.setMaxResults(limit);
        return tq.getResultList();
    }    
    
    /**
     * Las Viñetas pertenecientes a una serie
     * @param idSerie El identificador de la serie por la que buscar
     * @return La lista de Viñetas asociadas a dicha serie
     */
    public List<Vinieta> findBySerie(Object idSerie) {        
        TypedQuery tq = em.createQuery("SELECT v FROM Vinieta V WHERE v.idserie = :idSerie", Vinieta.class);
        tq.setParameter("idSerie", idSerie);
        return tq.getResultList();
    }
    
}
