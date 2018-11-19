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
import jpa.Serie;
import static jpa.Serie_.autor;
import jpa.Vinieta;
import session.SerieFacade;
import session.VinietaFacade;

/**
 *
 * @author jose
 */
@WebService(serviceName = "ComicWS")
@Stateless
public class ComicWS {

    @EJB
    private SerieFacade serieFacade;
    @EJB
    private VinietaFacade vinietaFacade;

    @WebMethod(operationName = "createSerie")
    @Oneway
    public void createSerie(@WebParam(name = "entity") Serie entity) {
        serieFacade.create(entity);
    }

    @WebMethod(operationName = "editSerie")
    @Oneway
    public void editSerie(@WebParam(name = "entity") Serie entity) {
        serieFacade.edit(entity);
    }

    @WebMethod(operationName = "removeSerie")
    @Oneway
    public void removeSerie(@WebParam(name = "entity") Serie entity) {
        serieFacade.remove(entity);
    }

    @WebMethod(operationName = "findSerie")
    public Serie findSerie(@WebParam(name = "id") Object id) {
        return serieFacade.find(id);
    }

    @WebMethod(operationName = "findAllSeries")
    public List<Serie> findAllSeries() {
        return serieFacade.findAll();
    }

    @WebMethod(operationName = "findRangeSeries")
    public List<Serie> findRangeSeries(@WebParam(name = "range") int[] range) {
        return serieFacade.findRange(range);
    }

    @WebMethod(operationName = "countSeries")
    public int countSeries() {
        return serieFacade.count();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "topFiveSeries")
    public List<Serie> topFiveSeries() {
        return serieFacade.topSeries(5);
    }

    /**
     * Web service operation
     * Buscar las series de un autor en concreto
     */
    @WebMethod(operationName = "searchSerieByAutor")
    public List<String> searchSerieByAutor(@WebParam(name = "autor") final String autor) {
        return serieFacade.findByAutor(String.valueOf(autor));
    }
    
    @WebMethod(operationName = "searchSerieByName")
    public List<Serie> searchSerieByName(@WebParam(name = "nombre") final String nombre) {
        return serieFacade.searchSerieByName(String.valueOf(nombre));
    }
    
    @WebMethod(operationName = "createVinieta")
    @Oneway
    public void createVinieta(@WebParam(name = "entity") Vinieta entity) {
        vinietaFacade.create(entity);
    }

    @WebMethod(operationName = "editVinieta")
    @Oneway
    public void editVinieta(@WebParam(name = "entity") Vinieta entity) {
        vinietaFacade.edit(entity);
    }

    @WebMethod(operationName = "removeVinieta")
    @Oneway
    public void removeVinieta(@WebParam(name = "entity") Vinieta entity) {
        vinietaFacade.remove(entity);
    }

    @WebMethod(operationName = "findVinieta")
    public Vinieta findVinieta(@WebParam(name = "id") Object id) {
        return vinietaFacade.find(id);
    }

    @WebMethod(operationName = "findAllVinietas")
    public List<Vinieta> findAllVinietas() {
        return vinietaFacade.findAll();
    }

    @WebMethod(operationName = "findRangeVinietas")
    public List<Vinieta> findRangeVinietas(@WebParam(name = "range") int[] range) {
        return vinietaFacade.findRange(range);
    }

    @WebMethod(operationName = "countVinietas")
    public int countVinietas() {
        return vinietaFacade.count();
    }

    /**
     * Web service operation
     * @param date to search by format YYYY-MM-DD
     * @return the list of vinietas with that date
     * @throws IllegalArgumentException if the date can not be resolved.
     */
    @WebMethod(operationName = "findVinietasByDate")
    public List<Vinieta> findVinietasByDate(@WebParam(name = "date") final String date) throws IllegalArgumentException {
        Date d = Date.valueOf(date);
        return vinietaFacade.findByDate(d);
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
    @WebMethod(operationName = "findVinietasBetweenDates")
    public List<Vinieta> findVinietasBetweenDates(@WebParam(name = "from") final String from, @WebParam(name = "to") final String to)
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
        
        return vinietaFacade.findBetweenDates(start, end);
    }
    
    /**
     * @return the top 5 vinietas ordered by puntuacion in descendent order
     */
    @WebMethod(operationName = "top5Vinietas")
    public List<Vinieta> top5VinietasPorPuntuacion() {
        return vinietaFacade.topVinietas(5);
    }

    /**
     * @return the latest 10 vinietas from newest to older
     */
    @WebMethod(operationName = "ultimasVinietas")
    public List<Vinieta> ultimasVinietas() {
        return vinietaFacade.latestVinietas(10);
    }
   
    /**
     * @return Athors from system. Not duplicated values.
     */
    @WebMethod(operationName = "findAutores")
    public List<String> findAutores() {
        return serieFacade.authors();
    }
    
    /*
    * searhVinietasBySerie(Integer idSerie)
    * Método que relaciona las dos tablas Serie y Vinieta
    * @return Listado de viñetas de una determinada serie con "idSerie"
    */
    @WebMethod(operationName = "searchVinietaBySerie")
    public List<Vinieta> searchVinietaBySerie(@WebParam(name = "serie") Object idSerie) throws IllegalArgumentException{
        return vinietaFacade.findBySerie(idSerie);            
    }
            
}
