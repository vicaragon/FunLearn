/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Story;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Song;
/**
 *
 * @author rramsis
 */
public class StoryService implements Servicer {
    private EntityManager manager;
    public StoryService(EntityManager manager) {
        this.manager = manager;
    }
    public Story create() {
        return null;
    }
    public Story read() {
        return null;
    }
    
    public List<Story> readAll() {
        TypedQuery<Story> query;
        query = manager.createQuery("SELECT e FROM story e", Story.class);
    	List<Story> result = query.getResultList();

    	return result;      
    }
    
    public Story update() {
        return null;
    }
    public Story delete() {
        return null;
    }
}
