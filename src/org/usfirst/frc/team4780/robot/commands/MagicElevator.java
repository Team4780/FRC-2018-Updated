package org.usfirst.frc.team4780.robot.commands;

import org.usfirst.frc.team4780.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MagicElevator extends Command {

	double dir;
	double go;
	double more;
	boolean done;

	public MagicElevator(double setpoint) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.elevator);
		this.dir = dir + setpoint;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println(this);
		Robot.elevator.torro(go);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (!Robot.elevator.isHallSet() && dir >= 1) {
			go = 1;
		} else if (!Robot.elevator.isHallSet() && dir <= -1) {
			go = -1;
		} else if (Robot.elevator.isHallSet() && dir >= 1) {
			dir = dir--;
		} else if (Robot.elevator.isHallSet() && dir <= -1) {
			dir = dir++;
		}

		if (dir != 0) {
			done = false;
		} else if (dir == 0) {
			done = true;
		}
		SmartDashboard.putNumber("whaeva", dir);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return done;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.elevator.nothing();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}