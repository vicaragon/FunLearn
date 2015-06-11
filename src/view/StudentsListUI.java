package view;

import controller.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sonam
 */
public class StudentsListUI extends javax.swing.JPanel {
    
    private JTable jTable1; 
    private JTable jTable2; 
    private StudentController studentController;
    static private PlayerController playerController;
    ImageIcon icon = new ImageIcon("/pis/bg1.jpg");
    private int i;

    public StudentController getStudentController() {
        return studentController;
    }

    public void setStudentController(StudentController studentController) {
        this.studentController = studentController;
    }

    public static PlayerController getPlayerController() {
        return playerController;
    }

    public static void setPlayerController(PlayerController playerController) {
        playerController = playerController;
    }

    /**
     * Creates new form StudentsListUI
     */
    public StudentsListUI() {
        setOpaque(false);
        repaint();
        initComponents();
        studentController = new StudentController(this);
        playerController = new PlayerController(this);
        
        addJTable1();
        addJTable2();
        jTextField4.setVisible(false);
        jTextField5.setVisible(false);
        jTextField6.setVisible(false);
              
        class CircularList<E> extends ArrayList<E> {
            @Override
            public E get(int index) {
                return super.get(index % size());
            }
        }
        final CircularList<JButton> buttonsList = new CircularList<JButton>();
        buttonsList.add(jButton1);
        buttonsList.add(jButton2);
        buttonsList.add(jButton3);
        class TimerHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buttonsList.get(i++).requestFocusInWindow();
            }
        }
        TimerHandler timerHandler = new TimerHandler();
        Timer timer1 = new Timer(4000, timerHandler);
     //   timer1.start();

    }
    
    public void addJTable1() {
        //TODO: Revisit code to be removed, but keep listSelection Listener.
        jTable1 = new JTable(studentController.getTableModel());
        jTable1.getSelectionModel().addListSelectionListener(studentController);
        JScrollPane scrollpane1 = new JScrollPane(jTable1);
        jPanel3.setLayout(new BorderLayout());
    	jPanel3.add(scrollpane1, BorderLayout.CENTER);
        
        
    }
    
    public void addJTable2() {
        jTable2 = new JTable(playerController.getTableModel());
        jTable2.getSelectionModel().addListSelectionListener(playerController);
        JScrollPane scrollpane2 = new JScrollPane(jTable2);
        jPanel4.setLayout(new BorderLayout());
    	jPanel4.add(scrollpane2);
    }
    
     public void updateTable1() {
         System.out.println("hello");
    	jTable1.setModel(studentController.getTableModel());
    }
     
     public void updateTable2() {
    	jTable2.setModel(playerController.getTableModel());
    }
     
    public void setFirstNameTextField(String value) {
    	jTextField1.setText(value);
    }
    
    public void setLastNameTextField(String value) {
    	jTextField2.setText(value);
    }
     
    public void setAgeTextField(String value) {
    	jTextField3.setText(value);
    }
    
    public void setStudentID(String value) {
        jTextField4.setText(value);
    }
    
    public void setPlayerID(String value) {
        jTextField5.setText(value);
    }
    
    public void setPlayerName(String value) {
        jTextField6.setText(value);
    }
    
     // code for the Add button
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        //add a row to the table
    	String[] array = new String[jTable1.getColumnCount()];
    	array[1] = jTextField1.getText();
    	array[2] = jTextField2.getText();
    	array[3] = jTextField3.getText();
        array[4] = "0";
        array[5] = "0";
        array[6] = "0";
    	// send data to the controller to add it to the model
   	    studentController.addStudent(array);
    } 
    
    // code for the Delete button
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        int rowNumber = jTable1.getRowCount();
    	String[] array = new String[jTable1.getColumnCount()];
    	array[0] = jTextField4.getText();
        array[1] = jTextField1.getText();
    	array[2] = jTextField2.getText();
    	array[3] = jTextField3.getText();
    	// send data to the controller to add it to the model
   	    studentController.deleteStudent( rowNumber, array);
    } 
    
    // code for the Update button
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        //add a row to the table
    	int rowNumber = jTable1.getRowCount();
    	String[] array = new String[jTable1.getColumnCount()];
        array[0] = jTextField4.getText();
    	array[1] = jTextField1.getText();
    	array[2] = jTextField2.getText();
    	array[3] = jTextField3.getText();
    	// send data to the controller to add it to the model
   	    studentController.updateStudent( rowNumber, array);
    } 
     
    private void addPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) { 
        playerController.addPlayer(jTextField4.getText(), jTextField1.getText());
    }
    
    private void deletePlayerButtonActionPerformed(java.awt.event.ActionEvent evt) { 
        playerController.deletePlayer(jTextField5.getText(), jTextField6.getText());
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
         Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(icon.getImage(), 10, 10, this);
    }   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
        jLabel2 = new javax.swing.JLabel();
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(215, 240, 217));
        setBorder(new javax.swing.border.MatteBorder(new javax.swing.ImageIcon(getClass().getResource("/bg1.jpg")))); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 800));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(215, 240, 217));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("First Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 44, 90, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Age:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 80, 30));

        jTextField1.setColumns(10);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 130, 30));

        jTextField3.setColumns(10);
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 130, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 203, 100, 40));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 110, 40));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 110, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Last Name:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, 30));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 130, 30));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Results Table");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 110, 40));

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 102, 102)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 510, 160));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Add Player");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, 130, 50));

        add(jPanel1);
        jPanel1.setBounds(10, 11, 600, 646);

        jPanel2.setBackground(new java.awt.Color(215, 240, 217));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);
        jPanel2.setMinimumSize(new java.awt.Dimension(370, 610));
        jPanel2.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Play List of Students");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(140, 20, 180, 52);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Delete Player");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(160, 260, 140, 40);

        jButton6.setBackground(new java.awt.Color(0, 204, 204));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(204, 0, 0));
        jButton6.setText("Setup Game!");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(150, 450, 171, 140);

        jPanel4.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 151, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(140, 90, 181, 151);
        jPanel2.add(jTextField5);
        jTextField5.setBounds(604, 315, 6, 20);
        jPanel2.add(jTextField6);
        jTextField6.setBounds(620, 315, 6, 20);

        add(jPanel2);
        jPanel2.setBounds(610, 10, 370, 640);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        SetupUI.getCardLayout().next(SetupUI.getCards());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addButtonActionPerformed(evt);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        deletePlayerButtonActionPerformed(evt);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        addPlayerButtonActionPerformed(evt);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        updateButtonActionPerformed(evt);
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        deleteButtonActionPerformed(evt);
    }  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
