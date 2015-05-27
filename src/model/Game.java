package model;
import java.util.List;
import java.util.Map;


public class Game {
	private Integer gameID;
	private String gameName;
	private Integer ageGroup;
	private String language;

	private List<String> pictures;
	private List<String> music;
	private Map<Integer,String> questions;
	private Map<Integer,String> anwers;
	private Map<Integer,List<Integer>> Rightanswer;
	private Integer scores;

    public Game(){ 	
    }
	// Getter and Setters
}
