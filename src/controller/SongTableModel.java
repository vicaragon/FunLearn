package controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.*;
import view.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SongTableModel extends AbstractTableModel {
	private List<Song> songsResultList;
	private EntityManager manager;
	private SongService songService;
	private Song song;
	private int numcols,numrows;
	public SongTableModel () {
		manager = SetupUI.factory.createEntityManager();
		song = new Song();
		songService = new SongService(manager);
                songsResultList = songService.readAll();
                numrows = songsResultList.size();
                numcols = song.getNumberOfColumns();
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
		// TODO Auto-generated method stub
		try {
                   return songsResultList.get(row).getColumnData(col);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
        
        @Override
	public Class<?> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	 }
        
	//public void setValueAt(Object aValue, int row, int col) {
		// TODO Auto-generated method stub
	//}
	public List<Song> getList() {
		return songsResultList;
	}
	public EntityManager getEntityManager() {
		return manager;
	}
        
        	 // create a new table model using the existing data in list
	 public SongTableModel(List<Song> list, EntityManager em)  {
	    songsResultList = list;
	    numrows = songsResultList.size();
	    song = new Song();
	    numcols = song.getNumberOfColumns();     
	    manager = em;  
	    songService = new SongService(manager);
	 }
	

}
