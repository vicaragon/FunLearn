/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Xinran
 */
public class SongUI extends javax.swing.JFrame {

    /**
     * Creates new form SongUI
     */
    
    private SongController songController;
    private AudioPlayer player;
    private String audioPath;
    private int pictureIndex;
    private ArrayList<String> picturePaths;
    private ArrayList<Integer> pictureTime;
    
    //private JPanel songPanel;
    //private JLabel songTitle;
    //private PicturePanel picture;
    //private JLabel picLabel;
    
    public SongUI() {
        initComponents();
        setSize(1000, 750);
        //songPanel = new JPanel(new BorderLayout());
        //setContentPane(songPanel);
        songController = new SongController(this);
    }
    
    public SongUI(int songNumber){
        this();
        //songTitle = new JLabel("",SwingConstants.CENTER);
        //songTitle.setSize(100,800);
        //songTitle.setBorder(new BevelBorder(BevelBorder.RAISED));
        //songTitle.setFont(new Font("Serif", Font.PLAIN, 40));
        jLabel1.setSize(100,800);
        jLabel1.setBorder(new BevelBorder(BevelBorder.RAISED));
        jLabel1.setFont(new Font("Serif", Font.PLAIN, 40));
        songController.loadSong(songNumber);
        songController.loadSongEntry(this);
        //songPanel.add(songTitle,BorderLayout.NORTH);
        //picLabel = new JLabel();
        //songPanel.add(picLabel,BorderLayout.CENTER);
        setVisible(true);
    }
    
    public void setSongName(String name){
        //songTitle.setText(name);
        jLabel1.setText(name);
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
    
    /*class PicturePanel extends JPanel {
        @Override
        public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D myGraphics = (Graphics2D)g;
        if (!picturePaths.isEmpty()){
            Image pic = new ImageIcon(picturePaths.get(pictureIndex)).getImage();
            g.drawImage(pic,0,0,null);
        }
        }
    }*/
    
    public void play() {
        
        SwingWorker songWorker = new SwingWorker(){

            @Override
            protected Object doInBackground() throws Exception {
                for (int i=0; i<picturePaths.size();i++){
            try {
                //pictureIndex = i;
                pictureIndex = i;
                //picture = new PicturePanel();
                //picLabel.setIcon(new ImageIcon(picturePaths.get(pictureIndex)));
                //songPanel.add(picLabel,BorderLayout.CENTER);
                //picLabel.repaint();
                jLabel2.setIcon(new ImageIcon(picturePaths.get(pictureIndex)));
                jLabel2.repaint();
                Thread.sleep(pictureTime.get(pictureIndex)*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SongUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                return null;
            }
        };
        songWorker.execute();
        
        /*for (int i=0; i<picturePaths.size();i++){
            try {
                //pictureIndex = i;
                pictureIndex = i;
                //picture = new PicturePanel();
                //picLabel.setIcon(new ImageIcon(picturePaths.get(pictureIndex)));
                //songPanel.add(picLabel,BorderLayout.CENTER);
                //picLabel.repaint();
                jLabel2.setIcon(new ImageIcon(picturePaths.get(pictureIndex)));
                jLabel2.repaint();
                Thread.sleep(pictureTime.get(pictureIndex)*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SongUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        
    }
    
    public void start(){
        player = new AudioPlayer(new File(audioPath));
        SwingWorker songWorker = new SwingWorker(){

            @Override
            protected Object doInBackground() throws Exception {
                player.play();
                System.out.println("Playing");
                return null;
            }
        };
        songWorker.execute();
        this.play();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        jLabel2.setText("           ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the song?", "Confirm close", JOptionPane.YES_NO_OPTION);
        if(i == 0) {
            AudioPlayer.getClip().stop();
            this.setVisible(false);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(SongUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SongUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SongUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SongUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        SongUI songWindow = new SongUI(0);
        //songWindow.setSongName("Sample Song");
        //songWindow.setAudioPath("song/blues.wav");
        //ArrayList<String> paths = new ArrayList<String>();
        //paths.add("pic/butterflies.png");
        //paths.add("pic/daffodils.jpg");
        //songWindow.setPicturePaths(paths);
        //ArrayList<Integer> time = new ArrayList<Integer>();
        //time.add(5);
        //time.add(10);
        //songWindow.setPictureTime(time);
        songWindow.setVisible( true );
        songWindow.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    
}
