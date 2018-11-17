/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import jpa.Vinieta;
import session.VinietaFacade;

/**
 *
 * @author jose
 */
@WebService(serviceName = "VinietasWS")
@Stateless()
public class VinietasWS {

    @EJB
    private VinietaFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Vinieta entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Vinieta entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Vinieta entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Vinieta find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Vinieta> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Vinieta> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    /**
     * Web service operation
     * @param date to search by format YYYY-MM-DD
     * @return the list of vinietas with that date
     * @throws IllegalArgumentException if the date can not be resolved.
     */
    @WebMethod(operationName = "findByDate")
    public List<Vinieta> findByDate(@WebParam(name = "date") final String date) throws IllegalArgumentException {
        Date d = Date.valueOf(date);
        return ejbRef.findByDate(d);
    }

    /**
     * Web service operation
     * 
     * Dates in format YYYY-MM-DD.
     * @param from minimum date to show. If null, then the minimum will be used.
     * @param to max date to show. If null, then the max will be used.
     * @return the vinietas between those dates
     * @throws IllegalArgumentException if a date is sent and can not be resolved.
     */
    @WebMethod(operationName = "findBetweenDates")
    public List<Vinieta> findBetweenDates(@WebParam(name = "from") final String from, @WebParam(name = "to") final String to)
            throws IllegalArgumentException{
        Date start, end;
        if(from == null) {
            start = Date.valueOf(LocalDate.MIN);
        } else {
            start = Date.valueOf(from);
        }
        
        if (to == null) {
            end = Date.valueOf(LocalDate.MAX);
        } else {
            end = Date.valueOf(to);
        }
        
        return ejbRef.findBetweenDates(start, end);
    }
    
    /**
     * @return the top 5 vinietas ordered by puntuacion in descendent order
     */
    @WebMethod(operationName = "top5Vinietas")
    public List<Vinieta> top5VinietasPorPuntuacion() {
        return ejbRef.topVinietas(5);
    }

    /**
     * @return the latest 10 vinietas from newest to older
     */
    @WebMethod(operationName = "ultimasVinietas")
    public List<Vinieta> ultimasVinietas() {
        return ejbRef.latestVinietas(10);
    }
}
