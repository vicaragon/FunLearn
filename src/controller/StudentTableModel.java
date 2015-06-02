package controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.*;
import view.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentTableModel extends AbstractTableModel {
	private List<Student> studentsList;
        private EntityManager manager;
	private StudentService studentService;
	private Student student;
	private int numcols,numrows;
	public StudentTableModel () {
            
		manager = SetupUI.factory.createEntityManager();
		student = new Student();
		studentService = new StudentService(manager);
                
                studentsList = studentService.readAll();
                
                numrows = studentsList.size();
                numcols = student.getNumberOfColumns();
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return numcols;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return numrows;
	}

	@Override
	public Object getValueAt(int row, int col) {
            	try {
                    return studentsList.get(row).getColumnData(col);
		} catch (Exception e) {
                    e.getMessage();
                    return null;
		}
	}
        
        public boolean isCellEditable(int rowIndex, int colIndex) {
		return false;
	 }
        
        public Class<?> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	 }
                 
	public void setValueAt(Object aValue, int row, int col) {
		try {
		   Student element = studentsList.get(row);
                   element.setColumnData(col, aValue); 
                   fireTableCellUpdated(row, col);
		} catch(Exception err) {
			err.toString();
		}	
	}
	public List<Student> getList() {
		return studentsList;
	}
	public EntityManager getEntityManager() {
		return manager;
	}
        
        public StudentTableModel(List<Student> list, EntityManager em)  {
	    studentsList = list;
	    numrows = studentsList.size();
	    student = new Student();
            numcols = student.getNumberOfColumns();     
            manager = em;  
            studentService = new StudentService(manager);
	 }
	

}
