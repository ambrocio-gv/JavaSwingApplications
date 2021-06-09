/**
This is a template for a Java file.

@author Gerard V. Ambrocio
@version December 04, 2021
**/


public class Food {
	
	private String FoodName;
	private double FoodCalories;
	
	public Food(String f, double c) {
		//initializes the instance fields with the values provided in the parameters
		
		//f - name of the food
		//c - calorie value of the food
		
		FoodName = f;
		FoodCalories = c;
		
		
	}
	
	public String getFoodName() {
		//returns the name of the Food
		
		return FoodName;
	}
	
	public double getFoodCalories() {
		//returns the calorie value of one serving of the Food
		
		return FoodCalories;
	}
	
	public void updateCalories(double c) {
		//enables the Food to update the calorie value
		
		//c - new calorie value of one serving of the food
		
		FoodCalories = c;
		
		
	}	
	
	
	
}
