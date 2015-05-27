package controller;
import java.util.ArrayList;

import model.Student;


public class GetStats{
	private Student student;
	private ArrayList<Student> students;
	
	public GetStats(){
		
	}
	
	public GetStats(ArrayList<Student> s){
		students = s;
	}
	
	public double getMax(){
		return 0.0;
	}
	
	public double getMin(){
		return 0.0;
	}
	
	public double getAverage(){
		return 0.0;
	}
}