package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;

import frc.robot.*;

public class Sensors {

    public static DigitalInput liftLowered = new DigitalInput(Constants.LIFT_SENSOR_PORT);
    public static DigitalInput hatchPresent = new DigitalInput(Constants.HATCH_SENSOR_PORT);
    public static DigitalInput cargoPresentArm = new DigitalInput(Constants.CARGO_ARM_SENSOR_PORT);
    public static DigitalInput cargoPresentLift = new DigitalInput(Constants.CARGO_LIFT_SENSOR_PORT);

    public static AnalogPotentiometer armPotentiometer = new AnalogPotentiometer(Constants.ARM_POTENTIOMETER_PORT);

    public static boolean getDIValue(DigitalInput d) {
        return d.get();
    }

    public static AnalogPotentiometer getArmPotentiometer() {
        return armPotentiometer;
    }

}