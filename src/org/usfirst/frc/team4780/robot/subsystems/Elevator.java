package org.usfirst.frc.team4780.robot.subsystems;

import org.usfirst.frc.team4780.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
//	private static Spark elevatorSpark;
	public static double timer = 0;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Elevator() {
//		elevatorSpark = new Spark(RobotMap.elevatorSparkPort);
	}
	
	public static void auto() {
/*		
		if (Timer.getFPGATimestamp()<timer+5)
		{
		elevatorSpark.set(0.5);
		}
		else
		{
		elevatorSpark.set(0);
		}
	}
*/
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}