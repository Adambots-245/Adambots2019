package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Drive{

    public static void tankDrive(double speed, double turnSpeed){
        
        //Makes sure speed does not go above max
        double leftSpeed = Math.min(speed + turnSpeed, Constants.MAX_MOTOR_SPEED);
        double rightSpeed = Math.min(speed - turnSpeed, Constants.MAX_MOTOR_SPEED);

        //Sets the speeds
        Actuators.getLeft1Motor().set(ControlMode.PercentOutput, leftSpeed);
        Actuators.getLeft2Motor().set(ControlMode.PercentOutput, leftSpeed);
        Actuators.getRight1Motor().set(ControlMode.PercentOutput, rightSpeed);
        Actuators.getRight2Motor().set(ControlMode.PercentOutput, rightSpeed);
    }
}