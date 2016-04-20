package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import view.StoryUI;

public class StoryController implements TableModelListener {
	private StoryTableModel storyTablemodel;
        private StoryUI storyUI;
	private int index;
        private String storyName;
        private String audioPath;
        private ArrayList<String> storyText;
        private ArrayList<String> picturePaths;
        private ArrayList<String> pictureTime;

	/**
	 * @param story
	 */
        public StoryController(StoryUI storyUI) {
            this.storyUI = storyUI;
            storyTablemodel = new StoryTableModel();
            storyTablemodel.addTableModelListener(this);
        }
        
        public StoryTableModel getTableModel() {
            return storyTablemodel;
	}
        
        public void loadStory(int storyNumber){
            index = storyNumber;
            storyName = (String)storyTablemodel.getValueAt(storyNumber,1);
            audioPath = (String)storyTablemodel.getValueAt(storyNumber,4);
            storyText = new ArrayList<String>(Arrays.asList(((String) storyTablemodel.getValueAt(storyNumber, 5)).split(";")));
            picturePaths = new ArrayList<String>(Arrays.asList(((String) storyTablemodel.getValueAt(storyNumber, 6)).split(";")));
            pictureTime = new ArrayList<String>(Arrays.asList(((String)storyTablemodel.getValueAt(storyNumber,7)).split(";")));
        }
        
        public void loadStoryEntry(StoryUI newStoryUI){
            newStoryUI.setStoryName(storyName);
            newStoryUI.setAudioPath(audioPath);
            newStoryUI.setStoryText(storyText);
            newStoryUI.setPicturePaths(picturePaths);
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (String t:pictureTime){
                temp.add(Integer.parseInt(t));
            }
            newStoryUI.setPictureTime(temp);
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