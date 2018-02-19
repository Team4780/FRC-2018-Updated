package org.usfirst.frc.team4780.robot.subsystems;

import org.usfirst.frc.team4780.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private VictorSP leftVictorSP;
	private VictorSP rightVictorSP;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public DriveTrain() {
		rightVictorSP = new VictorSP(RobotMap.rightVictorSPPort);
		leftVictorSP = new VictorSP(RobotMap.leftVictorSPPort);
	}
	
	public void drive(Joystick stick) {
		double x = stick.getX();
		double y = stick.getY();
		
		leftVictorSP.set(x-y);
		rightVictorSP.set(x+y);
	}
	public void auto() {
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}