package controller;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import view.*;
import model.*;

public class GameController implements TableModelListener {
	private int index;
	private int score;
        private GameTableModel gameTablemodel;
        private GameUI gameUI;
        private ArrayList<String> picturePaths;
        private ArrayList<String> questionPaths;
        private ArrayList<String> option1Paths;
        private ArrayList<String> option2Paths;
        private ArrayList<String> option3Paths;
	/**
	 * @param game
	 */
        public GameController(GameUI gameUI) {
            this.gameUI = gameUI;
            gameTablemodel = new GameTableModel();
            gameTablemodel.addTableModelListener(this);
            score = 0;
        }
        public GameTableModel getTableModel() {
            return gameTablemodel;
	}
	public void loadGame(int gameNumber) {
                index = gameNumber;
                picturePaths = new ArrayList<String>(Arrays.asList(((String) gameTablemodel.getValueAt(gameNumber, 4)).split(";")));
		questionPaths =  new ArrayList<String>(Arrays.asList(((String) gameTablemodel.getValueAt(gameNumber, 6)).split(";")));
		option1Paths = new ArrayList<String>(Arrays.asList(((String) gameTablemodel.getValueAt(gameNumber, 10)).split(";")));
		option2Paths= new ArrayList<String>(Arrays.asList(((String) gameTablemodel.getValueAt(gameNumber, 11)).split(";")));
		option3Paths = new ArrayList<String>(Arrays.asList(((String) gameTablemodel.getValueAt(gameNumber, 12)).split(";")));
        }
        
        public void loadGameEntry(int questionNumber) {
                gameUI.setPictureField(picturePaths.get(questionNumber));
                gameUI.setQuestionField(questionPaths.get(questionNumber));
		gameUI.setOption1Field(option1Paths.get(questionNumber));
		gameUI.setOption2Field(option2Paths.get(questionNumber));
		gameUI.setOption3Field(option3Paths.get(questionNumber));     
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
	
        public int getScore() {
            return score;
        }
        
	public int updateScore() {
            return 0;
        }
	
	public ImageIcon retrievePicture() {
		return null;
	}
	public File retrieveMusic() {
		return null;
	}
	public String retrieveQuestion() {
		return null;
	}
	public File retrieveQuestionAudio() {
		return null;
	}
	public String retrieverightAnswer() {
		return null;
	}
	public File  retrieverightAnswerAudio() {
		return null;
	}
	public List<String> retrieveAnswers() {
		return null;
	}
	public List<File> retrieveAnswersAudio() {
		return null;
	}

    @Override
    public void tableChanged(TableModelEvent tme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}