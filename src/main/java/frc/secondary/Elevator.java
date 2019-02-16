package frc.secondary;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.Actuators;
import frc.robot.Constants;

public class Elevator {
    private static boolean Level_1;
    private static boolean Level_2;
    private static boolean Level_3;
    private static int level1Dist;
    private static int level2Dist;
    private static int level3Dist;
    private static int nearestDistance;
    private static int targetPosition;

    public static void init() {
        Level_1 = true;
        Level_2 = false;
        Level_3 = false;

    }
    public static void elevator(double liftSpeed){
        setLiftMotorSpeed(liftSpeed);
        passiveGotoNearestLevel(liftSpeed);
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

    public static void passiveGotoNearestLevel(double speed) {
        if (speed == 0) {
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