package controller;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import view.*;


public class SongController implements TableModelListener {
        private int index;
        private SongTableModel songTablemodel;
        private SongUI songUI;
        private String songName;
        private String audioPath;
        private ArrayList<String> picturePaths;
        private ArrayList<String> pictureTime;
        
	/**
	 * @param song
	 */
        public SongController(SongUI songUI) {
            this.songUI = songUI;
            songTablemodel = new SongTableModel();
            songTablemodel.addTableModelListener(this);
        }
        
        public SongTableModel getTableModel() {
            return songTablemodel;
	}
        
	public void loadSong(int songNumber) {
            index = songNumber;
            songName = (String)songTablemodel.getValueAt(songNumber,1);
            audioPath = (String)songTablemodel.getValueAt(songNumber,4);
            picturePaths = new ArrayList<String>(Arrays.asList(((String) songTablemodel.getValueAt(songNumber, 5)).split(";")));
            pictureTime = new ArrayList<String>(Arrays.asList(((String)songTablemodel.getValueAt(songNumber,6)).split(";")));
        }
        
	public void loadSongEntry(SongUI newSongUI){
            newSongUI.setSongName(songName);
            newSongUI.setAudioPath(audioPath);
            newSongUI.setPicturePaths(picturePaths);
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (String t:pictureTime){
                temp.add(Integer.parseInt(t));
            }
            newSongUI.setPictureTime(temp);
        }

    @Override
    public void tableChanged(TableModelEvent tme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}