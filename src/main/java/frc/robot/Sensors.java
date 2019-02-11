package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class Sensors {

    private static DigitalInput liftLowered;
    private static DigitalInput hatchPresent;
    private static DigitalInput cargoPresentArm;
    private static DigitalInput cargoPresentLift;
    private static DigitalInput armLimitSwitch;
    private static AnalogPotentiometer armPotentiometer;
    private static double offset;

    public static void init() {
        Actuators.getLiftMotor1().configSelectedFeedbackSensor(Constants.QUAD_ENCODER, 0, 0);
        Actuators.getLiftMotor1().setSelectedSensorPosition(0, 0, 0);
        Actuators.getLiftMotor1().configForwardSoftLimitThreshold(Constants.MAX_FORWARD_LIFT_LIMIT, 0);
        Actuators.getLiftMotor1().configReverseSoftLimitThreshold(Constants.MAX_REVERSE_LIFT_LIMIT, 0);
        Actuators.getLiftMotor1().configForwardSoftLimitEnable(Constants.FORWARD_LIMIT_ENABLED, 0);
        Actuators.getLiftMotor1().configReverseSoftLimitEnable(Constants.REVERSE_LIMIT_ENABLED, 0);
        Actuators.getLiftMotor1().setSensorPhase(Constants.LIFT_MOTOR_PHASE);

        offset = 0;

        armLimitSwitch = new DigitalInput(Constants.CARGO_ARM_SENSOR_PORT);
        liftLowered = new DigitalInput(Constants.LIFT_LOWERED_LIMIT_SWITCH);
        hatchPresent = new DigitalInput(Constants.HATCH_PRESENT_ENCODER);
        cargoPresentArm = new DigitalInput(Constants.CARGO_PRESENT_ARM);
        cargoPresentLift = new DigitalInput(Constants.CARGO_PRESENT_LIFT);
        armPotentiometer = new AnalogPotentiometer(Constants.ARM_POTENTIOMETER_PORT); // https://wpilib.screenstepslive.com/s/4485/m/13810/l/241877-potentiometers-measuring-joint-angle-or-linear-motion
    }

    public static boolean getDIValue(DigitalInput d) {
        return d.get();
    }

    public static AnalogPotentiometer getArmPotentiometer() {
        return armPotentiometer;
    }

    public static double getArmPotentiometerValue() {
        return getArmPotentiometer().get() - offset;
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

    public static DigitalInput getArmLimitSwitch() {
        return armLimitSwitch;
    }

    public static int getLiftSensorPosition() {
        return Actuators.getLiftMotor1().getSelectedSensorPosition(0);
    }

    public static void resetLiftEncoder() {
        Actuators.getLiftMotor1().getSensorCollection().setQuadraturePosition(0, 0);
    }

    public static void resetArmPotentiometer() {
        offset = getArmPotentiometer().get();
    }

}