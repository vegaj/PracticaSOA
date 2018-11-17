/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ws.Vinieta;

import java.util.List;

public class VinietaService implements CrudService<Vinieta>{

    private static VinietaService singleton = null;

    private final ws.WSVinieta port;

    private VinietaService() {
        ws.WSVinieta_Service service = new ws.WSVinieta_Service();
        port = service.getWSVinietaPort();
    }

    public static VinietaService getInstance() {
        if(singleton == null){
            singleton = new VinietaService();
        }
        return singleton;
    }

    @Override
    public int count() {
        return port.count();
    }

    @Override
    public void create(Vinieta entity) {
        port.create(entity);
    }

    @Override
    public void edit(Vinieta entity) {
        port.edit(entity);
    }

    @Override
    public Vinieta find(Object id) {
        return port.find(id);
    }

    @Override
    public List<Vinieta> findAll() {
        return port.findAll();
    }

    @Override
    public void remove(Vinieta entity) {
        port.remove(entity);
    }
}
