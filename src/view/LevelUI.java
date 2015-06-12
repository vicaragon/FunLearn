package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sonam
 */
public class LevelUI extends javax.swing.JPanel {

    /**
     * Creates new form SpeedTypeUI
     */
    public LevelUI() {
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
        speed1 = new javax.swing.JButton();
        speed2 = new javax.swing.JButton();
        speed3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Select Level");
        add(jLabel1);
        jLabel1.setBounds(110, 100, 218, 66);

        speed1.setBackground(new java.awt.Color(0, 204, 204));
        speed1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        speed1.setForeground(new java.awt.Color(204, 0, 0));
        speed1.setText("1");
        speed1.setPreferredSize(new java.awt.Dimension(137, 53));
        speed1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speed1ActionPerformed(evt);
            }
        });
        add(speed1);
        speed1.setBounds(110, 290, 190, 140);

        speed2.setBackground(new java.awt.Color(0, 204, 204));
        speed2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        speed2.setForeground(new java.awt.Color(204, 0, 0));
        speed2.setText("2");
        speed2.setPreferredSize(new java.awt.Dimension(137, 53));
        speed2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speed2ActionPerformed(evt);
            }
        });
        add(speed2);
        speed2.setBounds(400, 290, 200, 140);

        speed3.setBackground(new java.awt.Color(0, 204, 204));
        speed3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        speed3.setForeground(new java.awt.Color(204, 0, 0));
        speed3.setText("3");
        speed3.setPreferredSize(new java.awt.Dimension(137, 53));
        speed3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speed3ActionPerformed(evt);
            }
        });
        add(speed3);
        speed3.setBounds(690, 290, 190, 140);

        jButton2.setBackground(new java.awt.Color(204, 0, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 204, 102));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(810, 560, 140, 70);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/bgg.jpg"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(121, 53));
        add(jLabel2);
        jLabel2.setBounds(0, 0, 1000, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void speed2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speed2ActionPerformed
        SetupUI.setActivityLevel(1);
        SetupUI.getCardLayout().next(SetupUI.getCards());
    }//GEN-LAST:event_speed2ActionPerformed

    private void speed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speed1ActionPerformed
        SetupUI.setActivityLevel(0);
        SetupUI.getCardLayout().next(SetupUI.getCards());
    }//GEN-LAST:event_speed1ActionPerformed

    private void speed3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speed3ActionPerformed
        SetupUI.setActivityLevel(2);
        SetupUI.getCardLayout().next(SetupUI.getCards());
    }//GEN-LAST:event_speed3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SetupUI.getCardLayout().previous(SetupUI.getCards());
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton speed1;
    private javax.swing.JButton speed2;
    private javax.swing.JButton speed3;
    // End of variables declaration//GEN-END:variables
}
