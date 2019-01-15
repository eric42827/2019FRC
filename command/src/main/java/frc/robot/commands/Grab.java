package frc.robot.commands;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.PWMVictorSPX;

import frc.robot.RobotMap;

public class Grab{
    private static SpeedController claw1 = new PWMVictorSPX(RobotMap.claw1Port);
    private static SpeedController claw2 = new PWMVictorSPX(RobotMap.claw2Port);
    private static PWMVictorSPX spin = new PWMVictorSPX(RobotMap.spinPort);
    public void initDefaultCommand(){
        //this is for implementing the inherited abstract method
    }
    public static void in(){
        claw1.set(-1);
        claw2.set(-1);
    }
    public static void out(){
        spin.set(-1);
        claw1.set(1);
        claw2.set(1);
    }
    public static void stop(){
        claw1.set(0);
        claw2.set(0);
        spin.set(0);
    }
    public static void move_back(){
        spin.set(1);
    }
}