package frc.robot;
import edu.wpi.first.wpilibj.RobotController;

public class Brownout {
    public static boolean isBrownedOut;
    public static double voltage;
    public static double SMART_MOTOR_SPEED;
    public static void avoidBrownOut() {
        isBrownedOut = RobotController.isBrownedOut();
        if (isBrownedOut) {
            SMART_MOTOR_SPEED = 0.0;
        }
        else {
            voltage = RobotController.getBatteryVoltage();
            if (voltage < Constants.MAX_BROWNOUT_MARGIN) {
                SMART_MOTOR_SPEED = Constants.MAX_MOTOR_SPEED / 2;
            }
            else {
                SMART_MOTOR_SPEED = Constants.MAX_MOTOR_SPEED;
            }
        }
    }
}