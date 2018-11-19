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

    /**
     * Mejores series por puntuacion
     * @return Hasta <i>5</i> series ordenadas de mejor a peor puntuación
     */
    @WebMethod(operationName = "topFiveSeries")
    public List<Serie> topFiveSeries() {
        return serieFacade.topSeries(5);
    }

    /**
     * Buscar lista de nombres de series por autores no estricta.
     * @param autor nombre de autor o término por el que buscar
     * @return Lista con los nombres de las series que encajan con <i>author</i>
     */
    @WebMethod(operationName = "searchSerieByAutor")
    public List<String> searchSerieByAutor(@WebParam(name = "autor") final String autor) {
        return serieFacade.findByAutor(String.valueOf(autor));
    }
    
    /**
     * Buscar no estricta de serie por nombre
     * @param nombre el nombre de la serie o término de búsqueda.
     * @return una lista de las series que encajan con <i>name</i>.
     */
    @WebMethod(operationName = "searchSerieByName")
    public List<Serie> searchSerieByName(@WebParam(name = "nombre") final String nombre) {
        return serieFacade.searchSerieByName(String.valueOf(nombre));
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
     * Búsqueda entre rango de fechas
     * El formato de fecha debe ser <b>YYYY-MM-DD</b>
     * @param from Inicio del rango. Por defecto la menor fecha posible.
     * @param to Fin del rango. Por defecto el mayor rango posible.
     * @return La lista de Viñetas con fechas en ese rango.
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
     * Devuelve las mejores Viñetas
     * @return hasta <i>5</i> Viñetas ordenadas de mejor a peor puntuación
     */
    @WebMethod(operationName = "top5Vinietas")
    public List<Vinieta> top5VinietasPorPuntuacion() {
        return vinietaFacade.topVinietas(5);
    }
    
    /**
     * Últimas viñetas
     * @return Una lista con las <i>5</i> últimas Viñetas, de más nuevas a más antiguas.
     */
    @WebMethod(operationName = "ultimasVinietas")
    public List<Vinieta> ultimasVinietas() {
        return vinietaFacade.latestVinietas(10);
    }
   
    /**
     * Busca los nombre de los autores
     * @return Una lista con todos los autores de series
     */
    @WebMethod(operationName = "findAutores")
    public List<String> findAutores() {
        return serieFacade.authors();
    }
    
    /**
     * Las Viñetas pertenecientes a una serie
     * @param idSerie El identificador de la serie por la que buscar
     * @return La lista de Viñetas asociadas a dicha serie
     */
    @WebMethod(operationName = "searchVinietaBySerie")
    public List<Vinieta> searchVinietaBySerie(@WebParam(name = "serie") Object idSerie) throws IllegalArgumentException{
        return vinietaFacade.findBySerie(idSerie);            
    }
       
    /**
     * AUTOGENERADOS
     */
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

}
