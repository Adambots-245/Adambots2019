package frc.robot;


import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SensorUtil;

public class Dashboard{

    public static void init() {
        CameraServer.getInstance().startAutomaticCapture();
    }

    public static boolean isMotorRunning(SpeedController motor) {
        double speed = motor.get();
        return Math.abs(speed) > 0;
    }
    /*
    public static double Voltage() {
        PowerDistributionPanel pdp = Sensors.getPowerDistributionPanel();
        double voltage = pdp.getVoltage();
        return voltage;
    }

    public static void Currents() {
        PowerDistributionPanel pdp = Sensors.getPowerDistributionPanel();
        int numChannels = 16;
        for (int i = 0; i < numChannels; i++) {
            double current = pdp.getCurrent(i);
            SmartDashboard.putNumber("Current " + i, current);
        }
    }
    */
    public static void updateDash() {

        SmartDashboard.putBoolean("Is Left 1 Motor Running", isMotorRunning(Actuators.getLeft1Motor()));
        SmartDashboard.putBoolean("Is Right 1 Motor Running", isMotorRunning(Actuators.getRight1Motor()));
        SmartDashboard.putBoolean("Is Left 2 Motor Running", isMotorRunning(Actuators.getLeft2Motor()));
        SmartDashboard.putBoolean("Is Right 2 Motor Running", isMotorRunning(Actuators.getRight2Motor()));
        SmartDashboard.putData("camera", CameraServer.getInstance());
    }

}