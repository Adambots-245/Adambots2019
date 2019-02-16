package frc.secondary;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.*;

public class Cargo {
<<<<<<< HEAD

    // If arm sensor isn't blocked, only run the intake
    // If lift sensor is blocked, only run the outake
    public static void cargoInOut(double speed) {
       
        if (Sensors.getDIValue(Sensors.cargoPresentArm)){
=======
    public static void cargo(int modeTogglePresses, double intakeSpeed, double armSpeed) {
        if (modeTogglePresses % 2 == 0) {
            cargoIntake(intakeSpeed);
            moveArm(armSpeed);
        }
    }
    public static void cargoIntake(double intakeSpeed){
        
    }
    // If sensor is blocked, stop the intake and move the arm
    // If not, set the intake to the input of the triggers
    public static void combinedCargoIntake(double speed) {
        if (Sensors.getDIValue(Sensors.getCargoPresentArm())) {
>>>>>>> 9504994e8d2ac26837d0d953a3842395fa8d86db
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
        double maxArmPos = Constants.ARM_POTENTIOMETER_MAX;
        double minArmPos = Constants.ARM_POTENTIOMETER_MIN;
        double armSpeed;
        if ((positive && armPos > minArmPos) || (!positive && armPos <= maxArmPos)){
            armSpeed = speed;
        }
        else{
            armSpeed = Constants.STOP_MOTOR_SPEED;
        }
        Actuators.getClimbMotor().set(ControlMode.PercentOutput, armSpeed);
        
        /*if (positive && armPos < Constants.ARM_POTENTIOMETER_MIN) {
            Actuators.getClimbMotor().set(ControlMode.PercentOutput, speed / 2);
        } else if (!positive && armPos > Constants.ARM_POTENTIOMETER_MAX) {
            Actuators.getClimbMotor().set(ControlMode.PercentOutput, speed / 2);
        } else {
            Actuators.getClimbMotor().set(ControlMode.PercentOutput, Constants.STOP_MOTOR_SPEED);
        }*/
    }

}