/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Story;
import javax.persistence.EntityManager;
/**
 *
 * @author rramsis
 */
public class StoryService {
    private EntityManager manager;
    public StoryService(EntityManager manager) {
        this.manager = manager;
    }
    public Story creatStory() {
        return null;
    }
    public Story readStory() {
        return null;
    }
    public Story updateStory() {
        return null;
    }
    public Story deleteStory() {
        return null;
    }
}
