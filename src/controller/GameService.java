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
public class GameService {
    private EntityManager manager;
    public GameService(EntityManager manager) {
        this.manager = manager;
    }
    
    public Game createGame() {
        return null;
    }
    public Game readGame() {
        Game game = manager.find(Game.class, gameID);
    	 return game;  
    }
    public List<Game> readAll() {
         TypedQuery<Game> query = manager.createQuery("SELECT e FROM game e", Game.class);
    	 List<Game> result =  query.getResultList();

    	 return result;      
    }
    public Game updateGame() {
        return null;
    }
    public Game deleteGame() {
        return null;
    }
}
