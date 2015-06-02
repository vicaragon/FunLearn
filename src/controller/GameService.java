/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.*;
import java.util.*;
import javax.persistence.*;
import model.Game;
import static model.Game_.gameID;

/**
 *
 * @author rramsis
 */
public class GameService implements Servicer {
    private EntityManager manager;
    public GameService(EntityManager manager) {
        this.manager = manager;
    }
    
    public Game create() {
        return null;
    }
    public Game read() {
        Game game = manager.find(Game.class, gameID);
    	 return game;  
    }
    public List<Game> readAll() {
         TypedQuery<Game> query;
        query = manager.createQuery("SELECT e FROM game e", Game.class);
    	 List<Game> result =  query.getResultList();

    	 return result;      
    }
    public Game update() {
        return null;
    }
    public Game delete() {
        return null;
    }
}
