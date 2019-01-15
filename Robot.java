/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;


public class Robot extends TimedRobot {
  private final DifferentialDrive m_robotDrive
      = new DifferentialDrive(new PWMVictorSPX(4), new PWMVictorSPX(9)); 
  private final Joystick m_stick = new Joystick(0);
  private final Timer m_timer = new Timer();
  private Compressor c = new Compressor(0);
  private Solenoid s = new Solenoid(1);
  
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {

  }

  /**
   * This function is run once each time the robot enters autonomous mode.
   */
  @Override
  public void autonomousInit() {
    m_timer.reset();
    m_timer.start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    // Drive for 2 seconds
    if (m_timer.get() < 2.0) {
      m_robotDrive.arcadeDrive(0.5, 0.0); // drive forwards half speed
    } 
    else {
      m_robotDrive.stopMotor(); // stop robot
    }
  }

  /**
   * This function is called once each time the robot enters teleoperated mode.
   */
  @Override
  public void teleopInit() {
  }


  @Override
  public void teleopPeriodic() {
   // if(m_stick.getButton(1)){
    m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getRawAxis(4));

    
   if(m_stick.getRawButton(2)){
      //c.start();  //不知道沙小用的
      c.setClosedLoopControl(true);
      s.set(true); //電磁閥
   }

   if(m_stick.getRawButton(3)){
     //c.close(); //好像不用打
     c.setClosedLoopControl(false);
     s.set(false);
   }

   if(m_stick.getRawButton(5)){
     s.set(true);
   }
   if(m_stick.getRawButton(6)){
    s.set(false);
   }

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}