package frc.secondary;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.Actuators;

public class CargoIntake {


    public static void cargoIntake(double pivotArmSpeed, double inOutSpeed){
        
        Actuators.getClimbMotor().set(ControlMode.PercentOutput, pivotArmSpeed);
        Actuators.getInfeedArmMotor().set(ControlMode.PercentOutput, -inOutSpeed);
        
    }
}