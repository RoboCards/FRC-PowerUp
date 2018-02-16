package org.usfirst.frc.team5077.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/*import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
*/

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
@SuppressWarnings("deprecation")
public class Robot extends IterativeRobot {
	DifferentialDrive myRobot;
	Joystick stick;
	Timer timer;
	Gyro gyro;
	Spark frontLeft, frontRight, rearLeft, rearRight;
	SpeedControllerGroup left;
	SpeedControllerGroup right;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public Robot () {
		
		System.out.println("Leaving Constructor");
	}
	@Override
	public void robotInit() {
		stick = new Joystick(1);
		timer = new Timer();
		
		frontLeft = new Spark(1);
		frontRight = new Spark(2);
		rearLeft = new Spark(3);
		rearRight = new Spark (4);
		
		left = new SpeedControllerGroup(frontLeft, rearLeft);
		right = new SpeedControllerGroup(frontRight, rearRight);
		System.out.println("Leaving Initialization");
	}
	
	@Override
	public void autonomousInit() {
		//test commit
		
	}

	@Override
	public void autonomousPeriodic() {
		
	}

	@Override
	public void teleopPeriodic() {
		
		

	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
