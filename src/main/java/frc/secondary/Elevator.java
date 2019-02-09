package frc.secondary;
import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.Actuators;
import frc.robot.Constants;

public class Elevator {
    private static boolean level1;
    private static boolean level2;
    private static boolean level3;
    private static int currentPosition;
        
    public void init() {
        currentPosition = Constants.LIFT_LEVEL_1;
        setLevel();
    }

    public static int findNearestLevel(){
        currentPosition = Actuators.getLiftMotor1().getSelectedSensorPosition();
        int level1Dist = Math.abs(Constants.LIFT_LEVEL_1 - currentPosition);
        int level2Dist = Math.abs(Constants.LIFT_LEVEL_2 - currentPosition);
        int level3Dist = Math.abs(Constants.LIFT_LEVEL_3 - currentPosition);
        if (level1Dist < level2Dist && level1Dist < level3Dist) {
            return Constants.LIFT_LEVEL_1;
        } else if (level2Dist < level1Dist && level2Dist < level3Dist) {
            return Constants.LIFT_LEVEL_2;
        }
        return Constants.LIFT_LEVEL_3;
    }

    public static void move(int speed) {
        Actuators.getLiftMotor1().set(ControlMode.PercentOutput, speed);
        setLevel();
    }

    public static void goTo(int position) {
        Actuators.getLiftMotor1().set(ControlMode.Position, position);
        setLevel();
    }

    public static void goToNearest() {
        Actuators.getLiftMotor1().set(ControlMode.Position, findNearestLevel());
        setLevel();
    }

    public static void setLevel() {
        int nearestLevel = findNearestLevel();
        level1 = (nearestLevel == Constants.LIFT_LEVEL_1);
        level2 = (nearestLevel == Constants.LIFT_LEVEL_2);
        level3 = (nearestLevel == Constants.LIFT_LEVEL_3);
    }

    public static boolean getLevel1() {
        return level1;
    }

    public static boolean getLevel2() {
        return level2;
    }

    public static boolean getLevel3() {
        return level3;
    }

}
