
package org.usfirst.frc.team4780.robot;

import org.usfirst.frc.team4780.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4780.robot.subsystems.ExampleSubsystem;

import edu.wpi.cscore.VideoSource;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SPI.Port;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {	
	
	
	
	/*
	private static final double kAngleSetpoint = 0.0;
	private static final double kP = 0.005; // propotional turning constant

	// gyro calibration constant, may need to be adjusted;
	// gyro value of 360 is set to correspond to one full revolution
	private static final double kVoltsPerDegreePerSecond = 0.0128;

	private static final int kLeftMotorPort = 0;
	private static final int kRightMotorPort = 1;
	private static final int kGyroPort = 0;
	private static final int kJoystickPort = 0;

	private DifferentialDrive m_myRobot
			= new DifferentialDrive(new Spark(kLeftMotorPort),
			new Spark(kRightMotorPort));
	private AnalogGyro m_gyro = new AnalogGyro(kGyroPort);
	private Joystick m_joystick = new Joystick(kJoystickPort);
	
	*/
	
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static VictorSP leftVictor;
	public static VictorSP rightVictor;
	public static DriveTrain drivetrain;
	public static Joystick joystick1;
	public static Joystick joystick2;
	public static Spark elevatorSpark;
	public static Spark cubeSpark;
	public static Servo newServo;
	DigitalInput hallEffectSensorUp; 
	DigitalInput hallEffectSensorDown;
	public static SPI gyroSensor;
	
	/*
	
	double angleSetpoint = 0.0;
    final double pGain = .006;  //propotional turning constant ~rd
    
    //gyro calibration constant, may need to be adjusted; 
    //gyro value of 360 is set to correspond to one full revolution ~rd
    final double voltsPerDegreePerSecond = .0128;
   
	*/
	
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {

		// m_gyro.setSensitivity(kVoltsPerDegreePerSecond);
		
		// boolean sensorValue = value;
		ADXRS450_Gyro gyro= new ADXRS450_Gyro();
		oi = new OI();
		drivetrain = new DriveTrain();
		joystick1 = new Joystick(0);
		joystick2 = new Joystick(1);
		cubeSpark = new Spark(RobotMap.cubeSparkPort);
		elevatorSpark = new Spark(RobotMap.elevatorSparkPort);
		newServo = new Servo(RobotMap.newServoPort);
		hallEffectSensorUp = new DigitalInput(0);
		hallEffectSensorDown = new DigitalInput(1);
		SmartDashboard.putData("Auto mode", chooser);
		CameraServer camera = CameraServer.getInstance();
		VideoSource usbCam = camera.startAutomaticCapture("cam0", 0);
		usbCam.setResolution(320,240); 
		usbCam.setFPS(30);
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
		// Add myTimer.start and myTimer.reset for timers in autonomousInit(this area) 
		// and autonomousPeriodic(below this)
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
		
			leftVictor.set(1);
			rightVictor.set(1);
			Timer.delay(5);
		
		
		
		
		Scheduler.getInstance().run();
	/*	
		//ADD timer called myTimer.get for auto code below to work! ~RD
		
		 // If is has been less than 15 seconds since autonomous started, drive forwards
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
		
	// Drivetrain for tele-op
		
		drivetrain.drive(joystick1);
		
	// Cube Spark Intake/Outtake "If-Then" Statements ~RD
		
		if(joystick2.getRawButton(2))
		{
			cubeSpark.set(-0.5);
		}
		else cubeSpark.set(0);
		
		if(joystick2.getRawButton(1))	
			
		{
			cubeSpark.set(1);
		}
		
		// Hall Effect Sensor Code
	
		
		boolean upTriggered = hallEffectSensorUp.get() == false;
		boolean downTriggered = hallEffectSensorDown.get() == false;
		double joystickYAxis = joystick2.getY();
		
		elevatorSpark.set(joystick2.getY());

		 if (joystickYAxis<0 && downTriggered)
		    {
		        elevatorSpark.set(0);
		    }
		 	else
		    {
		    }
		 
		 if (joystickYAxis>0 && upTriggered)
		    {
		        elevatorSpark.set(0);
		    }
		    else
		    {
		    }
		
		
		// Elevator Spark Y-Axis Control--Replaces Elevator Spark "If-Then" Statements ~RD
		
	

	
	}

	 
	
	public void operatorControl() {

		}
	

		/*	
			
			boolean direction = true;
			boolean stopped = true;
			
			
			double turningValue;
	//		gyroSensor.setSensitivity(voltsPerDegreePerSecond); //calibrates gyro values to equal degrees
		        while (isOperatorControl() && isEnabled()) {
		            
		            turningValue =  (angleSetpoint - ((Gyro) gyroSensor).getAngle())*pGain;
		            if(joystick1.getY() <= 0)
		            {
		        	//forwards
		        	DriveTrain.drive(joystick1.getY(), turningValue); 
		            } else {
		        	//backwards
		        	DriveTrain.drive(joystick1.getY(), -turningValue);
		            }
		        }
			}
*/




	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}
