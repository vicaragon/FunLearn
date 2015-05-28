package controller;

import javax.swing.table.AbstractTableModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class storyTableModel extends AbstractTableModel {
	private List<story> storysList;
	private static final String PERSISTENCE_UNIT_NAME="PersistenceUnit";
	private static EntityManagerFactory factory;
	private EntityManager manager;
	private storyService storyService;
	private story story;
	private storyController storyController;
	private int numcols,numrows;
	public storyTableModel () {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		manager = factory.createEntityManager();
		story = new story();
		storyService = new storyService(manager);
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
	public List<story> getList() {
		return storysList;
	}
	public EntityManager getEntityManager() {
		return manager;
	}
	

}
