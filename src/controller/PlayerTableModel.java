/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Student;

/**
 *
 * @author Sonam
 */
public class PlayerTableModel extends AbstractTableModel {
    private List<Object> playerList;
    private String playerName;
//    private Object[][] arr;
    private int numcols,numrows;
    
    public PlayerTableModel() {
     playerList = new ArrayList<Object>();
     playerList.add("hello");
//     arr = playerList.toArray(new Object[playerList.size()][]);
     numrows = playerList.size();
     numcols = 1;
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
      	try {
            return playerList.get(row);
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
        try {
           return "player_name";
        } catch (Exception err) {
           return err.toString();
        }             
    }
    
    @Override
    public void setValueAt(Object aValue, int row, int col) {
	try {
   //         playerName = Integer.parseInt((String) value);
//	   Student element = playerList.get(row);
 //          element.setColumnData(col, aValue); 
           fireTableCellUpdated(row, col);
	} catch(Exception err) {
            err.toString();
	}	
    }
    
    public List getList() {
	return playerList;
    }
    
    public PlayerTableModel(List list)  {
        playerList = list;
        numrows = playerList.size();
        numcols = 1;     
     }
    
    public void addRow(Object name) {	 		 
        // set the current row to rowIndex
        playerList.add(name);
	int row = playerList.size();  
	int col = 0;

	// update the data in the model to the entries in array
        setValueAt((String) name, row-1, col);
		          
	numrows++;           
    }
        
        public void deleteRow(Object name) {	 
            // set the current row to rowIndex
            playerList.remove(name);
	    int row = playerList.size();  
	    int col = 0;

	    // update the data in the model to the entries in array
	    setValueAt((String) name, row-1, col);
		          
	    numrows--;
        }
}
