package controller;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import view.*;

public class GameController implements TableModelListener {
	private int index;
	private int score;
        private GameTableModel gameTablemodel;
        private StudentTableModel studentTablemodel;
        private GameUI gameUI;
        private ArrayList<String> picturePaths;
        private ArrayList<String> questions;
        private ArrayList<String> questionPaths;
        private ArrayList<String> rightAnswers;
        private ArrayList<String> rightAnswerPaths;
        private ArrayList<String> option1;
        private ArrayList<String> option2;
        private ArrayList<String> option3;
        private ArrayList<String> option1Paths;
        private ArrayList<String> option2Paths;
        private ArrayList<String> option3Paths;
	/**
	 * @param game
	 */
        public GameController(GameUI gameUI) {
            this.gameUI = gameUI;
            gameTablemodel = new GameTableModel();
            studentTablemodel = new StudentTableModel();
            gameTablemodel.addTableModelListener(this);
            studentTablemodel.addTableModelListener(this);
            score = 0;
        }
        public GameTableModel getTableModel() {
            return gameTablemodel;
	}
	public void loadGame(int gameNumber) {
                index = gameNumber;
                picturePaths = new ArrayList<String>(Arrays.asList(((String) gameTablemodel.getValueAt(gameNumber, 4)).split(";")));
                questions = new ArrayList<String>(Arrays.asList(((String) gameTablemodel.getValueAt(gameNumber, 6)).split(";")));
		questionPaths =  new ArrayList<String>(Arrays.asList(((String) gameTablemodel.getValueAt(gameNumber, 7)).split(";")));
                rightAnswers = new ArrayList<String>(Arrays.asList(((String) gameTablemodel.getValueAt(gameNumber, 8)).split(";")));
                rightAnswerPaths = new ArrayList<String>(Arrays.asList(((String) gameTablemodel.getValueAt(gameNumber, 9)).split(";")));
                option1 = new ArrayList<String>(Arrays.asList(((String) gameTablemodel.getValueAt(gameNumber, 10)).split(";")));
                option2 = new ArrayList<String>(Arrays.asList(((String) gameTablemodel.getValueAt(gameNumber, 11)).split(";")));
                option3 = new ArrayList<String>(Arrays.asList(((String) gameTablemodel.getValueAt(gameNumber, 12)).split(";")));
		option1Paths = new ArrayList<String>(Arrays.asList(((String) gameTablemodel.getValueAt(gameNumber, 13)).split(";")));
		option2Paths= new ArrayList<String>(Arrays.asList(((String) gameTablemodel.getValueAt(gameNumber, 14)).split(";")));
		option3Paths = new ArrayList<String>(Arrays.asList(((String) gameTablemodel.getValueAt(gameNumber, 15)).split(";")));
        }
        
        public void loadGameEntry(int questionNumber) {
                gameUI.setPictureField(picturePaths.get(questionNumber));
                gameUI.setQuestionField("<html>"+questions.get(questionNumber)+"</html>");
                gameUI.setQustionAudio(questionPaths.get(questionNumber));
		gameUI.setOption1Field(option1.get(questionNumber));
		gameUI.setOption2Field(option2.get(questionNumber));
		gameUI.setOption3Field(option3.get(questionNumber)); 
                gameUI.setOptionAudio(option1Paths.get(questionNumber), option2Paths.get(questionNumber), option3Paths.get(questionNumber));
                gameUI.setRightAnswer(rightAnswers.get(questionNumber));
                gameUI.setAnswerAudio(rightAnswerPaths.get(questionNumber));
        }
        
	public void playGame(){
            
        }
	public void endGame() {
            
        }
	
	public void iterateQuestions() {
            
        }
        public boolean isRightAnswer(String ans1, String ans2) {
            return ans1.equals(ans2);
        }
	
        public int getScore() {
            return score;
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
	public File retrieveQuestionAudio(int questionNumber) {
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