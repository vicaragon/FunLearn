package controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.*;
import view.*;
import javax.persistence.EntityManager;

public class StoryTableModel extends AbstractTableModel {
	private List<Story> storysList;
	private EntityManager manager;
	private StoryService storyService;
	private Story story;
	private int numcols,numrows;
	public StoryTableModel () {
		manager = SetupUI.factory.createEntityManager();
		story = new Story();
		storyService = new StoryService(manager);
                storysList = storyService.readAll();
                numrows = storysList.size();
                numcols = story.getNumberOfColumns();
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
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
            try {
                   return storysList.get(row).getColumnData(col);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	public void setValueAt(Object aValue, int row, int col) {
		// TODO Auto-generated method stub
	}
        
        @Override
	public Class<?> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	 }
        
	public List<Story> getList() {
		return storysList;
	}
	public EntityManager getEntityManager() {
		return manager;
	}
	
        public StoryTableModel(List<Story> list, EntityManager em)  {
	    storysList = list;
	    numrows = storysList.size();
	    story = new Story();
	    numcols = story.getNumberOfColumns();     
	    manager = em;  
	    storyService = new StoryService(manager);
	 }
}
