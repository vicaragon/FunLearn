/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.SwingWorker;
import javax.swing.Timer;

/**
 *
 * @author Sonam
 */
public class GameUI extends javax.swing.JFrame {
    private final AudioPlayer judgePlayer;
    private final File correct;
    private final File wrong;
    private final CircularList<JButton> buttonsList ;
    
    private int i,j;
    private Timer timer1;
    
    private GameController gameController;
    private int gameNumber;
    private int questionNumber;
    private AudioPlayer questionPlayer;
    private AudioPlayer optionPlayer;
    private AudioPlayer answerPlayer;
    private CircularList<File> optionAudios;
    private String rightAnswer;
    private boolean right = false;

    /**
     * Creates new form GameUI
     */
    
    public GameUI() {
        initComponents();
        gameController = new GameController(this);
        gameNumber = 0;
        questionNumber = 0;
        judgePlayer = new AudioPlayer();
        correct = new File("song/correct.wav");
        wrong = new File("song/wrong.wav");
        buttonsList = new CircularList<JButton>();
    }
    
    public GameUI(int[] userLists){
        this();
        //set the user list
    }
    
    //prepareQuestion donnot repeat
    public void prepareQuestion(){
        gameController.loadGame(gameNumber);
        gameController.loadGameEntry(questionNumber);
        SwingWorker questionWorker = new SwingWorker(){

            @Override
            protected Object doInBackground() throws Exception {
                questionPlayer.play();
                return null;
            }
        };
        questionWorker.execute();
        
        jButton1.addActionListener(new ButtonListener());
        jButton2.addActionListener(new ButtonListener());
        jButton3.addActionListener(new ButtonListener());
    }
    
    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (rightAnswer.equals(((JButton)e.getSource()).getText())){
                right = true;
                //update the student score
            }
            else{
                right = false;
            }
            timer1.stop();
            judgeAnswer();
        }
        
    }
    
    class TimerHandler implements ActionListener {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                buttonsList.get(i).requestFocusInWindow();
                optionPlayer.setAudioFile(optionAudios.get(i++));
                optionPlayer.play();
            }
        }
    
    //playQuestion may repeat
    public void playQuestion(){
        
        buttonsList.add(jButton1);
        buttonsList.add(jButton2);
        buttonsList.add(jButton3);

        TimerHandler timerHandler = new TimerHandler();
        timer1 = new Timer(3500, timerHandler);
        timer1.setRepeats(true);
        timer1.start();
    }
    
    public void judgeAnswer(){
        //judge the answers
        if (right){
            judgePlayer.setAudioFile(correct);
            judgePlayer.play();
        }
        else{
            judgePlayer.setAudioFile(wrong);
            judgePlayer.play();
        }
        answerPlayer.play();
    }
    
    //to finish playing one question and its answers
    public void play(){
        prepareQuestion();
        playQuestion();
        
    }
    
    //to iterate through a list of questions
    public void start(){
        //iterate and set game number
        //iterate and set question number
        //iterate and set student player id
        play();
    }
    
    public void setScoreField(String value) {
        jTextField1.setText(value);
        jTextField1.repaint();
    }

    public void setPictureField(String value) {
        jLabel3.setIcon(new javax.swing.ImageIcon(value));
        jLabel3.repaint();
    }

    public void setQuestionField(String value) {
        jLabel2.setText(value);
        jLabel2.repaint();
    }

    public void setOption1Field(String value) {
        jButton1.setText(value);
        jButton1.repaint();
    }

    public void setOption2Field(String value) {
        jButton2.setText(value);
        jButton2.repaint();
    }

    public void setOption3Field(String value) {
        jButton3.setText(value);
        jButton3.repaint();
    }
    
    public void setQustionAudio(String value){
        File temp = new File(value);
        questionPlayer = new AudioPlayer(temp);
    }
    
    public void setOptionAudio(String op1, String op2, String op3){
        optionAudios = new CircularList<File>();
        optionPlayer = new AudioPlayer();
        optionAudios.add(new File(op1));
        optionAudios.add(new File(op2));
        optionAudios.add(new File(op3));
    }
    
    public void setAnswerAudio(String answerPath){
        answerPlayer = new AudioPlayer(new File(answerPath));
    }
    
    public void setRightAnswer(String answer){
        rightAnswer = answer;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("question");

        jButton1.setText("option1");

        jButton2.setText("option2");

        jButton3.setText("option3");

        jLabel1.setText("Question:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 86, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton1)
                        .addGap(28, 28, 28)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(232, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GameUI playGame = new GameUI();
                playGame.setVisible(true);
                //playGame.prepareQuestion();
                //playGame.playQuestion();
                playGame.start();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    
    class CircularList<E> extends ArrayList<E> {

            @Override
            public E get(int index) {
                return super.get(index % size());
            }
        }
}

