package org.usfirst.frc.team4780.robot.commands;



import org.usfirst.frc.team4780.robot.Robot;
import org.usfirst.frc.team4780.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Spark;

/**
 *
 */
public class Elevate extends Command {
	
	int count;
	int tcount;
	double go;
	boolean done;
	int mySetpoint;
	

	
  	public Elevate(int setpoint) {
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
//  		requires(Robot.elevator);
		mySetpoint=setpoint;
  	}
  	
  	
  	
  
    

    // Called just before this Command runs the first time
	protected void initialize() {
        go=0;
        done=false;
        count=0;
        tcount=mySetpoint;
        System.out.println(this);
	}

    // Called repeatedly when this Command is scheduled to run
 /*   protected void execute() {
    	count = count + tcount;

		if (count > 0 && Robot.elevator.isHallSet()) {
			count = (count - 1);
		} else if (count < 0 && Robot.elevator.isHallSet()) {
			count = (count + 1);
		}

		if (count >= 1) {
			go = 1;
		} else if (count <= -1) {
			go = -1;
		}
		Robot.elevator.torro(go);

		if (count != 0) {
			done = false;
		} else if (count == 0) {
			done = true;
		}
		tcount = 0;
		SmartDashboard.putNumber("whatever", count);
		SmartDashboard.putBoolean("hall", Robot.elevator.isHallSet());
	}
    */
	
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
