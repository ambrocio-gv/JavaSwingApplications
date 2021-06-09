/**
This is a template for a Java file.

@author Gerard V. Ambrocio
@version December 04, 2021
**/


import java.util.ArrayList;
import java.util.List;

public class LifestyleTracker {	
	
	private List<Food> FoodList;
	private List<Activity> ActivityList;	
	private List<Food> EatList;	
	private List<Activity> PerformList;
    private boolean isUpdated = false;
    private int isUpdatedIndex = 0;
    private boolean isContains = false;
    private int isContainsIndex = 0;
	private double isContainsCalories = 0;
    private double TotalCaloriesConsumed = 0;
    private double TotalCaloriesBurned = 0;
    private String message = "";
	
	public LifestyleTracker() {
		//initializes the instance fields
		
		ActivityList = new ArrayList<Activity>();
		FoodList = new ArrayList<Food>();		
		EatList  = new ArrayList<Food>();
		PerformList = new ArrayList<Activity>();
		
		
	}
	
	public String addFood(String n, double c) {
		//creates a Food object, given a name and a calorie value
		//new Food object is added to the collection of Food objects
		
		//if Food object with the same name already exists in the collection of Food objects,
		//the calorie value of the existing Food object is update with the provided calorie value
		
		//feedback message is returned
		
		//f - name of food
		//c - calorie value of one serving of food
		
		Food FoodObject = new Food(n, c);
		
		
		if(FoodList.isEmpty()) {
			FoodList.add(FoodObject);
			System.out.printf("Added Food %s %5.2f \n", FoodObject.getFoodName() ,FoodObject.getFoodCalories());		
			message = String.format("Added Food %s %5.2f \n", FoodObject.getFoodName() ,FoodObject.getFoodCalories());
		}
		else {		
			 for(int i = 0; i <= FoodList.size()-1; i++)
			 {					
				    if(FoodList.get(i).getFoodName().equals(n)) {				    					
						isUpdated = true;
						isUpdatedIndex = i;						
						break;
					}				    
			 }
			 
			 if(isUpdated == true) {
				 FoodList.remove(isUpdatedIndex);
				 FoodObject.updateCalories(c);
				 FoodList.add(FoodObject);
				 System.out.printf("Updated Food %s with %5.2f  \n", FoodObject.getFoodName() ,FoodObject.getFoodCalories());
				 message = String.format("Updated Food %s with %5.2f  \n", FoodObject.getFoodName() ,FoodObject.getFoodCalories());
			 }
			 else {
				 FoodList.add(FoodObject);
				 System.out.printf("Added Food %s %5.2f \n", FoodObject.getFoodName() ,FoodObject.getFoodCalories());
				 message = String.format("Added Food %s %5.2f \n", FoodObject.getFoodName() ,FoodObject.getFoodCalories());
			 }			
		}		
		
		isUpdated = false;
		return message;	
		
	}
	
	public String addActivity(String n, double c) {
		//creates an Activity object,given a name and a calorie value
		//the new Activity object is added to the collection of activity objects
		//if Activity object with the same name already exists in the collection of Activity objects,
		//the calorie value of the existing Activity object is update with the provided calorie value
		
		//feedback message is returned
		
		//n - name of activity
		//c - calorie value of performing the activity for one hour
		
		Activity ActivityObject = new Activity(n, c);
		
		if(ActivityList.isEmpty()) {
			ActivityList.add(ActivityObject);
			System.out.printf("Added Activity %s %5.2f \n", ActivityObject.getActivityName() ,ActivityObject.getActivityCalories());	
			message = String.format("Added Activity %s %5.2f \n", ActivityObject.getActivityName() ,ActivityObject.getActivityCalories());
		}
		
		else {		
			 for(int i = 0; i <= ActivityList.size()-1; i++)
			 {					
				    if(ActivityList.get(i).getActivityName().equals(n)) {				    					
						isUpdated = true;
						isUpdatedIndex = i;						
						break;
					}				    
			 }
		
			 if(isUpdated == true) {
				 ActivityList.remove(isUpdatedIndex);
				 ActivityObject.updateCalories(c);
				 ActivityList.add(ActivityObject);
				 System.out.printf("Updated Activity %s with %5.2f  \n", ActivityObject.getActivityName() ,ActivityObject.getActivityCalories());
				 message = String.format("Updated Activity %s with %5.2f  \n", ActivityObject.getActivityName() ,ActivityObject.getActivityCalories());
			 }
			 else {
				 ActivityList.add(ActivityObject);	
				 System.out.printf("Added Activity %s %5.2f \n", ActivityObject.getActivityName() ,ActivityObject.getActivityCalories());
				 message = String.format("Added Activity %s %5.2f \n", ActivityObject.getActivityName() ,ActivityObject.getActivityCalories());
			 }
		
		
		}
		
		
		isUpdated = false;
		return message;	
				
		
		
	}
	
