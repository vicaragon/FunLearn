package controller;
import model.Student;


public class GetStats{
	private Student student;
	
	public GetStats(){
		
	}
	
	public double getMax(){
		
		return 0.0;
	}
	
	public double getMin(){
		
		return 0.0;
	}
	
	public double getMean(){
		return 0.0;
	}
	
	public void setStudent(Student s){
		student = s;
	}
	
	public Student getStudent(){
		return student;
	}
	
	public double getGameMax(){
		return 0.0;
	}
	
	public double getStoryMax(){
		return 0.0;
	}
	
	public double getGameMin(){
		return 0.0;
	}
	
	public double getStoryMin(){
		return 0.0;
	}
	
	public double getStoryMean(){
		return 0.0;
	}
	
	public double getGameMean(){
		return 0.0;
	}
}