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
	public void loadGame();
	public void playGame();
	public void endGame();
	
	public void iterateQuestions();  
	public boolean isRightAnswer();
	
	public int updateScore();
	
	public ImageIcon retrievePicture() {
		
	};
	public AudioStream retrieveMusic() {
		
	};
	public String retrieveQuestion() {
		
	};
	public AudioStream retrieveQuestionAudio() {
		
	};
	public String retrieverightAnswer() {
		
	};
	public AudioStream  retrieverightAnswerAudio() {
		
	};
	public List<String> retrieveAnswers() {
		
	};
	public List<AudioStream> retrieveAnswersAudio() {
		
	};
}