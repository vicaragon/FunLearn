package controller;

import javax.swing.table.AbstractTableModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentTableModel extends AbstractTableModel {
	private List<Student> StudentsList;
	private static final String PERSISTENCE_UNIT_NAME="PersistenceUnit";
	private static EntityManagerFactory factory;
	private EntityManager manager;
	private StudentService StudentService;
	private Student Student;
	private StudentController StudentController;
	private int numcols,numrows;
	public StudentTableModel () {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		manager = factory.createEntityManager();
		Student = new Student();
		StudentService = new StudentService(manager);
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	public void setValueAt(Object aValue, int row, int col) {
		// TODO Auto-generated method stub
	}
	public List<Student> getList() {
		return StudentsList;
	}
	public EntityManager getEntityManager() {
		return manager;
	}
	

}
