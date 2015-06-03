/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;



/**
 *
 * @author Xinran
 */
public class SongUI extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form SongUI
     */
    
    private SongController songController;
    private AudioPlayer player;
    private String audioPath;
    private int pictureIndex;
    private ArrayList<String> picturePaths;
    private ArrayList<Integer> pictureTime;
    private Thread t;
    
    public SongUI() {
        initComponents();
        //songController = new SongController(this);
        jPanel1 = new JPanel();
        jPanel1.setLayout(new BorderLayout());
    }
    
    public SongUI(int songNumber) throws IOException{
        this();
        //songController.loadSong(songNumber);
        //songController.loadSongEntry(this);
        jLabel1 = new JLabel("sample");
        jPanel1.add(jLabel1,BorderLayout.NORTH);
    }
    
    public void setSongName(String name){
        jLabel1 = new JLabel(name);
    }
    
    public void setAudioPath(String path){
        audioPath = path;
    }
    
    public void setPicturePaths(ArrayList<String> path){
        picturePaths = path;
    }
    
    public void setPictureTime(ArrayList<Integer> time){
        pictureTime = time;
    }
    
    class PicturePanel extends JPanel {
        @Override
        public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D myGraphics = (Graphics2D)g;
        if (!picturePaths.isEmpty()){
            Image pic = new ImageIcon(picturePaths.get(pictureIndex)).getImage();
            g.drawImage(pic,0,0,null);
        }
        }
    }
    
    public void paintComponent(Graphics g){
        PicturePanel picture = new PicturePanel();
        jPanel1.add(picture,BorderLayout.CENTER);
    }
    
    public void start(){
        t = new Thread(this);
        player = new AudioPlayer();
        player.setAudioFile(new File(audioPath));
        Thread p = new Thread(player);
        t.start();
        p.start();
    }
    
    public static void main(String args[]) {

        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
            */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(GameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(GameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(GameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(GameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            //</editor-fold>
            
            /* Create and display the form */
            JFrame window = new JFrame( "Song Test" );
            window.setSize(800, 800);
            window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            SongUI songPanel = new SongUI(0);
            songPanel.setSongName("Sample Song");
            songPanel.setAudioPath("song/blues.wav");
            ArrayList<String> paths = new ArrayList<String>();
            paths.add("pic/butterflies.png");
            paths.add("pic/daffodils.jpg");
            songPanel.setPicturePaths(paths);
            ArrayList<Integer> time = new ArrayList<Integer>();
            time.add(5);
            time.add(10);
            
            window.add( songPanel );
            window.setVisible( true );
        } catch (IOException ex) {
            Logger.getLogger(SongUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
    }
        /*Method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        for (int i=0; i<picturePaths.size();i++){
            try {
                pictureIndex = i;
                repaint();
                Thread.sleep(pictureTime.get(i));
            } catch (InterruptedException ex) {
                Logger.getLogger(SongUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
