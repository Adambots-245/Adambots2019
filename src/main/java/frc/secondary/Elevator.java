package frc.secondary;
import frc.robot.Actuators;
import frc.robot.Constants;

public class Elevator {
        private static boolean Level_1;
        private static boolean Level_2;
        private static boolean Level_3;
    public void init() {
        Level_1 = true;
        Level_2 = false;
        Level_3 = false;
    }
    public static void elevator(double elevateSpeed, boolean height) {
        double liftSpeed = Math.min(elevateSpeed, Constants.MAX_LIFT_SPEED);
        Actuators.getLiftMotor1().set(liftSpeed);
        if (height) {
            if (Level_1) {
                Level_2 = true;
                Level_1 = false;
                Actuators.getLiftMotor1().setPosition(Constants.LIFT_LEVEL_2);
            }
            else if (Level_2) {
                Level_3 = true;
                Level_2 = false;
                Actuators.getLiftMotor1().setPosition(Constants.LIFT_LEVEL_3);
            }
            else {
                Level_1 = true;
                Level_3 = false;
                Actuators.getLiftMotor1().setPosition(Constants.LIFT_LEVEL_1);
            }
        }
    }
}
