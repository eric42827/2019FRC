package frc.robot.commands;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.RobotMap;

public class Grab{
    private static SpeedController claw1 = new PWMVictorSPX(RobotMap.claw1Port);
    private static SpeedController claw2 = new PWMVictorSPX(RobotMap.claw2Port);
    private static SpeedController spin = new PWMVictorSPX(RobotMap.spinPort);
    private static Timer mtimer = new Timer();
    public void initDefaultCommand(){
        //this is for implementing the inherited abstract method
    }
    public static void in(){
        claw1.set(-1);
        claw2.set(-1);
    }
    public static void out(){
        mtimer.reset();
        mtimer.start();
        
        claw1.set(1);
        claw2.set(1);
        while(mtimer.get()<0.7){}
        spin.set(-1);
        while(mtimer.get()<1.0){}
        spin.set(0);
        while(mtimer.get()<1.7){}
        spin.set(1);
        while(mtimer.get()<2.0){}
        spin.set(0);
        claw1.set(0);
        claw2.set(0);
    }
    public static void stop(){
        spin.set(0);
        claw1.set(0);
        claw2.set(0);
    }
    public static void move_back(){
        spin.set(-0.5);
    }
    public static void move_forth(){
        claw1.set(0.1);
        claw2.set(0.1);
    }
}