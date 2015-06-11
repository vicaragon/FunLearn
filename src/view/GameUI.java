/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
    private int i, j;
    private Timer timer1;
    private int score;
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

    /**
     * Creates new form GameUI
     */
    public GameUI(int gameNumber,List<Integer> userIDList, List<String> userList ) {
        initComponents();
        setSize(1000, 750);
        gameController = new GameController(this);
        studentController = new StudentController(new StudentsListUI());
        this.userIDList = userIDList;
        this.userList = userList;
        rn = new Random();
        scoreList = new CircularList<>();
        for (int j=0;i<userIDList.size();i++) {
            scoreList.add(i, 0);
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
    }

    //prepareQuestion donnot repeat
    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gameController.isRightAnswer(rightAnswer, ((JButton) e.getSource()).getText())) {
                right = true;
            //    System.out.println("Score: " + gameController.updateScore(true, score));
                scoreList.set(playerIndex, gameController.updateScore(true, score));
            } else {
                right = false;
                //gameController.updateScore(false, score);
                //scoreList.set(playerIndex, gameController.updateScore(false, score));
            }
            timer1.stop();
            judgeAnswer();
            questionNumber = rn.nextInt(9);
            playerIndex = (playerIndex+1) % userIDList.size();
            jLabel4.setText(userList.get(playerIndex).toString());
            jLabel5.setText(scoreList.get(playerIndex).toString());
            play();
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

    public void prepareQuestion() {
        gameController.loadGameEntry(questionNumber);
        SwingWorker questionWorker = new SwingWorker() {
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
    //playQuestion may repeat

    public void playQuestion() {
        TimerHandler timerHandler = new TimerHandler();
        timer1 = new Timer(3500, timerHandler);
        timer1.setRepeats(true);
        timer1.start();
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
        playQuestion();
    }

    //to iterate through a list of questions

    public void start() {
        play();
    }

    public void setScoreField(String value) {
        jLabel5.setText(value);
    }

    public void setPictureField(String value) {
        jLabel3.setIcon(new javax.swing.ImageIcon(value));
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addGap(28, 28, 28)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(238, Short.MAX_VALUE))
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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the game?", "Confirm close", JOptionPane.YES_NO_OPTION);
            if(i == 0) {
                studentController.storeScores(getUserIDList(), getUserList(), getScoreList());
                AudioPlayer.getClip().stop();
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables


}