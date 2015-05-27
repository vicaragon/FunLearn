package model;
import java.util.List;
import java.util.Map;


public class Game {
	private Integer gameID;
	private String gameName;
	private Integer ageGroup;
	private String language;

	private List<String> picturePath;
	private List<String> musicPath;
	private Map<Integer,String> questions;
	private Map<Integer,String> rightAnswers;
	private Map<Integer,List<Integer>> answers;
	private Integer topScore;

    public Game(){ 	
    }
	// Getter and Setters
}
