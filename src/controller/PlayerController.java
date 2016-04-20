package controller;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import view.StudentsListUI;
import javax.swing.table.TableModel;
import javax.swing.event.*;
import javax.swing.ListSelectionModel;

public class PlayerController implements ListSelectionListener, TableModelListener {
	private PlayerTableModel playerTablemodel;

    public PlayerTableModel getPlayerTablemodel() {
        return playerTablemodel;
    }

    public void setPlayerTablemodel(PlayerTableModel playerTablemodel) {
        this.playerTablemodel = playerTablemodel;
    }
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
            ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
            int firstIndex = selectModel.getMinSelectionIndex();
            studentsListUI.setPlayerID( (String) playerTablemodel.getValueAt(firstIndex, 0));
            studentsListUI.setPlayerName( (String) playerTablemodel.getValueAt(firstIndex, 1));
	}   
        
        @Override
        public void tableChanged(TableModelEvent e) {
	   try {
	    	int firstIndex =  e.getFirstRow();
	    	// create a new table model with the new data
	        playerTablemodel = new PlayerTableModel(playerTablemodel.getPlayerIDs(), playerTablemodel.getPlayerList());
	        playerTablemodel.addTableModelListener(this);
	        // update the JTable with the data
	    	studentsListUI.updateTable2();	    
	} catch(Exception exp) {
		exp.getMessage();
		exp.printStackTrace();
	}
	}

        public void addPlayer(String ID, String name){
            playerTablemodel.addRow(Integer.valueOf(ID), name);	
	}
        
	public void deletePlayer(String ID, String name){
            if (ID.equals("") || name.equals("")) {
                JOptionPane.showMessageDialog(null,"Please select a player to delete","No players selected",JOptionPane.ERROR_MESSAGE);
            } else {
                playerTablemodel.deleteRow(Integer.valueOf(ID), name);
            }
	}	
}
