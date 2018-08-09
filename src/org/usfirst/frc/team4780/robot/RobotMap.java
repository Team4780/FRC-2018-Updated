package org.usfirst.frc.team4780.robot;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Counter;

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

	Servo brakeServo = new Servo(4);
	public static final int brakeServoPort = 4;
	
	Servo newServo = new Servo(5);
	public static final int newServoPort = 5;

	DigitalInput hallEffectSensorUp = new DigitalInput(0);
	public static final int hallEffectSensorUpPort = 0;
	
	DigitalInput hallEffectSensorDown = new DigitalInput(1);
	public static final int hallEffectSensorDownPort = 1;
	
	ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	public static final int ADXRS450_GyroPort = 0;
	
	Counter normalCounter = new Counter();
	
	
	
	
	
	
}

