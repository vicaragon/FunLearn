package controller;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;

import sun.audio.AudioStream;
import view.*;
import model.*;

public class GameController {
	private int index;
	private int score;
        private GameTableModel gameTablemodel;
        private GameUI gameUI;
	/**
	 * @param game
	 */
	public GameController(GameUI gameUI) {
		this.gameUI = gameUI;
	}
	public void loadGame() {
            
        }
	public void playGame(){
            
        }
	public void endGame() {
            
        }
	
	public void iterateQuestions() {
            
        }
	public boolean isRightAnswer() {
            return false;
        }
	
	public int updateScore() {
            return 0;
        }
	
	public ImageIcon retrievePicture() {
		return null;
	}
	public AudioStream retrieveMusic() {
		return null;
	}
	public String retrieveQuestion() {
		return null;
	}
	public AudioStream retrieveQuestionAudio() {
		return null;
	}
	public String retrieverightAnswer() {
		return null;
	}
	public AudioStream  retrieverightAnswerAudio() {
		return null;
	}
	public List<String> retrieveAnswers() {
		return null;
	}
	public List<AudioStream> retrieveAnswersAudio() {
		return null;
	}
}