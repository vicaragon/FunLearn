package model;
import java.io.Serializable;
import java.util.Map;

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8865536250554293578L;
	private int studentID;
	private String picPath;
	private Map<Integer,Integer> gameScore;
	private String lastName;
	private String firstName;
	private int ageGroup;
	/**
	 * @param studentID
	 * @param picPath
	 * @param gameScore
	 * @param lastName
	 * @param firstName
	 * @param ageGroup
	 */
	public Student(int studentID, String picPath,
			Map<Integer, Integer> gameScore, String lastName, String firstName,
			int ageGroup) {
		this.studentID = studentID;
		this.picPath = picPath;
		this.gameScore = gameScore;
		this.lastName = lastName;
		this.firstName = firstName;
		this.ageGroup = ageGroup;
	}
	public Student() {
		
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public Map<Integer, Integer> getGameScore() {
		return gameScore;
	}
	public void setGameScore(Map<Integer, Integer> gameScore) {
		this.gameScore = gameScore;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
	}

}