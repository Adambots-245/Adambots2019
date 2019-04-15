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
    private static double elevatorSpeed;
    public static void init() {
        liftSpeedModifier = Constants.LIFT_NORMAL_MODIFIER;
        Level_1 = true;
        Level_2 = false;
        Level_3 = false;

    }
    public static void elevator(Axis liftAxis, double intakeSpeed, boolean low, boolean mid, boolean high){
        updateLiftSpeedModifier();
        double liftSpeed = (liftSpeedModifier) * (liftAxis.get());
        liftSpeed += -Constants.ELEVATOR_HOLD_SPEED;
        elevatorSpeed = liftSpeed;
        //setLiftMotorSpeed(liftSpeed);
    
        //passiveGotoNearestLevel(liftAxis.isUntoggled(), liftAxis.get());
        /*if((boolean)Sensors.getCargoPresentLift().get()){
            setCarriageWheelsSpeed(intakeSpeed);
        }*/
        buttonsElevator(low, mid, high, liftSpeed);
        //System.out.println("elevator pos = " + Sensors.getLiftSensorPosition());
    }
    public static double getLiftSpeedModifier(){
        return liftSpeedModifier;
    }
    public static double getLiftSpeed(){
        return elevatorSpeed;
    }
    public static void resetEncoderOnLimitSwitch() {
		if (!Sensors.getLiftLoweredLimitSwitch().get()) {
			Sensors.resetLiftEncoder();
		}
	}

    public static void updateLiftSpeedModifier(){
        if (Sensors.getLiftSensorPosition() > Constants.LIFT_UPPER_SPEED_ENCODER_THRESHOLD || Sensors.getLiftSensorPosition() < Constants.LIFT_LOWER_SPEED_ENCODER_THRESHOLD ){
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

    public static void passiveGotoNearestLevel(boolean unToggled, double speed) {
        if (speed == 0) {
            int currentPosition = Sensors.getLiftSensorPosition();
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
        if (!Sensors.getDIValue(Sensors.getLiftLoweredLimitSwitch()) && speed >= 0) {
            Actuators.getLiftMotor1().set(ControlMode.PercentOutput, 0);
        }
        else{
            Actuators.getLiftMotor1().set(ControlMode.PercentOutput, speed);
        }
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

    public static void buttonsElevator(boolean low, boolean mid, boolean high, double liftSpeed) {
        int liftEncoder = Sensors.getLiftSensorPosition();
        int range = 2000;
        if (low == true && mid == false && high == false) {
            if (liftEncoder > Constants.LIFT_LEVEL_1 + range) {
                Actuators.getLiftMotor1().set(ControlMode.PercentOutput, 0.5);
            } else {
                setLiftMotorSpeed(liftSpeed);
            }
            //Actuators.getLiftMotor1().set(ControlMode.Position, -Constants.LIFT_LEVEL_1);
        } else if (low == false && mid == true && high == false) {
            if (liftEncoder > Constants.LIFT_LEVEL_2 + range) {
                Actuators.getLiftMotor1().set(ControlMode.PercentOutput, 0.5);
            } else if (liftEncoder < Constants.LIFT_LEVEL_2 - range) {
                Actuators.getLiftMotor1().set(ControlMode.PercentOutput, -0.75);
            } else {
                setLiftMotorSpeed(liftSpeed);
            }
            //Actuators.getLiftMotor1().set(ControlMode.Position, -Constants.LIFT_LEVEL_2);
        } else if (low == false && mid == false && high == true) {
            if (liftEncoder < Constants.LIFT_LEVEL_3 - range) {
                Actuators.getLiftMotor1().set(ControlMode.PercentOutput, -0.75);
            } else {
                setLiftMotorSpeed(liftSpeed);
            }
            //Actuators.getLiftMotor1().set(ControlMode.Position, -Constants.LIFT_LEVEL_3);
        }
        else{
            setLiftMotorSpeed(liftSpeed);
        }
    }
}