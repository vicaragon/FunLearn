package model;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Map;

public class Student{
	private int studentID;
	private Image pic;
	private Map<Integer,Integer> storyScore;
	private Map<Integer,Integer> gameScore;
	private String lastName;
	private String firstName;
	
	public int getID(){
		return studentID;
	}
	
	public Image getPic(){
		return pic;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getFirstname(){
		return firstName;
	}
	
	public void setID(int i){
		studentID = i;
	}
	
	public void setPic(Image im){
		pic = im;
	}
	
	public void setLastName(String lname){
		lastName = lname;
	}
	
	public void setFirstName(String fname){
		firstName = fname;
	}

	public Map<Integer, Integer> getStoryScore() {
		return storyScore;
	}

	public void setStoryScore(Map<Integer, Integer> storyScore) {
		this.storyScore = storyScore;
	}

	public Map<Integer, Integer> getGameScore() {
		return gameScore;
	}

	public void setGameScore(Map<Integer, Integer> gameScore) {
		this.gameScore = gameScore;
	}
}