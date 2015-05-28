package view;

import javax.swing.JFrame;
import controller.*;
import javax.swing.JPanel;

public class SetupUI {
	private JFrame window;
	private JPanel cards;
	private StudentsListUI studentListUI;
	private GameTypeUI gameTypeUI;
	private LevelTypeUI levelTypeUI;
	private StartUI startUI;
	private GameUI gameUI;
	private StoryUI storyUI;
	private SongUI songUI;
	private String PERSISTENCE_UNIT_NAME="PersistenceUnit";
	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager manager = factory.createEntityManager();
	GameService gameService = new GameService(manager);
	SongService songService = new SongService(manager);
	StoryService storyService = new StoryService(manager);
	public SetupUI() {
		cards.add(studentListUI);
		cards.add(gameTypeUI);
		cards.add(levelTypeUI);
		cards.add(startUI);
	}
	
	public static void main (String[] args) {
		
	}
		

}
