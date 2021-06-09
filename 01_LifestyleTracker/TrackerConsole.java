/**
This is a template for a Java file.

@author Gerard V. Ambrocio (207165)
@version December 04, 2021
**/


import java.util.Scanner;

public class TrackerConsole {
	 //Food - calls addFood() on the LifestyleTracker object, given the values that follow
	 //Activity - calls addActivity() on the LifestyleTracker object, given the values that follow
	 //Eat - calls eat() on the LifestyleTracker object, given the values that follow
	 //Perform - calls perform() on the LifestyleTracker object, given the values that follow
	 //Report - calls report() on the LifestyleTracker object
	
	
	
	
	public static void main(String args[]) {
		// TODO Auto-generated method stub

		System.out.printf("Welcome to %s's Lifestyle Tracker!\n", args[0]); 
		
		TrackerGUI gd = new TrackerGUI(400, 750);
		
		gd.setUpGUI();
		gd.setUpButtonListeners();
		

		
		LifestyleTracker Tracker = new LifestyleTracker();
		
		double calorie = 0;
		double hours = 0;
		double servings = 0;
		
		
		
		
		Scanner scanner = new Scanner(System.in);
		
		
		
		while (scanner.hasNext()) {
		
			String initialword = scanner.next();
			
			if(initialword.equals("Food")) {
				String food = scanner.next();				
				calorie = scanner.nextDouble();
				Tracker.addFood(food, calorie);
			}
			
			else if(initialword.equals("Activity")) {
				String activity = scanner.next();				
				calorie = scanner.nextDouble();
				Tracker.addActivity(activity, calorie);
			}
			
			else if(initialword.equals("Eat")) {
				String food = scanner.next();				
				servings = scanner.nextDouble();
				Tracker.eat(food, servings);
			}
			
			else if(initialword.equals("Perform")) {
				String activity = scanner.next();				
				hours = scanner.nextDouble();
				Tracker.perform(activity, hours);
			}
			
			else if(initialword.equals("Report")) {
				Tracker.report();
				
				
			}
			
			else {
				 System.out.println("Input Error");
			}
			
			
			
			
		}
		
		
		
		
		scanner.close();
		
	}

}
