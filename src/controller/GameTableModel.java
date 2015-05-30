package controller;

import java.util.List;
import model.*;
import view.*;
import javax.swing.table.AbstractTableModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GameTableModel extends AbstractTableModel {
	private List<Game> gamesList;
	private EntityManager manager;
	private GameService gameService;
	private Game game;	
	private int numcols,numrows;
	public GameTableModel () {
		manager = StartUI.factory.createEntityManager();
		game = new Game();
		gameService = new GameService(manager);
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
	public List<Game> getList() {
		return gamesList;
	}
	public EntityManager getEntityManager() {
		return manager;
	}
	

}
