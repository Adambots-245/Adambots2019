package frc.secondary;
import frc.robot.Constants;
import frc.robot.Actuators;

public class Climb {
    public static void climb(double climbArmSpeed, double linearActuatorSpeed) {
        double climbSpeed = Math.min(climbArmSpeed, Constants.MAX_CLIMB_SPEED);
        double linearSpeed = Math.min(linearActuatorSpeed, Constants.MAX_CLIMB_SPEED);
        Actuators.getClimbMotor().set(climbSpeed);
        Actuators.getLinearActuator().set(linearSpeed);
    }
}