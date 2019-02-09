package frc.secondary;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.Actuators;
import frc.robot.Constants;

public class Cargo {


    public static void cargoIntake(double pivotArmSpeed, double inOutSpeed, double potentiometer){
        if(Sensors.getPhotoEyeValue1() == false){
            Actuators.getInfeedArmMotor().set(ControlMode.PercentOutput, Constants.STOP_MOTOR_SPEED);
            Actuators.getClimbMotor().set(ControlMode.PercentOutput, 0.5);
        }
        else {
            Actuators.getInfeedArmMotor().set(ControlMode.PercentOutput, -inOutSpeed);
        }
    }
}