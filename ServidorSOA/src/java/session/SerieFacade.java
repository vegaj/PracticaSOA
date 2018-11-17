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
     * @return a list with all the different authors
     * MAngeles
     */
    public List<String> authors(){
        throw new UnsupportedOperationException("Not implemented yet");    
    }
    
    /**
     * 
     * @param name
     * @return a list of series with the given name in it.
     * MAngeles
     */
    public List<Serie> searchSerieByName(String name) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
