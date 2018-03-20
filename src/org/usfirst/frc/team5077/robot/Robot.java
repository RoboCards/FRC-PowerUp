package org.usfirst.frc.team5077.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

//TODO make robot drive like a tank using 2 joysticks

public class Robot extends IterativeRobot {
	DifferentialDrive m_drive;
	Joystick stickRight;
	Joystick stickLeft;
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
		stickRight = new Joystick(0);
		stickLeft = new Joystick(1);
		timer = new Timer();
		
		mc_frontLeft = new Spark(0);
		mc_frontRight = new Spark(1);
		mc_rearLeft = new Spark(2);
		mc_rearRight = new Spark (3);
		mc_arm = new Spark(4);
		
		cg_left = new SpeedControllerGroup(mc_frontLeft, mc_rearLeft);
		cg_right = new SpeedControllerGroup(mc_frontRight, mc_rearRight);
		m_drive = new DifferentialDrive(cg_left, cg_right);
		gyro = new ADXRS450_Gyro();
	}
	
	@Override
	public void robotInit() {
		gyro.calibrate();
	}
	
	@Override
	public void autonomousInit() {
		gyro.reset();
		timer.reset();
		timer.start();
	}

	@Override
	public void autonomousPeriodic() {
		double angle = gyro.getAngle();
		double matchTime = timer.get();
		
		if (matchTime < 8.5) { 
			m_drive.arcadeDrive(0.25, -angle * 0.05, false);
		} else {
			m_drive.arcadeDrive(0.0, 0.0);
		}
	}

	@Override
	public void teleopPeriodic() {
		oneJoystickDrive();
		//twoJoystickDrive();
		armLogic();
	}
	
	private void oneJoystickDrive() {
		double stickRightSpeed = stickRight.getY();
		double stickRightRotation = stickRight.getZ();
		m_drive.arcadeDrive(stickRightSpeed, stickRightRotation);
	}
	
	private void armLogic() {
		boolean upButton = stickRight.getRawButton(7);
		boolean downButton = stickRight.getRawButton(9); 
		if (upButton) {
			mc_arm.set(1.0);
		} else if (!downButton) {
			mc_arm.set(0.0);
		}
		if (downButton) {
			mc_arm.set(-1.0);
		} else if (!upButton) {
			mc_arm.set(0.0);
		}
	}
	
	// Caveat operans! This code has not been tested.
	private void twoJoystickDrive() {
		double stickRightSpeed = stickRight.getY();
		double stickLeftSpeed = stickLeft.getY();	
		cg_left.set(stickLeftSpeed);
		cg_right.set(stickRightSpeed);
	}
	
	
	
	@Override
	public void testPeriodic() {
	
	}
}
