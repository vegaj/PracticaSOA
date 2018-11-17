/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import jpa.Serie;
import session.SerieFacade;

/**
 *
 * @author jose
 */
@WebService(serviceName = "SeriesWS")
@Stateless
public class SeriesWS {

    @EJB
    private SerieFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Serie entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Serie entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Serie entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Serie find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Serie> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Serie> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "topFiveSeries")
    public List<Serie> topFiveSeries() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     * MAngeles
     */
    
    @WebMethod(operationName = "findAutores")
    public List<String> findAutores() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Web service operation
     * MAngeles
     * Buscar las series de un autor en concreto, con paginación de 10 en 10
     */
    @WebMethod(operationName = "searchSerieByAutor")
    public List<Serie> searchSerieByAutor(@WebParam(name="autor") final String aut) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
   
}
