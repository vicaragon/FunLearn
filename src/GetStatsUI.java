import javax.swing.*;


public class GetStatsUI {
	private JFrame window;
	private JPanel panel;
	private JMenu menu;
	private JMenuItem allStats;
	private JMenuItem GameStats;
	private JMenuItem StoryStats;
	private JButton max;
	private JButton min;
	private JButton mean;
	private GetStats gsController;
	
	public GetStatsUI(){
		
	}
	
	public void registerEvents(){
		
	}
}

class GetStats{
	private StudentInformation student;
	private FindStudent find;
	
	public GetStats(){
		
	}
	
	public double getMax(){
		
		return 0.0;
	}
	
	public double getMin(){
		
		return 0.0;
	}
	
	public double getMean(){
		return 0.0;
	}
	
	public void setStudent(StudentInformation s){
		student = s;
	}
	
	public StudentInformation getStudent(){
		return student;
	}
	
	public double getGameMax(){
		return 0.0;
	}
	
	public double getStoryMax(){
		return 0.0;
	}
	
	public double getGameMin(){
		return 0.0;
	}
	
	public double getStoryMin(){
		return 0.0;
	}
	
	public double getStoryMean(){
		return 0.0;
	}
	
	public double getGameMean(){
		return 0.0;
	}
}