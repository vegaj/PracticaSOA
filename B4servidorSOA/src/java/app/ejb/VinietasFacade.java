/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ejb;

import app.entity.Vinietas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Félix
 */
@Stateless
public class VinietasFacade extends AbstractFacade<Vinietas> {

    @PersistenceContext(unitName = "B4servidorSOAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VinietasFacade() {
        super(Vinietas.class);
    }
    
}
