package controller;

import java.io.File;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import view.StoryUI;

public class StoryController implements TableModelListener {
	private StoryTableModel storyTablemodel;
        private StoryUI storyUI;
	private int index;

	/**
	 * @param story
	 */
        public StoryController(StoryUI storyUI) {
            this.storyUI = storyUI;
            storyTablemodel = new StoryTableModel();
            storyTablemodel.addTableModelListener(this);
        }
        
        public void loadStory(int storyNumber){
            
        }
        
	public String retrieveParagraph() {
		return null;
	};
	public ImageIcon retrievePicture() {
		return null;
	};
	public File retrievemusicAudio() {
		return null;
	};
	public File paragraphAudioPath() {
		return null;
	};

    @Override
    public void tableChanged(TableModelEvent tme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}