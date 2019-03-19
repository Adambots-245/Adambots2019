package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.secondary.Elevator;
import frc.secondary.HatchAutomation;
import frc.secondary.HatchIntake;
import edu.wpi.first.wpilibj.DriverStation;

public class Dash {
    public static void dash(){
        putMotorOutputs();
        putAutoShiftEnabled();
        putDriveVelocity();
        putSecondaryLeftYValue();
        putLiftOutput();
        putLiftEncoderValue();
        putLimitSwitches();
        //putCameraData();
        putEncoder();
        putSensors();
        putAxis();
        putHatchStates();
        putMatchTime();
    }
    public static void init() {
        dash();
    }
    public static void putMatchTime(){
        SmartDashboard.putNumber("match time", DriverStation.getInstance().getMatchTime());
    }
    public static void putHatchStates(){
        SmartDashboard.putBoolean("spear", HatchIntake.spearState());
        SmartDashboard.putBoolean("clamp", HatchIntake.clampState());
    }
    public static void putAutoShiftEnabled(){
        SmartDashboard.putBoolean("auto shift enabled", Drive.getAutoShiftState());
    }
    public static void putMotorOutputs(){
        SmartDashboard.putNumber("left 1", Actuators.getLeft1Motor().getMotorOutputPercent());
        SmartDashboard.putNumber("left 2", Actuators.getLeft2Motor().getMotorOutputPercent());
        SmartDashboard.putNumber("left 3", Actuators.getLeft3Motor().getMotorOutputPercent());
        SmartDashboard.putNumber("right 1", Actuators.getRight1Motor().getMotorOutputPercent());
        SmartDashboard.putNumber("right 2", Actuators.getRight2Motor().getMotorOutputPercent());
        SmartDashboard.putNumber("right 3", Actuators.getRight3Motor().getMotorOutputPercent());
    }
    public static void putDriveVelocity(){
        SmartDashboard.putNumber("left velocity", Actuators.getLeft1Motor().getSelectedSensorVelocity());
        SmartDashboard.putNumber("right velocity", Actuators.getRight1Motor().getSelectedSensorVelocity());
    }
    public static void putSecondaryLeftYValue(){
        SmartDashboard.putNumber("secondary left y", -Gamepad.secondary.getLeftY().get());
    }
    public static void putLiftOutput(){
        SmartDashboard.putNumber("lift output", Actuators.getLiftMotor1().getMotorOutputPercent());
    } 
    public static void putLiftEncoderValue(){
        SmartDashboard.putNumber("lift encoder", Actuators.getLiftMotor1().getSelectedSensorPosition());     
        SmartDashboard.putNumber("LiftSpeedModifier", Elevator.getLiftSpeedModifier());     
    }
    public static void putLimitSwitches() {
        SmartDashboard.putBoolean("arm limit switch", Sensors.getArmLimitSwitch().get());
        SmartDashboard.putBoolean("lift limit switch", Sensors.getLiftLoweredLimitSwitch().get());
    }
    //public static void putCameraData() {
    //   CameraServer.getInstance().startAutomaticCapture();
    //}
    public static void putEncoder() {
        SmartDashboard.putNumber("l drive encoder", Actuators.getLeft1Motor().getSelectedSensorPosition());
        SmartDashboard.putNumber("r drive encoder", Actuators.getRight1Motor().getSelectedSensorPosition());        
    }
    public static void putAxis(){
        SmartDashboard.putBoolean("secondary left y isUntoggled", Gamepad.secondary.getLeftY().isUntoggled());
        SmartDashboard.putNumber("secondary left y presses", Gamepad.secondary.getLeftY().getPresses());
    }
    public static void putSensors() {
       // SmartDashboard.putNumber("arm potentiometer", Sensors.getArmPotentiometerValue());
       // SmartDashboard.putBoolean("hatch present", Sensors.getHatchPresent().get());
       //SmartDashboard.putBoolean("cargo present arm", Sensors.getDIValue(Sensors.getCargoPresentArm()));
       //zSmartDashboard.putBoolean("cargo present lift", Sensors.getCargoPresentLift().get());
    }
}