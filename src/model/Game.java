package model;
import java.util.List;
import java.util.Map;


public class Game {
	private Integer gameID;
	/**
	 * @param gameID
	 * @param gameName
	 * @param ageGroup
	 * @param language
	 * @param picturePath
	 * @param musicPath
	 * @param questions
	 * @param rightAnswers
	 * @param answers
	 * @param topScore
	 */
	public Game(Integer gameID, String gameName, Integer ageGroup,
			String language, List<String> picturePath, List<String> musicPath,
			Map<Integer, String> questions, Map<Integer, String> rightAnswers,
			Map<Integer, List<Integer>> answers, Integer topScore) {
		this.gameID = gameID;
		this.gameName = gameName;
		this.ageGroup = ageGroup;
		this.language = language;
		this.picturePath = picturePath;
		this.musicPath = musicPath;
		this.questions = questions;
		this.rightAnswers = rightAnswers;
		this.answers = answers;
		this.topScore = topScore;
	}
	private String gameName;
	private Integer ageGroup;
	private String language;

	private List<String> picturePath;
	private List<String> musicPath;
	private Map<Integer,String> questions;
	private Map<Integer,String> rightAnswers;
	private Map<Integer,List<Integer>> answers;
	private Integer topScore;
	/**
	 * @return the gameID
	 */
	public Integer getGameID() {
		return gameID;
	}
	/**
	 * @param gameID the gameID to set
	 */
	public void setGameID(Integer gameID) {
		this.gameID = gameID;
	}
	/**
	 * @return the gameName
	 */
	public String getGameName() {
		return gameName;
	}
	/**
	 * @param gameName the gameName to set
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	/**
	 * @return the ageGroup
	 */
	public Integer getAgeGroup() {
		return ageGroup;
	}
	/**
	 * @param ageGroup the ageGroup to set
	 */
	public void setAgeGroup(Integer ageGroup) {
		this.ageGroup = ageGroup;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the picturePath
	 */
	public List<String> getPicturePath() {
		return picturePath;
	}
	/**
	 * @param picturePath the picturePath to set
	 */
	public void setPicturePath(List<String> picturePath) {
		this.picturePath = picturePath;
	}
	/**
	 * @return the musicPath
	 */
	public List<String> getMusicPath() {
		return musicPath;
	}
	/**
	 * @param musicPath the musicPath to set
	 */
	public void setMusicPath(List<String> musicPath) {
		this.musicPath = musicPath;
	}
	/**
	 * @return the questions
	 */
	public Map<Integer, String> getQuestions() {
		return questions;
	}
	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(Map<Integer, String> questions) {
		this.questions = questions;
	}
	/**
	 * @return the rightAnswers
	 */
	public Map<Integer, String> getRightAnswers() {
		return rightAnswers;
	}
	/**
	 * @param rightAnswers the rightAnswers to set
	 */
	public void setRightAnswers(Map<Integer, String> rightAnswers) {
		this.rightAnswers = rightAnswers;
	}
	/**
	 * @return the answers
	 */
	public Map<Integer, List<Integer>> getAnswers() {
		return answers;
	}
	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(Map<Integer, List<Integer>> answers) {
		this.answers = answers;
	}
	/**
	 * @return the topScore
	 */
	public Integer getTopScore() {
		return topScore;
	}
	/**
	 * @param topScore the topScore to set
	 */
	public void setTopScore(Integer topScore) {
		this.topScore = topScore;
	}
	
}
