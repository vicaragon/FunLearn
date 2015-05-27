package model;

public class Song{
	private Integer songID;
	private String songName;
	private Integer ageGroup;
	private String language;
	public Integer getSongID() {
		return songID;
	}
	public void setSongID(Integer songID) {
		this.songID = songID;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
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
}