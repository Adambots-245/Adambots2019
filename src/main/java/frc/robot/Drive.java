package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Drive{

    public static void tankDrive(double speed, double turnSpeed){
        
        //Makes sure speed does not go above max
        double leftSpeed = Math.min(speed + turnSpeed, Constants.MAX_MOTOR_SPEED);
        double rightSpeed = Math.min(speed - turnSpeed, Constants.MAX_MOTOR_SPEED);

        //Sets the speeds
        Actuators.getLeft1Motor().set(ControlMode.PercentOutput, leftSpeed);        
        Actuators.getRight1Motor().set(ControlMode.PercentOutput, rightSpeed);
        
    }
    public static void shiftGear(double speed, boolean shiftHigh, boolean shiftLow) {

        //automatic shifting
        if (speed < 0.4 && speed > -0.4) {
            
        } else if (speed >= 0.6 || speed <= -0.6) {
            
        } else {
            
        }

    }
}