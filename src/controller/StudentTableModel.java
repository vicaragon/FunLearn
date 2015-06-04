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
            Student newRecord = studentService.createStudent(new Integer(0), (String) array[1],(String) array[2], Integer.parseInt((String) array[3]), Integer.parseInt((String) array[4]), Integer.parseInt((String) array[5]), Integer.parseInt((String) array[6]));
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
        
        public void deleteRow(int rowNumber, Object[] array) {
            EntityTransaction userTransaction = manager.getTransaction();  
            userTransaction.begin();
            studentService.deleteStudent(Integer.parseInt((String) array[0]));
            userTransaction.commit();
		 		 
            // set the current row to rowIndex
	    int row = studentsList.size();  
	    int col = 0;

	    studentsList.remove(rowNumber-1);
            
            while(rowNumber < row) {  
                Student element1 = studentsList.get(rowNumber-1);
                Student element2 = studentsList.get(rowNumber);
                int i = 0;
                try {
                    while (i < 7)
                    element1.setColumnData(i, element2.getColumnData(i)); 
        //            fireTableCellUpdated((rowNumber-1), i);
                } catch(Exception err) {
			err.toString();
		}
                rowNumber++;
            }
		          
	    numrows--;
        }
        
        public void updateRow(int rowNumber, Object[] array) {
            EntityTransaction userTransaction = manager.getTransaction();  
            userTransaction.begin();
		Student updatedRecord = studentService.updateStudent(Integer.parseInt((String) array[0]),(String) array[1],(String) array[2], Integer.parseInt((String) array[3]));
		userTransaction.commit();
		studentsList.set(rowNumber-1, updatedRecord);
                int row = studentsList.size();  
                int col = 0;

             // update the data in the model to the entries in array
                for (Object data : array) {
          	  setValueAt((String) data, rowNumber, col++);
                }
        }
	

}
