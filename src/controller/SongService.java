/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Song;
import javax.persistence.EntityManager;
/**
 *
 * @author rramsis
 */
public class SongService {
    private EntityManager manager;
    public SongService(EntityManager manager) {
        this.manager = manager;
    }
    public Song creatSong() {
        return null;
    }
    public Song readSong() {
        return null;
    }
    public Song updateSong() {
        return null;
    }
    public Song deleteSong() {
        return null;
    }
}
