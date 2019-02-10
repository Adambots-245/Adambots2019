package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Sensors{

private static DigitalInput liftLowered;
private static DigitalInput hatchPresent;
private static DigitalInput cargoPresentArm;
private static DigitalInput cargoPresentLift;

public static void init() {

//Limit switch:
Actuators.getLiftMotor1().configSelectedFeedbackSensor(Constants.QUAD_ENCODER, 0, 0);
Actuators.getLiftMotor1().setSelectedSensorPosition(0, 0, 0);
Actuators.getLiftMotor1().configForwardSoftLimitThreshold(Constants.MAX_FORWARD_LIFT_LIMIT, 0);
Actuators.getLiftMotor1().configReverseSoftLimitThreshold(Constants.MAX_REVERSE_LIFT_LIMIT, 0);
Actuators.getLiftMotor1().configForwardSoftLimitEnable(Constants.FORWARD_LIMIT_ENABLED, 0);
Actuators.getLiftMotor1().configReverseSoftLimitEnable(Constants.REVERSE_LIMIT_ENABLED, 0);
Actuators.getLiftMotor1().setSensorPhase(Constants.LIFT_MOTOR_PHASE);
    public static AnalogPotentiometer armPotentiometer = new AnalogPotentiometer(Constants.ARM_POTENTIOMETER_PORT);

    public static boolean getDIValue(DigitalInput d) {
        return d.get();
    }

	//Encoder ports set
	liftLowered = new DigitalInput(Constants.LIFT_LOWERED_LIMIT_SWITCH);
	hatchPresent = new DigitalInput(Constants.HATCH_PRESENT_ENCODER);
	cargoPresentArm = new DigitalInput(Constants.CARGO_PRESENT_ARM);
	cargoPresentLift = new DigitalInput(Constants.CARGO_PRESENT_LIFT);
    public static AnalogPotentiometer getArmPotentiometer() {
        return armPotentiometer;
	}

}

public static DigitalInput getLiftLoweredLimitSwitch() {
    return liftLowered;
}

public static DigitalInput getHatchPresentEncoder() {
    return hatchPresent;
}

public static DigitalInput getCargoPresentArm() {
    return cargoPresentArm;
}

public static DigitalInput getCargoPresentLift() {
    return cargoPresentLift;
}
public static int getLiftSensorPosition() {
    return Actuators.getLiftMotor1().getSelectedSensorPosition(0);
}
public static void resetLiftEncoder() {
    Actuators.getLiftMotor1().getSensorCollection().setQuadraturePosition(0, 0);
}

}