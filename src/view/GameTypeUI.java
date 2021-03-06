package view;

import java.util.List;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sonam
 */
public class GameTypeUI extends javax.swing.JPanel {

    /**
     * Creates new form GameTypeUI
     */
    public GameTypeUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        song = new javax.swing.JButton();
        story = new javax.swing.JButton();
        game = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setText("Select Activity");
        add(jLabel1);
        jLabel1.setBounds(110, 100, 421, 62);

        song.setBackground(new java.awt.Color(0, 204, 204));
        song.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        song.setForeground(new java.awt.Color(204, 0, 0));
        song.setText("Song");
        buttonGroup.add(song);
        song.setPreferredSize(new java.awt.Dimension(137, 53));
        song.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                songActionPerformed(evt);
            }
        });
        add(song);
        song.setBounds(110, 290, 200, 150);

        story.setBackground(new java.awt.Color(0, 204, 204));
        story.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        story.setForeground(new java.awt.Color(204, 0, 0));
        story.setText("Story");
        buttonGroup.add(story);
        story.setPreferredSize(new java.awt.Dimension(137, 53));
        story.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storyActionPerformed(evt);
            }
        });
        add(story);
        story.setBounds(410, 290, 200, 150);

        game.setBackground(new java.awt.Color(0, 204, 204));
        game.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        game.setForeground(new java.awt.Color(204, 0, 0));
        game.setText("Game");
        buttonGroup.add(game);
        game.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameActionPerformed(evt);
            }
        });
        add(game);
        game.setBounds(710, 290, 200, 150);

        jButton1.setBackground(new java.awt.Color(204, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 204, 102));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(810, 570, 140, 70);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/bgg.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 0, 1000, 750);
    }// </editor-fold>//GEN-END:initComponents

    private void songActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_songActionPerformed
        SetupUI.setActivityType(3);
        SetupUI.getCardLayout().next(SetupUI.getCards());
    }//GEN-LAST:event_songActionPerformed

    private void storyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storyActionPerformed
        SetupUI.setActivityType(2);
        SetupUI.getCardLayout().next(SetupUI.getCards());
    }//GEN-LAST:event_storyActionPerformed

    private void gameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameActionPerformed
        List<Integer> ID = StudentsListUI.getPlayerController().getPlayerTablemodel().getPlayerIDs();
        List<String> names = StudentsListUI.getPlayerController().getPlayerTablemodel().getPlayerList();
        if ( ID == null || names == null || ID.size()== 0 || names.size()== 0 ) {
            JOptionPane.showMessageDialog(null,"Please select players to play a game","No players assigned",JOptionPane.ERROR_MESSAGE);
        } else {
                    SetupUI.setActivityType(1);
                    SetupUI.getCardLayout().next(SetupUI.getCards());
        }
    }//GEN-LAST:event_gameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SetupUI.getCardLayout().previous(SetupUI.getCards());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton game;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton song;
    private javax.swing.JButton story;
    // End of variables declaration//GEN-END:variables
}
