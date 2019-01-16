package frc.robot.commands;


import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.RobotMap;

public class MecanumDriver{
    static SpeedController frontLeft = new PWMVictorSPX(RobotMap.frontLeftPort);
    static SpeedController rearLeft = new PWMVictorSPX(RobotMap.rearLeftPort);
    static SpeedController frontRight = new PWMVictorSPX(RobotMap.frontRightPort);
    static SpeedController rearRight = new PWMVictorSPX(RobotMap.rearRightPort);
    static MecanumDrive mdrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
    
    static double rotationSpeed = 0.1;
    
    public static void drive(double speed, double drivingAngle){
        mdrive.drivePolar(speed, drivingAngle, 0);
    }
    public static void drive(double x, double y, double z){
        mdrive.driveCartesian(x, y, z);
    }
    public static void stop(){
        mdrive.driveCartesian(0, 0, 0);
    }
    public static void rotate(int dir){
        //1 for clockwise
        if(dir==1){
            frontLeft.set(-rotationSpeed);
            rearLeft.set(-rotationSpeed);
            frontRight.set(-rotationSpeed);
            rearRight.set(-rotationSpeed);
        }
        else if(dir==-1){
            frontLeft.set(rotationSpeed);
            rearLeft.set(rotationSpeed);
            frontRight.set(rotationSpeed);
            rearRight.set(rotationSpeed);
        }
    }
    public static void rotate(double speed, int dir){
        //1 for clockwise
        if(dir==1){
            frontLeft.set(-speed);
            rearLeft.set(-speed);
            frontRight.set(-speed);
            rearRight.set(-speed);
        }
        else if(dir==-1){
            frontLeft.set(speed);
            rearLeft.set(speed);
            frontRight.set(speed);
            rearRight.set(speed);
        }
    }
}