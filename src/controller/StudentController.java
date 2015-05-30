package controller;

import java.util.HashMap;

import model.Student;
import view.StudentsListUI;

public class StudentController {
	private StudentTableModel studentTablemodel;
        private StudentsListUI studentsListUI;
	public StudentController(StudentsListUI studentsListUI) {
            this.studentsListUI = studentsListUI;
            studentTablemodel = new StudentTablemodel();
            studentTablemodel.addTableModelListener(this);
        }
	public void findStudentNames(String name){
		
	}
	
	public void findStudentID(int i){
		
	}
	
	public void findStudentAge(int age){
		
	}
	
	public void addStudent(){
		
	}
	
	public void deleteStudent(int id){
		
	}
	
	public void updateStudent(int id){
		
	}
		
}
