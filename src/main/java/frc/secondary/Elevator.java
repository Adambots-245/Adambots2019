package frc.secondary;
import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.Actuators;
import frc.robot.Constants;

public class Elevator {
    private static boolean Level_1;
    private static boolean Level_2;
    private static boolean Level_3;
    private static int currentPosition;
    private static int level1Dist;
    private static int level2Dist;
    private static int level3Dist;
        
    public void init() {
        Level_1 = true;
        Level_2 = false;
        Level_3 = false;
        currentPosition = Constants.LIFT_LEVEL_1; 
    }

    public static int findNearestLevel(){
        currentPosition = Actuators.getLiftMotor1().getSelectedSensorPosition();
        level1Dist = Math.abs(Constants.LIFT_LEVEL_1 - currentPosition);
        level2Dist = Math.abs(Constants.LIFT_LEVEL_2 - currentPosition);
        level3Dist = Math.abs(Constants.LIFT_LEVEL_3 - currentPosition);
        if (level1Dist < level2Dist && level1Dist < level3Dist) {
            return Constants.LIFT_LEVEL_1;
        } else if (level2Dist < level1Dist && level2Dist < level3Dist) {
            return Constants.LIFT_LEVEL_2;
        }
        return Constants.LIFT_LEVEL_3;
    }
    public static void toggleElevator(double elevateSpeed, boolean height) {
        double liftSpeed = Math.min(elevateSpeed, Constants.MAX_LIFT_SPEED);
        Actuators.getLiftMotor1().set(ControlMode.PercentOutput, liftSpeed);
        if (height) {
            if (Level_1) {
                Level_2 = true;
                Level_1 = false;
                Actuators.getLiftMotor1().set(ControlMode.Position, Constants.LIFT_LEVEL_2);
            }
            else if (Level_2) {
                Level_3 = true;
                Level_2 = false;
                Actuators.getLiftMotor1().set(ControlMode.Position, Constants.LIFT_LEVEL_3);
            }
            else {
                Level_1 = true;
                Level_3 = false;
                Actuators.getLiftMotor1().set(ControlMode.Position, Constants.LIFT_LEVEL_1);
            }
        }
    }
}
