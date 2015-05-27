package model;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class Game implements Serializable {
	private int gameID;
	private String gameName;
	private int ageGroup;
	private String language;
	private Map<Integer,String> picturePath;
	private Map<Integer,String> musicPath;
	private Map<Integer,String> questions;
	private Map<Integer,String> questionsAudioPath;
	private Map<Integer,String> rightAnswer;
	private Map<Integer,String> rightAnswerAudioPath;
	private Map<Integer,List<String>> answers;
	private Map<Integer,List<String>> answersAudioPath;
	/**
	 * @param gameID
	 * @param gameName
	 * @param ageGroup
	 * @param language
	 * @param picturePath
	 * @param musicPath
	 * @param questions
	 * @param questionsAudioPath
	 * @param rightAnswer
	 * @param rightAnswerAudioPath
	 * @param answers
	 * @param answersAudioPath
	 */
	public Game(int gameID, String gameName, int ageGroup, String language,
			Map<Integer, String> picturePath, Map<Integer, String> musicPath,
			Map<Integer, String> questions,
			Map<Integer, String> questionsAudioPath,
			Map<Integer, String> rightAnswer,
			Map<Integer, String> rightAnswerAudioPath,
			Map<Integer, List<Integer>> answers,
			Map<Integer, List<String>> answersAudioPath) {
		this.gameID = gameID;
		this.gameName = gameName;
		this.ageGroup = ageGroup;
		this.language = language;
		this.picturePath = picturePath;
		this.musicPath = musicPath;
		this.questions = questions;
		this.questionsAudioPath = questionsAudioPath;
		this.rightAnswer = rightAnswer;
		this.rightAnswerAudioPath = rightAnswerAudioPath;
		this.answers = answers;
		this.answersAudioPath = answersAudioPath;
	}
	public int getGameID() {
		return gameID;
	}
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public int getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Map<Integer, String> getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(Map<Integer, String> picturePath) {
		this.picturePath = picturePath;
	}
	public Map<Integer, String> getMusicPath() {
		return musicPath;
	}
	public void setMusicPath(Map<Integer, String> musicPath) {
		this.musicPath = musicPath;
	}
	public Map<Integer, String> getQuestions() {
		return questions;
	}
	public void setQuestions(Map<Integer, String> questions) {
		this.questions = questions;
	}
	public Map<Integer, String> getQuestionsAudioPath() {
		return questionsAudioPath;
	}
	public void setQuestionsAudioPath(Map<Integer, String> questionsAudioPath) {
		this.questionsAudioPath = questionsAudioPath;
	}
	public Map<Integer, String> getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(Map<Integer, String> rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	public Map<Integer, String> getRightAnswerAudioPath() {
		return rightAnswerAudioPath;
	}
	public void setRightAnswerAudioPath(Map<Integer, String> rightAnswerAudioPath) {
		this.rightAnswerAudioPath = rightAnswerAudioPath;
	}
	public Map<Integer, List<Integer>> getAnswers() {
		return answers;
	}
	public void setAnswers(Map<Integer, List<Integer>> answers) {
		this.answers = answers;
	}
	public Map<Integer, List<String>> getAnswersAudioPath() {
		return answersAudioPath;
	}
	public void setAnswersAudioPath(Map<Integer, List<String>> answersAudioPath) {
		this.answersAudioPath = answersAudioPath;
	}
}
