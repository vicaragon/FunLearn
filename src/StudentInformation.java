import java.awt.Image;
import java.util.ArrayList;

public class StudentInformation{
	private int id;
	private Image pic;
	private ArrayList<Double> storyScore;
	private ArrayList<Double> gameScore;
	private String lastName;
	private String firstName;
	
	public int getID(){
		return id;
	}
	
	public Image getPic(){
		return pic;
	}
	
	public ArrayList<Double> getStoryScore(){
		return storyScore;
	}
	
	public ArrayList<Double> getGameScore(){
		return gameScore;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getFirstname(){
		return firstName;
	}
	
	public void setID(int i){
		id = i;
	}
	
	public void setPic(Image im){
		pic = im;
	}
	
	public void setStoryScore(ArrayList<Double> sscore){
		storyScore = sscore;
	}
	
	public void setGameScore(ArrayList<Double> gscore){
		gameScore = gscore;
	}
	
	public void setLastName(String lname){
		lastName = lname;
	}
	
	public void setFristName(String fname){
		firstName = fname;
	}
}