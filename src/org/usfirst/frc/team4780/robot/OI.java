package org.usfirst.frc.team4780.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4780.robot.commands.Elevate;
import org.usfirst.frc.team4780.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
Joystick joystick = new Joystick(0);
double x;
double y;

Joystick joystick2 = new Joystick(1);
public Button elevatorButton = new JoystickButton(joystick2, 5);
public Button elevatorButton2 = new JoystickButton(joystick2, 6);
public Button intakeButton = new JoystickButton(joystick2, 7);
public Button intakeButton2 = new JoystickButton(joystick2, 8);
public Button cubeSpark = new JoystickButton(joystick2, 3);




public OI(){
	
//	elevatorButton.whileHeld(new ExampleCommand());
//	elevatorButton2.whileHeld(new ExampleCommand());
	intakeButton.whenPressed(new ExampleCommand());
	intakeButton2.whenPressed(new ExampleCommand());
	
	
	}

	public double getXValue() {
		return joystick.getX();
		}
		public Joystick getJoystickValue() {
		return joystick;
		}
		public double getValue() {
		return joystick2.getX();
		}
		public Joystick getJoystick2Value() {
		return joystick2; 
}	
}
