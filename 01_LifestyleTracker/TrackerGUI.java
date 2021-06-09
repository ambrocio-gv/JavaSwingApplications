/**
This is a template for a Java file.

@author Gerard V. Ambrocio
@version December 04, 2021
**/



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;



public class TrackerGUI{
	private JFrame frame;
	private JPanel panel;

	private JLabel mainLabel;
	private JTextArea area;
	
	
	
	private JLabel userLabel;
	private JTextField userText;
	
	private JLabel calorieLabel;
	private JTextField calorieText;
	
	private JButton buttonEnter; 

	private JComboBox<String> choiceBox;
	
	private int width;
	private int height;
	
	LifestyleTracker Tracker = new LifestyleTracker();
	
	double calorie = 0;
	double hours = 0;
	double servings = 0;
	
	
	
	
	
	public TrackerGUI(int w, int h) {

		frame = new JFrame();
		panel = new JPanel();

		
		
		panel.setLayout(null);
		userLabel = new JLabel("Food/Activity");
		userLabel.setBounds(10,10,80,25);		
		
        userText = new JTextField(20);
        userText.setBounds(100,10,120,25);
        
      
        
        calorieLabel = new JLabel("Calorie");
        calorieLabel.setBounds(10,40,80,25);
        panel.add(calorieLabel);
        
        calorieText = new JTextField(20);
        calorieText.setBounds(100,40,120,25);
        panel.add(calorieText);
		
        
        buttonEnter = new JButton("Enter");
        buttonEnter.setBounds(230, 10, 70, 50);
        panel.add(buttonEnter);
        
        
		choiceBox = new JComboBox<>();
        
		choiceBox.addItem("Food");
		choiceBox.addItem("Activity");
		choiceBox.addItem("Eat");
		choiceBox.addItem("Perform");
		choiceBox.addItem("Report");
		
		choiceBox.setBounds(10, 70, 80, 25);
		
		
		
		mainLabel = new JLabel("------");
		mainLabel.setBounds(100, 70, 300, 25);
        panel.add(mainLabel);
		
		
		
		area = new JTextArea("");  
		area.setBounds(10, 100, 350, 600);
		area.setEditable(false);
		
		
		height = h;
		width = w;
		
	}
	
	public void setUpGUI() {
		
		
		
		frame.setSize(width,height);
		frame.setTitle("Lifestyle Tracker");
	
		
		panel.add(buttonEnter);
		
		panel.add(userLabel);
		panel.add(userText);
		
		panel.add(calorieLabel);
		panel.add(calorieText);
		
		panel.add(choiceBox);
		panel.add(mainLabel);
		
		
		panel.add(area);
		
		
		frame.add(panel);
			
		frame.getRootPane().setDefaultButton(buttonEnter);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
		
		
	}
	
	
	
	
	public void setUpButtonListeners() {
		ActionListener buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				
				Object o = ae.getSource();
				
		
				if(o == buttonEnter) {
									
					
				    if(choiceBox.getSelectedItem() == "Report") {
						Tracker.report();
						area.append("REFER TO THE CONSOLE FOR THE REPORT\n");
					}
					
				    else if (userText.getText().isBlank() || calorieText.getText().isBlank()) {
						
						
						mainLabel.setText("-------");
						
						
					
					}
					
					else if (!calorieText.getText().matches("^[+-]?(\\d*\\.)?\\d+$")) {
						mainLabel.setText("NUMBERS ONLY FOR CALORIES");
					}
					
					
					
					
					else {
						String s = userText.getText().trim();
						String c = calorieText.getText().trim();
						
						userText.setText("");
						calorieText.setText("");
						
						if(choiceBox.getSelectedItem() == "Food") {
							String food = s;
							String val = c;
							double calorie = Double.parseDouble(val);	
							String result = Tracker.addFood(food, calorie);
							mainLabel.setText(result); 
							area.append(result);
							
						}
						
						else if(choiceBox.getSelectedItem() == "Activity") {
							String activity = s;
							String val = c;
							double calorie = Double.parseDouble(val);	
							String result = Tracker.addActivity(activity, calorie);
							mainLabel.setText(result);
							area.append(result);
						}
						
						else if(choiceBox.getSelectedItem() == "Eat") {
							String food = s;
							String val = c;
							double servings = Double.parseDouble(val);						
							String result = Tracker.eat(food, servings);
							mainLabel.setText(result);
							area.append(result);
						}
						
						else if(choiceBox.getSelectedItem() == "Perform") {
							String activity = s;
							String val = c;
							double hours = Double.parseDouble(val);						
							String result = Tracker.perform(activity, hours);
							mainLabel.setText(result);
							area.append(result);
							
						}
						
						
					}
					
					
				    userText.requestFocus();
				    
				}
				
				
			}
		};
		
	
		
		
		buttonEnter.addActionListener(buttonListener);	

		
		
	}
	

		
	
	
	
	
	
	
	
	
	
	
	
	
}

			


	