	public String eat(String foodName, double servings) {
		//records the Food eaten by the user, given the name of the food and the new servings consumed,
		//provided that the identified Food object exists in the Trackers collection of Food objects
		
		//a record of the consumed food is added to the records to the Tracker
		
		//feedback message is returned
		
		//if Food object does not exist, the corresponding feedback is returned
		//a negative value  of the number of servings is not allowed. The corresponding feedback message is returned
		
		//foodName - name of the food
		//servings - number of servings eaten
		
		
		
		
	
		if(servings < 0) {
			
			System.out.println("Number of servings cannot be negative.");
			message = "Number of servings cannot be negative.";
		}
		
		
		
		else
		{
			for(int i = 0; i <= FoodList.size()-1; i++)
			{
				if(FoodList.get(i).getFoodName().equals(foodName))
				{
					isContains = true;
					isContainsIndex = i;
					isContainsCalories = FoodList.get(i).getFoodCalories();
				}
			}
			
			if(isContains == true) {
				
				double totalcalories = isContainsCalories * servings;
				Food EatObject = new Food(foodName, totalcalories);
				EatList.add(EatObject);
				System.out.printf("Ate %4.2f serving(s) of %s, %5.2f kcal.\n", servings, foodName, totalcalories);
				TotalCaloriesConsumed += totalcalories;
				message = String.format("Ate %4.2f serving(s) of %s, %5.2f kcal.\n", servings, foodName, totalcalories);
			}
			
			else {
				System.out.println("The specified food does not exist.");
				message = "The specified food does not exist.";
			}			
		}
		isContains = false;
		return message;
		
		
	}
	
