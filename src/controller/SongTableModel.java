package controller;

import javax.swing.table.AbstractTableModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class songTableModel extends AbstractTableModel {
	private List<song> songsList;
	private static final String PERSISTENCE_UNIT_NAME="PersistenceUnit";
	private static EntityManagerFactory factory;
	private EntityManager manager;
	private songService songService;
	private song song;
	private songController songController;
	private int numcols,numrows;
	public songTableModel () {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		manager = factory.createEntityManager();
		song = new song();
		songService = new songService(manager);
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
	public List<song> getList() {
		return songsList;
	}
	public EntityManager getEntityManager() {
		return manager;
	}
	

}
