/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
//import edu.wpi.first.wpilibj.RobotDrive;
//import edu.wpi.first.wpilibj.Compressor;


public class Robot extends TimedRobot {
  //private static final int claw1port = 9;
 // private static final int claw2port = 4;
  //private static final int kJoystickPort = 0;



/*
	PWMVictorSPX m_frontLeft = new PWMVictorSPX(1);
  PWMVictorSPX m_rearLeft = new PWMVictorSPX(2);
	PWMVictorSPX m_frontRight = new PWMVictorSPX(3);
  PWMVictorSPX m_rearRight = new PWMVictorSPX(7);
  *//*
	MecanumDrive m_drive = new MecanumDrive(m_frontLeft,m_rearLeft,m_frontRight,m_rearRight);
*/

  PWMVictorSPX spin = new PWMVictorSPX(3);
  private SpeedController claw1;
  private SpeedController claw2;
  private Joystick mstick;

  //private DigitalInput limitSwitch;
  //Compressor c = new Compressor(0);

  @Override
  public void robotInit() {

    /***********claw initialization********/
    claw1 = new PWMVictorSPX(9);
    claw2 = new PWMVictorSPX(4);
  
  
    mstick = new Joystick(0);
    //limitSwitch = new DigitalInput(2);
  }

  @Override
  public void teleopPeriodic() {
    claw1.set(mstick.getY());
    claw2.set(mstick.getY());
    while(mstick.getRawButton(1)){
      spin.set(-1);
      claw1.set(1);
      claw2.set(1);
    }
    spin.set(mstick.getRawAxis(5));
    //m_drive.driveCartesian(mstick.getY(),mstick.getX(),mstick.getZ());
 /*
  if(limitSwitch.get()) {
    System.out.println("He");
    //Timer.delay(10);
  }
  else{
    System.out.println("e");
  }*/
  }
}