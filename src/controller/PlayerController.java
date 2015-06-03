package controller;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import view.StudentsListUI;
import javax.swing.table.TableModel;
import javax.swing.event.*;
import javax.swing.ListSelectionModel;

public class PlayerController implements ListSelectionListener, TableModelListener {
	private PlayerTableModel playerTablemodel;
        private StudentsListUI studentsListUI;
	public PlayerController(StudentsListUI studentsListUI) {
            this.studentsListUI = studentsListUI;
            playerTablemodel = new PlayerTableModel();
            playerTablemodel.addTableModelListener(this);
        }
        
        public TableModel getTableModel() {
		return playerTablemodel;
	}
        
        @Override
	public void valueChanged(ListSelectionEvent e) {
	}   
        
        @Override
        public void tableChanged(TableModelEvent e) {
	   try {
	    	// get the index of the inserted row
	        //tableModel.getRowSet().moveToCurrentRow();
	    	int firstIndex =  e.getFirstRow();
	    	
	    	// create a new table model with the new data
	        playerTablemodel = new PlayerTableModel(playerTablemodel.getList());
	        playerTablemodel.addTableModelListener(this);
	        // update the JTable with the data
	    	studentsListUI.updateTable1();	    
	} catch(Exception exp) {
		exp.getMessage();
		exp.printStackTrace();
	}
	}

	public void deletePlayer(String[] array){
      //      playerTablemodel.deleteRow(array);	
	}	
}
