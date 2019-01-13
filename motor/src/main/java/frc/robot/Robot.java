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
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.Compressor;

/**
 * This sample program shows how to control a motor using a joystick. In the
 * operator control part of the program, the joystick is read and the value is
 * written to the motor.
 *
 * <p>Joystick analog values range from -1 to 1 and speed controller inputs also
 * range from -1 to 1 making it easy to work together.
 */
public class Robot extends TimedRobot {
  private static final int claw1port = 9;
  private static final int claw2port = 4;
  private static final int kJoystickPort = 0;

  private SpeedController claw1;
  private SpeedController claw2;
  private Joystick mstick;
  private DigitalInput limitSwitch;
  //Compressor c = new Compressor(0);

  @Override
  public void robotInit() {
    claw1 = new PWMVictorSPX(claw1port);
    claw2 = new PWMVictorSPX(claw2port);
    mstick = new Joystick(kJoystickPort);
    limitSwitch = new DigitalInput(2);
  }

  @Override
  public void teleopPeriodic() {
    //while()
    claw1.set(mstick.getY());
    claw2.set(mstick.getY());
    while(mstick.getRawButton(1)){
      claw1.set(-1);
      claw2.set(-1);
    }
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


/*
package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;

public class Robot extends SampleRobot {

	DigitalInput limitSwitch;
  //PWMVictorSPX 
  Joystick mstick = new Joystick(0);
  private SpeedController claw1;

    public void robotInit() {
      limitSwitch = new DigitalInput(1);
      claw1 = new PWMVictorSPX(9);
    }

    public void operatorControl() {
      // more code here
      /*while(mstick.getRawButton(1)){
        claw1.setSpeed(0.5);
      }*//*
        claw1.set(mstick.getY());
        System.out.println("e");
    	while (limitSwitch.get()) {
        System.out.println("He");
    		Timer.delay(10);
    	}
        // more code here
    }
  }
  */