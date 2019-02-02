package frc.secondary;
import frc.robot.Actuators;
import frc.robot.Constants;

public class Elevator {
    public static void elevator(double elevateSpeed) {
        double liftSpeed = Math.min(elevateSpeed, Constants.MAX_LIFT_SPEED);
        Actuators.getLiftMotor1().set(liftSpeed);
    }
}

//TODO: Encoders, and fix any mistakes I made above