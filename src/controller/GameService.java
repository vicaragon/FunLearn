/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.*;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author rramsis
 */
public class GameService {
    private EntityManager manager;
    public GameService(EntityManager manager) {
        this.manager = manager;
    }
    
    public Game creatGame() {
        
    }
    public Game readGame() {
        
    }
    public List<Game> readAll() {
         TypedQuery<Game> query = manager.createQuery("SELECT e FROM courselist e", Game.class);
    	 List<Game> result =  query.getResultList();

    	 return result;      
    }
    public Game updateGame() {
        
    }
    public Game deleteGame() {
        
    }
}
