public abstract class GameController {
	protected Game game;
	protected abstract void ifPreviousSaved();
	protected abstract void loadGame();
	protected abstract void playGame();
	protected abstract void endGame();
	
	protected abstract void iterateQuestions();  
	protected abstract boolean isRightAnswered();
	protected abstract void displayScore();
	protected abstract void updateScore();
}
