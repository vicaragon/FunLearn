import java.awt.image.*;
import java.io.File;
import java.util.*;

import javax.swing.*;


public class SongUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
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
	private PlaySong playSong;//song controller
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

class PlaySong{
	private Song song;
	private HashSet<Song> songs;
	
	public void playSong(){
		
	}
	
	public void updateSong(){
		
	}
	
	public HashSet<Song> getAllSongs(){
		
		return songs;
	}
	
	public void setSong(Song song1){
		song = song1;
	}
}

class Song{
	private String songName;
	private int ageGroup;
	private int level;
	
	public String getName(){
		return songName;
	}
	
	public void setName(String name){
		songName = name;
	}
	
	public int getAge(){
		return ageGroup;
	}
	
	public void setAge(int age){
		ageGroup = age;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setLevel(int l){
		level = l;
	}
		
}