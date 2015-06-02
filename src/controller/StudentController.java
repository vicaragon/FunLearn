package controller;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import view.StudentsListUI;
import javax.swing.table.TableModel;
import javax.swing.event.*;
import javax.swing.ListSelectionModel;

public class StudentController implements ListSelectionListener, TableModelListener {
	private StudentTableModel studentTablemodel;
        private StudentsListUI studentsListUI;
	public StudentController(StudentsListUI studentsListUI) {
            this.studentsListUI = studentsListUI;
            studentTablemodel = new StudentTableModel();
            studentTablemodel.addTableModelListener(this);
        }
        
        public TableModel getTableModel() {
		return studentTablemodel;
	}
        
        @Override
	public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
            int firstIndex = selectModel.getMinSelectionIndex();
		
            studentsListUI.setFirstNameTextField( (String) studentTablemodel.getValueAt(firstIndex, 0));
            studentsListUI.setLastNameTextField( (String) studentTablemodel.getValueAt(firstIndex, 1));
            studentsListUI.setAgeTextField( (String) studentTablemodel.getValueAt(firstIndex, 2));
	}   
        
        @Override
        public void tableChanged(TableModelEvent e) {
	   try {
	    	// get the index of the inserted row
	        //tableModel.getRowSet().moveToCurrentRow();
	    	int firstIndex =  e.getFirstRow();
	    	
	    	// create a new table model with the new data
	        studentTablemodel = new StudentTableModel(studentTablemodel.getList(), studentTablemodel.getEntityManager());
	        studentTablemodel.addTableModelListener(this);
	        // update the JTable with the data
	    	studentsListUI.updateTable1();
	    
	        studentsListUI.setFirstNameTextField( (String) studentTablemodel.getValueAt(firstIndex, 0));
                studentsListUI.setLastNameTextField( (String) studentTablemodel.getValueAt(firstIndex, 1));
                studentsListUI.setAgeTextField( (String) studentTablemodel.getValueAt(firstIndex, 2));

	} catch(Exception exp) {
		exp.getMessage();
		exp.printStackTrace();
	}
	}
        
	public void findStudentNames(String name){
		
	}
	
	public void findStudentID(int i){
		
	}
	
	public void findStudentAge(int age){
		
	}
	
	public void addStudent(String[] array){
            studentTablemodel.addRow(array);	
	}
	
	public void deleteStudent(String[] array){
            studentTablemodel.deleteRow(array);	
	}
	
	public void updateStudent(int rowNumber, String[] array){
            studentTablemodel.updateRow(rowNumber, array);	
	}

		
}
