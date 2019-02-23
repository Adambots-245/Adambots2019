package frc.robot;
import edu.wpi.first.wpilibj.RobotController;

public class Brownout {
    private static boolean isBrownedOut;
    private static double voltage;
    public static double SMART_MOTOR_SPEED;
    private static int FORWARD_LIFT_LIMIT = Constants.MAX_FORWARD_LIFT_LIMIT - (Constants.MAX_FORWARD_LIFT_LIMIT / 4);
    private static int REVERSE_LIFT_LIMIT = Constants.MAX_REVERSE_LIFT_LIMIT - (Constants.MAX_REVERSE_LIFT_LIMIT / 4);
    public static void avoidBrownOut() {
        isBrownedOut = RobotController.isBrownedOut();
        if (isBrownedOut) {
            SMART_MOTOR_SPEED = 0.0;
        }
        else {
            voltage = RobotController.getBatteryVoltage();
            if (voltage < Constants.MAX_BROWNOUT_MARGIN) {
                //Half max speed:
                SMART_MOTOR_SPEED = Constants.MAX_MOTOR_SPEED / 2;
                //Low gear:
                Actuators.getShiftHighGear().set(Drive.shiftingValue(false));
                //Remove 1/4 of usual soft limits:
                Actuators.getLiftMotor1().configForwardSoftLimitThreshold(FORWARD_LIFT_LIMIT, 0);
                Actuators.getLiftMotor1().configReverseSoftLimitThreshold(REVERSE_LIFT_LIMIT, 0);
            }
            else {
                SMART_MOTOR_SPEED = Constants.MAX_MOTOR_SPEED;
                Actuators.getLiftMotor1().configForwardSoftLimitThreshold(Constants.MAX_FORWARD_LIFT_LIMIT, 0);
                Actuators.getLiftMotor1().configReverseSoftLimitThreshold(Constants.MAX_REVERSE_LIFT_LIMIT, 0);
            }
        }
    }
    public static boolean statusBrownedOut() {
        return isBrownedOut;
    }
    public static double currentVoltage() {
        return voltage;
    }
}