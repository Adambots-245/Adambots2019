package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dash {

    public static void init() {
        putMotorOutputs();
        putAutoShiftEnabled();
        putDriveVelocity();
        putSecondaryLeftYValue();
        putCompressorValues();

    }

    public static void dash() {
        putMotorOutputs();
        putAutoShiftEnabled();
        putDriveVelocity();
        putSecondaryLeftYValue();
        putCompressorValues();

    }

    public static void putAutoShiftEnabled() {
        SmartDashboard.putBoolean("auto shift enabled", Drive.getAutoShiftState());
    }

    public static void putMotorOutputs() {
        SmartDashboard.putNumber("left 1", Actuators.getLeft1Motor().getMotorOutputPercent());
        SmartDashboard.putNumber("left 2", Actuators.getLeft2Motor().getMotorOutputPercent());
        SmartDashboard.putNumber("left 3", Actuators.getLeft3Motor().getMotorOutputPercent());
        SmartDashboard.putNumber("right 1", Actuators.getRight1Motor().getMotorOutputPercent());
        SmartDashboard.putNumber("right 2", Actuators.getRight2Motor().getMotorOutputPercent());
        SmartDashboard.putNumber("right 3", Actuators.getRight3Motor().getMotorOutputPercent());

    }

    public static void putDriveVelocity() {
        SmartDashboard.putNumber("left velocity", Actuators.getLeft1Motor().getSelectedSensorVelocity());
        SmartDashboard.putNumber("right velocity", Actuators.getRight1Motor().getSelectedSensorVelocity());

    }

    public static void putSecondaryLeftYValue() {
        SmartDashboard.putNumber("secondary left y", -Gamepad.secondary.getLeftY().get());
    }

    public static void putCompressorValues() {
        SmartDashboard.putNumber("compressor 1 current", Actuators.getCompressor1().getCompressorCurrent());
        SmartDashboard.putBoolean("compressor 1 running", Actuators.getCompressor1().enabled());

    }

}