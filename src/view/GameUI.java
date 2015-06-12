/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
    private final CircularList<JButton> buttonsList;
    private Random rn;
    private int optionsAudioIndex, j;
    private Timer timer1;    
    private int playerIndex = 0;
    private GameController gameController;
    private StudentController studentController;
    private int gameNumber = 0;
    private int questionNumber = 0;
    private AudioPlayer questionPlayer;
    private AudioPlayer optionPlayer;
    private AudioPlayer answerPlayer;
    private CircularList<File> optionAudios;
    private String rightAnswer;
    private boolean right = false;
    private CircularList<Integer> scoreList;
    private List<Integer> userIDList;
    private List<String> userList;
    private SwingWorker questionWorker;
    private SwingWorker judgeWorker;
    private ButtonListener bListener;

    /**
     * Creates new form GameUI
     */
    public GameUI(int gameNumber,List<Integer> userIDList, List<String> userList ) {
        this.setResizable(false);
        initComponents();
        setSize(1000, 750);
        gameController = new GameController(this);
      //  studentController = new StudentController(new StudentsListUI());
        this.userIDList = userIDList;
        this.userList = userList;
        rn = new MyRandom(9);
        questionNumber = rn.nextInt();
        scoreList = new CircularList<>();
        for (int j=0;j<userIDList.size();j++) {
            scoreList.add(j, 0);
        }
        judgePlayer = new AudioPlayer();
        correct = new File("song/correct.wav");
        wrong = new File("song/wrong.wav");
        buttonsList = new CircularList<>();
        buttonsList.add(jButton1);
        buttonsList.add(jButton2);
        buttonsList.add(jButton3);
        gameController.loadGame(gameNumber);
        jLabel4.setText(userList.get(playerIndex));
        jLabel5.setText(scoreList.get(playerIndex).toString());
        
        TimerHandler timerHandler = new TimerHandler();
        timer1 = new Timer(3500, timerHandler);
        timer1.setRepeats(true);
        
    }

    //prepareQuestion donnot repeat
    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(questionNumber);
            jButton1.removeActionListener(bListener);
            jButton2.removeActionListener(bListener);
            jButton3.removeActionListener(bListener);
            if (gameController.isRightAnswer(rightAnswer, ((JButton) e.getSource()).getText())) {
                right = true;
                scoreList.set(playerIndex, scoreList.get(playerIndex)+5);
            } else {
                right = false;
            }
            timer1.stop();
            
            judgeWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                if(!Thread.currentThread().isInterrupted()){
                //clean up and return
                    judgeAnswer();
                }
                return null;
            }
            
            @Override
            protected void done(){
                if(!Thread.currentThread().isInterrupted()){
                    questionNumber = rn.nextInt();
                    playerIndex = (playerIndex+1) % userIDList.size();
                    jLabel4.setText(userList.get(playerIndex).toString());
                    jLabel5.setText(scoreList.get(playerIndex).toString());
                    play();
                }   
            }
        };
        judgeWorker.execute();
        
        }
    }

    class TimerHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            buttonsList.get(optionsAudioIndex).requestFocusInWindow();
            optionPlayer.setAudioFile(optionAudios.get(optionsAudioIndex++));
            optionPlayer.play();
        }
    }

    public void prepareQuestion() {
        gameController.loadGameEntry(questionNumber);
        questionWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                if(!Thread.currentThread().isInterrupted()){
                    Thread.sleep(1000);
                    questionPlayer.play();
                }
                return null;
            }
            
            @Override
            protected void done(){
                if(!Thread.currentThread().isInterrupted()){
                    playQuestion();
                }
            }
        };
        questionWorker.execute();

    }
    //playQuestion may repeat

    public void playQuestion() {
        bListener = new ButtonListener();
        jButton1.addActionListener(bListener);
        jButton2.addActionListener(bListener);
        jButton3.addActionListener(bListener);
        
        timer1.restart();
    }

    public void judgeAnswer() {
        //judge the answers
        if (right) {
            judgePlayer.setAudioFile(correct);
            judgePlayer.play();
        } else {
            judgePlayer.setAudioFile(wrong);
            judgePlayer.play();
        }
        answerPlayer.play();
    }

    public void play() {
        prepareQuestion();
        //playQuestion();
    }

    //to iterate through a list of questions

    public void start() {
        play();
    }

    public void setScoreField(String value) {
        jLabel5.setText(value);
    }

    public void setPictureField(String value) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(value));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon imageIcon = new ImageIcon(img.getScaledInstance(jLabel3.getWidth(),jLabel3.getHeight(),Image.SCALE_SMOOTH));
        jLabel3.setIcon(imageIcon);
        jLabel3.repaint();
    }

    public void setQuestionField(String value) {
        jLabel2.setText(value);
    }

    public void setOption1Field(String value) {
        jButton1.setText(value);
    }

    public void setOption2Field(String value) {
        jButton2.setText(value);
    }

    public void setOption3Field(String value) {
        jButton3.setText(value);
    }

    public void setQustionAudio(String value) {
        File temp = new File(value);
        questionPlayer = new AudioPlayer(temp);
    }

    public void setOptionAudio(String op1, String op2, String op3) {
        optionAudios = new CircularList<File>();
        optionPlayer = new AudioPlayer();
        optionAudios.add(new File(op1));
        optionAudios.add(new File(op2));
        optionAudios.add(new File(op3));
        optionsAudioIndex=0;
    }

    public void setAnswerAudio(String answerPath) {
        answerPlayer = new AudioPlayer(new File(answerPath));
    }

    public void setRightAnswer(String answer) {
        rightAnswer = answer;
    }
    public CircularList<Integer> getScoreList() {
        return scoreList;
    }

    public List<String> getUserList() {
        return userList;
    }
    
    public List<Integer> getUserIDList() {
        return userIDList;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabel3.setText("Pic");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(300, 50, 380, 270);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("question");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(130, 360, 600, 70);

        jButton1.setBackground(new java.awt.Color(204, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 255, 255));
        jButton1.setText("option1");
        jPanel1.add(jButton1);
        jButton1.setBounds(140, 470, 210, 130);

        jButton2.setBackground(new java.awt.Color(204, 0, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 255, 255));
        jButton2.setText("option2");
        jPanel1.add(jButton2);
        jButton2.setBounds(410, 470, 210, 130);

        jButton3.setBackground(new java.awt.Color(204, 0, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 255, 255));
        jButton3.setText("option3");
        jPanel1.add(jButton3);
        jButton3.setBounds(690, 470, 200, 130);

        jLabel1.setText("Question:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 280, 100, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(770, 50, 110, 50);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(890, 60, 80, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/gbg.jpg"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, -10, 1000, 750);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int sureClose = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the game?", "Confirm close", JOptionPane.YES_NO_OPTION);
            if(sureClose == 0) {
           //     StudentsListUI.getStudentController().storeScores(getUserIDList(), getUserList(), getScoreList());
                if (AudioPlayer.getClip() != null)
                    AudioPlayer.getClip().stop();
                if (timer1 != null)
                    timer1.stop();
                if (questionWorker != null)
                    questionWorker.cancel(true);
                if (judgeWorker != null)
                    judgeWorker.cancel(true);
                if (timer1 != null)
                    timer1.stop();
                this.setVisible(false);
                this.dispose();
            }
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables


}