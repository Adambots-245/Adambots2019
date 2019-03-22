package frc.secondary;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Constants;
import frc.robot.Actuators;

public class Climb {
    public static void climb(int modeTogglePresses, double stiltSpeed){
        //if (modeTogglePresses % 2 == 1){
            //climbMode(stiltSpeed);
            Actuators.getClimbMotor().set(ControlMode.PercentOutput, stiltSpeed);
        //}
    }

    public static void testClimb(double stiltSpeed) {
        Actuators.getLinearActuator().set(ControlMode.PercentOutput, stiltSpeed);
    }

    /*public static void climbMode(double linearActuatorSpeed) {
        double climbSpeed = Math.min(climbArmSpeed, Constants.MAX_CLIMB_SPEED);
        double linearSpeed = Math.min(linearActuatorSpeed, Constants.MAX_CLIMB_SPEED);
        if (climbSpeed > Constants.MIN_CLIMB_SPEED && linearSpeed > Constants.MIN_CLIMB_SPEED) {
            Actuators.getClimbMotor().set(ControlMode.PercentOutput, climbSpeed);
            Actuators.getLinearActuator().set(ControlMode.PercentOutput, linearSpeed);
        } else {
            Actuators.getClimbMotor().set(ControlMode.PercentOutput, Constants.MIN_CLIMB_SPEED);
            Actuators.getLinearActuator().set(ControlMode.PercentOutput, Constants.MIN_CLIMB_SPEED);
        }
    }*/
}