package frc.robot.commands;


import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.Spark;

import frc.robot.RobotMap;

public class MecanumDriver{
    static Spark frontLeft = new Spark(RobotMap.frontLeftPort);
    static Spark rearLeft = new Spark(RobotMap.rearLeftPort);
    static Spark frontRight = new Spark(RobotMap.frontRightPort);
    static Spark rearRight = new Spark(RobotMap.rearRightPort);
    static MecanumDrive mdrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
    public static void drive(double speed, double drivingAngle){
        mdrive.drivePolar(speed, drivingAngle, 0);
    }
    public static void drive(double x, double y, double z){
        mdrive.driveCartesian(x, y, z);
    }

    public static void stop(){
        mdrive.stopMotor();
    }
}