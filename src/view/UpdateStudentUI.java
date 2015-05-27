package view;
import javax.swing.*;

import model.Student;
import controller.UpdateStudent;


public class UpdateStudentUI {
	private JPanel topPanel;
	private JButton add;
	private Student updatedStudent;
	private JTextArea Id;
	private JLabel id;
	private JTextArea lastName;
	private JLabel lastname;
	private JTextArea firstName;
	private JLabel firstname;
	private JTextArea Age;
	private JLabel age;
	private JButton picture;
	private JButton submit;
	
	public UpdateStudentUI(){
		
	}
	
	public UpdateStudentUI(Student s){
		updatedStudent = s;
	}
	
	public void registerEvents(){
		
	}
}
