/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Song;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
/**
 *
 * @author rramsis
 */
public class SongService implements Servicer {
    private EntityManager manager;
    public SongService(EntityManager manager) {
        this.manager = manager;
    }
    public Song create() {
        return null;
    }
    
    public Song read() {
        //Song song = manager.find(Song.class, songID);
        return null;
    }
    
    
    public List<Song> readAll() {
         TypedQuery<Song> query;
        query = manager.createQuery("SELECT e FROM song e", Song.class);
    	 List<Song> result =  query.getResultList();

    	 return result;      
    }
    
    public Song update() {
        return null;
    }
    public Song delete() {
        return null;
    }
}