	public String perform(String actName, double hours) {
		//records the activity done by the user, given the name of the Activity and the number of hours that the activity was performed,
		//provided that the identified Activity object exists in the Trackers collection of Activity objects
		
		//a record of the performed Activity is added to the records of the Tracker
		
		//a feedback message is returned
		
		//if Activity object does not exist, the corresponding feedback is returned
		//a negative value of the number of hours is not allowed. The corresponding feedback message is returned
		
		//actName - name of the food
		//servings - number of servings eaten
		
		
		
		if(hours < 0) {
			
			System.out.println("Number of hours cannot be negative.");
			message = "Number of hours cannot be negative.";
		}
		
		else {
			for(int i = 0; i <= ActivityList.size()-1; i++) 
			{
				if(ActivityList.get(i).getActivityName().equals(actName)) 
				{
					isContains = true;
					isContainsIndex = i;
					isContainsCalories = ActivityList.get(i).getActivityCalories();
				}
			}
			
			if(isContains == true) {
				
				double totalcalories = isContainsCalories * hours;
				Activity PerformObject = new Activity(actName, totalcalories);
				PerformList.add(PerformObject);	
				System.out.printf("Performed %4.2f hour(s) of %s, %5.2f kcal.\n", hours, actName, totalcalories );
				
				message = String.format("Performed %4.2f hour(s) of %s, %5.2f kcal.\n", hours, actName, totalcalories );
				TotalCaloriesBurned += totalcalories;
			}
			
			else {
				System.out.println("The specified activity does not exist.");
				message = "The specified activity does not exist.";
				
			}
	
		}
		isContains = false;
		return message;
		
	}
	
	
	public String report() {
		//displays the recorded items
		//It displays all the records of the Food eaten, as well as the total calories consumed
		//It displays all the records of the Activities done, as well as well as the total calories burned
		//It provides a prediction of weight loss or weight gain based on the net calories
		String a = null;
		
		System.out.println("----------------"); 
		System.out.println("LIFESTYLE REPORT"); 
		System.out.println("----------------"); 
		System.out.println("Food Consumed"); 
		
		for (int i = 0; i < EatList.size(); i++) {
			for(int j = 0; j < FoodList.size(); j++) {
				if(EatList.get(i).getFoodName().equals(FoodList.get(j).getFoodName())) {
					double servings = EatList.get(i).getFoodCalories() / FoodList.get(j).getFoodCalories();
					System.out.printf("%5.2f serving(s) of %s, %5.2f kcal. \n", servings,  EatList.get(i).getFoodName(), EatList.get(i).getFoodCalories());
				}			
			}
		}
		
		System.out.println("----------------"); 
		System.out.printf("Total Calories Consumed: %5.2f \n", TotalCaloriesConsumed); 
		System.out.println("----------------"); 	
		
	    System.out.println("Activities Performed"); 
	    for (int i = 0; i < PerformList.size(); i++) {
			for(int j = 0; j < ActivityList.size(); j++) {
				if(PerformList.get(i).getActivityName().equals(ActivityList.get(j).getActivityName())) {
					double hours = PerformList.get(i).getActivityCalories() / ActivityList.get(j).getActivityCalories();
					System.out.printf("%5.2f hours(s) of %s, %5.2f kcal. \n", hours,  PerformList.get(i).getActivityName(), PerformList.get(i).getActivityCalories());
				}			
			}
		}	
	    
	    System.out.println("----------------"); 
		System.out.printf("Total Calories Burned: %5.2f \n", TotalCaloriesBurned); 
		System.out.println("----------------"); 
		System.out.printf("Net Calories for the Day: %5.2f \n", (TotalCaloriesConsumed - TotalCaloriesBurned)); 
		System.out.println("If you keep up this lifestyle..."); 
		
		double CalorieConversion = 0.00012959782 * (Math.abs((TotalCaloriesConsumed - TotalCaloriesBurned))); 
		
		if((TotalCaloriesConsumed - TotalCaloriesBurned) < 0) { // lose
			System.out.printf("In a week, you will lose %4.2f kilograms.\n", CalorieConversion* 7);
			System.out.printf("In a month, you will lose %4.2f kilograms.\n", CalorieConversion * 30);
			System.out.printf("In 3 months, you will lose %4.2f kilograms.\n", CalorieConversion * 30 * 3);
			System.out.printf("In 6 months, you will lose %4.2f kilograms.\n", CalorieConversion * 30 * 6);
		}
		
		else if((TotalCaloriesConsumed - TotalCaloriesBurned) > 0) { // gain
			System.out.printf("In a week, you will gain %4.2f kilograms.\n", CalorieConversion * 7);
			System.out.printf("In a month, you will gain %4.2f kilograms.\n", CalorieConversion * 30);
			System.out.printf("In 3 months, you will gain %4.2f kilograms.\n", CalorieConversion * 30 * 3);
			System.out.printf("In 6 months, you will gain %4.2f kilograms.\n", CalorieConversion * 30 * 6);
		}
		
		else if((TotalCaloriesConsumed - TotalCaloriesBurned) == 0) { // neither
			System.out.printf("In a week, you will neither gain or lose %4.2f kilograms.\n", CalorieConversion * 7);
			System.out.printf("In a month, you will neither gain or lose %4.2f kilograms.\n", CalorieConversion * 30);
			System.out.printf("In 3 months, you will neither gain or lose %4.2f kilograms.\n", CalorieConversion * 30 * 3);
			System.out.printf("In 6 months, you will neither gain or lose %4.2f kilograms.\n", CalorieConversion * 30 * 6);
		}
	   
		System.out.println("----------------");
		
		//message = String.format
		
		
		
		
		return a;
	}
	
	
	
	
	
	
	
}
