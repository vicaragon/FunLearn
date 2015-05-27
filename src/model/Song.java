package model;

public class Song{
	private Integer songID;
	private String songName;
	private Integer ageGroup;
	private String language;
	private String songAudioPath;
	private String[] songImagePath;
	
	/**
	 * @param songID
	 * @param songName
	 * @param ageGroup
	 * @param language
	 * @param songAudioPath
	 * @param songImagePath
	 */
	public Song(Integer songID, String songName, Integer ageGroup,
			String language, String songAudioPath, String[] songImagePath) {
		this.songID = songID;
		this.songName = songName;
		this.ageGroup = ageGroup;
		this.language = language;
		this.songAudioPath = songAudioPath;
		this.songImagePath = songImagePath;
	}
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
	public String getSongAudioPath() {
		return songAudioPath;
	}
	public void setSongAudioPath(String songAudioPath) {
		this.songAudioPath = songAudioPath;
	}
	public String[] getSongImagePath() {
		return songImagePath;
	}
	public void setSongImagePath(String[] songImagePath) {
		this.songImagePath = songImagePath;
	}	
}