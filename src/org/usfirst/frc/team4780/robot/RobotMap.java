package org.usfirst.frc.team4780.robot;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DigitalOutput;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	VictorSP leftVictor = new VictorSP(0);
	public static final int leftVictorSPPort = 0;
	
	VictorSP rightVictor = new VictorSP(1);
	public static final int rightVictorSPPort = 1;
		
	Spark cubeSpark = new Spark(3);
	public static final int cubeSparkPort = 2;
	
	Spark elevatorSpark = new Spark(2);
	public static final int elevatorSparkPort = 3;

	Servo newServo = new Servo(5);
	public static final int newServoPort = 5; 
	
	DigitalOutput HallEffectSensorUp = new DigitalOutput(0);
	public static final int newHallEffectPortUp =0; 

	DigitalOutput HallEffectSensorDown = new DigitalOutput(1);
	public static final int newHallEffectPortDown =1; 

	
	
	
	
	
	
	
	
}

