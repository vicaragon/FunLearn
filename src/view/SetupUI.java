package view;

import javax.swing.JFrame;
import controller.*;
import javax.swing.JPanel;

public class SetupUI {
	private JFrame window;
	private JPanel topPanel;
	private String PERSISTENCE_UNIT_NAME="PersistenceUnit";
	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager manager = factory.createEntityManager();
	GameService gameService = new GameService(manager);
	SongService songService = new SongService(manager);
	StoryService storyService = new StoryService(manager);
	public SetupUI() {
		new AdminSetupUI();
	}
	
	public static void main (String[] args) {
		
	}
		

}
