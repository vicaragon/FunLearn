package controller;
import sun.audio.AudioStream;
import model.*;

import javax.swing.*;
import view.StoryUI;

public class StoryController {
	private StoryTableModel storyTablemodel;
        private StoryUI storyUI;
	private int index;

	/**
	 * @param story
	 */
	public StoryController(StoryUI storyUI) {
		this.storyUI = storyUI;
	}
	public String retrieveParagraph() {
		return null;
	};
	public ImageIcon retrievePicture() {
		return null;
	};
	public AudioStream retrievemusicAudio() {
		return null;
	};
	public AudioStream paragraphAudioPath() {
		return null;
	};
	
}