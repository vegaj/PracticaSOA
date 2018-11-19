/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

import ws.ComicWS;
import ws.ComicWS_Service;
import ws.Serie;
import ws.Vinieta;

public class ComicService {

    private static ComicService singleton = null;

    private final ComicWS port;
    
    private ComicService() {
        ComicWS_Service service = new ComicWS_Service();
        port = service.getComicWSPort();
    }


    public static ComicService getInstance() {
        if(singleton == null){
            singleton = new ComicService();
        }
        return singleton;
    }

    public int countSeries() {
        return port.countSeries();
    }

    public void createSerie(Serie entity) {
        port.createSerie(entity);
    }

    public void editSerie(Serie entity) {
        port.editSerie(entity);
    }

    public Serie findSerie(Object id) {
        return port.findSerie(id);
    }

    public List<Serie> findAllSeries() {
        return port.findAllSeries();
    }

    public void removeSerie(Serie entity) {
        port.removeSerie(entity);
    }

    public int countVinietas() {
        return port.countVinietas();
    }

    public void createVinieta(Vinieta entity) {
        port.createVinieta(entity);
    }

    public void editVinieta(Vinieta entity) {
        port.editVinieta(entity);
    }

    public Vinieta findVinieta(Object id) {
        return port.findVinieta(id);
    }

    public List<Vinieta> findAllVinietas() {
        return port.findAllVinietas();
    }

    public void removeVinieta(Vinieta entity) {
        port.removeVinieta(entity);
    }

    public List<Vinieta> searchVinietasBySerie(Object id) {
        return port.searchVinietaBySerie(id);
    }

    public List<Vinieta> topVinietas() {
        return port.top5Vinietas();
    }

    public List<Serie> topSeries() {
        return port.topFiveSeries();
    }
}
