package frc.secondary;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.*;

public class Cargo {

    // If arm sensor isn't blocked, only run the intake
    // If lift sensor is blocked, only run the outake
    public static void cargoInOut(double speed) {
       
        if (Sensors.getDIValue(Sensors.cargoPresentArm)){
            Actuators.getInfeedArmMotor().set(ControlMode.PercentOutput, Constants.STOP_MOTOR_SPEED);
        } else {
            Actuators.getInfeedArmMotor().set(ControlMode.PercentOutput, speed);
        }

        if (!Sensors.getDIValue(Sensors.cargoPresentLift)){
            Actuators.getArmInOutLift1().set(ControlMode.PercentOutput, Constants.STOP_MOTOR_SPEED);
        } else {
            Actuators.getArmInOutLift1().set(ControlMode.PercentOutput, speed);
        }

    }

    // Moves the arm so long as it is within the threshold
    public static void moveArm(double speed) {
        boolean positive = speed > 0;
        double armPos = Sensors.getArmPotentiometer().get();
        if (positive && armPos < Constants.ARM_POTENTIOMETER_MIN) {
            Actuators.getClimbMotor().set(ControlMode.PercentOutput, speed / 2);
        } else if (!positive && armPos > Constants.ARM_POTENTIOMETER_MAX) {
            Actuators.getClimbMotor().set(ControlMode.PercentOutput, speed / 2);
        } else {
            Actuators.getClimbMotor().set(ControlMode.PercentOutput, Constants.STOP_MOTOR_SPEED);
        }
    }

}