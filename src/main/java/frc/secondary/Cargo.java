package frc.secondary;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.*;

public class Cargo {

    public static void cargoIntake(double pivotArmSpeed, double inOutSpeed) {
        if (Sensors.getDIValue(Sensors.cargoPresentArm)){
            Actuators.getInfeedArmMotor().set(ControlMode.PercentOutput, Constants.STOP_MOTOR_SPEED);
            moveArm(pivotArmSpeed);
        } else {
            Actuators.getInfeedArmMotor().set(ControlMode.PercentOutput, inOutSpeed);
        }
    }

    private static void moveArm(double speed) {
        boolean positive = (speed > 0);
        double armPos = Sensors.getArmPotentiometer().get();
        if (positive && armPos < Constants.ARM_POTENTIOMETER_MAX) {
            Actuators.getClimbMotor().set(ControlMode.PercentOutput, speed);
        } else if (!positive && armPos > Constants.ARM_POTENTIOMETER_MIN){
            Actuators.getClimbMotor().set(ControlMode.PercentOutput, speed);
        }
    }

}