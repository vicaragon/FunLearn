/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Xinran
 */
public class AudioPlayer implements Runnable{
    
    private File audioFile = null;
    
    public void setAudioFile(File f){
        audioFile = f;
    }
    
    public AudioPlayer(){
        
    }
    
    public AudioPlayer(File f){
        this();
        setAudioFile(f);
    }
    
    public void play(){
        AudioInputStream stream = null;
        try {
            stream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = (Clip)AudioSystem.getClip();
            
            clip.open(stream);
            clip.start();
            
            Thread.sleep(1800*1000);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stream.close();
            } catch (IOException ex) {
                Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    @Override
    public void run() {
        play();
    }
    
}
