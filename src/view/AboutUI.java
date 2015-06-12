/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;

/**
 *
 * @author Sonam
 */
public class AboutUI extends javax.swing.JPanel {
    Image resizedImage;
    /**
     * Creates new form AboutUI
     */
    public AboutUI() {
        try {
            InputStream inputStream = new FileInputStream("pic/learn.jpg");
            Image img = ImageIO.read(inputStream);
            resizedImage = img.getScaledInstance(454, 151, 0);
        }
        catch(Exception e) {
            e.getMessage();
        }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new ImageIcon("pic/frugal_logo.jpg"));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 712, 106));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("FUN LEARN SOFTWARE");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 520, 100));

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 0));
        jButton1.setText("Start Playing");
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, 250, 100));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("This is a learning software developed mainly for visually impared kids of 3-5 years");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 670, 42));

        jLabel4.setIcon(new ImageIcon(resizedImage));
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 650, 190));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sonam\\Desktop\\bgmain.jpg")); // NOI18N
        jLabel5.setText("jLabel5");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 1050));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SetupUI.getCardLayout().next(SetupUI.getCards());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
