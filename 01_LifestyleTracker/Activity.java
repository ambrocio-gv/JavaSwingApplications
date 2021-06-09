/**
This is a template for a Java file.

@author Gerard V. Ambrocio
@version December 04, 2021
**/


public class Activity {

	private String ActivityName;
	private double ActivityCalories;
	
	public Activity (String n, double c) {
		//initializes the instance fields with the values provided in the parameters
		
		//n - name of the activity
		//c - calorie value of the activity
		
		ActivityName = n;
		ActivityCalories = c;
	}
	
	public String getActivityName() {
		//returns the name of the Activity
		
		return ActivityName;
	}
	
	
	public double getActivityCalories() {
		//returns the calorie value burned when performing the Activity for one hour
		
		return ActivityCalories;
	}
	
	public void updateCalories(double c) {
		//enables the Activity to update the calorie value
		
		//c - new calorie value burned when performing the activity for one hour 
		
		
		ActivityCalories = c;
	}
	
	
	
	
	
	
	
	
	
	
	
}
