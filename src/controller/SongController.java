package controller;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import model.*;
import view.*;


public class SongController implements TableModelListener {
	private SongTableModel songTablemodel;
        private SongUI songUI;
	/**
	 * @param song
	 */
        public SongController(SongUI songUI) {
            this.songUI = songUI;
            songTablemodel = new SongTableModel();
            songTablemodel.addTableModelListener(this);
        }
	public void playSong(){
		
	}
	public void pauseSong(){
		
	}
	public void resumeSong(){
		
	}

    @Override
    public void tableChanged(TableModelEvent tme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}