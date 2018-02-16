package org.usfirst.frc.team4780.robot.subsystems;

import org.usfirst.frc.team4780.robot.RobotMap;
import org.usfirst.frc.team4780.robot.Robot;
import org.usfirst.frc.team4780.robot.OI;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {


    // Put methods for controlling this subsystem
    // here. Call these from Commands.
/*		public void Elevate(Joystick stick) {
		
		double y = stick.getY();
		
		elevatorSpark.set(-y);
		elevatorSpark.set(+y);
		}
	
	
*/
	public void auto() {
		
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
//   	setDefaultCommand(new org.usfirst.frc.team4780.robot.commands.Elevate);
    }
}

