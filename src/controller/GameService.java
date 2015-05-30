/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.*;
import javax.persistence.EntityManager;
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
        return null;
    }
    public Game readGame() {
        return null;
    }
    public Game updateGame() {
        return null;
    }
    public Game deleteGame() {
        return null;
    }
}
