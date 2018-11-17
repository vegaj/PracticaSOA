/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

interface CrudService<T> {
    int count();
    void create(T entity);
    void edit(T entity);
    T find(Object id);
    List<T> findAll();
    void remove(T entity);
}
