/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sonam
 */
public class PlayerTableModel extends AbstractTableModel {
    private List<Integer> playerIDs;
    private List<String> playerList;
    private Integer playerID;
    private String playerName;
//    private Object[][] arr;
    private int numcols, numrows;
    
    public PlayerTableModel() {
     playerIDs = new ArrayList<Integer>();
     playerList = new ArrayList<String>();
//     arr = playerList.toArray(new Object[playerList.size()][]);
     numrows = playerList.size();
     numcols = 2;    
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
    public String getValueAt(int row, int col) {
      	try {
            if (col == 0) 
                return Integer.toString(playerIDs.get(row));
            else if (col == 1)
                return playerList.get(row);
            else
		   throw new Exception("Error: invalid column index in playerlist table");
        } catch (Exception e) {
            e.getMessage();
            return null;
	}
    }        
    @Override
    public boolean isCellEditable(int rowIndex, int colIndex) {
	return false;
    }
        
    @Override
    public Class<?> getColumnClass(int col) {
	return getValueAt(0, col).getClass();
    }
        
    @Override
    public String getColumnName(int col) {
        String colName = null;
        try {
            if (col == 0) 
            	   colName = "ID";
            else if (col == 1)
            	   colName = "Name";
            else 
                throw new Exception("Access to invalid column number in courselist table");
        }
        catch (Exception err) {
           return err.toString();
        }  
        return colName;
    }
    
    @Override
    public void setValueAt(Object aValue, int row, int col) {
    }
    
    public List getPlayerIDs() {
	return playerIDs;
    }
    
    public List getPlayerList() {
	return playerList;
    }
    
    public PlayerTableModel(List list1, List list2)  {
        playerIDs = list1;
        playerList = list2;
        numrows = playerList.size();
        numcols = 2;     
     }
    
    public void addRow(Integer ID, String name) {	 		 
        playerIDs.add(ID);
        playerList.add(name);
        System.out.println("ID: " + ID + "name: " + name);
        fireTableRowsInserted(playerList.size()-1, numcols-1);
        numrows++;
    }
        
    public void deleteRow(Integer ID, String name) {
            playerIDs.remove(ID);
            playerList.remove(name);
            fireTableRowsDeleted(playerList.size(), numcols-1);   
        }
}
