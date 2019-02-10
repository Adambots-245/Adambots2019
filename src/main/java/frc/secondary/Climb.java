package frc.secondary;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.Actuators;

public class Climb {
    public static void climb(double climbArmSpeed, double linearActuatorSpeed) {
        double climbSpeed = Math.min(climbArmSpeed, Constants.MAX_CLIMB_SPEED);
        double linearSpeed = Math.min(linearActuatorSpeed, Constants.MAX_CLIMB_SPEED);
        if (climbSpeed > Constants.MIN_CLIMB_SPEED && linearSpeed > Constants.MIN_CLIMB_SPEED) {
            Actuators.getClimbMotor().set(ControlMode.PercentOutput, climbSpeed);
            Actuators.getLinearActuator().set(ControlMode.PercentOutput, linearSpeed);
        }
        else {
            Actuators.getClimbMotor().set(ControlMode.PercentOutput, Constants.MIN_CLIMB_SPEED);
            Actuators.getLinearActuator().set(ControlMode.PercentOutput, Constants.MIN_CLIMB_SPEED);
        }
    }
}