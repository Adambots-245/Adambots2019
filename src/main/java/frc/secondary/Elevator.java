package frc.secondary;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.Actuators;
import frc.robot.Constants;
import frc.robot.Sensors;
import frc.robot.Axis;;

public class Elevator {
    private static boolean Level_1;
    private static boolean Level_2;
    private static boolean Level_3;
    private static int level1Dist;
    private static int level2Dist;
    private static int level3Dist;
    private static int nearestDistance;
    private static int targetPosition;
    private static double liftSpeedModifier;
    public static void init() {
        liftSpeedModifier = Constants.LIFT_NORMAL_MODIFIER;
        Level_1 = true;
        Level_2 = false;
        Level_3 = false;

    }
    public static void elevator(Axis liftAxis, double intakeSpeed){
        //liftSpeed += Constants.ELEVATOR_HOLD_SPEED - .02;
        //updateLiftSpeedModifier();
        double liftSpeed = (liftSpeedModifier) * (liftAxis.get());
        setLiftMotorSpeed(liftSpeed);
       
        if (Math.abs(liftSpeed) > 0.1) {
            HatchIntake.spear(false);
        }
        //passiveGotoNearestLevel(liftAxis.isUntoggled());
        setCarriageWheelsSpeed(intakeSpeed);
        //System.out.println("elevator pos = " + Sensors.getLiftSensorPosition());
    }

    public static void resetEncoderOnLimitSwitch() {
		if (Sensors.getLiftLoweredLimitSwitch().get()) {
			Sensors.resetLiftEncoder();
		}
	}

    public static void updateLiftSpeedModifier(){
        if (Actuators.getLiftMotor1().getSelectedSensorPosition() > Constants.LIFT_UPPER_SPEED_ENCODER_THRESHOLD || Actuators.getLiftMotor1().getSelectedSensorPosition() < Constants.LIFT_LOWER_SPEED_ENCODER_THRESHOLD ){
            liftSpeedModifier = Constants.LIFT_SLOW_MODIFIER;
        }
        else{
            liftSpeedModifier = Constants.LIFT_NORMAL_MODIFIER;
        }
    }
    public static void setCarriageWheelsSpeed(double speed){
        Actuators.getArmInOutLift1().set(ControlMode.PercentOutput, speed);
    }

    public static int findNearestLevel(int currentPosition) {
        level1Dist = Math.abs(Constants.LIFT_LEVEL_1 - currentPosition);
        level2Dist = Math.abs(Constants.LIFT_LEVEL_2 - currentPosition);
        level3Dist = Math.abs(Constants.LIFT_LEVEL_3 - currentPosition);
        nearestDistance = Math.min(Math.min(level1Dist, level2Dist), level3Dist);
        if (nearestDistance == level1Dist) {
            targetPosition = Constants.LIFT_LEVEL_1;
        } else if (nearestDistance == level2Dist) {
            targetPosition = Constants.LIFT_LEVEL_2;
        } else {
            targetPosition = Constants.LIFT_LEVEL_3;
        }
        return targetPosition;
    }

    public static void passiveGotoNearestLevel(boolean unToggled) {
        if (unToggled) {
            int currentPosition = Actuators.getLiftMotor1().getSelectedSensorPosition();
            int targetPosition = findNearestLevel(currentPosition);
            Actuators.getLiftMotor1().set(ControlMode.Position, targetPosition);
        }
    }

    public static void gotoNearestLevel(boolean go) {
        if (go) {
            int currentPosition = Actuators.getLiftMotor1().getSelectedSensorPosition();
            int targetPosition = findNearestLevel(currentPosition);
            Actuators.getLiftMotor1().set(ControlMode.Position, targetPosition);
        }
    }

    public static void setLiftMotorSpeed(double speed) {
        Actuators.getLiftMotor1().set(ControlMode.PercentOutput, speed);
    }

    public static void toggleElevator(double elevateSpeed, boolean height) {
        double liftSpeed = Math.min(elevateSpeed, Constants.MAX_LIFT_SPEED);
        Actuators.getLiftMotor1().set(ControlMode.PercentOutput, liftSpeed);
        if (height) {
            if (Level_1) {
                Level_2 = true;
                Level_1 = false;
                Actuators.getLiftMotor1().set(ControlMode.Position, Constants.LIFT_LEVEL_2);
            } else if (Level_2) {
                Level_3 = true;
                Level_2 = false;
                Actuators.getLiftMotor1().set(ControlMode.Position, Constants.LIFT_LEVEL_3);
            } else {
                Level_1 = true;
                Level_3 = false;
                Actuators.getLiftMotor1().set(ControlMode.Position, Constants.LIFT_LEVEL_1);
            }
        }
    }

    public static void buttonsElevator(boolean low, boolean mid, boolean high) {
        if (low == true && mid == false && high == false) {
            Actuators.getLiftMotor1().set(ControlMode.Position, Constants.LIFT_LEVEL_1);
        } else if (low == false && mid == true && high == false) {
            Actuators.getLiftMotor1().set(ControlMode.Position, Constants.LIFT_LEVEL_2);
        } else if (low == false && mid == false && high == true) {
            Actuators.getLiftMotor1().set(ControlMode.Position, Constants.LIFT_LEVEL_3);
        }
    }
}