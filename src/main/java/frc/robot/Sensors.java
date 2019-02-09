package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class Sensors{

private static DigitalInput liftLowered;
private static DigitalInput hatchPresent;
private static DigitalInput cargoPresentArm;
private static DigitalInput cargoPresentLift;

public static void init() {

liftLowered = new DigitalInput(Constants.LIFT_LOWERED_LIMIT_SWITCH);
hatchPresent = new DigitalInput(Constants.HATCH_PRESENT_ENCODER);
cargoPresentArm = new DigitalInput(Constants.CARGO_PRESENT_ARM);
cargoPresentLift = new DigitalInput(Constants.CARGO_PRESENT_LIFT);

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

}
