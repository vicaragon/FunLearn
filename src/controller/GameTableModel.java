package controller;

import java.util.List;
import model.*;
import view.*;
import javax.swing.table.AbstractTableModel;
import javax.persistence.*;

public class GameTableModel extends AbstractTableModel {
	private List<Game> gamesResultList;
	private EntityManager manager;
	private GameService gameService;
	private Game game;	
	private int numcols,numrows;
	public GameTableModel () {
		manager = SetupUI.factory.createEntityManager();
		game = new Game();
		gameService = new GameService(manager);
                gamesResultList = gameService.readAll();
                numrows = gamesResultList.size();
                numcols = game.getNumberOfColumns();
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return numrows;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return numcols;
	}

	@Override
	public Object getValueAt(int row, int col) {
                try {
                   return gamesResultList.get(row).getColumnData(col);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
        
        public Class<?> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	 }
        
	public List<Game> getList() {
		return gamesResultList;
	}
	public EntityManager getEntityManager() {
		return manager;
	}
        
	 public GameTableModel(List<Game> list, EntityManager em)  {
	    gamesResultList = list;
	    numrows = gamesResultList.size();
	    game = new Game();
	   	numcols = game.getNumberOfColumns();     
		manager = em;  
		gameService = new GameService(manager);
	 }
	

}
