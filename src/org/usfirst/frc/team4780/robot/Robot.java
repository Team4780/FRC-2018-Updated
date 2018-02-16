
package org.usfirst.frc.team4780.robot;

import org.usfirst.frc.team4780.robot.commands.ExampleCommand;
import org.usfirst.frc.team4780.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4780.robot.subsystems.Elevator;
import org.usfirst.frc.team4780.robot.subsystems.ExampleSubsystem;

import edu.wpi.cscore.VideoSource;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final Elevator elevator = new Elevator();
	public static OI oi;
	public static DriveTrain drivetrain;
	public static Elevator Elevate;
	public static Joystick joystick1;
	public static Joystick joystick2;
	public static Spark elevatorSpark;
	public static Spark cubeSpark;
	public static Servo newServo;
	public static JoystickButton elevatorButton;
	public static JoystickButton elevatorButton2;
	public static JoystickButton intakeButton;
	public static JoystickButton intakeButton2;
	

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		drivetrain = new DriveTrain();
		joystick1 = new Joystick(0);
		joystick2 = new Joystick(1);
	/* This code that is commented out underneath gets the current Y axis value of the secondary controller plugged
	 * into driver station port 1 (because 0 is the driving joystick) and stores it in the variable speed or whatever 
	 * other name is is given. Also it creates a new joystick object connected to port 1 in driver station ~Rish */
		//	Joystick stick = new Joystick(1);
		//	double speed = stick.getY ();
		elevatorButton = new JoystickButton(joystick2, 2);
		elevatorButton2 = new JoystickButton(joystick2, 4);
		intakeButton = new JoystickButton(joystick2, 7);
		intakeButton2 = new JoystickButton(joystick2, 8);
		// elevator = new Elevator;
		cubeSpark = new Spark(RobotMap.cubeSparkPort);
		elevatorSpark = new Spark(RobotMap.elevatorSparkPort);
		newServo = new Servo(RobotMap.newServoPort);
		chooser.addDefault("Default Auto", new ExampleCommand());
		SmartDashboard.putData("Auto mode", chooser);
		CameraServer camera = CameraServer.getInstance();
		VideoSource usbCam = camera.startAutomaticCapture("cam0", 0);
		usbCam.setResolution(320,240); 
		usbCam.setFPS(25);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
//~rd	autonomousCommand = new (command goes here)
// cubeSpark.set(0.5);
	
		// Add myTimer.start and myTimer.reset for timers in autonomousInit(this area) 
		// and autonomousPeriodic(below this)
		
		/*
		
		// Reset timer to 0sec
	    myTimer.reset();

	    // Start timer
	    myTimer.start();
	    
	    */
		
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		//ADD timer called myTimer.get for auto code below to work! ~rish
		
		/* // If is has been less than 15 seconds since autonomous started, drive forwards
	    if(myTimer.get() < 15.0){
	        DriveTrain.drive(0.5, 0.5);
	    }

	    // If more than 15 seconds have elapsed, stop driving and turn off the timer
	    else {
	        DriveTrain.drive(0.0, 0.0);
	        myTimer.stop();
	    }
*/
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		
		drivetrain.drive(joystick1);
		if(joystick2.getRawButton(3))
		{
			cubeSpark.set(-0.5);
		}
		else cubeSpark.set(0);
	
		
		if(joystick2.getRawButton(1))
		
		{
			cubeSpark.set(0.5);
		}
	
		if(joystick2.getRawButton(3))
		{
			elevatorSpark.set(0.5);
		}
		else elevatorSpark.set(0);
		
		if(joystick2.getRawButton(2))
		{
			elevatorSpark.set(-0.5);
		}
		else elevatorSpark.set(0);
	}
	


	
	
	
	
	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
