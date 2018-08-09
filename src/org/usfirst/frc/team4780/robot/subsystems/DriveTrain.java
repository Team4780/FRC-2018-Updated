package org.usfirst.frc.team4780.robot.subsystems;

import org.usfirst.frc.team4780.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private VictorSP leftVictorSP;
	private VictorSP rightVictorSP;
	public double timer = 0;
	
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
		
		if (Timer.getFPGATimestamp()<timer+5)
		{
		leftVictorSP.set(0.275);
		rightVictorSP.set(-0.25); 
		}
		else
		{
		leftVictorSP.set(0);
		rightVictorSP.set(0);
		}
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public static void drive(double y, double turningValue) {
		// TODO Auto-generated method stub
		
	}
}