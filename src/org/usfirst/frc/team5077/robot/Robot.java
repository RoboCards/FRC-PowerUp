package org.usfirst.frc.team5077.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

//TODO make robot drive like a tank using 2 joysticks

public class Robot extends IterativeRobot {
	//DifferentialDrive m_drive;
	Joystick stick;
	Timer timer;
	Gyro gyro;
	Spark mc_frontLeft, mc_frontRight, mc_rearLeft, mc_rearRight, mc_arm;
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
		stick = new Joystick(0);
		
		timer = new Timer();
		
		mc_frontLeft = new Spark(1);
		mc_frontRight = new Spark(2);
		mc_rearLeft = new Spark(3);
		mc_rearRight = new Spark (4);
		mc_arm = new Spark(5);
		
		cg_left = new SpeedControllerGroup(mc_frontLeft, mc_rearLeft);
		cg_right = new SpeedControllerGroup(mc_frontRight, mc_rearRight);
		//m_drive = new DifferentialDrive(cg_left, cg_right);
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
		double yAxis = stick.getY();
		double zAxis = stick.getZ();
			
		
		if ((yAxis == 0)) {
			mc_frontLeft.set(zAxis);
			mc_rearLeft.set(zAxis);
			mc_frontRight.set(zAxis);
			mc_rearRight.set(zAxis);
		} else if ((zAxis == 0)) {
			mc_frontLeft.set(yAxis);
			mc_rearLeft.set(yAxis);
			mc_frontRight.set(-yAxis);
			mc_rearRight.set(-yAxis);
		}
		
		
		/*if trigger down and arm not up then
		 * smoothdecay
		 * if arm up then
		 * do nothing
		 * 
		 * 
		 * */
		
		if (stick.getRawButtonPressed(1)) {
			mc_arm.set(0);
		}
		
	}

	@Override
	public void testPeriodic() {
	}
}
