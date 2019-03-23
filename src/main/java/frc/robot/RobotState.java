package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class RobotState {
    private static String robotState;
    private static String enabledState;

    public static void init() {
        robotState = "?";
        enabledState = "?";
    }

    public static void stateUpdate() {
        if (isDisabled()) {
            enabledState = "disabled";
        } else if (isEnabled()) {
            enabledState = "enabled";
            if (isAuton()) {
                robotState = "auton";
            } else if (isTeleop()) {
                robotState = "teleop";
            } else if (isTest()) {
                robotState = "test";
            } else {
                robotState = "?";
            }
        }
    }

    public static String getRobotState() {
        return robotState;
    }

    public static String getEnabledState() {
        return enabledState;
    }

    public static boolean isEnabled() {
        return DriverStation.getInstance().isEnabled();
    }

    public static boolean isDisabled() {
        return DriverStation.getInstance().isDisabled();
    }

    public static boolean isAuton() {
        return DriverStation.getInstance().isAutonomous();
    }

    public static boolean isTeleop() {
        return DriverStation.getInstance().isOperatorControl();
    }

    public static boolean isTest() {
        return DriverStation.getInstance().isTest();
    }
}