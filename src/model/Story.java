package model;
import java.io.Serializable;
import java.util.Map;


public class Story implements Serializable {
	private int storyID;
	private String storyName;
	private int ageGroup;
	private String language;
	private Map<Integer,String> paragraph;
	private Map<Integer,String> picturePath;
	private Map<Integer,String> musicAudioPath;
	private Map<Integer,String> paragraphAudioPath;
	/**
	 * @param storyID
	 * @param storyName
	 * @param ageGroup
	 * @param language
	 * @param paragraph
	 * @param picturePath
	 * @param musicAudioPath
	 * @param paragraphAudioPath
	 */
	public Story(int storyID, String storyName, int ageGroup, String language,
			Map<Integer, String> paragraph, Map<Integer, String> picturePath,
			Map<Integer, String> musicAudioPath,
			Map<Integer, String> paragraphAudioPath) {
		this.storyID = storyID;
		this.storyName = storyName;
		this.ageGroup = ageGroup;
		this.language = language;
		this.paragraph = paragraph;
		this.picturePath = picturePath;
		this.musicAudioPath = musicAudioPath;
		this.paragraphAudioPath = paragraphAudioPath;
	}
	public int getStoryID() {
		return storyID;
	}
	public void setStoryID(int storyID) {
		this.storyID = storyID;
	}
	public String getStoryName() {
		return storyName;
	}
	public void setStoryName(String storyName) {
		this.storyName = storyName;
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
	public Map<Integer, String> getParagraph() {
		return paragraph;
	}
	public void setParagraph(Map<Integer, String> paragraph) {
		this.paragraph = paragraph;
	}
	public Map<Integer, String> getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(Map<Integer, String> picturePath) {
		this.picturePath = picturePath;
	}
	public Map<Integer, String> getMusicAudioPath() {
		return musicAudioPath;
	}
	public void setMusicAudioPath(Map<Integer, String> musicAudioPath) {
		this.musicAudioPath = musicAudioPath;
	}
	public Map<Integer, String> getParagraphAudioPath() {
		return paragraphAudioPath;
	}
	public void setParagraphAudioPath(Map<Integer, String> paragraphAudioPath) {
		this.paragraphAudioPath = paragraphAudioPath;
	}
}