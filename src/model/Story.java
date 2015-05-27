package model;
import java.io.Serializable;


public class Story implements Serializable {
	private Integer storyID;
	private String storyName;
	private Integer ageGroup;
	private String language;
	private String[] questions;
	private String[] rightAnswers;
	private String[] possibleAnswers;
	private String[] text;
	private String[] picturesPaths;
	public Story(String storyName, Integer ageGroup, String language,
			String[] questions, String[] rightAnswers,
			String[] possibleAnswers, String[] text, String[] picturesPaths) {
		this.storyName = storyName;
		this.ageGroup = ageGroup;
		this.language = language;
		this.questions = questions;
		this.rightAnswers = rightAnswers;
		this.possibleAnswers = possibleAnswers;
		this.text = text;
		this.picturesPaths = picturesPaths;
	}
	public String getStoryName() {
		return storyName;
	}
	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}
	public Integer getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(Integer ageGroup) {
		this.ageGroup = ageGroup;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String[] getQuestions() {
		return questions;
	}
	public void setQuestions(String[] questions) {
		this.questions = questions;
	}
	public String[] getRightAnswers() {
		return rightAnswers;
	}
	public void setRightAnswers(String[] rightAnswers) {
		this.rightAnswers = rightAnswers;
	}
	public String[] getPossibleAnswers() {
		return possibleAnswers;
	}
	public void setPossibleAnswers(String[] possibleAnswers) {
		this.possibleAnswers = possibleAnswers;
	}
	public String[] getText() {
		return text;
	}
	public void setText(String[] text) {
		this.text = text;
	}
	public String[] getPicturesPaths() {
		return picturesPaths;
	}
	public void setPicturesPaths(String[] picturesPaths) {
		this.picturesPaths = picturesPaths;
	}
}