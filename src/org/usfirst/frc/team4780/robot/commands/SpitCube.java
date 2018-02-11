package org.usfirst.frc.team4780.robot.commands;

import org.usfirst.frc.team4780.robot.OI;
import org.usfirst.frc.team4780.robot.RobotMap;
import org.usfirst.frc.team4780.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class SpitCube extends Command {

    public SpitCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super("SpitCube");
    	requires(OI.class);    
    }
		
    
    private void requires(Class<OI> class1) {
		// TODO Auto-generated method stub
    }
    
	// Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
