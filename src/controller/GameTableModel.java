package controller;

import java.util.List;
import model.*;
import view.*;
import javax.swing.table.AbstractTableModel;
import javax.persistence.*;

public class GameTableModel extends AbstractTableModel {
	private List<Game> gameResultList;
	private EntityManager manager;
	private GameService gameService;
	private Game game;	
	private int numcols,numrows;
	public GameTableModel () {
		manager = SetupUI.factory.createEntityManager();
		game = new Game();
		gameService = new GameService(manager);
                gameResultList = gameService.readAll();
                numrows = gameResultList.size();
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
		  return gameResultList.get(row).getColumnData(col);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	//public void setValueAt(Object aValue, int row, int col) {
		// TODO Auto-generated method stub
	//}
	public List<Game> getList() {
		return gameResultList;
	}
	public EntityManager getEntityManager() {
		return manager;
	}
        
        	 // create a new table model using the existing data in list
	 public GameTableModel(List<Game> list, EntityManager em)  {
	    gameResultList = list;
	    numrows = gameResultList.size();
	    game = new Game();
	   	numcols = game.getNumberOfColumns();     
		manager = em;  
		gameService = new GameService(manager);
	 }
	

}
