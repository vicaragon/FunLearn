/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.BevelBorder;
/**
 *
 * @author Xinran
 */
public class StoryUI extends javax.swing.JFrame {

    /**
     * Creates new form StoryUI
     */
    
    //private JPanel storyPanel;
    //private JLabel storyTitle;
    //private JTextArea storyLines;
    //private PicturePanel picture;
    
    private StoryController storyController;
    private AudioPlayer player;
    private String audioPath;
    private int pictureIndex;
    private ArrayList<String> storyText;
    private ArrayList<String> picturePaths;
    private ArrayList<Integer> pictureTime;
    
    public StoryUI() {
        initComponents();
        setSize(1000, 750);
        storyController = new StoryController(this);
    }
    
    public StoryUI(int storyNumber){
        this();
        jLabel1.setSize(100,800);
        //jLabel1.setBorder(new BevelBorder(BevelBorder.RAISED));
        jLabel1.setFont(new Font("Serif", Font.PLAIN, 25));
        storyController.loadStory(storyNumber);
        storyController.loadStoryEntry(this);
        setVisible(true);
    }
    
    public void setStoryName(String name){
        //songTitle.setText(name);
        jLabel1.setText(name);
    }
    
    public void setAudioPath(String path){
        audioPath = path;
    }
    
    public void setStoryText(ArrayList<String> text){
        storyText = text;
    }
    
    public void setPicturePaths(ArrayList<String> path){
        picturePaths = path;
    }
    
    public void setPictureTime(ArrayList<Integer> time){
        pictureTime = time;
    }
    
    public void play() {
        
        SwingWorker songWorker = new SwingWorker(){

            @Override
            protected Object doInBackground() throws Exception {
                for (int i=0; i<picturePaths.size();i++){
            try {
                pictureIndex = i;
                jLabel2.setIcon(new ImageIcon(picturePaths.get(pictureIndex)));
                jLabel2.repaint();
                jTextArea1.setText(storyText.get(pictureIndex));
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
                pictureIndex = i;
                jLabel2.setIcon(new ImageIcon(picturePaths.get(pictureIndex)));
                jLabel2.repaint();
                jTextArea1.setText(storyText.get(pictureIndex));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
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

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("          ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(87, 87, 87))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the story?", "Confirm close", JOptionPane.YES_NO_OPTION);
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
            java.util.logging.Logger.getLogger(StoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        StoryUI storyWindow = new StoryUI(2);
        storyWindow.setVisible( true );
        storyWindow.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
