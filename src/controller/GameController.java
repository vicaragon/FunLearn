package controller;
import java.io.File;
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
<<<<<<< HEAD
	public void loadGame(int gameNumber) {
            	String picturePaths = (String) gameTablemodel.getValueAt(gameNumber, 4);
		String questionPaths =  (String) gameTablemodel.getValueAt(gameNumber, 6);
		String option1Paths = (String) gameTablemodel.getValueAt(gameNumber, 10);
		String option2Paths= (String) gameTablemodel.getValueAt(gameNumber, 11);
		String option3Paths = (String) gameTablemodel.getValueAt(gameNumber, 12);
=======
	public void loadGame() {
            	gameUI.setPictureField( (String) gameTablemodel.getValueAt(0, 4));
		gameUI.setQuestionField( (String) gameTablemodel.getValueAt(0, 6));
		gameUI.setOption1Field( (String) gameTablemodel.getValueAt(0, 10));
		gameUI.setOption2Field( (String) gameTablemodel.getValueAt(0, 11));
		gameUI.setOption3Field( (String) gameTablemodel.getValueAt(0, 12));
>>>>>>> origin/master
        }
        
        public void loadGameEntry(int n) {
            int question = 0;
        //         gameUI.setPictureField( ) ;
	//	gameUI.setQuestionField( ) ;
	//	gameUI.setOption1Field() ;
	//	gameUI.setOption2Field( );
	//	gameUI.setOption3Field(); 
            
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