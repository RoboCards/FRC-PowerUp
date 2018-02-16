package org.usfirst.frc.team5077.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Robot extends IterativeRobot {
	DifferentialDrive myRobot;
	Joystick stick;
	Timer timer;
	Gyro gyro;
	Spark mc_frontLeft, mc_frontRight, mc_rearLeft, mc_rearRight;
	SpeedControllerGroup cg_left;
	SpeedControllerGroup cg_right;

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
		
		mc_frontLeft = new Spark(1);
		mc_frontRight = new Spark(2);
		mc_rearLeft = new Spark(3);
		mc_rearRight = new Spark (4);
		
		cg_left = new SpeedControllerGroup(mc_frontLeft, mc_rearLeft);
		cg_right = new SpeedControllerGroup(mc_frontRight, mc_rearRight);
		System.out.println("Leaving Initialization");
	}
	
	@Override
	public void autonomousInit() {
		
	}

	@Override
	public void autonomousPeriodic() {
		
	}

	@Override
	public void teleopPeriodic() {
	

	}

	@Override
	public void testPeriodic() {
	}
}
