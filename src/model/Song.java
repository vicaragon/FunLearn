package model;

import java.io.Serializable;
import java.util.List;

public class Song implements Serializable {
	private int songID;
	private String songName;
	private int ageGroup;
	private String language;
	private String songAudioPath;
	private List<String> songImagePath;
	/**
	 * @param songID
	 * @param songName
	 * @param ageGroup
	 * @param language
	 * @param songAudioPath
	 * @param songImagePath
	 */
	public Song(int songID, String songName, int ageGroup, String language,
			String songAudioPath, List<String> songImagePath) {
		this.songID = songID;
		this.songName = songName;
		this.ageGroup = ageGroup;
		this.language = language;
		this.songAudioPath = songAudioPath;
		this.songImagePath = songImagePath;
	}
	public int getSongID() {
		return songID;
	}
	public void setSongID(int songID) {
		this.songID = songID;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
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
	public String getSongAudioPath() {
		return songAudioPath;
	}
	public void setSongAudioPath(String songAudioPath) {
		this.songAudioPath = songAudioPath;
	}
	public List<String> getSongImagePath() {
		return songImagePath;
	}
	public void setSongImagePath(List<String> songImagePath) {
		this.songImagePath = songImagePath;
	}
}