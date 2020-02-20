import java.util.ArrayList;

public class Timeline {
	public int numOfDays;
	public ArrayList<Boolean> signingUp;
	public ArrayList<Day> days;
	
	public Timeline(int num){
		numOfDays = num;
		signingUp = new ArrayList<Boolean>();
		for(int i=0; i<numOfDays ; i++) {
			signingUp.add(false);
			days.add(new Day());
		}
		
		
		
		
	}
	
}
