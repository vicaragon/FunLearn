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
import javax.sound.sampled.*;

/**
 *
 * @author Xinran
 */
public class AudioPlayer {

    private File audioFile = null;
    private static Clip clip;
    
    public void setAudioFile(File f){
        audioFile = f;
    }
    
    public AudioPlayer(){
        
    }
    
    public AudioPlayer(File f){
        this();
        setAudioFile(f);
    }
    
    public int getAudioLength(){
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioInputStream.getFormat();
            long frames = audioInputStream.getFrameLength();
            double durationInSeconds = (frames+0.0) / format.getFrameRate();
            return (int)Math.ceil(durationInSeconds);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                audioInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
    public static Clip getClip() {
        return clip;
    }
    
    public  void play(){
        AudioInputStream stream = null;
        
        try {
            stream = AudioSystem.getAudioInputStream(audioFile);
            clip = (Clip)AudioSystem.getClip();
            
            clip.open(stream);
            clip.start();
            Thread.sleep(getAudioLength()*1000);
            //Thread.sleep(4200);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            //Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
            Thread.currentThread().interrupt();
        } finally {
            try {
                stream.close();
            } catch (IOException ex) {
                Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void stop(){
        clip.stop();
    }
    
    public static void main(String[] args){
        AudioPlayer player = new AudioPlayer(new File("song/blues.wav"));
        System.out.println(player.getAudioLength());
        //Timer songTimer = new Timer(0,player);
        //songTimer.setRepeats(false);
        //songTimer.start();
    }
}
