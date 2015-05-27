package view;
import controller.*;
import model.*;

import java.awt.image.*;
import java.io.File;
import java.util.*;

import javax.swing.*;


public class SongUI {
	private Song song;
	private SongController playSong;//song controller
	private JFrame window;//the window frame
	private JButton back;//to go back to previous page
	private JButton next;//to go to next page
	private JMenu menu;//to display song menu
	private JMenuItem selectSongs;//to select from all songs
	private JButton play;//to play the song
	private JButton stop;//to stop the song
	private JTextArea nowPlaying;//to dispay song name
	private BufferedImage image;//to load the image for the responding song
	private File imageF;//the image file
	private File songF;//the song file
	private String imageFName;//the image file name
	private String songFName;//the song file name
	
	private JPanel panel;//panel
	
	public SongUI(){
		//initialize window frame
		//add panel
		
		//instantiate playSong
		//instantiate all control buttons
		
		//register all event listeners
	}
	
	public void loadSongs(){
		//create buttons from 
	}
	
	public void registerEvents(){
		
	}
	
}