/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 *
 * @author me
 */
@Entity(name = "game")
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer gameID;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String gameName;
    private Integer ageGroup;
    @Column(length = 45)
    private String language;
    @Lob
    @Column(length = 2147483647)
    private String picturePath;
    @Lob
    @Column(length = 2147483647)
    private String musicPath;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String questions;
    @Lob
    @Column(length = 2147483647)
    private String questionsAudioPath;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String rightAnswer;
    @Lob
    @Column(length = 2147483647)
    private String rightAnswerAudioPath;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String op1;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String op2;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String op3;
    @Lob
    @Column(length = 2147483647)
    private String op1AudioPath;
    @Lob
    @Column(length = 2147483647)
    private String op2AudioPath;
    @Lob
    @Column(length = 2147483647)
    private String op3AudioPath;

    public Game() {
    }

    public Game(Integer gameID) {
        this.gameID = gameID;
    }

    public Game(Integer gameID, String gameName, String questions, String rightAnswer, String op1, String op2, String op3) {
        this.gameID = gameID;
        this.gameName = gameName;
        this.questions = questions;
        this.rightAnswer = rightAnswer;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
    }

    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Integer getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(Integer ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getMusicPath() {
        return musicPath;
    }

    public void setMusicPath(String musicPath) {
        this.musicPath = musicPath;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getQuestionsAudioPath() {
        return questionsAudioPath;
    }

    public void setQuestionsAudioPath(String questionsAudioPath) {
        this.questionsAudioPath = questionsAudioPath;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getRightAnswerAudioPath() {
        return rightAnswerAudioPath;
    }

    public void setRightAnswerAudioPath(String rightAnswerAudioPath) {
        this.rightAnswerAudioPath = rightAnswerAudioPath;
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOp3() {
        return op3;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public String getOp1AudioPath() {
        return op1AudioPath;
    }

    public void setOp1AudioPath(String op1AudioPath) {
        this.op1AudioPath = op1AudioPath;
    }

    public String getOp2AudioPath() {
        return op2AudioPath;
    }

    public void setOp2AudioPath(String op2AudioPath) {
        this.op2AudioPath = op2AudioPath;
    }

    public String getOp3AudioPath() {
        return op3AudioPath;
    }

    public void setOp3AudioPath(String op3AudioPath) {
        this.op3AudioPath = op3AudioPath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gameID != null ? gameID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        if ((this.gameID == null && other.gameID != null) || (this.gameID != null && !this.gameID.equals(other.gameID))) {
            return false;
        }
        return true;
    }

       public int getNumberOfColumns() {
	   return 16;
   }
       
          // return the data in column i
   public String getColumnData(int i) throws Exception {
	   if (i == 0)
		   return Integer.toString(getGameID());
	   else if (i == 1)
		   return getGameName();
	   else if (i == 2) 
		   return Integer.toString(getAgeGroup());
	   else if (i == 3)
		   return getLanguage();
	   else if (i == 4)
		   return getPicturePath();
           else if (i == 5)
		   return getMusicPath();
           else if (i == 6)
		   return getQuestions();
           else if (i == 7)
		   return getQuestionsAudioPath();
           else if (i == 8)
		   return getRightAnswer();
           else if (i == 9)
		   return getRightAnswerAudioPath();
           else if (i == 10)
		   return getOp1();
           else if (i == 11)
		   return getOp2();
           else if (i == 12)
		   return getOp3();
           else if (i == 13)
		   return getOp1AudioPath();
           else if (i == 14)
		   return getOp2AudioPath();
           else if (i == 15)
		   return getOp3AudioPath();
	   else
		   throw new Exception("Error: invalid column index in game table");    
   }
       
    @Override
    public String toString() {
        return "model.Game[ gameID=" + gameID + " ]";
    }
    
}
