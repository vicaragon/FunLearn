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
	private List<Song> songsList;
	private EntityManager manager;
	private SongService songService;
	private Song song;
	private int numcols,numrows;
	public SongTableModel () {
		manager = StartUI.factory.createEntityManager();
		song = new Song();
		songService = new SongService(manager);
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
	public List<Song> getList() {
		return songsList;
	}
	public EntityManager getEntityManager() {
		return manager;
	}
	

}
