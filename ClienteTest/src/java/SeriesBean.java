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
import ws.SeriesWS_Service;

/**
 *
 * @author Félix
 */
@Named(value = "seriesBean")
@SessionScoped
public class SeriesBean implements Serializable {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/SeriesWS/SeriesWS.wsdl")
    private SeriesWS_Service service;
    private Serie s;

    public Serie getS() {
        return s;
    }

    public void setS(Serie s) {
        this.s = s;
    }
    /**
     * Creates a new instance of SeriesBean
     */
    public SeriesBean() {
    }
    
    public String crear(){
        service.getSeriesWSPort().create(s);
        return "index";
    }

    @PostConstruct
    public void init(){
        
    }
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
