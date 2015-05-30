package controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.*;
import view.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StoryTableModel extends AbstractTableModel {
	private List<Story> storysList;
	private EntityManager manager;
	private StoryService storyService;
	private Story story;
	private int numcols,numrows;
	public StoryTableModel () {
		manager = StartUI.factory.createEntityManager();
		story = new Story();
		storyService = new StoryService(manager);
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
