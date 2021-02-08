package frc.robot.commands;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;

import frc.robot.RobotMap;

public class Pneumatics{
    private static Compressor comp = new Compressor(RobotMap.compressorPort);
    private static Solenoid sole = new Solenoid(RobotMap.solenoidPort);

    public void initDefaultCommand(){
        //this is for implementing the inherited abstract method
    }
    public static void boot(boolean stat){
        //true for on
        comp.setClosedLoopControl(stat);
        sole.set(stat);
    }
    public static void move(boolean stat){
        //true for ?
        sole.set(stat);
    }
    
}