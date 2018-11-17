/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.xml.ws.WebServiceRef;
import ws.Serie;
import ws.SeriesWS;
import ws.SeriesWS_Service;

/**
 *
 * @author Félix
 */
@Named(value = "seriesBean")
@SessionScoped
public class SeriesBean implements Serializable {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/SeriesWS/SeriesWS?wsdl")
    private SeriesWS_Service service;
    
    /* VARIABLES */
    
    private SeriesWS port;
    private Serie serie;

    /**
     * Creates a new instance of SeriesBean
     */
    public SeriesBean() {
    }
    
    @PostConstruct
    public void init(){
        port = service.getSeriesWSPort();
        serie = new Serie();
    }
    
    /* GETTERS AND SETTERS */

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
    
    /* METODOS PARA PROBAR LOS SERVICIOS */
    
    public String nuevaSerie(){
        //redirige al formulario para introducir los datos de la serie
        return "nuevaSerie.xhtml";
    }
    
    public String crear(){
        //llama al servicio para insertar la serie en la BD
        port.create(serie);
        // una vez se ha insertado se vuelve a inicializar para que se pueda volver a utilizar
        this.serie = new Serie();
        return "index.xhtml";
    }
    
    public String borrarSerie(Serie s){
        //borra la serie de la base de datos
        port.remove(s);
        return "index.xhtml";
    }
    
    public String editarSerie(Serie s){
        return "editarSerie.xhtml";
    }
    
    public String mostrarSeries(){
        return "listadoSeries.xhtml";
    }
    
    
    /* OPERACIONES DE LOS SERVICIOS */ 

    private void create(ws.Serie entity) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.SeriesWS port = service.getSeriesWSPort();
        port.create(entity);
    }

    private void edit(ws.Serie entity) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.SeriesWS port = service.getSeriesWSPort();
        port.edit(entity);
    }

    private int count() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.SeriesWS port = service.getSeriesWSPort();
        return port.count();
    }

    private Serie find(java.lang.Object id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.SeriesWS port = service.getSeriesWSPort();
        return port.find(id);
    }

    private java.util.List<ws.Serie> findAll() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.SeriesWS port = service.getSeriesWSPort();
        return port.findAll();
    }

    private java.util.List<ws.Serie> findRange(java.util.List<java.lang.Integer> range) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.SeriesWS port = service.getSeriesWSPort();
        return port.findRange(range);
    }

    private void remove(ws.Serie entity) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.SeriesWS port = service.getSeriesWSPort();
        port.remove(entity);
    }
    
}
