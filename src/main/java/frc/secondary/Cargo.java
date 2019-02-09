package frc.secondary;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.*;

public class Cargo {

    // If sensor is blocked, stop the intake and move the arm
    // If not, set the intake to the input of the triggers
    public static void cargoIntake(double speed) {
        if (Sensors.getDIValue(Sensors.cargoPresentArm)){
            Actuators.getInfeedArmMotor().set(ControlMode.PercentOutput, Constants.STOP_MOTOR_SPEED);
            moveArm(speed);
        } else {
            Actuators.getInfeedArmMotor().set(ControlMode.PercentOutput, speed);
        }
    }

    // Moves the arm so long as it is within the threshold
    private static void moveArm(double speed) {
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