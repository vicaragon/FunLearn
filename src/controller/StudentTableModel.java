package controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.*;
import view.*;
import javax.persistence.*;

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
        
        @Override
        public boolean isCellEditable(int rowIndex, int colIndex) {
		return false;
	 }
        
        @Override
        public Class<?> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	 }
        
        @Override
        public String getColumnName(int col) {
            try {
                return student.getColumnName(col);
            } catch (Exception err) {
	        return err.toString();
	       }             
	 }
         
        @Override
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
        
        public void addRow(Object[] array) {
            EntityTransaction userTransaction = manager.getTransaction();  
            userTransaction.begin();
            Student newRecord = studentService.createStudent(new Integer(0), (String) array[0],(String) array[1], Integer.parseInt((String) array[2]), Integer.parseInt((String) array[3]), Integer.parseInt((String) array[4]), Integer.parseInt((String) array[5]));
            userTransaction.commit();
		 		 
            // set the current row to rowIndex
            studentsList.add(newRecord);
	    int row = studentsList.size();  
	    int col = 0;

	    // update the data in the model to the entries in array
	    for (Object data : array) {
	     	 setValueAt((String) data, row-1, col++);
	    }
		          
	    numrows++;           
        }
        
        public void deleteRow(Object[] array) {
            
        }
        
        public void updateRow(int rowNumber, Object[] array) {
            
        }
	

}
