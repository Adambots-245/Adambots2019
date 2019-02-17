package frc.secondary;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Constants;
import frc.robot.Actuators;
import frc.secondary.Cargo;

public class Climb {

    public static void climb(int modeTogglePresses, double speed, double armSpeed, 
                double armWheelsSpeed, double stiltSpeed) {
        if (modeTogglePresses % 2 == 1){
            Actuators.getShiftHighGear().set(state);
            gyroClimb(speed, armSpeed, stiltSpeed);
            Cargo.cargoIntakeWheelsSpeed(cargoArmWheelsSpeed);
        }
    }

    public static void gyroClimb(double speed, double climbArmSpeed, double linearActuatorSpeed) {
        double climbSpeed = Math.min(climbArmSpeed, Constants.MAX_CLIMB_SPEED);
        double linearSpeed = Math.min(linearActuatorSpeed, Constants.MAX_CLIMB_SPEED);
        float pitchDegree = Gyro.values.getPitch();
        
        if (pitchDegree > Constants.TIPPING_ANGLE) {
            Actuators.getLinearActuator().set(ControlMode.PercentOutput, Constants.LIN_ACT_SPEED);
        } else if (pitchDegree < -(Constants.TIPPING_ANGLE)) {
            Actuators.getLinearActuator().set(ControlMode.PercentOutput, -(Constants.LIN_ACT_SPEED));
        } else {
            climbMode(speed, climbArmSpeed, linearActuatorSpeed);
        }
    }

    public static void climbMode(double speed, double climbArmSpeed, double linearActuatorSpeed) {
        double climbSpeed = Math.min(climbArmSpeed, Constants.MAX_CLIMB_SPEED);
        double linearSpeed = Math.min(linearActuatorSpeed, Constants.MAX_CLIMB_SPEED);
        double leftSpeed = Math.min(speed, Constants.MAX_MOTOR_SPEED);
        double rightSpeed = Math.min(speed, Constants.MAX_MOTOR_SPEED);

        // Sets the speeds
        Actuators.getLeft1Motor().set(ControlMode.PercentOutput, leftSpeed);
        Actuators.getRight1Motor().set(ControlMode.PercentOutput, rightSpeed);
        Actuators.getClimbMotor().set(ControlMode.PercentOutput, climbSpeed);
        Actuators.getLinearSpeed().set(ControlMode.PercentOutput, linearSpeed);
    }
}