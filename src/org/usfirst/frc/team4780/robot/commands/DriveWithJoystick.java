package org.usfirst.frc.team4780.robot.commands;

import org.usfirst.frc.team4780.robot.Robot;
import org.usfirst.frc.team4780.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;


public class DriveWithJoystick extends Command {
	protected DriveTrain drivetrain = Robot.drivetrain;
	public DriveWithJoystick() {
		requires(Robot.drivetrain);
	}
	
	protected void initialize()  {
		
	}
	protected void drive(double x, double y) {
		drive(x,y);
	}
	
	protected void execute() {
	drivetrain.drive(Robot.oi.getJoystickValue());
		}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	protected void end() {
		
	}
	protected void interrupted() {
		
	}

}
