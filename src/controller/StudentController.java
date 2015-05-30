package controller;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import view.StudentsListUI;

public class StudentController implements TableModelListener {
	private StudentTableModel studentTablemodel;
        private StudentsListUI studentsListUI;
	public StudentController(StudentsListUI studentsListUI) {
            this.studentsListUI = studentsListUI;
            studentTablemodel = new StudentTableModel();
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

    @Override
    public void tableChanged(TableModelEvent tme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
		
}
