/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import ws.Serie;

public class SerieService implements CrudService<Serie>{

    private static SerieService singleton = null;

    private final ws.WSSerie port;
    
    private SerieService() {
        ws.WSSerie_Service service = new ws.WSSerie_Service();
        port = service.getWSSeriePort();
    }


    public static SerieService getInstance() {
        if(singleton == null){
            singleton = new SerieService();
        }
        return singleton;
    }

    @Override
    public int count() {
        return port.count();
    }

    @Override
    public void create(Serie entity) {
        port.create(entity);
    }

    @Override
    public void edit(Serie entity) {
        port.edit(entity);
    }

    @Override
    public Serie find(Object id) {
        return port.find(id);
    }

    @Override
    public List<Serie> findAll() {
        return port.findAll();
    }

    @Override
    public void remove(Serie entity) {
        port.remove(entity);
    }
}
