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
	public SetupUI() {
		cards.add(studentListUI);
		cards.add(gameTypeUI);
		cards.add(levelTypeUI);
		cards.add(startUI);
	}
	
	public static void main (String[] args) {
		
	}
		

}
